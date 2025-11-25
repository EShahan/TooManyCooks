package Odds.TooManyCooks.controllers;

import Odds.TooManyCooks.models.*;
import Odds.TooManyCooks.models.data.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("Recipe")
public class RecipeController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RecipeCardRepository recipeCardRepository;
    @Autowired
    private StatCardRepository statCardRepository;
    @Autowired
    private IngredientCardRepository ingredientCardRepository;
    @Autowired
    private MeasurementRepository measurementRepository;
    @Autowired
    private RawIngredientRepository rawIngredientRepository;
    @Autowired
    private InstructionCardRepository instructionCardRepository;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private RecipeDetailRepository recipeDetailRepository;
    @Autowired
    private RecipeInstructionRepository recipeInstructionRepository;
    @Autowired
    private RatingsRepository ratingsRepository;

    @GetMapping("ExampleRecipe")
    public String ExampleRecipe(Model model) {
        model.addAttribute("recipeCard", recipeCardRepository.findRecipeCardById(1));
        model.addAttribute("cardInstructions", instructionCardRepository.findInstructionSetByRecipeIdOrderAsc(1));
        model.addAttribute("ingredients", ingredientCardRepository.findIngredientCardByList(1));
        return "recipe/examplerecipe.html";
    }

    @GetMapping("Add")
    public String displayAddRecipe(Model model) {
        model.addAttribute(new Recipe());
        model.addAttribute(new RecipeCard());
        model.addAttribute(new StatCard());
        model.addAttribute(new InstructionCard());
        return "recipe/add";
    }
    @PostMapping("Add")
    public String processAddRecipe(@RequestParam String[] recipeDetails, @RequestParam String[] recipeInstructions,
                                   @RequestParam String[] ingredient, @RequestParam String[] measurement, @RequestParam Integer[] amount, @RequestParam String[] instructionCard,
                                   @ModelAttribute @Valid Recipe newRecipe, @ModelAttribute @Valid RecipeCard newRecipeCard, @ModelAttribute @Valid StatCard newStatCard,
                                   Error errors, Model model, @AuthenticationPrincipal UserDetails userDetails) {
        newRecipe.setUser(userRepository.findUserByUsername(userDetails.getUsername()));
        recipeRepository.save(newRecipe);
        newRecipeCard.setStatCard(newStatCard);
        newRecipeCard.setRecipe(newRecipe);
//        newRecipeCard.setUser(userRepository.findUserByUsername(userDetails.getUsername()));
        recipeCardRepository.save(newRecipeCard);
        IngredientCard newIngredientCard = new IngredientCard();
        newStatCard.setAuthor(userDetails.getUsername());
        statCardRepository.save(newStatCard);

        // Uses optional queries to check if the name of our ingredient or measurement already exists
        // If it exists, it sets the ingredientCard to that ingredient or measurement
        // If it does not, it creates a new object of it and sets that object to the ingredientCard
        // TODO: This code causes an error if the user creates a duplicate ingredient or instruction.
        // For now handling can prevent a repeat input. But, depending on the features the site adds a more permanent solution may be needed.

        for (int i = 0; i < recipeDetails.length; i++) {
            RecipeDetail newRecipeDetail = new RecipeDetail(recipeDetails[i]);
            newRecipeDetail.setDetailOrder(i);
            newRecipeDetail.setRecipe(newRecipe);
            recipeDetailRepository.save(newRecipeDetail);
        }
        for (int i = 0; i < recipeInstructions.length; i++) {
            RecipeInstruction newRecipeInstructions = new RecipeInstruction(recipeInstructions[i]);
            newRecipeInstructions.setInstructionOrder(i);
            newRecipeInstructions.setRecipe(newRecipe);
            recipeInstructionRepository.save(newRecipeInstructions);
        }

        for (int i = 0; i < ingredient.length; i++) {
            int finalI = i; // From lambda, can't reference anything that isn't final
            rawIngredientRepository.findRawIngredientByName(ingredient[i]).ifPresentOrElse(
                newIngredientCard::setRawIngredient,
                () -> {
                    RawIngredient newRawIngredient = new RawIngredient(ingredient[finalI]);
                    rawIngredientRepository.save(newRawIngredient);
                    newIngredientCard.setRawIngredient(newRawIngredient);
                });
                measurementRepository.findMeasurementByName(measurement[i]).ifPresentOrElse(
                newIngredientCard::setMeasurement,
                () -> {
                    Measurement newMeasurement = new Measurement(measurement[finalI]);
                    measurementRepository.save(newMeasurement);
                    newIngredientCard.setMeasurement(newMeasurement);
                }
        );
            newIngredientCard.setAmount(amount[finalI]);
            newIngredientCard.setRecipeCard(newRecipeCard);
            ingredientCardRepository.save(newIngredientCard);
        }

//        rawIngredientRepository.findRawIngredientByName(ingredient).ifPresentOrElse(
//                newIngredientCard::setRawIngredient,
//                () -> {
//                    RawIngredient newRawIngredient = new RawIngredient(ingredient);
//                    rawIngredientRepository.save(newRawIngredient);
//                    newIngredientCard.setRawIngredient(newRawIngredient);
//                });
//        measurementRepository.findMeasurementByName(measurement).ifPresentOrElse(
//                newIngredientCard::setMeasurement,
//                () -> {
//                    Measurement newMeasurement = new Measurement(measurement);
//                    measurementRepository.save(newMeasurement);
//                    newIngredientCard.setMeasurement(newMeasurement);
//                }
//        );
//        newIngredientCard.setAmount(amount);
//        newIngredientCard.setRecipeCard(newRecipeCard);
//        ingredientCardRepository.save(newIngredientCard);

        // Iterate over list of all instructionCard to connect them to create instructionsteps and connect them to a card. Use iteration value to order them in MySQL server.
        for (int i = 0; i < instructionCard.length; i++) {
            InstructionCard newInstructionCard = new InstructionCard(instructionCard[i]);
            newInstructionCard.setRecipeCard(newRecipeCard);
            newInstructionCard.setInstructionOrder(i);
            instructionCardRepository.save(newInstructionCard);
        }

        return "redirect:/Recipe/view/" + newRecipeCard.getId();
    }
    @GetMapping("view/{id}")
    public String displayView(Model model, @PathVariable Integer id) {
        model.addAttribute("recipe", recipeRepository.findRecipeById(id));
        model.addAttribute("recipeInstructions", recipeInstructionRepository.findRecipeInstructionSetByRecipeIdOrderAsc(id));
        model.addAttribute("recipeDetails", recipeDetailRepository.findRecipeDetailSetByRecipeIdOrderAsc(id));
        model.addAttribute("cardInstructions", instructionCardRepository.findInstructionSetByRecipeIdOrderAsc(id));
        model.addAttribute("ingredients", ingredientCardRepository.findIngredientCardByList(id));
        return "recipe/examplerecipe.html";
    }

    @PostMapping("view/{id}")
    public String processViewRating(Model model, @PathVariable Integer id, @RequestParam Integer rating, @AuthenticationPrincipal UserDetails userDetails) {
        Rating newRating = new Rating();
        newRating.setRating(rating);
        newRating.setRecipeCard(recipeCardRepository.findRecipeCardById(id));
        newRating.setUser(userRepository.findUserByUsername(userDetails.getUsername()));
        ratingsRepository.save(newRating);
        model.addAttribute("recipe", recipeRepository.findRecipeById(id));
        model.addAttribute("recipeInstructions", recipeInstructionRepository.findRecipeInstructionSetByRecipeIdOrderAsc(id));
        model.addAttribute("recipeDetails", recipeDetailRepository.findRecipeDetailSetByRecipeIdOrderAsc(id));
        model.addAttribute("cardInstructions", instructionCardRepository.findInstructionSetByRecipeIdOrderAsc(id));
        model.addAttribute("ingredients", ingredientCardRepository.findIngredientCardByList(id));
        return "recipe/examplerecipe.html";
    }
}

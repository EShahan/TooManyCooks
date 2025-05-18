package Odds.TooManyCooks.controllers;

import Odds.TooManyCooks.models.*;
import Odds.TooManyCooks.models.data.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("Recipe")
public class RecipeController {
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

    @GetMapping("ExampleRecipe")
    public String ExampleRecipe(Model model) {
        model.addAttribute("recipeCard", recipeCardRepository.findRecipeCardById(1));
        model.addAttribute("cardInstructions", instructionCardRepository.findInstructionSetByRecipeIdOrderAsc(1));
        model.addAttribute("ingredients", ingredientCardRepository.findIngredientCardByList(1));
        return "recipe/examplerecipe.html";
    }

    @GetMapping("Add")
    public String displayAddRecipe(Model model) {
        model.addAttribute(new RecipeCard());
        model.addAttribute(new StatCard());
        model.addAttribute(new InstructionCard());
        return "recipe/add";
    }
    @PostMapping("Add")
    public String processAddRecipe(@RequestParam String ingredient, @RequestParam String measurement, @RequestParam Integer amount, @RequestParam String[] instructions,
                                   @ModelAttribute @Valid RecipeCard newRecipe, @ModelAttribute @Valid StatCard newStatCard,
                                   Error errors, Model model) {
        newRecipe.setStatCard(newStatCard);
        recipeCardRepository.save(newRecipe);
        IngredientCard newIngredientCard = new IngredientCard();
        newStatCard.setAuthor("Me"); //PLACEHOLDER! TODO: Once UserDetails is implemented, this should retrieve the user's name
        statCardRepository.save(newStatCard);
        // Uses optional queries to check if the name of our ingredient or measurement already exists
        // If it exists, it sets the ingredientCard to that ingredient or measurement
        // If it does not, it creates a new object of it and sets that object to the ingredientCard
        rawIngredientRepository.findRawIngredientByName(ingredient).ifPresentOrElse(
                newIngredientCard::setRawIngredient,
                () -> {
                    RawIngredient newRawIngredient = new RawIngredient(ingredient);
                    rawIngredientRepository.save(newRawIngredient);
                    newIngredientCard.setRawIngredient(newRawIngredient);
                });
        measurementRepository.findMeasurementByName(measurement).ifPresentOrElse(
                newIngredientCard::setMeasurement,
                () -> {
                    Measurement newMeasurement = new Measurement(measurement);
                    measurementRepository.save(newMeasurement);
                    newIngredientCard.setMeasurement(newMeasurement);
                }
        );
        newIngredientCard.setAmount(amount);
        newIngredientCard.setRecipeCard(newRecipe);
        ingredientCardRepository.save(newIngredientCard);
        // Iterate over list of all instructions to connect them to create instructionsteps and connect them to a card. Use iteration value to order them in MySQL server.
        for (int i = 0; i < instructions.length; i++) {
            InstructionCard newInstructionCard = new InstructionCard(instructions[i]);
            newInstructionCard.setRecipeCard(newRecipe);
            newInstructionCard.setInstructionOrder(i);
            instructionCardRepository.save(newInstructionCard);
        }

        return "redirect:/Recipe/view/" + newRecipe.getId();
    }
    @GetMapping("view/{id}")
    public String displayView(Model model, @PathVariable Integer id) {
        model.addAttribute("recipeCard", recipeCardRepository.findRecipeCardById(id));
        model.addAttribute("cardInstructions", instructionCardRepository.findInstructionSetByRecipeIdOrderAsc(id));
        model.addAttribute("ingredients", ingredientCardRepository.findIngredientCardByList(id));
        return "recipe/examplerecipe.html";
    }
}

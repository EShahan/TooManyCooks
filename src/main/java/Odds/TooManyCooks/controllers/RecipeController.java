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
    public String processAddRecipe(@RequestParam String ingredient, @RequestParam String measurement,
                                   @ModelAttribute @Valid RecipeCard newRecipe, @ModelAttribute @Valid StatCard newStatCard,
                                   @ModelAttribute InstructionCard newInstructionCard,
                                   Error errors, Model model) {
        IngredientCard newIngredientCard = new IngredientCard();
        statCardRepository.save(newStatCard);
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
        newIngredientCard.setRecipeCard(newRecipe);
        ingredientCardRepository.save(newIngredientCard);
        instructionCardRepository.save(newInstructionCard);
        newRecipe.setStatCard(newStatCard);
        recipeCardRepository.save(newRecipe);
        return "redirect:/Recipe/ExampleRecipe";
    }
}

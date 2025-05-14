package Odds.TooManyCooks.controllers;

import Odds.TooManyCooks.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Recipe")
public class RecipeController {
    @Autowired
    private RecipeCardRepository recipeCardRepository;
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
}

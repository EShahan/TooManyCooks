package Odds.TooManyCooks.controllers;

import Odds.TooManyCooks.models.IngredientCard;
import Odds.TooManyCooks.models.Measurement;
import Odds.TooManyCooks.models.data.IngredientCardRepository;
import Odds.TooManyCooks.models.data.IngredientListRepository;
import Odds.TooManyCooks.models.data.MeasurementRepository;
import Odds.TooManyCooks.models.data.RawIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Recipe")
public class RecipeController {
    @Autowired
    private IngredientCardRepository ingredientCardRepository;
    @Autowired
    private MeasurementRepository measurementRepository;
    @Autowired
    private IngredientListRepository ingredientListRepository;
    @Autowired
    private RawIngredientRepository rawIngredientRepository;

    @GetMapping("ExampleRecipe")
    public String ExampleRecipe(Model model) {
        model.addAttribute("ingredients", ingredientCardRepository.findIngredientCardByList(1));
        return "recipe/examplerecipe.html";
    }
}

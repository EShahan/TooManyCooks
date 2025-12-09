package Odds.TooManyCooks.controllers;

import Odds.TooManyCooks.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("User")
public class UserProfileController {
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

    @GetMapping("{id}")
    public String index(Model model, @PathVariable Integer id) {
        model.addAttribute("user", userRepository.findUserById(id));
        model.addAttribute("recipes", recipeRepository.findRecipesByUserId(id));
        model.addAttribute("ratings", ratingsRepository.findRatingsByUser(id));
        return "user/index.html";
    }
}

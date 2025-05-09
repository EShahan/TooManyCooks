package Odds.TooManyCooks.security;

import Odds.TooManyCooks.models.IngredientCard;
import Odds.TooManyCooks.models.RecipeCard;
import Odds.TooManyCooks.models.Measurement;
import Odds.TooManyCooks.models.RawIngredient;
import Odds.TooManyCooks.models.data.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup = true;

    @Autowired
    private RawIngredientRepository rawIngredientRepository;

    @Autowired
    private MeasurementRepository measurementRepository;

    @Autowired
    private IngredientCardRepository ingredientCardRepository;

    @Autowired
    private RecipeCardRepository recipeCardRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup)
            return;

        RawIngredient onion = new RawIngredient();
        onion.setName("Onion");
        rawIngredientRepository.save(onion);

        RawIngredient carrot = new RawIngredient();
        carrot.setName("Carrot");
        rawIngredientRepository.save(carrot);

        RawIngredient snail = new RawIngredient();
        snail.setName("Snail");
        rawIngredientRepository.save(snail);

        Measurement tbsp = new Measurement();
        tbsp.setName("Tbsp");
        measurementRepository.save(tbsp);

        Measurement whole = new Measurement();
        whole.setName("Whole");
        measurementRepository.save(whole);

        RecipeCard soupList = new RecipeCard();
        recipeCardRepository.save(soupList);

        RecipeCard escargotList = new RecipeCard();
        recipeCardRepository.save(escargotList);

        IngredientCard soupCard = new IngredientCard();
        soupCard.setRawIngredient(onion);
        soupCard.setMeasurement(tbsp);
        soupCard.setRecipeCard(soupList);
        ingredientCardRepository.save(soupCard);

        IngredientCard soupCard2 = new IngredientCard();
        soupCard2.setRawIngredient(carrot);
        soupCard2.setMeasurement(whole);
        soupCard2.setRecipeCard(soupList);
        ingredientCardRepository.save(soupCard2);

        IngredientCard escargot = new IngredientCard();
        escargot.setRawIngredient(snail);
        escargot.setMeasurement(whole);
        escargot.setRecipeCard(escargotList);
        ingredientCardRepository.save(escargot);
    }
}
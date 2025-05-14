package Odds.TooManyCooks.security;

import Odds.TooManyCooks.models.*;
import Odds.TooManyCooks.models.data.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup = false;

    @Autowired
    private RawIngredientRepository rawIngredientRepository;

    @Autowired
    private MeasurementRepository measurementRepository;

    @Autowired
    private IngredientCardRepository ingredientCardRepository;

    @Autowired
    private RecipeCardRepository recipeCardRepository;

    @Autowired
    private StatCardRepository statCardRepository;

    @Autowired
    private InstructionCardRepository instructionCardRepository;

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

        StatCard statCard = new StatCard();
        statCard.setAuthor("Eric");
        statCard.setPrepTime("Not Long");
        statCard.setCookTime("Now");
        statCard.setTotalTime("Just Make The Soup");
        statCard.setYield("1 Serving. Too good not to eat it all.");
        statCard.setMethod("With a Kitchen");
        statCard.setCuisine("Good");
        statCardRepository.save(statCard);

        RecipeCard soupList = new RecipeCard();
        soupList.setStatCard(statCard);
        recipeCardRepository.save(soupList);

        InstructionCard instructionCard1 = new InstructionCard();
        instructionCard1.setInstructionStep("Get Pots and Pans");
        instructionCard1.setRecipeCard(soupList);
        instructionCard1.setInstructionOrder(1);
        instructionCardRepository.save(instructionCard1);

        InstructionCard instructionCard2 = new InstructionCard();
        instructionCard2.setInstructionStep("Meditate");
        instructionCard2.setRecipeCard(soupList);
        instructionCard2.setInstructionOrder(2);
        instructionCardRepository.save(instructionCard2);

        InstructionCard instructionCard3 = new InstructionCard();
        instructionCard3.setInstructionStep("Let The Universe Guide You To Make The Best Soup");
        instructionCard3.setRecipeCard(soupList);
        instructionCard3.setInstructionOrder(3);
        instructionCardRepository.save(instructionCard3);

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
    }
}
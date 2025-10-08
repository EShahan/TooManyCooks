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

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeDetailRepository recipeDetailRepository;

    @Autowired
    private RecipeInstructionRepository recipeInstructionRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup)
            return;

        Recipe pickledPeppers = new Recipe();
        pickledPeppers.setRecipeName("Pickled Peppers");
        recipeRepository.save(pickledPeppers);

        RawIngredient pepper = new RawIngredient();
        pepper.setName("Pepper");
        rawIngredientRepository.save(pepper);

        RawIngredient pickleJuice = new RawIngredient();
        pickleJuice.setName("Pickle Juice");
        rawIngredientRepository.save(pickleJuice);

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

        Measurement jar = new Measurement();
        jar.setName("Jar");
        measurementRepository.save(jar);

        StatCard statCard = new StatCard();
        statCard.setAuthor("Peter Piper");
        statCard.setPrepTime("30 minutes");
        statCard.setCookTime("1 week");
        statCard.setTotalTime("About a week");
        statCard.setYield("15 servings");
        statCard.setMethod("Pickling");
        statCard.setCuisine("Pickled");
        statCardRepository.save(statCard);

        RecipeCard pepperList = new RecipeCard();
        pepperList.setStatCard(statCard);
        pepperList.setRecipe(pickledPeppers);
        pepperList.setRecipeName("Pickled Peppers");
        recipeCardRepository.save(pepperList);

        InstructionCard instructionCard1 = new InstructionCard();
        instructionCard1.setInstructionStep("Peter Piper Picked a Peck of Pickled Peppers;");
        instructionCard1.setRecipeCard(pepperList);
        instructionCard1.setInstructionOrder(1);
        instructionCardRepository.save(instructionCard1);

        InstructionCard instructionCard2 = new InstructionCard();
        instructionCard2.setInstructionStep("A Peck of Pickled Peppers Peter Piper Picked!");
        instructionCard2.setRecipeCard(pepperList);
        instructionCard2.setInstructionOrder(2);
        instructionCardRepository.save(instructionCard2);

        InstructionCard instructionCard3 = new InstructionCard();
        instructionCard3.setInstructionStep("If Peter Piper Picked a Peck of Pickled Peppers,");
        instructionCard3.setRecipeCard(pepperList);
        instructionCard3.setInstructionOrder(3);
        instructionCardRepository.save(instructionCard3);

        InstructionCard instructionCard4 = new InstructionCard();
        instructionCard4.setInstructionStep("Where's the Peck of Pickled Peppers Peter Piper Picked?");
        instructionCard4.setRecipeCard(pepperList);
        instructionCard4.setInstructionOrder(4);
        instructionCardRepository.save(instructionCard4);

        IngredientCard pepperCard = new IngredientCard();
        pepperCard.setRawIngredient(pepper);
        pepperCard.setMeasurement(whole);
        pepperCard.setAmount(15);
        pepperCard.setRecipeCard(pepperList);
        ingredientCardRepository.save(pepperCard);

        IngredientCard pepperCard2 = new IngredientCard();
        pepperCard2.setRawIngredient(pickleJuice);
        pepperCard2.setMeasurement(jar);
        pepperCard2.setAmount(1);
        pepperCard2.setRecipeCard(pepperList);
        ingredientCardRepository.save(pepperCard2);

        RecipeDetail recipeDetail = new RecipeDetail();
        recipeDetail.setDetail("Once upon a time, Peter Piper Prepared a Peck of Pickled Peppers that were so tantilizingly delicious that he hid them from the world. Henceforth, everyone demanded to know \"Where's The Peck of Pickled Peppers Peter Piper Picked!?\"");
        recipeDetail.setDetailOrder(1);
        recipeDetail.setRecipe(pickledPeppers);
        recipeDetailRepository.save(recipeDetail);

        RecipeDetail recipeDetail2 = new RecipeDetail();
        recipeDetail2.setDetail("Well. We don't know. But we've got the secret to make a batch of Pickled Peppers which are just as good!");
        recipeDetail2.setDetailOrder(2);
        recipeDetail2.setRecipe(pickledPeppers);
        recipeDetailRepository.save(recipeDetail2);

        RecipeInstruction recipeInstruction = new RecipeInstruction();
        recipeInstruction.setInstruction("You'll need some whole Peppers, and the most delicious Pickle Juice you can find.");
        recipeInstruction.setInstructionOrder(1);
        recipeInstruction.setRecipe(pickledPeppers);
        recipeInstructionRepository.save(recipeInstruction);

        RecipeInstruction recipeInstruction2 = new RecipeInstruction();
        recipeInstruction2.setInstruction("Then you'll put all the ingredients in a jar for a week. Yeah; it's that easy!");
        recipeInstruction2.setInstructionOrder(2);
        recipeInstruction2.setRecipe(pickledPeppers);
        recipeInstructionRepository.save(recipeInstruction2);
    }
}
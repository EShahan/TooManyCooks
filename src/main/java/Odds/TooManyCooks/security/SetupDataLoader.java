package Odds.TooManyCooks.security;

import Odds.TooManyCooks.models.IngredientCard;
import Odds.TooManyCooks.models.IngredientList;
import Odds.TooManyCooks.models.Measurement;
import Odds.TooManyCooks.models.RawIngredient;
import Odds.TooManyCooks.models.data.IngredientCardRepository;
import Odds.TooManyCooks.models.data.IngredientListRepository;
import Odds.TooManyCooks.models.data.MeasurementRepository;
import Odds.TooManyCooks.models.data.RawIngredientRepository;
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
    private IngredientListRepository ingredientListRepository;

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

        IngredientList soupList = new IngredientList();
        ingredientListRepository.save(soupList);

        IngredientList escargotList = new IngredientList();
        ingredientListRepository.save(escargotList);

        IngredientCard soupCard = new IngredientCard();
        soupCard.setRawIngredient(onion);
        soupCard.setMeasurement(tbsp);
        soupCard.setIngredientList(soupList);
        ingredientCardRepository.save(soupCard);

        IngredientCard soupCard2 = new IngredientCard();
        soupCard2.setRawIngredient(carrot);
        soupCard2.setMeasurement(whole);
        soupCard2.setIngredientList(soupList);
        ingredientCardRepository.save(soupCard2);

        IngredientCard escargot = new IngredientCard();
        escargot.setRawIngredient(snail);
        escargot.setMeasurement(whole);
        escargot.setIngredientList(escargotList);
        ingredientCardRepository.save(escargot);
    }
}
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
    boolean alreadySetup = false;

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

        RawIngredient rawIngredient = new RawIngredient();
        rawIngredient.setName("Onion");
        rawIngredientRepository.save(rawIngredient);

        Measurement measurement = new Measurement();
        measurement.setName("Tbsp");
        measurementRepository.save(measurement);

        IngredientList ingredientList = new IngredientList();
        ingredientListRepository.save(ingredientList);

        IngredientCard ingredientCard = new IngredientCard();
        ingredientCard.setRawIngredient(rawIngredient);
        ingredientCard.setMeasurement(measurement);
        ingredientCard.setIngredientList(ingredientList);
        ingredientCardRepository.save(ingredientCard);
    }
}
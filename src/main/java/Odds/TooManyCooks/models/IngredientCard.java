package Odds.TooManyCooks.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class IngredientCard {
    @EmbeddedId
    private IngredientCardId id;
    @ManyToOne @MapsId("rawIngredientId")
    private RawIngredient rawIngredient;
    @ManyToOne @MapsId("measurementId")
    private Measurement measurement;
    @ManyToOne @MapsId("recipeCardId")
    private RecipeCard recipeCard;

    public IngredientCard() {
        id = new IngredientCardId();
    }

    public IngredientCardId getId() {
        return id;
    }

    public void setId(IngredientCardId id) {
        this.id = id;
    }

    public RawIngredient getRawIngredient() {
        return rawIngredient;
    }

    public void setRawIngredient(RawIngredient rawIngredient) {
        this.rawIngredient = rawIngredient;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public RecipeCard getRecipeCard() {
        return recipeCard;
    }

    public void setRecipeCard(RecipeCard recipeCard) {
        this.recipeCard = recipeCard;
    }
}

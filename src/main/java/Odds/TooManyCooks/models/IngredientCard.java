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
    @ManyToOne @MapsId("ingredientListId")
    private IngredientList ingredientList;

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

    public IngredientList getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(IngredientList ingredientList) {
        this.ingredientList = ingredientList;
    }
}

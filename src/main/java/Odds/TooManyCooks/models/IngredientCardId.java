package Odds.TooManyCooks.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class IngredientCardId implements Serializable {
    private Integer rawIngredientId;
    private Integer measurementId;
    private Integer recipeCardId;
//    private Integer amount;

    public IngredientCardId() {
    }

    public Integer getRawIngredientId() {
        return rawIngredientId;
    }

    public void setRawIngredientId(Integer rawIngredientId) {
        this.rawIngredientId = rawIngredientId;
    }

    public Integer getMeasurementId() {
        return measurementId;
    }

    public void setMeasurementId(Integer measurementId) {
        this.measurementId = measurementId;
    }

    public Integer getRecipeCardId() {
        return recipeCardId;
    }

    public void setRecipeCardId(Integer recipeCardId) {
        this.recipeCardId = recipeCardId;
    }

//    public Integer getAmount() {
//        return amount;
//    }
//
//    public void setAmount(Integer amount) {
//        this.amount = amount;
//    }
}

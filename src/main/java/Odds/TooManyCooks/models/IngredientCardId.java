package Odds.TooManyCooks.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class IngredientCardId implements Serializable {
    private Integer rawIngredientId;
    private Integer measurementId;
    private Integer ingredientListId;
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

    public Integer getIngredientListId() {
        return ingredientListId;
    }

    public void setIngredientListId(Integer ingredientListId) {
        this.ingredientListId = ingredientListId;
    }

    //    public Integer getAmount() {
//        return amount;
//    }
//
//    public void setAmount(Integer amount) {
//        this.amount = amount;
//    }
}

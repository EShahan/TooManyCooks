package Odds.TooManyCooks.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class IngredientCardId implements Serializable {
    private Integer rawIngredientId;
    private Integer measurementId;
    private Integer amount;
}

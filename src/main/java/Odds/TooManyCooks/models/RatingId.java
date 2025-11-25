package Odds.TooManyCooks.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class RatingId implements Serializable {
    private Integer recipeCardId;
    private Integer userId;

    public RatingId() {

    }

    public Integer getRecipeCardId() {
        return recipeCardId;
    }

    public void setRecipeCardId(Integer recipeCardId) {
        this.recipeCardId = recipeCardId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}


package Odds.TooManyCooks.models;

import jakarta.persistence.*;

@Entity
public class Rating {
    @EmbeddedId
    private RatingId id;
    @ManyToOne @MapsId("recipeCardId")
    private RecipeCard recipeCard;
    @ManyToOne @MapsId("userId")
    private User user;
    private Integer rating;
    public Rating() {
        id = new RatingId();
    }

    public RatingId getId() {
        return id;
    }

    public void setId(RatingId id) {
        this.id = id;
    }

    public RecipeCard getRecipeCard() {
        return recipeCard;
    }

    public void setRecipeCard(RecipeCard recipeCard) {
        this.recipeCard = recipeCard;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}

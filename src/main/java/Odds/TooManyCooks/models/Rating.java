package Odds.TooManyCooks.models;

import jakarta.persistence.*;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private RecipeCard recipeCard;

    @ManyToOne
    private User user;

    private int rating;

    public Rating() {

    }

    public Rating(int rating) {
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

package Odds.TooManyCooks.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToOne(mappedBy = "recipe")
    private RecipeCard recipeCard;

    @OneToMany(mappedBy = "recipe")
    private Set<RecipeDetail> recipeDetails;

    @OneToMany(mappedBy = "recipe")
    private Set<RecipeInstruction> recipeInstructions;

    private String recipeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RecipeCard getRecipeCard() {
        return recipeCard;
    }

    public void setRecipeCard(RecipeCard recipeCard) {
        this.recipeCard = recipeCard;
    }

    public Set<RecipeDetail> getSaucyDetails() {
        return recipeDetails;
    }

    public void setSaucyDetails(Set<RecipeDetail> recipeDetails) {
        this.recipeDetails = recipeDetails;
    }

    public Set<RecipeInstruction> getSaucyInstructions() {
        return recipeInstructions;
    }

    public void setSaucyInstructions(Set<RecipeInstruction> recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
}

package Odds.TooManyCooks.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class RecipeCard {

    @Id
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private Recipe recipe;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stat_card_id", referencedColumnName = "id")
    private StatCard statCard;

    @OneToMany(mappedBy = "recipeCard")
    private Set<IngredientCard> ingredientCards;

    @OneToMany(mappedBy = "recipeCard")
    private Set<InstructionCard> instructionCards;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public RecipeCard() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StatCard getStatCard() {
        return statCard;
    }

    public void setStatCard(StatCard statCard) {
        this.statCard = statCard;
    }

    public Set<IngredientCard> getIngredientCards() {
        return ingredientCards;
    }

    public void setIngredientCards(Set<IngredientCard> ingredientCards) {
        this.ingredientCards = ingredientCards;
    }

    public Set<InstructionCard> getInstructionCards() {
        return instructionCards;
    }

    public void setInstructionCards(Set<InstructionCard> instructionCards) {
        this.instructionCards = instructionCards;
    }
}
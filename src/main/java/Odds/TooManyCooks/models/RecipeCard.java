package Odds.TooManyCooks.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class RecipeCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stat_card_id", referencedColumnName = "id")
    private StatCard statCard;

    @OneToMany(mappedBy = "recipeCard")
    private Set<IngredientCard> ingredientCards;

    @OneToMany(mappedBy = "recipeCard")
    private Set<InstructionCard> instructionCards;

    private String recipeName;

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

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
}
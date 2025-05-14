package Odds.TooManyCooks.models;

import jakarta.persistence.*;

@Entity
public class InstructionCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private RecipeCard recipeCard;

    private String instructionStep;

    private Integer instructionOrder;

    public InstructionCard() {
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

    public String getInstructionStep() {
        return instructionStep;
    }

    public void setInstructionStep(String instructionStep) {
        this.instructionStep = instructionStep;
    }

    public Integer getInstructionOrder() {
        return instructionOrder;
    }

    public void setInstructionOrder(Integer instructionOrder) {
        this.instructionOrder = instructionOrder;
    }
}

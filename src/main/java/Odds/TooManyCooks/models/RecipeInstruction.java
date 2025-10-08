package Odds.TooManyCooks.models;

import jakarta.persistence.*;

@Entity
public class RecipeInstruction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Recipe recipe;

    private String instruction;

    private Integer instructionOrder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Integer getInstructionOrder() {
        return instructionOrder;
    }

    public void setInstructionOrder(Integer instructionOrder) {
        this.instructionOrder = instructionOrder;
    }
}

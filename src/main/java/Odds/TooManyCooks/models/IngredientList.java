package Odds.TooManyCooks.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class IngredientList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "ingredientList")
    private Set<IngredientCard> ingredientCards;

    public IngredientList() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<IngredientCard> getIngredientCards() {
        return ingredientCards;
    }

    public void setIngredientCards(Set<IngredientCard> ingredientCards) {
        this.ingredientCards = ingredientCards;
    }
}

package Odds.TooManyCooks.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class RawIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "rawIngredient")
    private Set<IngredientCard> ingredientCards;

    private String name;

    public RawIngredient() {
    }

    public RawIngredient(String name) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

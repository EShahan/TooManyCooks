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
}
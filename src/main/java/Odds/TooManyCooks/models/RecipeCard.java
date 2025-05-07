package Odds.TooManyCooks.models;

import jakarta.persistence.*;

@Entity
public class RecipeCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stat_card_id", referencedColumnName = "id")
    private StatCard statCard;

    public RecipeCard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatCard getStatCard() {
        return statCard;
    }

    public void setStatCard(StatCard statCard) {
        this.statCard = statCard;
    }
}
package Odds.TooManyCooks.models;

import jakarta.persistence.*;

@Entity
public class RecipeDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Recipe recipe;

    private String detail;

    private Integer detailOrder;

    public RecipeDetail() {

    }

    public RecipeDetail(String detail) {
        this.detail = detail;
    }

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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getDetailOrder() {
        return detailOrder;
    }

    public void setDetailOrder(Integer detailOrder) {
        this.detailOrder = detailOrder;
    }
}

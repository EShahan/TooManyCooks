package Odds.TooManyCooks.models.data;

import Odds.TooManyCooks.models.IngredientCard;
import Odds.TooManyCooks.models.RecipeCard;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeCardRepository extends CrudRepository<RecipeCard, Integer> {
    @Query(value = "SELECT *\n" +
            "FROM recipe_card\n" +
            "WHERE recipe_card.id = :id",
            nativeQuery = true)
    RecipeCard findRecipeCardById(@Param("id") Integer id);
}
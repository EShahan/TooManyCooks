package Odds.TooManyCooks.models.data;

import Odds.TooManyCooks.models.IngredientCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientCardRepository extends CrudRepository<IngredientCard, Integer> {
    @Query(value = "SELECT *\n" +
            "FROM ingredient_card\n" +
            "WHERE ingredient_card.recipe_card_id = :listId",
    nativeQuery = true)
    Iterable<IngredientCard> findIngredientCardByList(@Param("listId") Integer listId);
}
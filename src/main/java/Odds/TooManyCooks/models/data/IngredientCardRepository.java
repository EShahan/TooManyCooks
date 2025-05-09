package Odds.TooManyCooks.models.data;

import Odds.TooManyCooks.models.IngredientCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientCardRepository extends CrudRepository<IngredientCard, Integer> {
}
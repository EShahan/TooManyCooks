package Odds.TooManyCooks.models.data;

import Odds.TooManyCooks.models.IngredientList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientListRepository extends CrudRepository<IngredientList, Integer> {
}

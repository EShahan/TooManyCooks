package Odds.TooManyCooks.models.data;

import Odds.TooManyCooks.models.RawIngredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawIngredientRepository extends CrudRepository<RawIngredient, Integer> {

}

package Odds.TooManyCooks.models.data;

import Odds.TooManyCooks.models.RecipeDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeDetailRepository extends CrudRepository<RecipeDetail, Integer> {
}
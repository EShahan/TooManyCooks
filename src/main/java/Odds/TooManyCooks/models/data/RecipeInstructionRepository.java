package Odds.TooManyCooks.models.data;

import Odds.TooManyCooks.models.RecipeInstruction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, Integer> {
}

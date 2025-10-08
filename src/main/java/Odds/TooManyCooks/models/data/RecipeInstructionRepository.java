package Odds.TooManyCooks.models.data;

import Odds.TooManyCooks.models.RecipeInstruction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, Integer> {
    @Query(value = "SELECT * FROM recipe_instruction\n" +
            "WHERE recipe_id = :id\n" +
            "ORDER BY instruction_order ASC",
            nativeQuery = true)
    Iterable<RecipeInstruction> findRecipeInstructionSetByRecipeIdOrderAsc(@Param("id") Integer id);
}

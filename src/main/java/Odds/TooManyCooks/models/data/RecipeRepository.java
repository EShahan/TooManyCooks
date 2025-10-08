package Odds.TooManyCooks.models.data;

import Odds.TooManyCooks.models.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    @Query(value = "SELECT *\n" +
            "FROM recipe\n" +
            "WHERE recipe.id = :id",
            nativeQuery = true)
    Recipe findRecipeById(@Param("id") Integer id);
}

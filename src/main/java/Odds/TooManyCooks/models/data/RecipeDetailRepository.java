package Odds.TooManyCooks.models.data;

import Odds.TooManyCooks.models.RecipeDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeDetailRepository extends CrudRepository<RecipeDetail, Integer> {
    @Query(value = "SELECT * FROM recipe_detail\n" +
            "WHERE recipe_id = :id\n" +
            "ORDER BY detail_order ASC",
            nativeQuery = true)
    Iterable<RecipeDetail> findRecipeDetailSetByRecipeIdOrderAsc(@Param("id") Integer id);
}
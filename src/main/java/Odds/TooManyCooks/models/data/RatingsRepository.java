package Odds.TooManyCooks.models.data;

import Odds.TooManyCooks.models.Rating;
import Odds.TooManyCooks.models.RecipeCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RatingsRepository extends CrudRepository<Rating, Integer> {
    @Query(value = "SELECT *\n" +
            "FROM rating\n" +
            "WHERE rating.user_id = :userId AND rating.recipe_card_id = :recipeCardId",
            nativeQuery = true)
    Optional<Rating> findRatingByUserAndRecipeCard(@Param("userId") Integer userID, @Param("recipeCardId") Integer recipeCardId);
}

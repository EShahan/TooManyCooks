package Odds.TooManyCooks.models.data;

import Odds.TooManyCooks.models.RecipeCard;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeCardRepository extends CrudRepository<RecipeCard, Integer> {
}
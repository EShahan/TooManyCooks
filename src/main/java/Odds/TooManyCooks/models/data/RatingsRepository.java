package Odds.TooManyCooks.models.data;

import Odds.TooManyCooks.models.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingsRepository extends CrudRepository<Rating, Integer> {
    
}

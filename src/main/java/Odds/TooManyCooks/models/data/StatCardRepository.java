package Odds.TooManyCooks.models.data;

import Odds.TooManyCooks.models.StatCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatCardRepository extends CrudRepository<StatCard, Integer> {

}

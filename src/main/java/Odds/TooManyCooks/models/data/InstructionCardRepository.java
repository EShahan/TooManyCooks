package Odds.TooManyCooks.models.data;

import Odds.TooManyCooks.models.InstructionCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionCardRepository extends CrudRepository<InstructionCard, Integer> {
}

package Odds.TooManyCooks.models.data;

import Odds.TooManyCooks.models.InstructionCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionCardRepository extends CrudRepository<InstructionCard, Integer> {
    @Query(value = "SELECT * FROM instruction_card\n" +
            "WHERE recipe_card_id = :id\n" +
            "ORDER BY instruction_order ASC",
    nativeQuery = true)
    Iterable<InstructionCard> findInstructionSetByRecipeIdOrderAsc(@Param("id") Integer id);
}
package Odds.TooManyCooks.models.data;

import Odds.TooManyCooks.models.Measurement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MeasurementRepository extends CrudRepository<Measurement, Integer> {
    Optional<Measurement> findMeasurementByName(String name);
}

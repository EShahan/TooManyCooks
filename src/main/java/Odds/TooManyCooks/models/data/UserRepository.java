package Odds.TooManyCooks.models.data;

import Odds.TooManyCooks.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findOptionalUserByUsername(String username);

    User findUserByUsername(String username);
}
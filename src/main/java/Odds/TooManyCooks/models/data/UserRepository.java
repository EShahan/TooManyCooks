package Odds.TooManyCooks.models.data;

import Odds.TooManyCooks.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(value = "SELECT *\n" +
            "FROM user\n" +
            "WHERE user.id = :id",
            nativeQuery = true)
    User findUserById(@Param("id") Integer id);

    Optional<User> findOptionalUserByUsername(String username);

    User findUserByUsername(String username);
}
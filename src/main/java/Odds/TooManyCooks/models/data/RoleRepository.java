package Odds.TooManyCooks.models.data;

import Odds.TooManyCooks.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, String> {
    Role findByName(String name);
}
package fr.da2i.flooz.repositories;

import fr.da2i.flooz.model.Group;
import fr.da2i.flooz.model.User;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Integer> {
    Iterable<Group> findByUsers(User user);
}

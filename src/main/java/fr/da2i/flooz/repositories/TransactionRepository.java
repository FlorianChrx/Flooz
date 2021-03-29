package fr.da2i.flooz.repositories;

import fr.da2i.flooz.model.Group;
import fr.da2i.flooz.model.Transaction;
import fr.da2i.flooz.model.User;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    Iterable<Transaction> findByTgroup(Group group);

    Iterable<Transaction> findByUserAndTgroup(User user, Group group);
}

package fr.da2i.flooz.repositories;

import fr.da2i.flooz.model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    Iterable<Transaction> findByTgroup(String group);
    Iterable<Transaction> findByUserAndTgroup(String user, String group);
}

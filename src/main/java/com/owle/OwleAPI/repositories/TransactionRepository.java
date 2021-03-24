package com.owle.OwleAPI.repositories;

import com.owle.OwleAPI.ids.TransactionId;
import com.owle.OwleAPI.model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, TransactionId> {
}

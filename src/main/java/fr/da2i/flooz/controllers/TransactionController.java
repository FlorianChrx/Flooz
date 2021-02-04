package fr.da2i.flooz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import fr.da2i.flooz.model.Transaction;
import fr.da2i.flooz.repositories.TransactionRepository;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepository;

	
	@GetMapping(path = "/user/transaction/{group}")
	public Iterable<Transaction> getMessage(@PathVariable String group) {
		return transactionRepository.findByGroup(group).orElse(new Arraylist<Transaction>());
	}
	
	@GetMapping(path = "/user/transaction/{group}/{username}")
	public Iterable<Transaction> getMessage(@PathVariable String user, @PathVariable String group) {
		return transactionRepository.findByUserAndGroup(user, group).orElse(new Arraylist<Transaction>());
	}
}

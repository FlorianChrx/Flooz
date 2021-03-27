package fr.da2i.flooz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import fr.da2i.flooz.model.Transaction;
import fr.da2i.flooz.model.User;
import fr.da2i.flooz.repositories.TransactionRepository;

@RestController
public class TransactionController {

	@Autowired
	private TransactionRepository transactionRepository;


	@GetMapping(path = "/user/transaction/{group}")
	public Iterable<Transaction> getTransactionByGroup(@PathVariable String group) {
		return transactionRepository.findByGroup(group);
	}

	@GetMapping(path = "/user/transaction/{group}/{username}")
	public Iterable<Transaction> getTransactionByGroupAndSpender(@PathVariable String user, @PathVariable String group) {
		return transactionRepository.findByUserAndGroup(user, group);
	}


	/*@PutMapping(path = {"/user/transaction/add/{group}/{username}/{amout}"})
	public Map<String, Boolean> addTransaction(@RequestBody Group group, @RequestBody User user, @RequestBody Double amout) {
		transactionRepository.save(new )
		return this.addUserByAdmin(user);
	}*/
}

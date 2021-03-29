package fr.da2i.flooz.controllers;

import fr.da2i.flooz.model.*;
import fr.da2i.flooz.repositories.GroupRepository;
import fr.da2i.flooz.repositories.TransactionRepository;
import fr.da2i.flooz.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    Calculator calculator = new Calculator();
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/admin/transaction/{group}")
    public Iterable<Transaction> getTransactionByGroup(@PathVariable int group) {
        return transactionRepository.findByTgroup(groupRepository.findById(group).get());
    }

    @GetMapping(path = "/user/transaction/mine/{group}")
    public Iterable<Transaction> getTransactionByGroupAndSpender(HttpServletRequest request, @PathVariable int group) {
        if (!groupRepository.existsById(group)) return null;
        Group tgroup = groupRepository.findById(group).get();
        User user = userRepository.findById(request.getUserPrincipal().getName()).get();
        if (!tgroup.getUsers().contains(user)) return null;
        return transactionRepository.findByTgroup(groupRepository.findById(group).get());
    }

    @PutMapping(path = "/user/transaction/mine/{group}")
    public Map<String, Boolean> addTransaction(@PathVariable int group, @RequestBody Map<String, String> transaction, HttpServletRequest request) {
        Map bad = Collections.singletonMap("success", false);
        if (!groupRepository.existsById(group)) return bad;
        Group tgroup = groupRepository.findById(group).get();
        User user = userRepository.findById(request.getUserPrincipal().getName()).get();
        if (!tgroup.getUsers().contains(user)) return bad;
        Transaction newTransaction = new Transaction();
        newTransaction.setTgroup(tgroup);
        newTransaction.setUser(user);
        newTransaction.setMotif(transaction.get("motif"));
        newTransaction.setAmount(Double.parseDouble(transaction.get("amount")));
        transactionRepository.save(newTransaction);
        return Collections.singletonMap("success", true);
    }

    @DeleteMapping(path = "/user/transaction/{id}")
    public Map<String, Boolean> deleteTransaction(@PathVariable int id, HttpServletRequest request) {
        Map bad = Collections.singletonMap("success", false);
        User user = userRepository.findById(request.getUserPrincipal().getName()).get();
        if (!transactionRepository.existsById(id)) return bad;
        Transaction realTransaction = transactionRepository.findById(id).get();
        if (!realTransaction.getTgroup().getUsers().contains(user)) return bad;
        transactionRepository.deleteById(id);
        return Collections.singletonMap("success", true);
    }

    @GetMapping(path = "/user/transaction/balance/{id}")
    public List<Repayment> getBalance(@PathVariable int id, HttpServletRequest request) {
        if (!groupRepository.existsById(id)) return null;
        Group tgroup = groupRepository.findById(id).get();
        User user = userRepository.findById(request.getUserPrincipal().getName()).get();
        if (!tgroup.getUsers().contains(user)) return null;
        Iterable<Transaction> transactions = transactionRepository.findByTgroup(groupRepository.findById(id).get());
        try {
            return calculator.getBalance(transactions, tgroup);
        } catch (Exception e) {
            System.out.println("ole");
            return null;
        }
    }
}

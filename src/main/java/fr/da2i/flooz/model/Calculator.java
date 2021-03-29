package fr.da2i.flooz.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {

    public List<Repayment> getBalance(Iterable<Transaction> transactions, Group group) throws Exception {
        Map<User, Double> balances = initBalances(transactions, group);
        List<Repayment> result = new ArrayList<>();
        System.out.println(balances.values());
        System.out.println(balanced(balances));
        while (!balanced(balances)) {
            for (User u : balances.keySet()) {
                User sender = null;
                User receiver = null;
                double amount;
                System.out.println("ok");
                if (balances.containsValue(-balances.get(u))) {
                    System.out.println("lol");
                    if (balances.get(u) > 0) {
                        receiver = u;
                        sender = findUser(-balances.get(u), balances);
                        amount = balances.get(u);
                    } else {
                        receiver = findUser(-balances.get(u), balances);
                        sender = u;
                        amount = -balances.get(u);
                    }
                    System.out.println("ouf");
                } else {
                    double max = balances.values().stream().max(Double::compareTo).get();
                    double min = balances.values().stream().min(Double::compareTo).get();
                    sender = findUser(min, balances);
                    receiver = findUser(max, balances);
                    amount = Double.min(max, -min);
                }
                Repayment repayment = new Repayment(sender, receiver, amount);
                if (!sender.equals(receiver)) {
                    result.add(repayment);
                    apply(repayment, balances);
                }
            }

        }
        return result;
    }

    private User findUser(Double value, Map<User, Double> balances) {
        for (User u : balances.keySet()) {
            System.out.println(balances.get(u));
            if (balances.get(u).equals(value)) {
                System.out.println(balances.get(u));
                return u;
            }
        }
        return null;
    }

    private void apply(Repayment repayment, Map<User, Double> balances) {
        balances.put(repayment.getSender(), balances.get(repayment.getSender()) + repayment.getAmount());
        balances.put(repayment.getReceiver(), balances.get(repayment.getReceiver()) - repayment.getAmount());
    }

    private boolean balanced(Map<User, Double> balances) {
        return balances.values().stream().allMatch(val -> val == 0);
    }

    private Map<User, Double> initBalances(Iterable<Transaction> transactions, Group group) throws Exception {
        Map<User, Double> balances = new HashMap<>();
        int nbUsers = group.getUsers().size();
        for (User u : group.getUsers()) {
            balances.put(u, 0.0);
        }
        for (Transaction t : transactions) {
            System.out.println(t.getAmount());
            if (!t.getTgroup().equals(group)) throw new Exception("Bad group");
            for (User u : balances.keySet()) {
                balances.put(u, balances.get(u) - (t.getAmount() / nbUsers));
                System.out.println(balances.get(u) - (t.getAmount() / nbUsers));
            }
            balances.put(t.getUser(), balances.get(t.getUser()) + t.getAmount());
            System.out.println(balances.get(t.getUser()) + t.getAmount());
            System.out.println(balances.values());
        }
        return balances;
    }
}
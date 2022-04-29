package ru.job4j.bank;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void adAccount(String passport, Account account) {
        if (findByPassport(passport) != null) {
            List<Account> list = users.get(findByPassport(passport));
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User client : users.keySet()) {
            if (client.getPassport().equals(passport)) {
                return client;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User client = findByPassport(passport);
        if (client != null) {
            List<Account> list = users.get(client);
            for (Account acc : list) {
                if (acc.getRequisite().equals(requisite)) {
                    return acc;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        boolean rsl = false;
        if (srcAcc != null && destAcc != null && srcAcc.getBalance() > 0) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}

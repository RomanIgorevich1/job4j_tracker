package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("Petr Arsentev", "3434");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434"), is(user));
    }

    @Test
    public void whenInvalidPassport() {
        User user = new User("Petr Arsentev", "3234");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.adAccount(user.getPassport(), new Account("5546", 150D));
        assertNull(bank.findByRequisite("34", "5546"));
    }

    @Test
    public void addAccount() {
        User user = new User("Petr Arsentev", "3434");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.adAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5546").getBalance(), is(150D));
    }

    @Test
    public void transferMoney() {
        User user = new User("Petr Arsentev", "3434");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.adAccount(user.getPassport(), new Account("5546", 150D));
        bank.adAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").getBalance(), is(200D));
    }
}
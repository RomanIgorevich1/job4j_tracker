package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001"));
        HashSet<Account> expected = new HashSet<>(Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")));
        assertThat(NotifyAccount.sent(accounts), is(expected));
    }

    @Test
    public void deleteDuplicate() {
        List<Account> accounts = Arrays.asList(
                new Account("555", "Roman Frolov", "00001"),
                new Account("555", "Roman Frolov", "0101010h"));
        HashSet<Account> expected = new HashSet<>(List.of(
                new Account("555", "Roman Frolov", "00001")));
        assertThat(NotifyAccount.sent(accounts), is(expected));
    }
}
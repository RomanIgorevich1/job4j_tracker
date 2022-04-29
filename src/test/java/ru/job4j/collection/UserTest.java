package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserTest {

    @Test
    public void whenAcs() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenAcsForUsersWithEqualsNameButDifferentAge() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 35));
        users.add(new User("Ivan", 31));
        users.add(new User("Petr", 25));
        users.add(new User("Ivan", 29));
        users.add(new User("Petr", 33));
        users.add(new User("Ivan", 27));
        Set<User> expected = new TreeSet<>(
                Arrays.asList(new User("Ivan", 27),
                new User("Ivan", 29),
                new User("Ivan", 31),
                new User("Petr", 25),
                new User("Petr", 33),
                new User("Petr", 35)));
        assertThat(users, is(expected));
    }

    @Test
    public void whenComparePetrVsIvan() {
        int rsl = new User("Petr", 32).compareTo(new User("Ivan", 31));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparePetrVsPetrWithDifferentAge() {
        int rsl = new User("Petr", 31).compareTo(new User("Petr", 32));
        assertThat(rsl, lessThan(0));
    }
}
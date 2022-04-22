package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("123", "Petr");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void duplicatePassport() {
        PassportOffice office = new PassportOffice();
        office.add(new Citizen("123", "Petr"));
        office.add(new Citizen("321", "Roman"));
        Assert.assertFalse(office.add(new Citizen("321", "Roman Igorevich")));
    }
}
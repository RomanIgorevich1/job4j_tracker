package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phone = new PhoneDictionary();
        phone.add(new Person("Petr", "Arsentev", "Bryansk", "54321"));
        ArrayList<Person> persons = phone.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindByAddress() {
        PhoneDictionary phone = new PhoneDictionary();
        phone.add(new Person("Roman", "Frolov", "Moskva", "12345"));
        ArrayList<Person> persons = phone.find("Moskva");
        assertThat(persons.get(0).getAddress(), is("Moskva"));
    }

    @Test
    public void whenFindByPhone() {
        PhoneDictionary phone = new PhoneDictionary();
        phone.add(new Person("Viktor", "Titov", "Tver", "98765"));
        ArrayList<Person> persons = phone.find("98765");
        assertThat(persons.get(0).getPhone(), is("98765"));
    }

    @Test
    public void whenNotFound() {
        PhoneDictionary phone = new PhoneDictionary();
        phone.add(new Person("Egor", "Sokolov", "Omsk", "123321"));
        ArrayList<Person> persons = phone.find("Roma");
        assertThat(persons.size(), is(0));
    }

    @Test
    public void whenAgainFindByName() {
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Dmitriy", "Bybnov", "Minsk", "345543"));
        ArrayList<Person> persons = phoneDictionary.find("Dmitriy");
        assertThat(persons.get(0).getSurname(), is("Bybnov"));
    }
}
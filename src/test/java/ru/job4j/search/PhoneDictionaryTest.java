package ru.job4j.search;

import org.junit.Test;
import ru.job4j.ooa.search.Person;
import ru.job4j.ooa.search.PhoneDictionary;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phone = new PhoneDictionary();
        phone.add(new Person("Petr", "Arsentev", "Bryansk", "54321"));
        var persons = phone.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindByAddress() {
        var phone = new PhoneDictionary();
        phone.add(new Person("Roman", "Frolov", "Moskva", "12345"));
        var persons = phone.find("Moskva");
        assertThat(persons.get(0).getAddress(), is("Moskva"));
    }

    @Test
    public void whenFindByPhone() {
        var phone = new PhoneDictionary();
        phone.add(new Person("Viktor", "Titov", "Tver", "98765"));
        var persons = phone.find("98765");
        assertThat(persons.get(0).getPhone(), is("98765"));
    }

    @Test
    public void whenNotFound() {
        var phone = new PhoneDictionary();
        phone.add(new Person("Egor", "Sokolov", "Omsk", "123321"));
        var persons = phone.find("Roma");
        assertThat(persons.size(), is(0));
    }

    @Test
    public void whenAgainFindByName() {
        var phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Dmitriy", "Bybnov", "Minsk", "345543"));
        var persons = phoneDictionary.find("Dmitriy");
        assertThat(persons.get(0).getSurname(), is("Bybnov"));
    }
}
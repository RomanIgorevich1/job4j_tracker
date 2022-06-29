package ru.job4j.stream;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenTestMethodCollect() {
        Address one = new Address("City1", "Street1", 1, 1);
        Address two = new Address("City2", "Street2", 2, 2);
        Address three = new Address("City3", "Street3", 3, 3);
        List<Profile> profileList = Arrays.asList(
                new Profile(one),
                new Profile(two),
                new Profile(three));
        List<Address> result = Profiles.collect(profileList);
        List<Address> expected = Arrays.asList(one, two, three);
        assertEquals(result, expected);
    }

    @Test
    public void whenTestMethodCollectSortWithoutDuplicate() {
        Address one = new Address("City1", "Street1", 1, 1);
        Address two = new Address("City2", "Street2", 2, 2);
        Address three = new Address("City3", "Street3", 3, 3);
        Address four = new Address("City1", "Street1", 1, 1);
        Address five = new Address("City2", "Street2", 2, 2);
        Address six = new Address("City3", "Street3", 3, 3);
        List<Profile> profiles = Arrays.asList(
                new Profile(one),
                new Profile(two),
                new Profile(three),
                new Profile(four),
                new Profile(five),
                new Profile(six));
        List<Address> result = Profiles.collectSortWithoutDuplicate(profiles);
        List<Address> expected = Arrays.asList(one, two, three);
        assertEquals(result, expected);

    }
}
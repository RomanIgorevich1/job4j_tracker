package ru.job4j.collection;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.Arrays;

public class LexSortTest {

    @Test
    public void sortNum1And2And10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."};
        String[] out = {
                "1. Task.",
                "2. Task.",
                "10. Task."};
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }
}
package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void whenFirst5ThenMaxFirst() {
        int first = 5;
        int second = 3;
        int rsl = Max.max(first, second);
        int expected = 5;
        Assert.assertEquals(rsl, expected);
    }

    @Test
    public void whenThird6ThenMaxThird() {
        int first = 5;
        int second = 3;
        int third = 6;
        int rsl = Max.max(first, second, third);
        int expected = 6;
        Assert.assertEquals(rsl, expected);
    }

    @Test
    public void whenFourth9ThenMaxFourth() {
        int first = 5;
        int second = 3;
        int third = 6;
        int fourth = 9;
        int rsl = Max.max(first, second, third, fourth);
        int expected = 9;
        Assert.assertEquals(rsl, expected);
    }
}
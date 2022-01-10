package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PointTest {

    @Test
    public void point() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(2.0, 0.001));
    }

    @Test
    public void point2() {
        Point a = new Point(2, 4);
        Point b = new Point(6, 7);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(5.0, 0.001));
    }
}
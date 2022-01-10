package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PointTest {

    @Test
    public void whenPoint0ThenDistance2() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(2.0, 0.001));
    }

    @Test
    public void whenPoint6ThenDistance5() {
        Point a = new Point(2, 4);
        Point b = new Point(6, 7);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(5.0, 0.001));
    }

    @Test
    public void whenPoint2ThenDistance2() {
        Point a = new Point(2, 2, 2);
        Point b = new Point(2, 2, 4);
        double rsl = a.distance3d(b);
        assertThat(rsl, closeTo(2, 0.001));
    }

    @Test
    public void whenPoint8ThenDistance7() {
        Point a = new Point(2, 2, 2);
        Point b = new Point(8, 5, 4);
        double rsl = a.distance3d(b);
        assertThat(rsl, closeTo(7, 0.001));
    }
}
package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JobTest {

    @Test
    public void whenCompareByNameAndPriority() {
        Comparator<Job> comp = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = comp.compare(new Job("Fix bugs", 0),
                new Job("Fix bugs", 1));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareAscByNameAndAscByPriority() {
        Comparator<Job> comp = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = comp.compare(new Job("Impl task", 1),
                new Job("Impl task", 2));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareAscByName() {
        Comparator<Job> comp = new JobAscByName();
        int rsl = comp.compare(new Job("Impl task", 0),
                new Job("Fix bugs", 1));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareDescName() {
        Comparator<Job> comp = new JobDescByName();
        int rsl = comp.compare(new Job("Impl task", 0),
                new Job("Fix bugs", 1));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareAscPriority() {
        Comparator<Job> comp = new JobAscByPriority();
        int rsl = comp.compare(new Job("Impl task", 0),
                new Job("Fix bugs", 1));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareAscByNameAndDescByPriority() {
        Comparator<Job> comp = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = comp.compare(new Job("Fix bugs", 0),
                new Job("Fix bugs", 1));
        assertThat(rsl, greaterThan(0));
    }
}
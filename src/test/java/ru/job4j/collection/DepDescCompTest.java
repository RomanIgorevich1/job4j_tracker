package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class DepDescCompTest {

    @Test
    public void compare() {
        int result = new DepDescComp().compare("K2/SK1/SSK2", "K2/SK1/SSK1");
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int result = new DepDescComp().compare("K2", "K2/SK1");
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenFirstDepartmentIsDifferentThenAsc() {
        int result = new DepDescComp().compare(
                "K2/SK1/SSK1",
                "K1/SK1/SSK2"
        );
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenFirstDepartmentIsDifferentThenDesc() {
        int result = new DepDescComp().compare(
                "K1/SK1/SSK1",
                "K2/SK1"
        );
        assertThat(result, greaterThan(0));
    }
}
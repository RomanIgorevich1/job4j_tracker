package ru.job4j.pojo;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setCode("Audi");
        License second = new License();
        second.setCode("Audi");
        assertThat(first, is(second));
    }

    @Test
    public void whenFirstEqSecond() {
        License first = new License();
        first.setModel("Toyota");
        License second = new License();
        second.setModel("Toyota");
        assertThat(first, is(second));
    }
}
package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"one", "1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected, is(1));
    }

    @Test
    public void whenMultiInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"1", "2", "3"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        int selected1 = input.askInt("Enter menu: ");
        int selected2 = input.askInt("Enter menu: ");
        assertThat(selected, is(1));
        assertThat(selected1, is(2));
        assertThat(selected2, is(3));
    }

    @Test
    public void whenCorrectInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected, is(1));
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"-2"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected, is(-2));
    }
}
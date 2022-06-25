package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CalcFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result  = CalcFunction.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunction() {
        List<Double> result = CalcFunction.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunction() {
        List<Double> result = CalcFunction.diapason(2, 6, x -> Math.pow(x, x));
        List<Double> expected = Arrays.asList(4D, 27D, 256D, 3125D);
        assertThat(result, is(expected));
    }
}
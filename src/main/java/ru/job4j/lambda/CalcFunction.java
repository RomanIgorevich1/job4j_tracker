package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CalcFunction {

    public static List<Double> diapason(int start, int end, Function<Double, Double> function) {
        List<Double> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            double num  = function.apply((double) i);
            list.add(num);
        }
        return list;
    }
}

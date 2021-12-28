package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int z) {
        return z + sum(10) + multiply(10) + minus(10) + divide(20);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(10);
        System.out.println(rsl);
        int rsl2 = Calculator.minus(10);
        System.out.println(rsl2);
        Calculator calc = new Calculator();
        int rsl3 = calc.divide(20);
        System.out.println(rsl3);
        Calculator sum = new Calculator();
        int rsl4 = sum.sumAllOperation(0);
        System.out.println(rsl4);
    }

}

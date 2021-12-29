package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int z) {
        return sum(z) + multiply(z) + minus(z) + divide(z);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(10);
        System.out.println(rsl);
        int rsl2 = Calculator.minus(10);
        System.out.println(rsl2);
        int rsl3 = calculator.divide(20);
        System.out.println(rsl3);
        int rsl4 = calculator.sumAllOperation(5);
        System.out.println(rsl4);
    }

}

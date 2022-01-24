package ru.job4j.poly;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " автобус приезжает на остановку с интервалом в 10 минут.");
    }
}

package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName()
                + " на маршруте Москва - Питер поезд будет следовать со скоростью 200 км/ч.");
    }
}

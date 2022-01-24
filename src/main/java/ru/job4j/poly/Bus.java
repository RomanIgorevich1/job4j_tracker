package ru.job4j.poly;

public class Bus implements Transport {

    private double price = 42.20;

    @Override
    public void drive() {
        System.out.print("Едем на дачу на ");
    }

    @Override
    public void passengers(int num) {
        if (num >= 5) {
            System.out.print("Автобусе ");
        } else {
            System.out.print("Автомобиле ");
        }
    }

    @Override
    public double gas(double fuel) {
        return fuel * price;
    }

    public static void main(String[] args) {
        Bus car = new Bus();
        car.drive();
        car.passengers(8);
        System.out.print("цена на бензин " + car.gas(30));
    }
}
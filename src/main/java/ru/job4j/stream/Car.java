package ru.job4j.stream;

import java.time.LocalDate;

public class Car {
    private String brand;
    private String model;
    private LocalDate create;
    private Double volume;
    private String color;

    static class Builder {
        private String brand;
        private String model;
        private LocalDate create;
        private Double volume;
        private String color;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildLocalDate(LocalDate create) {
            this.create = create;
            return this;
        }

        Builder buildVolume(Double volume) {
            this.volume = volume;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.color = color;
            car.create = create;
            car.volume = volume;
            car.model = model;
            return car;
        }
    }

    @Override
    public String toString() {
        return "{"
                + "brande='" + brand + '\''
                + ", model='" + model + '\''
                + ", create='" + create + '\''
                + ", volume='" + volume + '\''
                + ", color='" + color + '\''
                + '}';
    }

    public static void main(String[] args) {
        Car car = new Builder()
                .buildBrand("Toyota")
                .buildModel("Camry")
                .buildLocalDate(LocalDate.of(2021, 6, 1))
                .buildVolume(2.5)
                .buildColor("Red")
                .build();
        System.out.println(car);
        Car myCar = new Builder()
                .buildBrand("Mazda")
                .buildModel("CX-5")
                .buildLocalDate(LocalDate.of(2019, 11, 23))
                .buildVolume(2.0)
                .buildColor("Black")
                .build();
        System.out.println(myCar);
    }
}
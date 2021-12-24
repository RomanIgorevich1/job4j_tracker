package ru.job4j.oop;

public class Cat {

    private String name;
    private String food;

    public void show() {
        System.out.println(this.name + " and my food " + this.food);
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.giveNick("My nick is Gav");
        gav.eat("kotleta");
        gav.show();
        Cat black = new Cat();
        black.giveNick("My nick is Black");
        black.eat("fish");
        black.show();
    }
}

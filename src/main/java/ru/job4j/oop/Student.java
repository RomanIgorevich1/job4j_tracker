package ru.job4j.oop;

public class Student {

    public String draw() {
        String ln = System.lineSeparator();
        return   "   ^    " + ln
                + " /   \\ " + ln
                + "/_____\\" + ln;
    }

    public static void main(String[] args) {
        Student roma = new Student();
        System.out.println(roma.draw());
    }
}

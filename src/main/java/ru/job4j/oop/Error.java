package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String massage;

    public Error() {
    }

    public Error(boolean active, int status, String massage) {
        this.active = active;
        this.status = status;
        this.massage = massage;
    }

    public void info() {
        System.out.println("2 + 2 = 4 " + active);
        System.out.println("100 + 100 =  " + status);
        System.out.println("Hello " + massage);
    }

    public static void main(String[] args) {
        Error err = new Error();
        Error err1 = new Error(true, 200, "World!");
        err.info();
        err1.info();
    }
}

package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private String organ;

    public Surgeon(String name, String surname, String education, int birthday, String softskills, String organ) {
        super(name, surname, education, birthday, softskills);
        this.organ = organ;
    }

    public String operation(String organ) {
        return organ;
    }
}

package ru.job4j.inheritance;

public class Doctor extends Profession {

    private String softskills;

    public Doctor(String name, String surname, String education, int birthday, String softskills) {
        super(name, surname, education, birthday);
        this.softskills = softskills;
    }

    public String therapy(String softskills) {
        return softskills;
    }
}

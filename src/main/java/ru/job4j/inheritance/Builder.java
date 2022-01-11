package ru.job4j.inheritance;

public class Builder extends Engineer {

    private String detail;

    public Builder(String name, String surname, int birthday, String education, int experience, String detail) {
        super(name, surname, education, birthday, experience);
        this.detail = detail;
    }

    public String repair(String detail) {
        return detail;
    }
}

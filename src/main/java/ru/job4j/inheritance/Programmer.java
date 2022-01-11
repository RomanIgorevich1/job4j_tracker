package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String project;

    public Programmer(String name, String surname, String education, int birthday, int experience, String project) {
        super(name, surname, education, birthday, experience);
        this.project = project;
    }

    public String petProject(String project) {
        return project;
    }
}
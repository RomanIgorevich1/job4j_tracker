package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private int tooth;

    public Dentist(String name, String surname, int birthday, String eduction, String softskills, int tooth) {
        super(name, surname, eduction, birthday, softskills);
        this.tooth = tooth;
    }

    public int caries(int tooth) {
        return tooth;
    }
}

package ru.job4j.encapsulation;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Роман");
        student.setGroup("Информационные технологии");
        student.setAdmission(new Date());
        System.out.println("Студент " + student.getName() + " поступил на факультет "
                + student.getGroup() + " зачислен " + student.getAdmission());
    }
}

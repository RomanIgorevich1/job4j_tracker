package ru.job4j.map;

import java.util.*;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> result = Optional.empty();
        for (Student student : students.keySet()) {
            if (account.equals(student.getAccount())) {
                result = Optional.of(student);
                break;
            }
        }
        return result;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Student> findAcc = findByAccount(account);
        Optional<Subject> result = Optional.empty();
        if (findAcc.isPresent()) {
            Set<Subject> subjects = students.get(findAcc.get());
            for (Subject subject : subjects) {
                if (name.equals(subject.getName())) {
                    result = Optional.of(subject);
                    break;
                }
            }
        }
        return result;
    }
}

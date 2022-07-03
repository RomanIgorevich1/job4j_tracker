package ru.job4j.map;

import java.util.Objects;

public class Student {
    private String name;
    private String group;
    private String account;

    public Student(String name, String account, String group) {
        this.name = name;
        this.group = group;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public String getAccount() {
        return account;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return Objects.equals(account, student.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, account, group);
    }
}

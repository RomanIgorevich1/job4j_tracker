package ru.job4j.trial;

public class Builder {
    public static void main(String[] args) {
        Person person = new PersonImp()
                .setName("Roman")
                .setAge(31)
                .setSalary(5000)
                .build();
        person.print();
    }
}

class Person {
    String name;
    int age;
    double salary;

    public void print() {
        System.out.println(name + " " + age + " " + salary);
    }
}

interface BuilderTrial {
    BuilderTrial setName(String name);

    BuilderTrial setAge(int age);

    BuilderTrial setSalary(double salary);

    Person build();
}

class PersonImp implements BuilderTrial {
    Person person = new Person();

    @Override
    public BuilderTrial setName(String name) {
        person.name = name;
        return this;
    }

    @Override
    public BuilderTrial setAge(int age) {
        person.age = age;
        return this;
    }

    @Override
    public BuilderTrial setSalary(double salary) {
        person.salary = salary;
        return this;
    }

    @Override
    public Person build() {
        return person;
    }
}


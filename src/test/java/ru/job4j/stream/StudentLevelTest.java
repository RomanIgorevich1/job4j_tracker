package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StudentLevelTest {

    @Test
    public void whenSorted() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Masha", 28));
        studentList.add(new Student("Petya", 128));
        List<Student> expected = List.of(
                new Student("Petya", 128),
                new Student("Masha", 28));
        assertThat(StudentLevel.levelOf(studentList, 20), is(expected));
    }

    @Test
    public void whenOnlyNull() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(null);
        List<Student> expected = List.of();
        assertThat(StudentLevel.levelOf(studentList, 100), is(expected));
    }

    @Test
    public void whenHasNull() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(null);
        studentList.add(new Student("Petya", 28));
        List<Student> expected = List.of(new Student("Petya", 28));
        assertThat(StudentLevel.levelOf(studentList, 10), is(expected));
    }
}
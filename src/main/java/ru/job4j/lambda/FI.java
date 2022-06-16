package ru.job4j.lambda;

import ru.job4j.collection.StringCompare;

import java.util.Arrays;
import java.util.Comparator;

public class FI {

    public static void main(String[] args) {
        Attachment[] att = {
                new Attachment("1", 20),
                new Attachment("3", 120),
                new Attachment("2", 23)};
        Comparator<Attachment> comparator = (left, right) -> Integer.compare(left.getSize(), right.getSize());
        Arrays.sort(att, comparator);

        String[] array = {"Roma", "Sveta", "Viktor", "Dmitriy"};
        Comparator<String> comparator1 = (left, right) -> left.compareTo(right);
        Arrays.sort(array, comparator1);
        System.out.println(Arrays.toString(array));
        Comparator<String> comparator2 = (left, right) -> Integer.compare(right.length(), left.length());
        Arrays.sort(array, comparator2);
        System.out.println(Arrays.toString(array));
    }
}

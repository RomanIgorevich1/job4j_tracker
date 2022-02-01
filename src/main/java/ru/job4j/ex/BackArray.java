package ru.job4j.ex;

import java.util.Arrays;

public class BackArray {
    public static void main(String[] args) {
        String[] names = {"Petr", "Ivan", "Nick", "Vasya"};
        int middle = names.length / 2;
        for (int i = 0; i < names.length - 1; i++) {
            String temp = names[i];
            names[i] = names[names.length - 1];
            names[names.length - 1] = temp;
        }
        System.out.println(Arrays.toString(names));
    }
}

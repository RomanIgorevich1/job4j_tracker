package ru.job4j.collection;
import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] words = left.split(". ");
        String[] listWords = right.split(". ");
        return Integer.compare(Integer.parseInt(words[0]), Integer.parseInt(listWords[0]));
    }
}
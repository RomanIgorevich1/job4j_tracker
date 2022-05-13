package ru.job4j.collection;

import java.util.*;

public class DepDescComp implements Comparator<String> {
    /**
     * должен реализовать сравнение, если первые элементы равны, то идем по возрастанию,
     * если нет то по убыванию.
     * @param o1 строка для сравнения
     * @param o2 строка для сравнения
     * @return результат выражения, а именно равен ли первый элемент
     */
    @Override
    public int compare(String o1, String o2) {
        String[] one = o1.split("/");
        String[] two = o2.split("/");
        int result = two[0].compareTo(one[0]);
        return result == 0 ? o1.compareTo(o2) : result;
    }
}

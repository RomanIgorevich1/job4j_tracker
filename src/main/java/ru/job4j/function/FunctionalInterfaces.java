package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biConsumer = (number, word) -> map.put(number, word);
        biConsumer.accept(1, "one");
        biConsumer.accept(2, "two");
        biConsumer.accept(3, "three");
        biConsumer.accept(4, "four");
        biConsumer.accept(5, "five");
        biConsumer.accept(6, "six");
        biConsumer.accept(7, "seven");
        BiPredicate<Integer, String> biPredicate = (number, word) -> number % 2 == 0 || word.length() == 4;
        for (Integer i : map.keySet()) {
            if (biPredicate.test(i, map.get(i))) {
                System.out.println("key " + i + " value " + map.get(i));
            }
        }
        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        List<String> list = (sup.get());
        Consumer<String> consumer = (word) -> System.out.print(word + ", ");
        Function<String, String> function = (word1) -> word1.toUpperCase();
        for (String str : list) {
            consumer.accept(function.apply(str));
        }
    }
}

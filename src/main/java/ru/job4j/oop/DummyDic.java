package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String word = "World";
        return word;
    }

    public static void main(String[] args) {
        DummyDic human = new DummyDic();
        String word = "Мир";
        String speak = human.engToRus(word);
        System.out.println("Неизвестное слово. " + speak);
    }
}

package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизввестное слово. " + eng;
    }

    public static void main(String[] args) {
        DummyDic human = new DummyDic();
        String word = "Мир";
        String speak = human.engToRus(word);
        System.out.println(speak);
    }
}

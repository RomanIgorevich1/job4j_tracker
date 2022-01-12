package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String currentDataTime = item.getCreate().format(formatter);
        System.out.println("Текущая дата и время после форматирования " + currentDataTime);
    }
}
package ru.job4j.tracker;

import java.util.Scanner;

public class StartUi {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Select:");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create new Item ===");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Заявка добавлена " + item);
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                    System.out.println(item);
                    }
                } else {
                    System.out.println("Хранилище еще не содержит заявок.");
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.println("Enter id:");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter name");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.replace(id, item);
                System.out.println("Заявка изменена успешно");
            } else if (select == 6) {
                System.out.println("Пользователь выбрал " + select);
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {"Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"};
        System.out.println("Menu: ");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUi().init(scanner, tracker);

    }
}

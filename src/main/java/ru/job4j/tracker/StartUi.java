package ru.job4j.tracker;

import java.util.Scanner;

public class StartUi {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.println("Select:");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("===Create new Item===");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Заявка добавлена " + name);
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
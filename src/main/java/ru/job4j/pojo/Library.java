package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Java", 100);
        Book book2 = new Book("Head first", 120);
        Book book3 = new Book("The Witcher", 200);
        Book book4 = new Book("Clean code", 230);
        Book[] array = new Book[4];
        array[0] = book1;
        array[1] = book2;
        array[2] = book3;
        array[3] = book4;
        for (Book book : array) {
            System.out.println(book.getName() + " " + book.getPage());
        }
        System.out.println("Replace book number");
        Book tmp = array[0];
        array[0] = array[3];
        array[3] = tmp;
        for (Book book : array) {
            System.out.println(book.getName());
        }
        for (Book book : array) {
            String book5 = "Clean code";
            if (book.getName().equals(book5)) {
                System.out.println(book.getName());
            }
        }
    }
}

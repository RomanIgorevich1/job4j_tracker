package ru.job4j.pojo;

public class Shop {
    public static void main(String[] args) {
        Product[] prods = new Product[5];
        prods[0] = new Product("Milk", 10);
        prods[1] = new Product("Bread", 13);
        prods[2] = new Product("Egg", 9);
        for (Product prod : prods) {
            if (prod != null) {
                System.out.println(prod.getName());
            }
        }
    }

    public static int indexOfNull(Product[] prods) {
        for (int i = 0; i < prods.length; i++) {
            Product prod = prods[i];
            if (prod == null) {
               return i;
            }
        } return -1;
    }
}

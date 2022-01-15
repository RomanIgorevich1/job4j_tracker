package ru.job4j.pojo;

public class ShopDrop {
    public static void main(String[] args) {
        Product[] prod = new Product[3];
        prod[0] = new Product("Milk", 10);
        prod[1] = new Product("Bread", 5);
        prod[2] = new Product("Egg", 12);
        for (Product prods : prod) {
            System.out.println(prods.getName());
        }
        System.out.println("Replace products");
        System.out.println(" ");

        for (int i = 0; i < prod.length; i++) {
            Product prods = prod[i];
            if (prods != null) {
                System.out.println(prods.getName());
            } else {
                System.out.println("null");
            }
        }
        prod[1] = prod[2];
        prod[2] = null;
        for (int i = 0; i < prod.length; i++) {
            Product prods = prod[i];
            if (prods != null) {
                System.out.println(prods.getName());
            } else {
                System.out.println("null");
            }
        }
    }

    public static Product[] delete(Product[] products, int index) {
        for (int i = index; i < products.length - 1; i++) {
            products[i] = products[i + 1];
        }
        products[products.length - 1] = null;
        return products;
    }
}


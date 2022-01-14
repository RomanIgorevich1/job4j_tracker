package ru.job4j.pojo;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class ShopTest {

    @Test
    public void whenLastNull() {
        Product[] prods = new Product[5];
        prods[0] = new Product("Milk", 10);
        prods[1] = new Product("Bread", 13);
        prods[2] = new Product("Egg", 9);
        int rsl = Shop.indexOfNull(prods);
        assertThat(rsl, is(3));
    }

    @Test
    public void whenFirstNull() {
        Product[] prods = new Product[5];
        prods[1] = new Product("Milk", 10);
        int rsl = Shop.indexOfNull(prods);
        assertThat(rsl, is(0));
    }

    @Test
    public void whenHasNotNull() {
        Product[] prods = new Product[3];
        prods[0] = new Product("Milk", 10);
        prods[1] = new Product("Bread", 13);
        prods[2] = new Product("Egg", 9);
        int rsl = Shop.indexOfNull(prods);
        assertThat(rsl, is(-1));
    }
}
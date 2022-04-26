package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {

    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenDuplicateOrder() {
        List<Order>  order = new ArrayList<>();
        order.add(new Order("123", "Jacket"));
        order.add(new Order("321", "Coat"));
        order.add(new Order("123", "Jacket"));
        order.add(new Order("543", "Blazer"));
        HashMap<String, Order> map = OrderConvert.process(order);
        assertThat(map.size(), is(3));
    }
}
package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] array = new Item[items.length];
        int count = 0;
        for (int i = 0; i < this.size; i++) {
            Item item = items[i];
            if (item.getName().equals(key)) {
                array[count] = item;
                count++;
            }
        }
        return Arrays.copyOf(array, count);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < this.size; i++) {
            Item item = items[i];
            if (item.getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items[index].setName(item.getName());
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        int start = index + 1;
        int length = size - index - 1;
        boolean rsl = index != -1;
        for (int i = 0; i < items.length; i++) {
            if (rsl) {
                System.arraycopy(items, start, items, index, length);
                items[items.length - 1] = null;
                items[size - 1] = null;
                size--;
                break;
            }
        }
        return rsl;
    }
}
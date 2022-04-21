package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private List<Item> items = new ArrayList<>(100);
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>(items.size());
        for (Item pr : items) {
            if (pr.getName().equals(key)) {
                 list.add(pr);
            }
        }
        return list;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (Item pr : items) {
            if (pr.getId() == id) {
                rsl = pr.getId();
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index - 1) : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index - 1, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
                items.remove(items.get(index - 1));
        }
        return rsl;
    }
}
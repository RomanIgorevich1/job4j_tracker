package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public class DeleteAllItems implements UserAction {
    private final Output output;

    public DeleteAllItems(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Delete all items";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws SQLException {
        output.println("=== Delete all items ===");
        List<Item> allItem = tracker.findAll();
        List<Integer> collect = allItem.stream()
                .map(Item::getId).toList();
        for (Integer integer : collect) {
            tracker.delete(integer);
        }
        output.println("=== Все заявки удалены ===");
        return true;
    }
}

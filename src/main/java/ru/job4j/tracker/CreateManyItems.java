package ru.job4j.tracker;

import java.sql.SQLException;

public class CreateManyItems implements UserAction {
    private final Output output;

    public CreateManyItems(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Create many items";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws SQLException {
        output.println("=== Create many items ===");
        int count = input.askInt("Введите кол-во заявок ");
        for (int i = 0; i < count; i++) {
            tracker.add(new Item("Заявка № " + i));
        }
        output.println("Добавлено заявок: " + count);
        return true;
    }
}

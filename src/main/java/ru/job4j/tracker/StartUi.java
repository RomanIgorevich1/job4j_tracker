package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StartUi {
    private final Output out;

    public StartUi(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> list) throws SQLException {
        boolean run = true;
        while (run) {
            this.showMenu(list);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= list.size()) {
                out.println("Wrong input, you can select: 0 .. " + (list.size() - 1));
                continue;
            }
            UserAction user = list.get(select);
            run = user.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> list) {
        out.println("Menu: ");

        for (int i = 0; i < list.size(); i++) {
            out.println(i + " " + list.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        try (Store tracker = new SqlTracker()) {
            List<UserAction> actions = new ArrayList<>();
            actions.add(new CreateAction(output));
            actions.add(new CreateManyItems(output));
            actions.add(new ShowAction(output));
            actions.add(new EditAction(output));
            actions.add(new DeleteAction(output));
            actions.add(new DeleteAllItems(output));
            actions.add(new FindActionId(output));
            actions.add(new FindActionName(output));
            actions.add(new ExitAction());
            new StartUi(output).init(input, tracker, actions);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
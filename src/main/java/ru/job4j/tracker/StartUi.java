package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUi {
    private final Output out;

    public StartUi(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> list) {
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
        for (UserAction user : list) {
            out.println(user.name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> list = new ArrayList<>();
        list.add(new CreateAction(output));
        list.add(new ShowAction(output));
        list.add(new EditAction(output));
        list.add(new DeleteAction(output));
        list.add(new FindActionId(output));
        list.add(new FindActionName(output));
        list.add(new ExitAction());
        new StartUi(output).init(input, tracker, list);
    }
}

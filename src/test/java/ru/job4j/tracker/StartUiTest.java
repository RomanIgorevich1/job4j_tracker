package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

public class StartUiTest  {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(out), new ExitAction()};
        new StartUi(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replace item"));
        String replacedName = "New item name";
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "New item name", "1"});
        UserAction[] actions = {new EditAction(out), new ExitAction()};
        new StartUi(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Delete item"));
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {new DeleteAction(out), new ExitAction()};
        new StartUi(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new ExitAction()};
        new StartUi(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu: " + System.lineSeparator()
                + "0. Exit Program" + System.lineSeparator()));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New item name";
        Input in = new StubInput(new String[] {"0", String.valueOf(one.getId()), replaceName, "1"});
        UserAction[] actions = new UserAction[] {new EditAction(out), new ExitAction()};
        new StartUi(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu: " + ln
                + "0. Edit item" + ln
                + "1. Exit Program" + ln
                + "=== Edit item ===" + ln
                + "Заявка изменена успешно." + ln
                + "Menu: " + ln
                + "0. Edit item" + ln
                + "1. Exit Program" + ln));
    }

    @Test
    public void whenFindAllActionSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        Input in = new StubInput(new String[] {"0", "1"});
        UserAction[] actions = new UserAction[]{new ShowAction(out), new ExitAction()};
        new StartUi(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu: " + ln
                + "0. Show all item" + ln
                + "1. Exit Program" + ln
                + "=== Show all item ===" + ln
                + one + ln
                + two + ln
                + "Menu: " + ln
                + "0. Show all item" + ln
                + "1. Exit Program" + ln));
    }

    @Test
    public void whenFindByNameActionSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(new String[] {"0", String.valueOf(one.getName()), "1"});
        UserAction[] actions = new UserAction[] {new FindActionName(out), new ExitAction()};
        new StartUi(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu: " + ln
                + "0. Find item by name" + ln
                + "1. Exit Program" + ln
                + "=== Find item by Name ===" + ln
                + one + ln
                + "Menu: " + ln
                + "0. Find item by name" + ln
                + "1. Exit Program" + ln));
    }

    @Test
    public void whenFindByIdActionSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(new String[] {"0", String.valueOf(one.getId()), "1"});
        UserAction[] actions = new UserAction[] {new FindActionId(out), new ExitAction()};
        new StartUi(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu: " + ln
                + "0. Find item by id" + ln
                + "1. Exit Program" + ln
                + "=== Find item by id ===" + ln
                + one + ln
                + "Menu: " + ln
                + "0. Find item by id" + ln
                + "1. Exit Program" + ln));
    }
}
package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.ex.User;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

public class StartUiTest  {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        List<UserAction> list = new ArrayList<>();
        list.add(new CreateAction(out));
        list.add(new ExitAction());
        new StartUi(out).init(in, tracker, list);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replace item"));
        String replacedName = "New item name";
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "New item name", "1"});
        List<UserAction> list =  new ArrayList<>();
        list.add(new EditAction(out));
        list.add(new ExitAction());
        new StartUi(out).init(in, tracker, list);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Delete item"));
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        List<UserAction> list = new ArrayList<>();
        list.add(new DeleteAction(out));
        list.add(new ExitAction());
        new StartUi(out).init(in, tracker, list);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0"});
        Tracker tracker = new Tracker();
        List<UserAction> list = new ArrayList<>();
        list.add(new ExitAction());
        new StartUi(out).init(in, tracker, list);
        assertThat(out.toString(), is("Menu: " + System.lineSeparator()
                + "Exit Program" + System.lineSeparator()));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New item name";
        Input in = new StubInput(new String[] {"0", String.valueOf(one.getId()), replaceName, "1"});
        List<UserAction> list = new ArrayList<>();
        list.add(new EditAction(out));
        list.add(new ExitAction());
        new StartUi(out).init(in, tracker, list);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu: " + ln
                + "Edit item" + ln
                + "Exit Program" + ln
                + "=== Edit item ===" + ln
                + "Заявка изменена успешно." + ln
                + "Menu: " + ln
                + "Edit item" + ln
                + "Exit Program" + ln));
    }

    @Test
    public void whenFindAllActionSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        Input in = new StubInput(new String[] {"0", "1"});
        List<UserAction> list = new ArrayList<>();
        list.add(new ShowAction(out));
        list.add(new ExitAction());
        new StartUi(out).init(in, tracker, list);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu: " + ln
                + "Show all item" + ln
                + "Exit Program" + ln
                + "=== Show all item ===" + ln
                + one + ln
                + two + ln
                + "Menu: " + ln
                + "Show all item" + ln
                + "Exit Program" + ln));
    }

    @Test
    public void whenFindByNameActionSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(new String[] {"0", one.getName(), "1"});
        List<UserAction> list = new ArrayList<>();
        list.add(new FindActionName(out));
        list.add(new ExitAction());
        new StartUi(out).init(in, tracker, list);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu: " + ln
                + "Find item by name" + ln
                + "Exit Program" + ln
                + "=== Find item by Name ===" + ln
                + one + ln
                + "Menu: " + ln
                + "Find item by name" + ln
                + "Exit Program" + ln));
    }

    @Test
    public void whenFindByIdActionSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(new String[] {"0", String.valueOf(one.getId()), "1"});
        List<UserAction> list = new ArrayList<>();
        list.add(new FindActionId(out));
        list.add(new ExitAction());
        new StartUi(out).init(in, tracker, list);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu: " + ln
                + "Find item by id" + ln
                + "Exit Program" + ln
                + "=== Find item by id ===" + ln
                + one + ln
                + "Menu: " + ln
                + "Find item by id" + ln
                + "Exit Program" + ln));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(new String[] {"7", "0"});
        List<UserAction> list = new ArrayList<>();
        list.add(new ExitAction());
        new StartUi(out).init(in, tracker, list);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu: " + ln
                + "Exit Program" + ln
                + "Wrong input, you can select: 0 .. 0" + ln
                + "Menu: " + ln
                + "Exit Program" + ln));
    }
}
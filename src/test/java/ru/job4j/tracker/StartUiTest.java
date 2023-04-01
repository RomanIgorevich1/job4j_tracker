package ru.job4j.tracker;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StartUiTest  {

    @Test
    public void whenCreateItem() throws SQLException {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0", "Item name", "1"});
        Store memTracker = new SqlTracker();
        List<UserAction> list = new ArrayList<>();
        list.add(new CreateAction(out));
        list.add(new ExitAction());
        new StartUi(out).init(in, memTracker, list);
        assertThat(memTracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() throws SQLException {
        Output out = new StubOutput();
        Store memTracker = new SqlTracker();
        Item item = memTracker.add(new Item("Replace item"));
        String replacedName = "New item name";
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "New item name", "1"});
        List<UserAction> list =  new ArrayList<>();
        list.add(new EditAction(out));
        list.add(new ExitAction());
        new StartUi(out).init(in, memTracker, list);
        assertThat(memTracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteItem() throws SQLException {
        Output out = new StubOutput();
        Store memTracker = new SqlTracker();
        Item item = memTracker.add(new Item("Delete item"));
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        List<UserAction> list = new ArrayList<>();
        list.add(new DeleteAction(out));
        list.add(new ExitAction());
        new StartUi(out).init(in, memTracker, list);
        assertThat(memTracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenExit() throws SQLException {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0"});
        Store memTracker = new SqlTracker();
        List<UserAction> list = new ArrayList<>();
        list.add(new ExitAction());
        new StartUi(out).init(in, memTracker, list);
        assertThat(out.toString()).isEqualTo("Menu: " + System.lineSeparator()
                + "0 Exit Program" + System.lineSeparator());
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() throws SQLException {
        Output out = new StubOutput();
        Store memTracker = new SqlTracker();
        Item one = memTracker.add(new Item("test1"));
        String replaceName = "New item name";
        Input in = new StubInput(new String[] {"0", String.valueOf(one.getId()), replaceName, "1"});
        List<UserAction> list = new ArrayList<>();
        list.add(new EditAction(out));
        list.add(new ExitAction());
        new StartUi(out).init(in, memTracker, list);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("Menu: " + ln
                + "0 Edit item" + ln
                + "1 Exit Program" + ln
                + "=== Edit item ===" + ln
                + "Заявка изменена успешно." + ln
                + "Menu: " + ln
                + "0 Edit item" + ln
                + "1 Exit Program" + ln);
    }

    @Test
    public void whenFindAllActionSuccessfully() throws SQLException {
        Output out = new StubOutput();
        Store memTracker = new SqlTracker();
        Item one = memTracker.add(new Item("test1"));
        Item two = memTracker.add(new Item("test2"));
        Input in = new StubInput(new String[] {"0", "1"});
        List<UserAction> list = new ArrayList<>();
        list.add(new ShowAction(out));
        list.add(new ExitAction());
        new StartUi(out).init(in, memTracker, list);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("Menu: " + ln
                + "0 Show all item" + ln
                + "1 Exit Program" + ln
                + "=== Show all item ===" + ln
                + one + ln
                + two + ln
                + "Menu: " + ln
                + "0 Show all item" + ln
                + "1 Exit Program" + ln);
    }

    @Test
    public void whenFindByNameActionSuccessfully() throws SQLException {
        Output out = new StubOutput();
        Store memTracker = new SqlTracker();
        Item one = memTracker.add(new Item("test1"));
        Input in = new StubInput(new String[] {"0", one.getName(), "1"});
        List<UserAction> list = new ArrayList<>();
        list.add(new FindActionName(out));
        list.add(new ExitAction());
        new StartUi(out).init(in, memTracker, list);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("Menu: " + ln
                + "0 Find item by name" + ln
                + "1 Exit Program" + ln
                + "=== Find item by Name ===" + ln
                + one + ln
                + "Menu: " + ln
                + "0 Find item by name" + ln
                + "1 Exit Program" + ln);
    }

    @Test
    public void whenFindByIdActionSuccessfully() throws SQLException {
        Output out = new StubOutput();
        Store memTracker = new SqlTracker();
        Item one = memTracker.add(new Item("test1"));
        Input in = new StubInput(new String[] {"0", String.valueOf(one.getId()), "1"});
        List<UserAction> list = new ArrayList<>();
        list.add(new FindActionId(out));
        list.add(new ExitAction());
        new StartUi(out).init(in, memTracker, list);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("Menu: " + ln
                + "0 Find item by id" + ln
                + "1 Exit Program" + ln
                + "=== Find item by id ===" + ln
                + one + ln
                + "Menu: " + ln
                + "0 Find item by id" + ln
                + "1 Exit Program" + ln);
    }

    @Test
    public void whenInvalidExit() throws SQLException {
        Output out = new StubOutput();
        Store memTracker = new SqlTracker();
        Input in = new StubInput(new String[] {"7", "0"});
        List<UserAction> list = new ArrayList<>();
        list.add(new ExitAction());
        new StartUi(out).init(in, memTracker, list);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("Menu: " + ln
                + "0 Exit Program" + ln
                + "Wrong input, you can select: 0 .. 0" + ln
                + "Menu: " + ln
                + "0 Exit Program" + ln);
    }
}
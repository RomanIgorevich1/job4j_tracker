package ru.job4j.tracker;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

public class MemTrackerTest {

    @Test
    public void whenFindByIdSuccessfully() {
        Output output =  new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item(1, "Ivan"));
        Input input = mock(Input.class);
        FindActionId find = new FindActionId(output);
        when(input.askInt(any(String.class))).thenReturn(item.getId());
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ===" + ln
                + item + ln);
    }

    @Test
    public void whenFindByIdFails() {
        Output output =  new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item(1, "Ivan"));
        Input input = mock(Input.class);
        FindActionId find = new FindActionId(output);
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ===" + ln
                        + "Заявка с введенным id: " + new Item().getId() + " не найдена." + ln);
    }

    @Test
    public void whenDeleteSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item(1, "Roman"));
        Input input = mock(Input.class);
        DeleteAction deleteAction = new DeleteAction(output);
        when(input.askInt(any(String.class))).thenReturn(item.getId());
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Delete Item ===" + ln
                        + "Заявка удалена успешно." + ln
        );
    }

    @Test
    public void whenDeleteFails() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item(1, "Roman"));
        Input input = mock(Input.class);
        DeleteAction deleteAction = new DeleteAction(output);
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Delete Item ===" + ln
                        + "Ошибка удаления заявки." + ln
        );
    }

    @Test
    public void whenReplaceAction() throws SQLException {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        String replacedName = "New item name";
        EditAction replaceAction = new EditAction(output);
        Input input = mock(Input.class);
        Item item = tracker.add(new Item("Replace name"));
        when(input.askInt(any(String.class))).thenReturn(item.getId());
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        replaceAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln);
    }

    @Test
    public void whenReplaceErr() throws SQLException {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        String replacedName = "New item name";
        EditAction replaceAction = new EditAction(output);
        Input input = mock(Input.class);
        Item item = tracker.add(new Item("Replace name"));
        replaceAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Edit item ===" + ln
                        + "Ошибка замены заявки." + ln);
    }

    @Test
    public void whenFindByNameSuccessfully() {
        Output output =  new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item(1, "Ivan"));
        Input input = mock(Input.class);
        FindActionName find = new FindActionName(output);
        when(input.askStr(any(String.class))).thenReturn(item.getName());
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by Name ===" + ln
                        + item + ln);
    }

    @Test
    public void whenFindByNameFails() {
        Output output =  new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item(1, "Ivan"));
        Input input = mock(Input.class);
        FindActionName find = new FindActionName(output);
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by Name ===" + ln
                        + "Заявки с именем: " + new Item().getName() + " не найдены." + ln);
    }
}
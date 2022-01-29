package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

public class StartUiTest  {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(), new ExitAction()};
        new StartUi().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replace item"));
        String replacedName = "New item name";
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "New item name", "1"});
        UserAction[] actions = {new EditAction(), new ExitAction()};
        new StartUi().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Delete item"));
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {new DeleteAction(), new ExitAction()};
        new StartUi().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
}
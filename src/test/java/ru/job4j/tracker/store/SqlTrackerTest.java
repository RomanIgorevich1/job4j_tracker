package ru.job4j.tracker.store;

import java.io.FileInputStream;
import java.sql.Connection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.SqlTracker;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {
    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream inputStream = new FileInputStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(inputStream);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenReplaceItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item_1");
        tracker.add(item);
        assertThat(tracker.replace(item.getId(), new Item("item_2"))).isTrue();
    }

    @Test
    public void whenDeleteItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item_1");
        Item item2 = new Item("item_2");
        tracker.add(item1);
        tracker.add(item2);
        tracker.delete(item1.getId());
        assertThat(tracker.findById(item1.getId())).isNull();
    }

    @Test
    public void whenFindAllItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item_1");
        Item item2 = new Item("item_2");
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findAll().get(1).getName()).isEqualTo("item_2");
    }

    @Test
    public void whenFindByIdItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item_1");
        Item item2 = new Item("item_2");
        Item item3 = new Item("item_3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findById(item3.getId())).isEqualTo(item3);
    }

    @Test
    public void whenFindByNameItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item_1");
        Item item2 = new Item("item_2");
        Item item3 = new Item("item_3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findByName(item2.getName()).get(0)).isEqualTo(item2);
    }
}

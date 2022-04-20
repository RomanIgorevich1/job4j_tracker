package ru.job4j.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertMatrixToListTest {

    @Test
    public void when2on2ArrayThanList4() {
        ConvertMatrixToList list = new ConvertMatrixToList();
        int[][] input = {{1, 2}, {3, 4}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        List<Integer> result = list.toList(input);
        assertThat(result, is(expected));
    }

    @Test
    public void when4on4ArrayThanList8() {
        ConvertMatrixToList list = new ConvertMatrixToList();
        int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        List<Integer> result = list.toList(input);
        assertThat(result, is(expected));
    }
}
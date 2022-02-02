package ru.job4j.ex;

public class FindEl {
    public int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element not found.");
        }
        return rsl;
    }

    public static void main(String[] args) {
        FindEl index = new FindEl();
        try {
            System.out.println(index.indexOf(new String[] {"Petr", "Nick", "Roman", "Oleg", "Ivan"}, "Roman"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(index.indexOf(new String[] {"Petr", "Nick", "Roman", "Oleg", "Ivan"}, "Igor"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}

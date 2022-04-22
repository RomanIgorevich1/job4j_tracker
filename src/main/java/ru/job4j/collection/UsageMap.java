package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("votmoyapoch1@bk.ru", "Frolov Roman Igorevich");
        for (String str : map.keySet()) {
            String value = map.get(str);
            System.out.println(str + " = " + value);
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);

        }
    }
}
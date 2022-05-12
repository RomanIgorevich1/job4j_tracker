package ru.job4j.collection;

import java.util.*;

public class Departments {
    /**
     * должен сформировать список строк, при этом требуется учесть все возможные отсутствующие коды подразделений.
     * добавляет пропущенные подразделения и сортирует их
     * @param deps список строк
     * @return возвращает новый лист
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                tmp.add(start + el);
                tmp.add(value);
                break;
            }
        }
        return new ArrayList<>(tmp);
    }

    /**
     * должен просто отсортировать по возрастанию список строк, который он принимает на вход
     * @param orgm список строк
     */
    public static void sortAsc(List<String> orgm) {
        Collections.sort(orgm);
    }

    /**
     * должен отсортировать в соответствии с компаратором DepDescComp(с учетом равенства 1 элемента)
     * @param orgm список строк
     */
    public static void sortDesc(List<String> orgm) {
        orgm.sort(new DepDescComp());
    }
}

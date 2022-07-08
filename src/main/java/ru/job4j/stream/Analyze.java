package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    /**
     *Вычисляет общий средний балл
     * @param pupilStream поток учеников
     * преобразовываем в поток обьекты Subject
     * преобразовывваем в поток оценки
     * подсчитываем средний балл
     * @return средний балл
     */
    public static double averageScore(Stream<Pupil> pupilStream) {
        return pupilStream
                .flatMap(map -> map.getSubjects()
                        .stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    /**
     *Вычисляет средний балл по каждому предмету
     * @param pupilStream поток учеников
     * преобразовыываем в поток объекты Tuple (Создавая их)
     * берем имя Pupil, объекты Subject(преобразовываем в поток)
     * и подсчитываем средний балл
     * затем сохранеем в лист
     * @return лист баллов по предмету
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> pupilStream) {
        return pupilStream
                .map(map -> new Tuple(map.getName(), map.getSubjects()
                        .stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .orElse(0D))
                )
                .collect(Collectors.toList());
    }

    /**
     *Вычисляет средний бал по каждому ученику
     * @param pupilStream поток учеников
     * преобразовываем объекты Subject в поток
     * выполняем сбор данных в Map()
     * производим группировку метод groupingBy() (с тремя параметрами)
     * карта будет выглядеть :
     * ключ (первый параметр) - это имя предмета,
     * второй параметр - тип карты, который будем использовать (в нашем случае нужен LinkedHashMap::new,
     * который позволит хранить пары ключ-значение в порядке поступления),
     * значение карты (третий параметр) - средний балл по этому предмету для каждого ученика.
     * для расчета среднего балла метод Collectors.averagingDouble()
     * разбираем карту с помощью entrySet() и открываем поток stream()
     * преобразуем в поток объектов Tuple(Создаем их)
     * параметры будем получать с помощью методов getKey() и getValue()
     * собираем все в лист
     * @return лист баллов по ученику
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> pupilStream) {
        return pupilStream
                .flatMap(map -> map.getSubjects()
                        .stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(map -> new Tuple(map.getKey(), map.getValue()))
                .collect(Collectors.toList());
    }

    /**
     *Определяет лучшего ученика, у которого наибольший балл по всем предметам
     * @param pupilStream поток учеников
     * преобразовыываем в поток объекты Tuple (Создавая их)
     * берем имя и балл(преобразуем в поток)
     * рассчитываем суммарный балл методом sum()
     * в методе max() компаратор посчитает мах значение Score
     * @return объект Tuple
     */
    public static Tuple bestStudent(Stream<Pupil> pupilStream) {
        return pupilStream
                .map(map -> new Tuple(map.getName(), map.getSubjects()
                        .stream()
                        .mapToInt(Subject::getScore)
                        .sum())
                )
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }

    /**
     *Определяет предмет с наибольшим баллом среди учеников
     * @param pupilStream
     * преобразовываем объекты Subject в поток
     * выполняем сбор данных в Map()
     * производим группировку метод groupingBy() (с тремя параметрами)
     * карта будет выглядеть :
     * ключ (первый параметр) - это имя предмета,
     * второй параметр - тип карты, который будем использовать
     * значение карты (третий параметр) - суммарный балл по предмету
     * для расчета суммарного балла метод Collectors.summingDouble()
     * разбираем карту с помощью entrySet() и открываем поток stream()
     * преобразуем в поток объектов Tuple(Создаем их)
     * параметры будем получать с помощью методов getKey() и getValue()
     * методом max() будем подсчитывать Score
     * @return объект Tuple
     */
    public static Tuple bestSubject(Stream<Pupil> pupilStream) {
        return pupilStream
                .flatMap(map -> map.getSubjects()
                        .stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(map -> new Tuple(map.getKey(), map.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }
}

package ru.job4j.stream;

import java.util.Objects;

/**
 * Tuple содержит результаты: имя и баллы. Этот класс используется как для учеников, так и для предметов
 */
public class Tuple {
    private String name;
    private double score;

    public Tuple(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tuple tuple = (Tuple) obj;
        return Double.compare(score, tuple.score) == 0
                && Objects.equals(tuple.name, name);
    }
}

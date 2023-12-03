package fr.nbrouand.aoc2023.day3;

import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class EngineNumber {

    int number;
    List<Point> points;

    public EngineNumber(int number, List<Point> points) {
        this.number = number;
        this.points = points;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EngineNumber.class.getSimpleName() + "[", "]")
                .add("number=" + number)
                .toString();
    }
}

package fr.nbrouand.aoc2023.day3;

import org.apache.commons.lang3.tuple.Pair;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

public class Engine {

    List<EngineNumber> numbers = new ArrayList<>();
    List<EngineSymbol> symbols = new ArrayList<>();

    public Engine(String input) {
        AtomicInteger lineIndex = new AtomicInteger();
        input.lines().forEach(s -> {
            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                if (Character.isDigit(currentChar)) {
                    StringBuilder number = new StringBuilder();
                    number.append(currentChar);
                    List<Point> points = new ArrayList<>();
                    points.add(new Point(i, lineIndex.get()));
                    int j = i + 1;
                    while (j < s.length() && Character.isDigit(s.charAt(j))) {
                        points.add(new Point(j, lineIndex.get()));
                        number.append(s.charAt(j));
                        j++;
                    }
                    numbers.add(new EngineNumber(Integer.parseInt(number.toString()), points));
                    i = j - 1;
                } else {
                    if (!String.valueOf(currentChar).equals(".")) {
                        symbols.add(new EngineSymbol(String.valueOf(currentChar), new Point(i, lineIndex.get())));
                    }
                }
            }
            lineIndex.getAndIncrement();
        });
    }

    public List<Integer> computeAdditiveAllSymbol() {
        List<Integer> result = new ArrayList<>();
        numbers.forEach(n -> {
            Optional<Integer> adjacent = searchIfAdjacent(n);
            adjacent.ifPresent(result::add);
        });
        return result;
    }

    public List<Integer> computeMultiplicativeOnly() {
        List<Integer> result = new ArrayList<>();
        symbols.stream().filter(s -> s.symbol.equals("*")).forEach(s -> {
            Optional<Pair<Integer, Integer>> adjacent = searchTwoNumberAdjacent(s);
            adjacent.ifPresent(a -> {
                result.add(a.getLeft() * a.getRight());
            });
        });
        return result;
    }

    private Optional<Integer> searchIfAdjacent(EngineNumber n) {
        for (int i = 0; i < n.points.size(); i++) {
            Point pointNumber = n.points.get(i);
            for (EngineSymbol symbol : symbols) {
                Point pointSymbol = symbol.point;
                if (areAdjacent(pointNumber, pointSymbol)) {
                    return Optional.of(n.number);
                }
            }
        }
        return Optional.empty();
    }

    private Optional<Pair<Integer, Integer>> searchTwoNumberAdjacent(EngineSymbol s) {
        List<Integer> integersFound = new ArrayList<>();
        for (EngineNumber number : numbers) {
            for (Point numberPoint : number.points) {
                if (areAdjacent(numberPoint, s.point)) {
                    if (integersFound.size() < 2) {
                        integersFound.add(number.number);
                        break;
                    } else {
                        return Optional.empty();
                    }
                }
            }
        }

        if (integersFound.size() == 2) {
            return Optional.of(Pair.of(integersFound.get(0), integersFound.get(1)));
        } else {
            return Optional.empty();
        }
    }

    public static boolean areAdjacent(Point p1, Point p2) {
        int xDiff = Math.abs(p1.x - p2.x);
        int yDiff = Math.abs(p1.y - p2.y);

        return xDiff <= 1 && yDiff <= 1;
    }

    public List<EngineNumber> getNumbers() {
        return numbers;
    }

    public List<EngineSymbol> getSymbols() {
        return symbols;
    }
}
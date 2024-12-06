package fr.nbrouand.aoc2024.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Day1 {
    public static Integer computeDistance(String input) {

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        parserInput(input, left, right);

        List<Integer> leftSideSorted = left.stream().sorted().toList();
        List<Integer> rightSideSorted = right.stream().sorted().toList();

        int result = 0;
        for (int i = 0; i < leftSideSorted.size(); i++) {
            result += Math.abs(rightSideSorted.get(i) - leftSideSorted.get(i));
        }
        return result;
    }

    public static long computeSimilarityScore(String input) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        parserInput(input, left, right);

        Map<Integer, Long> occurrence = right.stream().collect(groupingBy(Function.identity(), counting()));

        return left.stream().mapToLong(value -> occurrence.getOrDefault(value, 0L) * value).sum();
    }

    private static void parserInput(String input, List<Integer> left, List<Integer> right) {
        input.lines().forEach(line -> {
            String[] parts = line.split("\\s+");
            left.add(Integer.parseInt(parts[0]));
            right.add(Integer.parseInt(parts[1]));
        });
    }


}

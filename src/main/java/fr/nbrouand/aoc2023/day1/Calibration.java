package fr.nbrouand.aoc2023.day1;

import fr.nbrouand.aoc2023.AocTools;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class Calibration {

    private final String code;
    private final boolean withWord;
    private static final List<String> NUMBERS = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

    public Calibration(String input) {
        this(input, false);
    }

    public Calibration(String input, boolean withWords) {
        this.withWord = withWords;
        this.code = input;
    }

    public int getValue() {
        int firstInt = getFirstInt();
        int lastInt = getLastInt();
        return firstInt * 10 + lastInt;
    }

    public int getFirstInt() {
        String input = code;
        if (withWord) {
            input = transformFirstWordToInt(input);
        }
        List<Integer> integers = getIntegers(input);
        return integers.get(0);
    }

    public int getLastInt() {
        String input = code;
        if (withWord) {
            input = transformLastWordToInt(input);
        }
        List<Integer> integers = getIntegers(input);
        return integers.get(integers.size() - 1);
    }

    private List<Integer> getIntegers(String input) {
        return Arrays.stream(input.split(""))
                .filter(AocTools::isInteger)
                .map(Integer::parseInt)
                .toList();
    }

    private String transformFirstWordToInt(String input) {
        return transformWordToInt(input, String::indexOf, (indexFound, numberFound) -> indexFound < numberFound);
    }

    private String transformLastWordToInt(String input) {
        return transformWordToInt(input, String::lastIndexOf, (indexFound, numberFound) -> indexFound > numberFound);
    }

    private String transformWordToInt(String input, BiFunction<String, String, Integer> indexSearch, BiPredicate<Integer, Integer> validateIndexFound) {
        Pair<Integer, Integer> numberFound = Pair.of(null, -1);
        for (int i = 0; i < NUMBERS.size(); i++) {
            String number = NUMBERS.get(i);
            int indexFound = indexSearch.apply(input, number);
            if (indexFound != -1 && (numberFound.getLeft() == null || validateIndexFound.test(indexFound, numberFound.getLeft()))) {
                numberFound = Pair.of(indexFound, i);
            }
        }
        if (numberFound.getRight() != -1) {
            return input.replace(NUMBERS.get(numberFound.getRight()), "" + (numberFound.getRight() + 1));
        }
        return input;
    }


}

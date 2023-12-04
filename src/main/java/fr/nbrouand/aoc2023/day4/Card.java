package fr.nbrouand.aoc2023.day4;

import java.util.List;

public class Card {

    private final int id;
    private final List<Integer> numbers;
    private final List<Integer> winningNumbers;

    public Card(int id, List<Integer> numbers, List<Integer> winningNumbers) {
        this.id = id;
        this.numbers = numbers;
        this.winningNumbers = winningNumbers;
    }

    public int calculatePoints() {
        int matchingNumbers = matchningNumbers();
        if (matchingNumbers >= 1) {
            return (int) Math.pow(2, matchingNumbers - 1);
        }
        return 0;
    }

    public int matchningNumbers() {
        return numbers.stream().filter(winningNumbers::contains).toList().size();
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}

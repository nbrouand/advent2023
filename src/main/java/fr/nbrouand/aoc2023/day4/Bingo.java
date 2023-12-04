package fr.nbrouand.aoc2023.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
 */
public class Bingo {

    Pattern patternNumber = Pattern.compile("\\d+");
    private List<Card> cards = new ArrayList<>();

    public Bingo(String input) {
        input.lines().forEach( l -> {
            String[] splitCard = l.split(":");
            int id = getId(splitCard[0]);

            String[] splitNumbers = splitCard[1].split("\\|");
            List<Integer> winningNumbers = getNumbers(splitNumbers[0]);
            List<Integer> numbers = getNumbers(splitNumbers[1]);

            cards.add(new Card(id, numbers, winningNumbers));
        });
    }

    private List<Integer> getNumbers(String numbersList) {
        List<Integer> numbers = new ArrayList<>();
        Matcher matcherNumber = patternNumber.matcher(numbersList);
        while(matcherNumber.find()) {
            int numberFound = Integer.parseInt(matcherNumber.group());
            numbers.add(numberFound);
        }
        return numbers;
    }

    private int getId(String split) {
        int id;
        Matcher matcher = patternNumber.matcher(split);
        if(matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        throw new RuntimeException("should not happen");
    }

    public List<Card> getCards() {
        return cards;
    }

    public int scratchcardsCopy() {
        int[] numberOfCards = new int[cards.size()];
        Arrays.fill(numberOfCards, 1);
        int index = 0;
        for (Card card : cards) {
            int machingCards = card.matchningNumbers();
            for (int i = 0; i < machingCards ; i++) {
                if(index + 1 + i < numberOfCards.length) {
                    numberOfCards[index + 1 + i] += numberOfCards[index];
                }
            }
            index++;
        }
        return Arrays.stream(numberOfCards).sum();
    }
}

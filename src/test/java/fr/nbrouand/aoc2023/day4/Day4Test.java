package fr.nbrouand.aoc2023.day4;

import fr.nbrouand.aoc2023.day1.Day1Test;
import fr.nbrouand.aoc2023.day3.Engine;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day4Test {

    @Test
    void acceptance_test() {
        String input = """
                Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
                Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
                Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
                Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
                Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
                Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11
                """;

        Bingo bingo = new Bingo(input);

        List<Card> cards = bingo.getCards();

        assertThat(cards.stream().mapToInt(Card::calculatePoints).sum()).isEqualTo(13);
    }

    @Test
    void parse_input() {
        String input = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";
        Bingo bingo = new Bingo(input);
        List<Card> cards = bingo.getCards();

        assertThat(cards).hasSize(1);
        assertThat(cards.get(0).getWinningNumbers()).containsExactly(41, 48, 83, 86, 17);
        assertThat(cards.get(0).getNumbers()).containsExactly(83, 86, 6, 31, 17, 9, 48, 53);
    }

    @Test
    void calculte_Point() {
        String input = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";
        Bingo bingo = new Bingo(input);
        List<Card> cards = bingo.getCards();

        assertThat(cards).hasSize(1);
        assertThat(cards.stream().mapToInt(Card::calculatePoints).sum()).isEqualTo(8);
    }

    @Test
    void answer_day4() throws URISyntaxException, IOException {
        URL resource = Day1Test.class.getClassLoader().getResource("day4.input");
        String input = Files.readString(Path.of(resource.toURI()));

        Bingo bingo = new Bingo(input);

        List<Card> cards = bingo.getCards();

        assertThat(cards.stream().mapToInt(Card::calculatePoints).sum()).isEqualTo(23847);
    }

    @Test
    void acceptance_test_2() {
        String input = """
                Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
                Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
                Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
                Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
                Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
                Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11
                """;

        Bingo bingo = new Bingo(input);

        assertThat(bingo.scratchcardsCopy()).isEqualTo(30);
    }

    @Test
    void answer_day4_2() throws URISyntaxException, IOException {
        URL resource = Day1Test.class.getClassLoader().getResource("day4.input");
        String input = Files.readString(Path.of(resource.toURI()));

        Bingo bingo = new Bingo(input);

        assertThat(bingo.scratchcardsCopy()).isEqualTo(8570000);
    }
}

package fr.nbrouand.aoc2023.day2;

import fr.nbrouand.aoc2023.day1.Day1Test;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class Day2Test {
    /**
     * Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
     * Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
     * Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
     * Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
     * Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
     * <p>
     * in bag : 12 red cubes, 13 green cubes, and 14 blue cubes
     */
    @Test
    void acceptance_test() {
        Bag bag = new Bag(12, 13, 14);
        String input = """
                Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
                Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
                Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
                """;
        BagGame bagGame = new BagGame(input);

        List<Game> possibleGame = bagGame.getPossibleGame(bag);

        int result = possibleGame.stream().mapToInt(Game::id).sum();
        assertThat(result).isEqualTo(8);
    }

    @Test
    void parseInput() {
        String input = """
                Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                """;
        BagGame bagGame = new BagGame(input);

        assertThat(bagGame.getGames()).hasSize(2);
        assertThat(bagGame.getGames()).containsExactlyInAnyOrder(
                new Game(1, List.of(new Round(4, 3, 0), new Round(1, 6, 2), new Round(0, 0, 2))),
                new Game(2, List.of(new Round(0, 1, 2), new Round(1, 4, 3), new Round(0, 1, 1)))
        );
    }

    @Test
    void answer_day2_1() throws URISyntaxException, IOException {
        URL resource = Day1Test.class.getClassLoader().getResource("day2.input");
        String input = Files.readString(Path.of(resource.toURI()));

        BagGame bagGame = new BagGame(input);
        Bag bag = new Bag(12, 13, 14);

        List<Game> possibleGame = bagGame.getPossibleGame(bag);

        int result = possibleGame.stream().mapToInt(Game::id).sum();
        assertThat(result).isEqualTo(2632);
    }

    @Test
    void acceptance_test_2() {
        Bag bag = new Bag(12, 13, 14);
        String input = """
                Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
                Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
                Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
                """;
        BagGame bagGame = new BagGame(input);
        List<Integer> powers = bagGame.getPowers();
        assertThat(powers.stream().mapToInt(Integer::intValue).sum()).isEqualTo(2286);
    }

    @Test
    void calculate_power() {
        String input = """
                Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                """;
        BagGame bagGame = new BagGame(input);
        List<Integer> powers = bagGame.getPowers();
        assertThat(powers.get(0)).isEqualTo(6 * 4 * 2);
        assertThat(powers.get(1)).isEqualTo(4 * 3 * 1);
    }

    @Test
    void answer_day2_2() throws URISyntaxException, IOException {
        URL resource = Day1Test.class.getClassLoader().getResource("day2.input");
        String input = Files.readString(Path.of(resource.toURI()));

        BagGame bagGame = new BagGame(input);
        List<Integer> powers = bagGame.getPowers();
        assertThat(powers.stream().mapToInt(Integer::intValue).sum()).isEqualTo(69629);
    }
}

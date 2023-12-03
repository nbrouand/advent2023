package fr.nbrouand.aoc2023.day3;

import fr.nbrouand.aoc2023.day1.Day1Test;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day3Test {


    @Test
    void acceptance_test() {
        String input = """
                467..114..
                ...*......
                ..35..633.
                ......#...
                617*......
                .....+.58.
                ..592.....
                ......755.
                ...$.*....
                .664.598..
                """;
        Engine engine = new Engine(input);

        int result = engine.computeAdditiveAllSymbol().stream().mapToInt(Integer::intValue).sum();

        assertThat(result).isEqualTo(4361);
    }
    @Test
    void parseInput() {
        String input = """
                467..114..
                ...*......
                """;
        Engine engine = new Engine(input);

        List<EngineNumber> engineNumbers = engine.getNumbers();
        List<EngineSymbol> engineSymbols = engine.getSymbols();

        assertThat(engineNumbers).hasSize(2);
        assertThat(engineSymbols).hasSize(1);
    }

    @Test
    void compute() {
        String input = """
                467..114..
                ...*...#.2
                """;

        Engine engine = new Engine(input);

        int result = engine.computeAdditiveAllSymbol().stream().mapToInt(Integer::intValue).sum();

        assertThat(result).isEqualTo(581);
    }

    @Test
    void answer_day3_1() throws URISyntaxException, IOException {
        URL resource = Day1Test.class.getClassLoader().getResource("day3.input");
        String input = Files.readString(Path.of(resource.toURI()));

        Engine engine = new Engine(input);

        int result = engine.computeAdditiveAllSymbol().stream().mapToInt(Integer::intValue).sum();

        assertThat(result).isEqualTo(544664);
    }

    @Test
    void acceptance_test_2() {
        String input = """
                467..114..
                ...*......
                ..35..633.
                ......#...
                617*......
                .....+.58.
                ..592.....
                ......755.
                ...$.*....
                .664.598..
                """;
        Engine engine = new Engine(input);

        int result = engine.computeMultiplicativeOnly().stream().mapToInt(Integer::intValue).sum();

        assertThat(result).isEqualTo(467835);
    }

    @Test
    void answer_day3_2() throws URISyntaxException, IOException {
        URL resource = Day1Test.class.getClassLoader().getResource("day3.input");
        String input = Files.readString(Path.of(resource.toURI()));

        Engine engine = new Engine(input);

        int result = engine.computeMultiplicativeOnly().stream().mapToInt(Integer::intValue).sum();

        assertThat(result).isEqualTo(84495585);
    }
}

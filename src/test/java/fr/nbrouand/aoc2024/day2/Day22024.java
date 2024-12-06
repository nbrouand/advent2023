package fr.nbrouand.aoc2024.day2;

import fr.nbrouand.aoc2023.day1.Day1Test;
import fr.nbrouand.aoc2024.day1.Day1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class Day22024 {

    @Test
    void example_1() {
        String input = """
                7 6 4 2 1
                1 2 7 8 9
                9 7 6 2 1
                1 3 2 4 5
                8 6 4 4 1
                1 3 6 7 9
                """.stripIndent();

        long result = Day2.countSafeReports(input);

        assertThat(result).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "7 6 4 2 1",
            "1 3 6 7 9"})
    void should_be_safe(String input) {
        Day2.Report report = new Day2.Report(input);
        boolean safe = report.isSafe();
        assertThat(safe).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1 2 7 8 9",
            "9 7 6 2 1",
            "1 3 2 4 5",
            "8 6 4 4 1"
    })
    void should_not_be_safe(String input) {
        Day2.Report report = new Day2.Report(input);
        boolean safe = report.isSafe();
        assertThat(safe).isFalse();
    }

    @Test
    void star_one() throws Exception {
        String input = readFile("2024/day2.input");
        long result = Day2.countSafeReports(input);

        assertThat(result).isEqualTo(236L);
    }

    @Test
    void example_2() {
        String input = """
                7 6 4 2 1
                1 2 7 8 9
                9 7 6 2 1
                1 3 2 4 5
                8 6 4 4 1
                1 3 6 7 9
                """.stripIndent();

        long result = Day2.countSafeReportsLenient(input);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void star_two() throws Exception {
        String input = readFile("2024/day2.input");
        long result = Day2.countSafeReportsLenient(input);

        assertThat(result).isEqualTo(308L);
    }

    private static String readFile(String file) throws IOException, URISyntaxException {
        URL resource = Day1Test.class.getClassLoader().getResource(file);
        return Files.readString(Path.of(resource.toURI()));
    }
}

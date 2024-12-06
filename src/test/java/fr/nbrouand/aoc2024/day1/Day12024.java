package fr.nbrouand.aoc2024.day1;

import fr.nbrouand.aoc2023.day1.Day1Test;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class Day12024 {

    @Test
    void example_1() {
        String input = """
                3   4
                4   3
                2   5
                1   3
                3   9
                3   3
                """.stripIndent();


        int result = Day1.computeDistance(input);

        assertThat(result).isEqualTo(11);
    }

    @Test
    void star_one() throws Exception {
        String input = readFile("2024/day1.input");

        int result = Day1.computeDistance(input);

        assertThat(result).isEqualTo(1603498);
    }



    @Test
    void example_2() {
        String input = """
                3   4
                4   3
                2   5
                1   3
                3   9
                3   3
                """.stripIndent();


        long result = Day1.computeSimilarityScore(input);

        assertThat(result).isEqualTo(31);
    }

    @Test
    void star_2() throws Exception{
        String input = readFile("2024/day1.input");

        long result = Day1.computeSimilarityScore(input);

        assertThat(result).isEqualTo(25574739L);
    }

    private static String readFile(String file) throws IOException, URISyntaxException {
        URL resource = Day1Test.class.getClassLoader().getResource(file);
        return Files.readString(Path.of(resource.toURI()));
    }
}

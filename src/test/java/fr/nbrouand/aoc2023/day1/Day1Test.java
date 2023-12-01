package fr.nbrouand.aoc2023.day1;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class Day1Test {


    @Test
    void acceptance_test() {
        String input = """
                1abc2
                pqr3stu8vwx
                a1b2c3d4e5f
                treb7uchet
                """;
        Trebuchet trebuchet = new Trebuchet();
        int calibration = trebuchet.getCalibration(input);

        assertThat(calibration).isEqualTo(142);
    }

    @Test
    void getFirstInt() {
        String input = "1abc2";
        Calibration calibration = new Calibration(input);
        int first = calibration.getFirstInt();
        assertThat(first).isEqualTo(1);
    }

    @Test
    void getLastInt() {
        String input = "1abc2";
        Calibration calibration = new Calibration(input);
        int first = calibration.getLastInt();
        assertThat(first).isEqualTo(2);
    }

    @Test
    void concat_integers() {
        String input = "1abc2";
        Calibration calibration = new Calibration(input);
        int result = calibration.getValue();
        assertThat(result).isEqualTo(12);
    }

    @Test
    void answer_day1() throws URISyntaxException, IOException {
        URL resource = Day1Test.class.getClassLoader().getResource("day1.input");
        String input = Files.readString(Path.of(resource.toURI()));

        Trebuchet trebuchet = new Trebuchet();
        int calibration = trebuchet.getCalibration(input);

        assertThat(calibration).isEqualTo(54573);
    }

    /**
     * Part 2
     */
    @Test
    void acceptance_test_2() {
        String input = """
                two1nine
                eightwothree
                abcone2threexyz
                xtwone3four
                4nineeightseven2
                zoneight234
                7pqrstsixteen
                eighthree
                sevenine
                eightthree8fiveqjgsdzgnnineeight
                """;
        Trebuchet trebuchet = new Trebuchet();
        int calibration = trebuchet.getCalibrationWithWords(input);

        assertThat(calibration).isEqualTo(531);
    }

    @Test
    void getFirstInt_as_word() {
        String input = "eightwothree";
        Calibration calibration = new Calibration(input, true);
        int first = calibration.getFirstInt();
        assertThat(first).isEqualTo(8);
    }

    @Test
    void getLastInt_as_word() {
        String input = "1abctwo";
        Calibration calibration = new Calibration(input, true);
        int first = calibration.getLastInt();
        assertThat(first).isEqualTo(2);
    }

    @Test
    void answer_day1_2() throws URISyntaxException, IOException {
        URL resource = Day1Test.class.getClassLoader().getResource("day1.input");
        String input = Files.readString(Path.of(resource.toURI()));

        Trebuchet trebuchet = new Trebuchet();
        int calibration = trebuchet.getCalibrationWithWords(input);

        assertThat(calibration).isEqualTo(54591);
    }
}

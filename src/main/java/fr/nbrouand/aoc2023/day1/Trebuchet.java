package fr.nbrouand.aoc2023.day1;

public class Trebuchet {
    public Integer getCalibration(String input) {
        return input.lines().mapToInt(s -> {
            Calibration calibration = new Calibration(s);
            return calibration.getValue();
        }).sum();
    }

    public Integer getCalibrationWithWords(String input) {
        return input.lines().mapToInt(s -> {
            Calibration calibration = new Calibration(s, true);
            return calibration.getValue();
        }).sum();
    }
}

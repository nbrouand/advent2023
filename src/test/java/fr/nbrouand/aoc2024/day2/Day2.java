package fr.nbrouand.aoc2024.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2 {
    public static long countSafeReports(String input) {
        String[] lines = input.split("\n");
        return Arrays.stream(lines).map(Report::new).filter(Report::isSafe).count();
    }

    public static long countSafeReportsLenient(String input) {
        String[] lines = input.split("\n");
        return Arrays.stream(lines).map(Report::new).filter(Report::isSafeLenient).count();
    }

    public static class Report {
        private List<Integer> levels = new ArrayList<>();

        public Report(String input) {
            String[] lines = input.trim().split("\\s+");
            levels = Arrays.stream(lines).map(Integer::parseInt).toList();
        }

        public Report(List<Integer> input) {
            levels = input;
        }

        public boolean isSafe() {
            float signum = Math.signum(levels.get(levels.size() - 1) - levels.get(0));
            for (int i = 0; i < levels.size() - 1; i++) {
                int difference = levels.get(i + 1) - levels.get(i);
                if (Math.abs(difference) > 3 || difference == 0) {
                    return false;
                }
                if (Math.signum(difference) != signum) {
                    return false;
                }
            }
            return true;
        }

        public boolean isSafeLenient() {
            if (isSafe()) {
                return true;
            }

            for (int i = 0; i < levels.size(); i++) {
                List<Integer> copy = new ArrayList<>(levels);
                copy.remove(i);
                if (new Report(copy).isSafe()) {
                    return true;
                }
            }
            return false;
        }
    }
}
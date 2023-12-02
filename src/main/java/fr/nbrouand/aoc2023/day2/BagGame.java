package fr.nbrouand.aoc2023.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class BagGame {
    List<Game> games = new ArrayList<>();

    public BagGame(String input) {
        Pattern patternGame = Pattern.compile("\\b\\d+\\b");
        Pattern patterRound = Pattern.compile("(\\d+)\\s+(\\w+)");

        input.lines().forEach(s -> {
            List<Round> rounds = new ArrayList<>();
            String[] split1 = s.split(":");
            Matcher matcherGame = patternGame.matcher(split1[0]);

            String id;
            if (matcherGame.find()) {
                id = matcherGame.group();
                String[] splitRound = split1[1].split(";");
                Arrays.stream(splitRound).forEach(r -> {
                    Matcher matcherRound = patterRound.matcher(r);
                    int red = 0;
                    int blue = 0;
                    int green = 0;
                    while (matcherRound.find()) {
                        int number = parseInt(matcherRound.group(1));
                        Color colorFound = Color.valueOf(matcherRound.group(2));
                        if (colorFound.equals(Color.red)) {
                            red = number;
                        } else if (colorFound.equals(Color.blue)) {
                            blue = number;
                        } else {
                            green = number;
                        }
                    }
                    rounds.add(new Round(red, blue, green));
                });
                games.add(new Game(parseInt(id), rounds));
            }
        });
    }

    public List<Game> getGames() {
        return games;
    }

    public List<Game> getPossibleGame(Bag bagGame) {
        List<Game> result = new ArrayList<>();
        for (Game game : games) {
            boolean valid = true;
            for (Round round : game.rounds) {
                if (round.blue > bagGame.blue || round.red > bagGame.red || round.green > bagGame.green) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                result.add(game);
            }
        }
        return result;
    }

    public List<Integer> getPowers() {
        List<Integer> result = new ArrayList<>();

        for (Game game : games) {
            int red = -1;
            int blue = -1;
            int green = -1;
            for (Round round : game.rounds) {
                red = Math.max(red, round.red);
                blue = Math.max(blue, round.blue);
                green = Math.max(green, round.green);
            }
            result.add(red * blue * green);
            if (red * blue * green < 0) {
                throw new RuntimeException("should not happened");
            }
        }
        return result;
    }

    public enum Color {
        red, blue, green
    }
}

package fr.nbrouand.aoc2023.day2;

import java.util.List;
import java.util.Objects;

public class Game {

    public final int id;
    public final List<Round> rounds;

    public Game(int id, List<Round> rounds) {
        this.id = id;
        this.rounds = rounds;
    }

    public int id() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id && Objects.equals(rounds, game.rounds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rounds);
    }
}

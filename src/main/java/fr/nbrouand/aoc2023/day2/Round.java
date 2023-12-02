package fr.nbrouand.aoc2023.day2;

import java.util.Objects;

public class Round {
    int red;
    int blue;
    int green;

    public Round(int red, int blue, int green) {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return red == round.red && blue == round.blue && green == round.green;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, blue, green);
    }
}

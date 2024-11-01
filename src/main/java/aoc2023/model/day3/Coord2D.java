package aoc2023.model.day3;

import java.util.Objects;

import static java.lang.Math.abs;

public record Coord2D(int x, int y) {
    public static Coord2D coord2D(int x, int y) {
        return new Coord2D(x, y);
    }

    public boolean isAdjacentTo(Coord2D other) {
        return !equals(other) &&
                abs(x - other.x()) <= 1 &&
                abs(y - other.y()) <= 1;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coord2D coord2D)) return false;
        return x == coord2D.x && y == coord2D.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

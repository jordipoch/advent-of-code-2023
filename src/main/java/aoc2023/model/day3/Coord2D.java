package aoc2023.model.day3;

public record Coord2D(int x, int y) {
    public static Coord2D coord2D(int x, int y) {
        return new Coord2D(x, y);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}

package aoc2023.model.day3;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class EngineNumber {
    private final int value;
    private final List<Coord2D> digitPositions;
    private EngineSchematic engineSchematic;

    private EngineNumber(int value, List<Coord2D> digitPositions) {
        this.value = value;
        this.digitPositions = Collections.unmodifiableList(digitPositions);
    }

    public static EngineNumber create(int value, List<Coord2D> digitPositions) {
        return new EngineNumber(value, digitPositions);
    }

    public List<Coord2D> getDigitPositions() {
        return digitPositions;
    }

    int getValue() {
        return value;
    }

    public boolean isAdjacent(Coord2D position) {
        return digitPositions.stream()
                .anyMatch(coord2D -> coord2D.isAdjacentTo(position));
    }

    @Override
    public String toString() {
        return String.format("{ value = %d, positions = %s }", value, digitPositions);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EngineNumber number = (EngineNumber) o;
        return value == number.value && Objects.equals(digitPositions, number.digitPositions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, digitPositions);
    }
}

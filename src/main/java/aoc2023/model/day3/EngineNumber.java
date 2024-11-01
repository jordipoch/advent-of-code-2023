package aoc2023.model.day3;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.lang.Character.isDigit;

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

    boolean isPartNumber(EngineSchematic engineSchematic) {
        this.engineSchematic = engineSchematic;
        return digitPositions.stream()
                .anyMatch(coord2D -> hasAdjacentSymbols(coord2D.x(), coord2D.y()));
    }

    public boolean isAdjacent(Coord2D position) {
        return digitPositions.stream()
                .anyMatch(coord2D -> coord2D.isAdjacentTo(position));
    }

    int getValue() {
        return value;
    }

    private boolean hasAdjacentSymbols(int x, int y) {
        return checkSymbolsInDifferentRow(x, y - 1) ||
                checkSymbolsInSameRow(x, y) ||
                checkSymbolsInDifferentRow(x, y + 1);
    }

    private boolean checkSymbolsInDifferentRow(int x, int row) {
        return safeCheckAdjacentSymbol(x - 1, row) || safeCheckAdjacentSymbol(x, row) || safeCheckAdjacentSymbol(x + 1, row);
    }

    private boolean checkSymbolsInSameRow(int x, int row) {
        return safeCheckAdjacentSymbol(x - 1, row) || safeCheckAdjacentSymbol(x + 1, row);
    }

    private boolean safeCheckAdjacentSymbol(int x, int y) {
        if (y >= 0 && y < engineSchematic.getYSize() &&
                x >= 0 && x < engineSchematic.getXSize())
            return engineSchematic.getCharAt(x, y) != '.' && !isDigit(engineSchematic.getCharAt(x, y));
        else
            return false;
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

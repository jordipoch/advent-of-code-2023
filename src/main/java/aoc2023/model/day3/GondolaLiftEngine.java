package aoc2023.model.day3;

import java.util.List;

public class GondolaLiftEngine {
    final EngineSchematic engineSchematic;
    final List<EngineNumber> numbers;
    GondolaLiftEngine(EngineSchematic engineSchematic, List<EngineNumber> numbers) {
        this.engineSchematic = engineSchematic;
        this.numbers = numbers;
    }

    public long calculateSumOfPartNumbers() {
        return numbers.stream()
                .filter(engineNumber -> engineNumber.isPartNumber(engineSchematic))
                .mapToInt(EngineNumber::getValue)
                .sum();
    }

    public long calculateSumOfGearRatios() {
        var starPositions = engineSchematic.getStarPositions();

        return starPositions.stream()
                .map(this::getAdjacentNumbers)
                .filter(list -> list.size() == 2)
                .mapToLong(list -> list.stream()
                        .mapToLong(EngineNumber::getValue)
                        .reduce(1, (a, b) -> a * b))
                .sum();
    }

    private List<EngineNumber> getAdjacentNumbers(Coord2D position) {
        return numbers.stream()
                .filter(number -> number.isAdjacent(position))
                .toList();
    }
}

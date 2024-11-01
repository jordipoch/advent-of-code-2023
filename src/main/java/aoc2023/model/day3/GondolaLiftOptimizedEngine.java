package aoc2023.model.day3;

import java.util.List;
import java.util.Map;

public class GondolaLiftOptimizedEngine extends GondolaLiftEngine {
    private final Map<Coord2D, EngineNumber> engineNumberPositions;

    GondolaLiftOptimizedEngine(EngineSchematic engineSchematic, List<EngineNumber> numbers, Map<Coord2D, EngineNumber> engineNumberPositions) {
        super(engineSchematic, numbers);
        this.engineNumberPositions = engineNumberPositions;
    }

    @Override
    protected List<EngineNumber> getAdjacentNumbers(Coord2D position) {
        return engineSchematic.getAdjacentDigitPositions(position).stream()
                .filter(engineNumberPositions::containsKey)
                .map(engineNumberPositions::get)
                .distinct()
                .toList();
    }
}

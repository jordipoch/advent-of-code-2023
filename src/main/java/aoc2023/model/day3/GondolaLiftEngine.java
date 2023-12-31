package aoc2023.model.day3;

import aoc2023.model.day3.parser.EngineNumbersParser;
import aoc2023.model.day3.parser.NumberExtractor;

import java.util.List;

public class GondolaLiftEngine {
    private final EngineSchematic engineSchematic;
    private final List<EngineNumber> numbers;
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
}

package aoc2023.model.day3;

import aoc2023.model.day3.parser.EngineNumbersParser;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class GondolaLiftOptimizedEngineFactory extends GondolaLiftEngineFactory {

    @Inject
    public GondolaLiftOptimizedEngineFactory(EngineNumbersParser engineNumbersParser) {
        super(engineNumbersParser);
    }

    @Override
    public GondolaLiftEngine create(List<String> input) {
        var engineSchematic = EngineSchematic.create(input);
        var numbers = createEngineNumbers(input);
        var numberPositions = createEngineNumberPositions(numbers);

        return new GondolaLiftOptimizedEngine(engineSchematic, numbers, numberPositions);
    }

    private Map<Coord2D, EngineNumber> createEngineNumberPositions(List<EngineNumber> engineNumbers) {
        var engineNumberPositionMap = new HashMap<Coord2D, EngineNumber>();

        for (var engineNumber : engineNumbers) {
            var digitPositions = engineNumber.getDigitPositions();
            digitPositions.forEach(digitPosition -> engineNumberPositionMap.put(digitPosition, engineNumber));
        }

        return engineNumberPositionMap;
    }
}

package aoc2023.model.day3;

import aoc2023.model.day3.parser.EngineNumbersParser;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class GondolaLiftEngineFactory {

    private final EngineNumbersParser engineNumbersParser;

    @Inject
    public GondolaLiftEngineFactory(EngineNumbersParser engineNumbersParser) {
        this.engineNumbersParser = engineNumbersParser;
    }

    public GondolaLiftEngine create(List<String> input) {
        EngineSchematic engineSchematic = EngineSchematic.create(input);
        List<EngineNumber> numbers = createEngineNumbers(input);

        return new GondolaLiftEngine(engineSchematic, numbers);
    }

    protected List<EngineNumber> createEngineNumbers(List<String> input) {
        return engineNumbersParser.parse(input);
    }
}

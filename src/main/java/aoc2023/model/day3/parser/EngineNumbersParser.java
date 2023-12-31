package aoc2023.model.day3.parser;

import aoc2023.model.day3.EngineNumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static aoc2023.model.day3.Coord2D.coord2D;

@Singleton
public class EngineNumbersParser {
    private final NumberExtractor numberExtractor;

    @Inject
    public EngineNumbersParser(NumberExtractor numberExtractor) {
        this.numberExtractor = numberExtractor;
    }


    public List<EngineNumber> parse(List<String> rawData) {
        List<EngineNumber> engineNumbers = new ArrayList<>();
        for (int yPos = 0; yPos < rawData.size(); yPos++) {
            engineNumbers.addAll(parseLine(rawData.get(yPos), yPos));
        }
        return engineNumbers;
    }

    private List<EngineNumber> parseLine(String line, int lineNum) {
        var extractedNumbers = numberExtractor.extractNumbersAndPositions(line);

        return extractedNumbers.stream()
                .map(extractedNumber -> createEngineNumber(extractedNumber, lineNum))
                .toList();
    }

    private EngineNumber createEngineNumber(ExtractedNumber number, int yPos) {
        var coords = Stream.iterate(
                        coord2D(number.position(), yPos),
                        coord -> coord.x() < number.position() + number.text().length(),
                        coord -> coord2D(coord.x() + 1, yPos))
                .toList();

        var engineNumber = EngineNumber.create(Integer.parseInt(number.text()), coords);
        return engineNumber;
    }
}



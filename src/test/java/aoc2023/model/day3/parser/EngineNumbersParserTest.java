package aoc2023.model.day3.parser;

import aoc2023.model.day3.EngineNumber;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static aoc2023.model.day3.Coord2D.coord2D;
import static org.assertj.core.api.Assertions.assertThat;

public class EngineNumbersParserTest {

    private EngineNumbersParser parser;
    @BeforeMethod
    public void setUp() {
        parser = new EngineNumbersParser(new NumberExtractor());
    }

    @Test
    public void testParseSingleLineOnlyDigits() {
        var rawData = List.of(
                "123"
        );

        var expectedNumbers = List.of(
                EngineNumber.create(123, List.of(
                        coord2D(0, 0),
                        coord2D(1, 0),
                        coord2D(2, 0)
                ))
        );

        assertThat(parser.parse(rawData)).containsExactlyElementsOf(expectedNumbers);
    }

    @Test
    public void testParseSingleLineWithOtherCharacters() {
        var rawData = List.of(
                ".123#"
        );

        var expectedNumbers = List.of(
                EngineNumber.create(123, List.of(
                        coord2D(1, 0),
                        coord2D(2, 0),
                        coord2D(3, 0)
                ))
        );

        assertThat(parser.parse(rawData)).containsExactlyElementsOf(expectedNumbers);
    }

    @Test
    public void testParseSingleLineWithMultipleNumbers() {
        var rawData = List.of(
                ".123#45..@67/"
        );

        var expectedNumbers = List.of(
                EngineNumber.create(123, List.of(coord2D(1, 0), coord2D(2, 0), coord2D(3, 0))),
                EngineNumber.create(45, List.of(coord2D(5, 0), coord2D(6, 0))),
                EngineNumber.create(67, List.of(coord2D(10, 0), coord2D(11, 0)))

        );

        assertThat(parser.parse(rawData)).containsExactlyElementsOf(expectedNumbers);
    }

    @Test
    public void testParseSingleLineWithNoNumbers() {
        var rawData = List.of(
                ".#..@/"
        );

        assertThat(parser.parse(rawData)).isEmpty();
    }

    @Test
    public void testParseMultipleLines() {
        var rawData = List.of(
                ".123#",
                "4@52.",
                ".....",
                "%.8.@",
                "100.7"
        );

        var expectedNumbers = List.of(
                EngineNumber.create(123, List.of(coord2D(1, 0), coord2D(2, 0), coord2D(3, 0))),
                EngineNumber.create(4, List.of(coord2D(0, 1))),
                EngineNumber.create(52, List.of(coord2D(2, 1), coord2D(3, 1))),
                EngineNumber.create(8, List.of(coord2D(2, 3))),
                EngineNumber.create(100, List.of(coord2D(0, 4), coord2D(1, 4), coord2D(2, 4))),
                EngineNumber.create(7, List.of(coord2D(4, 4)))

        );

        assertThat(parser.parse(rawData)).containsExactlyElementsOf(expectedNumbers);
    }
}
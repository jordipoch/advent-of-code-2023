package aoc2023.model.day3;

import aoc2023.model.day3.parser.EngineNumbersParser;
import aoc2023.model.day3.parser.NumberExtractor;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GondolaLiftEngineTest {
    private final GondolaLiftEngineFactory factory = new GondolaLiftEngineFactory(new EngineNumbersParser(new NumberExtractor()));


    @Test
    public void testCalculateSumOfPartNumberNoAdjacentSymbols() {
        var input = List.of(
                "...",
                ".5.",
                "..."
        );

        var engine = factory.create(input);
        assertThat(engine.calculateSumOfPartNumbers()).isEqualTo(0);
    }

    @Test
    public void testCalculateSumOfPartNumberWithDigitInTheEdge() {
        var input = List.of(
                "5..",
                "...",
                "..#"
        );

        var engine = factory.create(input);
        assertThat(engine.calculateSumOfPartNumbers()).isEqualTo(0);
    }

    @Test
    public void testCalculateSumOfPartNumberWhenAdjacentToSymbol() {
        var input = List.of(
                "5..",
                "..9",
                "..#"
        );

        var engine = factory.create(input);
        assertThat(engine.calculateSumOfPartNumbers()).isEqualTo(9);
    }

    @Test
    public void testCalculateSumOfPartNumberWithAdjacentNumbers() {
        var input = List.of(
                "5..",
                "3.9",
                "..#"
        );

        var engine = factory.create(input);
        assertThat(engine.calculateSumOfPartNumbers()).isEqualTo(9);
    }

    @Test
    public void testCalculateSumOfPartNumberWithSingleDigitNumbersOnly() {
        var input = List.of(
                "5@.8.",
                "3.2.9",
                ".4..#",
                "/9.3.",
                "..5.#"
        );

        var engine = factory.create(input);
        assertThat(engine.calculateSumOfPartNumbers()).isEqualTo(35);
    }

    @Test
    public void testCalculateSumOfPartNumberWithADoubleDigitNumber() {
        var input = List.of(
                "12.",
                "..#",
                "3.."
        );

        var engine = factory.create(input);
        assertThat(engine.calculateSumOfPartNumbers()).isEqualTo(12);
    }

    @Test
    public void testCalculateSumOfPartNumberWithComplexEngineSchematic() {
        var input = List.of(
                "12..%.45./",
                "...88#..#.",
                "45#..123..",
                ".9.@.58..*",
                "...724&...",
                ".#...//@..",
                "43...719..",
                "/7439...%1",
                "..56..24..",
                ".#....525&"
        );

        var engine = factory.create(input);
        assertThat(engine.calculateSumOfPartNumbers()).isEqualTo(
                45 +
                        88 +
                        45 + 123 +
                        9 + 58 +
                        724 +
                        0 +
                        43 + 719 +
                        7439 + 1 +
                        56 + 24 +
                        525
        );
    }
}
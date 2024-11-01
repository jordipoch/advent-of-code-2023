package aoc2023.model.day3;

import aoc2023.model.day3.parser.EngineNumbersParser;
import aoc2023.model.day3.parser.NumberExtractor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GondolaLiftEngineTest {
    private final GondolaLiftEngineFactory factory = new GondolaLiftEngineFactory(new EngineNumbersParser(new NumberExtractor()));
    private final GondolaLiftEngineFactory optimizedFactory = new GondolaLiftOptimizedEngineFactory(new EngineNumbersParser(new NumberExtractor()));


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

    @Test(dataProvider = "getGondolaLiftEngineFactories")
    public void testCalculateSumOfGearRatiosWithOneGear(GondolaLiftEngineFactory factory) {
        var input = List.of(
                "2*4",
                "...",
                "..."
        );

        var engine = factory.create(input);
        assertThat(engine.calculateSumOfGearRatios()).isEqualTo(8);
    }

    @Test(dataProvider = "getGondolaLiftEngineFactories")
    public void testCalculateSumOfGearRatiosWithSingleStarAdjacentTo3Numbers(GondolaLiftEngineFactory factory) {
        var input = List.of(
                "2*4",
                ".10",
                "..."
        );

        var engine = factory.create(input);
        assertThat(engine.calculateSumOfGearRatios()).isEqualTo(0);
    }

    @Test(dataProvider = "getGondolaLiftEngineFactories")
    public void testCalculateSumOfGearRatiosWithNoStars(GondolaLiftEngineFactory factory) {
        var input = List.of(
                "2#4",
                ".10",
                "..."
        );

        var engine = factory.create(input);
        assertThat(engine.calculateSumOfGearRatios()).isEqualTo(0);
    }

    @Test(dataProvider = "getGondolaLiftEngineFactories")
    public void testCalculateSumOfGearRatiosWithTwoGears(GondolaLiftEngineFactory factory) {
        var input = List.of(
                "2*4",
                "...",
                "5*3"
        );

        var engine = factory.create(input);
        assertThat(engine.calculateSumOfGearRatios()).isEqualTo(23);
    }

    @Test(dataProvider = "getGondolaLiftEngineFactories")
    public void testCalculateSumOfGearRatiosWithTwoStarsAndOneGear(GondolaLiftEngineFactory factory) {
        var input = List.of(
                "2*4",
                ".5.",
                ".*3"
        );

        var engine = factory.create(input);
        assertThat(engine.calculateSumOfGearRatios()).isEqualTo(15);
    }

    @Test(dataProvider = "getGondolaLiftEngineFactories")
    public void testCalculateSumOfGearRatiosWithThreeStarsAndTwoGear(GondolaLiftEngineFactory factory) {
        var input = List.of(
                "2@44",
                "..5*",
                "*./.",
                "12*2"
        );

        var engine = factory.create(input);
        assertThat(engine.calculateSumOfGearRatios()).isEqualTo(44*5 + 12*2);
    }

    @Test(dataProvider = "getGondolaLiftEngineFactories")
    public void testCalculateSumOfGearRatiosWithThreeStarsAndTwoGearDifferentVariant(GondolaLiftEngineFactory factory) {
        var input = List.of(
                "2@44",
                "..5*",
                "*2/.",
                "12*2"
        );

        var engine = factory.create(input);
        assertThat(engine.calculateSumOfGearRatios()).isEqualTo(44*5 + 12*2);
    }

    @Test(dataProvider = "getGondolaLiftEngineFactories")
    public void testCalculateSumOfGearRatiosWithComplexScenario(GondolaLiftEngineFactory factory) {
        var input = List.of(
                ".23*.....*", // 23*498 + 0
                "10/.498..4",
                "#397@...*5", // 0
                "...%134..6",
                "830..../*.", // 0
                "10$%25....",
                "*56.**..*.", // 0 + 25*91 + 25*91 + 0
                "675@91@..*", // 0
                "35*%.769..", // 675*35
                "*..$70/.##"  // 0
        );

        var engine = factory.create(input);
        assertThat(engine.calculateSumOfGearRatios()).isEqualTo(23*498 + 25*91 + 25*91 + 675*35);
    }

    @DataProvider
    private Iterator<Object[]> getGondolaLiftEngineFactories() {
        return Arrays.asList(new Object[][] {
                {factory},
                {optimizedFactory}
        }).listIterator();
    }
}
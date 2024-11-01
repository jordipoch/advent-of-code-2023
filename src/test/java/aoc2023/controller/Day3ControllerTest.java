package aoc2023.controller;

import aoc2023.controller.input.supplier.Day3InputSupplier;
import aoc2023.input.InputFileDataLoaderFactory;
import aoc2023.model.day3.GondolaLiftOptimizedEngineFactory;
import aoc2023.model.day3.parser.EngineNumbersParser;
import aoc2023.model.day3.parser.NumberExtractor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day3ControllerTest {

    private Day3Controller controller;
    @BeforeMethod
    public void setUp() {
        var supplier = new Day3InputSupplier(new InputFileDataLoaderFactory());
        controller = new Day3Controller(
                new GondolaLiftOptimizedEngineFactory(new EngineNumbersParser(new NumberExtractor())),
                supplier);
    }

    @Test
    public void testGetPart1Result() {
        assertThat(controller.getPart1Result()).isEqualTo(4361);
    }

    @Test
    public void testGetPart2Result() {
        assertThat(controller.getPart2Result()).isEqualTo(467835);
    }
}
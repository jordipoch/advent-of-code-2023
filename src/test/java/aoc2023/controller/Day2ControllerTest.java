package aoc2023.controller;

import aoc2023.controller.input.supplier.Day2InputSupplier;
import aoc2023.input.InputFileDataLoaderFactory;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day2ControllerTest {

    private Day2Controller controller;
    @BeforeMethod
    public void setUp() {
        var supplier = new Day2InputSupplier(new InputFileDataLoaderFactory());
        controller = new Day2Controller(supplier);
    }

    @Test
    public void testGetPart1Result() {
        Assertions.assertThat(controller.getPart1Result()).isEqualTo(8);
    }

    @Test
    public void testGetPart2Result() {
        Assertions.assertThat(controller.getPart2Result()).isEqualTo(2286);
    }
}
package aoc2023.controller;

import aoc2023.controller.input.supplier.Day2InputSupplier;
import aoc2023.input.InputFileDataLoaderFactory;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class Day2ControllerTest {

    @Test
    public void testGetPart1Result() {
        var supplier = new Day2InputSupplier(new InputFileDataLoaderFactory());
        var controller = new Day2Controller(supplier);

        Assertions.assertThat(controller.getPart1Result()).isEqualTo(8);
    }
}
package aoc2023.controller;

import aoc2023.controller.input.Day1InputSupplier;
import aoc2023.input.InputFileDataLoaderFactory;
import aoc2023.input.InputFileDataLoaderForTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class Day1ControllerTest {

    @Test
    public void testGetPart1Result() {
        Supplier<List<String>> supplier = () -> List.of(
                "1abc2",
                "pqr3stu8vwx",
                "a1b2c3d4e5f",
                "treb7uchet");

        var controller = new Day1Controller(supplier);
        assertThat(controller.getPart1Result()).isEqualTo(142);
    }

    @Test
    public void testGetPart2Result() {
        Supplier<List<String>> supplier = () -> List.of(
                "two1nine",
                "eightwothree",
                "abcone2threexyz",
                "xtwone3four",
                "4nineeightseven2",
                "zoneight234",
                "7pqrstsixteen");

        var controller = new Day1Controller(supplier);
        assertThat(controller.getPart2Result()).isEqualTo(281);
    }

    @Test
    public void testGetPart1ResultFromInputFile() {
        var supplier = new Day1InputSupplier(new InputFileDataLoaderFactory());

        var controller = new Day1Controller(supplier);
        assertThat(controller.getPart1Result()).isEqualTo(142);
    }
}
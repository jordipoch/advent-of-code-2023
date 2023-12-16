package aoc2023.model.day2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static aoc2023.model.day2.Cube.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HandfulOfCubesTest {

    private final GameConfiguration gameConfiguration = new GameConfiguration();
    @Test(dataProvider = "getTestData")
    public void testIsAllowedByConfiguration(List<CubeQuantity> cubeQuantities, boolean expectedResult) {
        var handfulOfCubes = new HandfulOfCubes(cubeQuantities);
        assertThat(handfulOfCubes.isAllowedByConfiguration(gameConfiguration)).isEqualTo(expectedResult);
    }

    @Test(dataProvider = "getUnparsedTestData")
    public void testIsAllowedByConfigurationFromTextInput(String input, boolean expectedResult) {
        var handfulOfCubes = HandfulOfCubes.create(input);
        assertThat(handfulOfCubes.isAllowedByConfiguration(gameConfiguration)).isEqualTo(expectedResult);
    }

    @Test
    public void testCreateFromText() {
        assertThat(HandfulOfCubes.create("5 red, 12 green, 18 blue")).isEqualTo(new HandfulOfCubes(List.of(
                CubeQuantity.of(RED, 5),
                CubeQuantity.of(GREEN, 12),
                CubeQuantity.of(BLUE, 18)
        )));
    }

    @DataProvider
    private Iterator<Object[]> getTestData() {
        return Arrays.asList(new Object[][] {
                { List.of(CubeQuantity.of(RED, 5), CubeQuantity.of(GREEN, 12)), true },
                { List.of(CubeQuantity.of(BLUE, 15)), false },
                { List.of(CubeQuantity.of(GREEN, 4), CubeQuantity.of(BLUE, 15)), false },
                { List.of(CubeQuantity.of(RED, 14), CubeQuantity.of(GREEN, 15)), false },
                { List.of(CubeQuantity.of(RED, 12), CubeQuantity.of(GREEN, 13), CubeQuantity.of(BLUE, 14)), true }
        }).iterator();
    }

    @DataProvider
    private Iterator<Object[]> getUnparsedTestData() {
        return Arrays.asList(new Object[][] {
                { "5 red, 12 green", true },
                { "15 blue", false },
        }).iterator();
    }
}
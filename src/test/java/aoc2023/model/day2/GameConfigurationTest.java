package aoc2023.model.day2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;

import static aoc2023.model.day2.Cube.*;
import static aoc2023.model.day2.GameConfiguration.createEmpty;
import static aoc2023.model.day2.GameConfiguration.of;
import static org.assertj.core.api.Assertions.assertThat;

public class GameConfigurationTest {

    @Test(dataProvider = "getTestData")
    public void testIsCubeQuantityAllowed(Cube cube, int quantity, boolean expectedResult) {
        var gameConfiguration = GameConfiguration.DEFAULT;
        assertThat(gameConfiguration.isCubeQuantityAllowed(CubeQuantity.of(cube, quantity))).isEqualTo(expectedResult);
    }

    @Test(dataProvider = "getUpdateMinConfigurationTestData")
    public void testUpdateMinConfiguration(GameConfiguration initialConfiguration, CubeQuantity quantityToUpdate, GameConfiguration expectedMinConfiguration) {
        assertThat(initialConfiguration.updateMinConfiguration(quantityToUpdate)).isEqualTo(expectedMinConfiguration);
    }

    @Test(dataProvider = "getCalculatePowerData")
    public void testCalculatePower(GameConfiguration gameConfiguration, int expectedPower) {
        assertThat(gameConfiguration.calculatePower()).isEqualTo(expectedPower);
    }

    @DataProvider
    private Iterator<Object[]> getTestData() {
        return Arrays.asList(new Object[][] {
                {RED, 8, true},
                {RED, 12, true},
                {RED, 13, false},
                {GREEN, 5, true},
                {GREEN, 13, true},
                {GREEN, 15, false},
                {BLUE, 10, true},
                {BLUE, 14, true},
                {BLUE, 15, false}
        }).listIterator();
    }

    @DataProvider
    private Iterator<Object[]> getUpdateMinConfigurationTestData() {
        return Arrays.asList(new Object[][] {
                {createEmpty(), CubeQuantity.create("3 red"), of(3, 0, 0)},
                {of(12, 0, 4), CubeQuantity.create("3 red"), of(12, 0, 4)},
                {of(12, 0, 4), CubeQuantity.create("4 green"), of(12, 4, 4)},
                {of(12, 0, 4), CubeQuantity.create("5 blue"), of(12, 0, 5)},
        }).listIterator();
    }

    @DataProvider
    private Iterator<Object[]> getCalculatePowerData() {
        return Arrays.asList(new Object[][] {
                {of (1, 2, 3), 6},
                {of (3, 10, 2), 60},
                {of (3, 0, 2), 0},
        }).listIterator();
    }
}
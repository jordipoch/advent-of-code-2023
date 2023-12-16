package aoc2023.model.day2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;

import static aoc2023.model.day2.Cube.*;
import static org.assertj.core.api.Assertions.assertThat;

public class GameConfigurationTest {

    private final GameConfiguration gameConfiguration = new GameConfiguration();

    @Test(dataProvider = "getTestData")
    public void testIsCubeQuantityAllowed(Cube cube, int quantity, boolean expectedResult) {
        assertThat(gameConfiguration.isCubeQuantityAllowed(CubeQuantity.of(cube, quantity))).isEqualTo(expectedResult);
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
}
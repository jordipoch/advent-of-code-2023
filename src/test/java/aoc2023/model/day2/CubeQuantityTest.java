package aoc2023.model.day2;

import org.testng.annotations.Test;

import static aoc2023.model.day2.Cube.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CubeQuantityTest {

    @Test
    public void testCreateFromText() {
        assertThat(CubeQuantity.create("5 red")).isEqualTo(CubeQuantity.of(RED, 5));
        assertThat(CubeQuantity.create("12 green")).isEqualTo(CubeQuantity.of(GREEN, 12));
        assertThat(CubeQuantity.create("25 blue")).isEqualTo(CubeQuantity.of(BLUE, 25));
    }
}
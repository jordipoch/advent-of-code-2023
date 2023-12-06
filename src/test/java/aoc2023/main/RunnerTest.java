package aoc2023.main;

import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RunnerTest {

    @BeforeMethod
    public void setUp() {
        Runner.createInjector();
    }

    @Test
    public void testDay1Part1() {
        Assertions.assertThat(Runner.runDay1Part1()).isEqualTo(55172);
    }
}
package aoc2023.main;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RunnerTest {

    @BeforeClass
    public void setUp() {
        Runner.createInjector();
    }

    @Test
    public void testDay1Part1() {
        assertThat(Runner.runDay1Part1()).isEqualTo(55172);
    }

    @Test
    public void testDay1Part2() {
        assertThat(Runner.runDay1Part2()).isEqualTo(54925);
    }
}
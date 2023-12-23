package aoc2023.main.runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day2Test {

    @BeforeClass
    public void setUp() {
        Day2.createInjector();
    }

    @Test
    public void testPart1() {
        assertThat(Day2.runPart1()).isEqualTo(2545);
    }

    @Test
    public void testPart2() {
        assertThat(Day2.runPart2()).isEqualTo(78111);
    }
}
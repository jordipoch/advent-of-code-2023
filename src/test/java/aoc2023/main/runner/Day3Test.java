package aoc2023.main.runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day3Test {

    @BeforeClass
    public void setUp() {
        Day3.createInjector();
    }

    @Test
    public void testPart1() {
        assertThat(Day3.runPart1()).isEqualTo(540025);
    }
}
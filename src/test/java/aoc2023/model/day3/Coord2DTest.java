package aoc2023.model.day3;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;

import static aoc2023.model.day3.Coord2D.coord2D;

public class Coord2DTest {

    @Test (dataProvider = "getIsAdjacentToTestData")
    public void testIsAdjacentTo(Coord2D coord1, Coord2D coord2, boolean expected) {
        Assertions.assertThat(coord1.isAdjacentTo(coord2)).isEqualTo(expected);
    }

    @DataProvider
    private Iterator<Object[]> getIsAdjacentToTestData() {
        return Arrays.asList(new Object[][] {
                { coord2D(0, 0), coord2D(1, 0), true},
                { coord2D(2, 3), coord2D(2, 3), false},
                { coord2D(2, 3), coord2D(2, 2), true},
                { coord2D(2, 3), coord2D(2, 4), true},
                { coord2D(2, 3), coord2D(2, 1), false},
                { coord2D(0, 0), coord2D(-1, -1), true},
                { coord2D(0, 0), coord2D(2, 0), false},
                { coord2D(10, 5), coord2D(11, 4), true},
                { coord2D(10, 5), coord2D(11, 5), true},
                { coord2D(10, 5), coord2D(10, 6), true},
                { coord2D(10, 5), coord2D(10, 4), true},
                { coord2D(10, 5), coord2D(9, 5), true},
                { coord2D(10, 5), coord2D(12, 5), false},
                { coord2D(10, 5), coord2D(10, 3), false},
        }).listIterator();
    }
}
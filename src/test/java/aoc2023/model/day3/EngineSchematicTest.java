package aoc2023.model.day3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static aoc2023.model.day3.Coord2D.coord2D;
import static org.assertj.core.api.Assertions.assertThat;

public class EngineSchematicTest {

    @Test
    public void testGetAdjacentDigitPositionsWhenNoThereAreNone() {
        var input = List.of(
                "...",
                ".*.",
                "..."
        );

        var engineSchematic = EngineSchematic.create(input);
        assertThat(engineSchematic.getAdjacentDigitPositions(coord2D(1, 1))).isEmpty();
    }

    @Test
    public void testGetAdjacentDigitPositionsWhenThereIsOneAdjacentPositions() {
        var input = List.of(
                "..1",
                ".*.",
                "..."
        );

        var engineSchematic = EngineSchematic.create(input);
        assertThat(engineSchematic.getAdjacentDigitPositions(coord2D(1, 1)))
                .containsExactlyInAnyOrder(coord2D(2, 0));
    }

    @Test
    public void testGetAdjacentDigitPositionsWhenThereAreSeveralAdjacentPositions() {
        var input = List.of(
                "..1",
                "4*.",
                ".9."
        );

        var engineSchematic = EngineSchematic.create(input);
        assertThat(engineSchematic.getAdjacentDigitPositions(coord2D(1, 1)))
                .containsExactlyInAnyOrder(coord2D(2, 0), coord2D(0, 1), coord2D(1, 2));
    }

    @Test
    public void testGetAdjacentDigitPositionsWhenThereAreSeveralAdjacentPositionsAndNonDigitCharacters() {
        var input = List.of(
                "31@",
                "/*5",
                ".98"
        );

        var engineSchematic = EngineSchematic.create(input);
        assertThat(engineSchematic.getAdjacentDigitPositions(coord2D(1, 1)))
                .containsExactlyInAnyOrder(
                        coord2D(0, 0),
                        coord2D(1, 0),
                        coord2D(2, 1),
                        coord2D(1, 2),
                        coord2D(2, 2)
                        );
    }

    @Test(dataProvider = "getOriginPositionsAndExpectedResults")
    public void testGetAdjacentDigitPositionsWhenSomeAdjacentPositionsAreOutOfBounds(Coord2D origin, List<Coord2D> expectedResult) {
        var input = List.of(
                "@.1",
                "...",
                ".9."
        );

        var engineSchematic = EngineSchematic.create(input);
        assertThat(engineSchematic.getAdjacentDigitPositions(origin))
                .containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    @DataProvider
    private Iterator<Object[]> getOriginPositionsAndExpectedResults() {
        return Arrays.asList(new Object[][] {
                {coord2D(0, 0), List.of()},
                {coord2D(1, 0), List.of(coord2D(2, 0))},
                {coord2D(2, 0), List.of()},
                {coord2D(0, 1), List.of(coord2D(1, 2))},
                {coord2D(1, 1), List.of(coord2D(1, 2), coord2D(2, 0))},
                {coord2D(2, 1), List.of(coord2D(1, 2), coord2D(2, 0))},
                {coord2D(0, 2), List.of(coord2D(1, 2))},
                {coord2D(1, 2), List.of()},
                {coord2D(2, 2), List.of(coord2D(1, 2))},
        }).listIterator();
    }
}
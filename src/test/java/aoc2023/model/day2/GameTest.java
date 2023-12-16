package aoc2023.model.day2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static aoc2023.model.day2.Cube.*;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    private final GameConfiguration gameConfiguration = new GameConfiguration();
    @Test
    public void testWhenGameIsPossibleWithSingleHandfulOfCubes() {
        List<HandfulOfCubes> groupsOfCubesGrabbed = List.of(
                new HandfulOfCubes(List.of(
                        CubeQuantity.of(RED, 4),
                        CubeQuantity.of(BLUE, 8)
                ))
        );
        var game = Game.create(1, groupsOfCubesGrabbed, gameConfiguration);

        assertThat(game.isGamePossible()).isTrue();
    }

    @Test
    public void testWhenGameIsNotPossibleWithSingleHandfulOfCubes() {
        List<HandfulOfCubes> groupsOfCubesGrabbed = List.of(
                new HandfulOfCubes(List.of(
                        CubeQuantity.of(RED, 4),
                        CubeQuantity.of(GREEN, 14),
                        CubeQuantity.of(BLUE, 8)
                ))
        );
        var game = Game.create(1, groupsOfCubesGrabbed, gameConfiguration);

        assertThat(game.isGamePossible()).isFalse();
    }

    @Test
    public void testWhenGameIsPossibleWithMultipleHandfulOfCubes() {
        List<HandfulOfCubes> groupsOfCubesGrabbed = List.of(
                new HandfulOfCubes(List.of(
                        CubeQuantity.of(RED, 4),
                        CubeQuantity.of(BLUE, 8)
                )),
                new HandfulOfCubes(List.of(
                        CubeQuantity.of(GREEN, 13),
                        CubeQuantity.of(RED, 3),
                        CubeQuantity.of(BLUE, 5)
                ))
        );
        var game = Game.create(1, groupsOfCubesGrabbed, gameConfiguration);

        assertThat(game.isGamePossible()).isTrue();
    }

    @Test
    public void testWhenGameIsNotPossibleWithMultipleHandfulOfCubes() {
        List<HandfulOfCubes> groupsOfCubesGrabbed = List.of(
                new HandfulOfCubes(List.of(
                        CubeQuantity.of(RED, 4),
                        CubeQuantity.of(BLUE, 8)
                )),
                new HandfulOfCubes(List.of(
                        CubeQuantity.of(GREEN, 14),
                        CubeQuantity.of(RED, 3),
                        CubeQuantity.of(BLUE, 5)
                ))
        );
        var game = Game.create(1, groupsOfCubesGrabbed, gameConfiguration);

        assertThat(game.isGamePossible()).isFalse();
    }

    @Test
    public void testToString() {
        List<HandfulOfCubes> groupsOfCubesGrabbed = List.of(
                new HandfulOfCubes(List.of(
                        CubeQuantity.of(BLUE, 3),
                        CubeQuantity.of(RED, 4)
                )),
                new HandfulOfCubes(List.of(
                        CubeQuantity.of(RED, 1),
                        CubeQuantity.of(GREEN, 2),
                        CubeQuantity.of(BLUE, 6)
                )),
                new HandfulOfCubes(List.of(
                        CubeQuantity.of(GREEN, 2)
                ))
        );
        var game = Game.create(1, groupsOfCubesGrabbed, gameConfiguration);
        assertThat(game).hasToString("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
    }

    @Test (dataProvider = "getCreateGameFromTextLineTestData")
    public void testCreateGameFromTextLine(String textLine) {
        assertThat(Game.create(textLine, new GameConfiguration())).hasToString(textLine);
    }

    @DataProvider
    private Iterator<Object[]> getCreateGameFromTextLineTestData() {
        return Arrays.asList(new Object[][] {
                { "Game 1: 3 blue, 4 red"},
                { "Game 2: 10 green"},
                { "Game 3: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green" },
                { "Game 100: 4 red, 9 green, 1 blue; 11 green, 11 blue, 4 red; 10 red, 17 blue, 11 green; 5 blue, 12 red, 2 green; 14 blue, 6 green, 5 red; 8 green, 19 blue, 13 red" },
        }).iterator();
    }
}
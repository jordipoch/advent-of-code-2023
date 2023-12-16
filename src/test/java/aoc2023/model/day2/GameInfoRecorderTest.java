package aoc2023.model.day2;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;

public class GameInfoRecorderTest {

    @Test
    public void testCalculateSumOfPossibleGameIds() {
        var gameLines = List.of(
                "Game 1: 5 green, 8 blue",
                "Game 2: 10 blue, 2 red; 13 red", // not possible
                "Game 3: 4 red, 3 blue; 14 blue, 12 red, 13 green; 10 green"
        );

        var gameInfoRecorder = GameInfoRecorder.create(gameLines);

        Assertions.assertThat(gameInfoRecorder.calculateSumOfPossibleGameIds()).isEqualTo(4);
    }
}
package aoc2023.model.day2;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameInfoRecorderTest {

    @Test
    public void testCalculateSumOfPossibleGameIds() {
        var gameLines = List.of(
                "Game 1: 5 green, 8 blue",
                "Game 2: 10 blue, 2 green; 13 red", // not possible
                "Game 3: 4 red, 3 blue; 14 blue, 12 red, 13 green; 10 green"
        );

        var gameInfoRecorder = GameInfoRecorder.create(gameLines);

        assertThat(gameInfoRecorder.calculateSumOfPossibleGameIds()).isEqualTo(4);
    }

    @Test
    public void testCalculateSumOfGamePowers() {
        var gameLines = List.of(
                "Game 1: 5 green, 8 blue, 2 red", // 80
                "Game 2: 4 blue, 3 red; 10 green", // 120
                "Game 3: 4 red, 3 blue; 14 blue, 12 red, 13 green; 10 green" // 12 * 13 * 14
        );

        var gameInfoRecorder = GameInfoRecorder.create(gameLines);
        assertThat(gameInfoRecorder.calculateSumOfGamePowers()).isEqualTo(200 + 12 * 13 * 14);
    }
}
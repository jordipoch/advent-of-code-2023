package aoc2023.model.day2;

import java.util.List;

public class GameInfoRecorder {
    private final List<Game> games;

    private GameInfoRecorder(List<Game> games) {
        this.games = games;
    }

    public static GameInfoRecorder create(List<String> gameLines) {
        var games = gameLines.stream()
                .map(Game::create)
                .toList();

        return new GameInfoRecorder(games);
    }

    public int calculateSumOfPossibleGameIds() {
        return games.stream()
                .filter(Game::isGamePossible)
                .mapToInt(Game::getGameNum)
                .sum();
    }

    public int calculateSumOfGamePowers() {
        return games.stream()
                .mapToInt(Game::calculateGamePower)
                .sum();
    }
}

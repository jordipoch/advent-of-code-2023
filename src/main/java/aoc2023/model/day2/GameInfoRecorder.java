package aoc2023.model.day2;

import java.util.List;

public class GameInfoRecorder {
    private final List<Game> games;

    private GameInfoRecorder(List<Game> games) {
        this.games = games;
    }

    public static GameInfoRecorder create(List<String> gameLines) {
        var gameConfiguration = new GameConfiguration();

        var games = gameLines.stream()
                .map(line -> Game.create(line, gameConfiguration))
                .toList();

        return new GameInfoRecorder(games);
    }

    public int calculateSumOfPossibleGameIds() {
        return games.stream()
                .filter(Game::isGamePossible)
                .mapToInt(Game::getGameNum)
                .sum();
    }
}

package aoc2023.model.day2;

import aoc2023.library.string.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Game {
    private final int gameNum;
    private final List<HandfulOfCubes> groupsOfCubesGrabbed;
    private final GameConfiguration defaultConfiguration = GameConfiguration.DEFAULT;

    private Game(int gameNum, List<HandfulOfCubes> groupsOfCubesGrabbed) {
        this.gameNum = gameNum;
        this.groupsOfCubesGrabbed = groupsOfCubesGrabbed;
    }

    static Game create(int gameNum, List<HandfulOfCubes> groupsOfCubesGrabbed) {
        return new Game(gameNum, groupsOfCubesGrabbed);
    }

    public static Game create(String text) {
        return Builder.aGame()
                .withText(text)
                .build();
    }

    public boolean isGamePossible() {
        return groupsOfCubesGrabbed.stream()
            .allMatch(hc -> hc.isAllowedByConfiguration(defaultConfiguration));
    }

    public int calculateGamePower() {
        var initialConfiguration = GameConfiguration.createEmpty();
        groupsOfCubesGrabbed.forEach((groupOfCubes) -> groupOfCubes.updateMinConfiguration(initialConfiguration));
        return initialConfiguration.calculatePower();
    }

    public int getGameNum() {
        return gameNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return gameNum == game.gameNum && Objects.equals(groupsOfCubesGrabbed, game.groupsOfCubesGrabbed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameNum, groupsOfCubesGrabbed);
    }

    @Override
    public String toString() {
        return String.format("Game %d: %s", gameNum, groupsOfCubesGrabbed.stream()
                .map(Objects::toString)
                .collect(Collectors.joining("; "))
        );
    }

    private static class Builder {
        private static final Pattern GAME_NUM_PATTERN = Pattern.compile("^Game (\\d{1,3})$");
        private String gameText;
        private static Builder aGame() {
            return new Builder();
        }

        private Builder withText(String gameText) {
            this.gameText = gameText;
            return this;
        }

        private Game build() {
            Objects.requireNonNull(gameText);

            var gameParts = parseText();
            var handfulOfCubesList = gameParts.handfulOfCubesTexts().stream()
                    .map(HandfulOfCubes::create)
                    .toList();

            return new Game(
                    gameParts.gameNum(),
                    handfulOfCubesList);
        }

        private GameParts parseText() {
            List<String> textParts = StringUtils.split(gameText, ": ");

            var gameNum = extractGameNum(textParts.get(0));
            var handFulOfCubesTexts = StringUtils.split(textParts.get(1), "; ");

            return new GameParts(gameNum, handFulOfCubesTexts);
        }

        private int extractGameNum(String text) {
            var matcher = GAME_NUM_PATTERN.matcher(text);
            if (matcher.find()) {
                return Integer.parseInt(matcher.group(1));
            } else {
                throw new IllegalArgumentException(String.format("Wrong game number format: %s", text));
            }
        }

        private record GameParts(int gameNum, List<String> handfulOfCubesTexts) {
        }
    }

}

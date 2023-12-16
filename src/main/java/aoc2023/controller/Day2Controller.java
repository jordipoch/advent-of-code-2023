package aoc2023.controller;

import aoc2023.controller.input.annotation.Day2;
import aoc2023.model.day2.GameInfoRecorder;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.function.Supplier;

@Singleton
public class Day2Controller {
    private final GameInfoRecorder gameInfoRecorder;

    @Inject
    public Day2Controller(@Day2 Supplier<List<String>> inputData) {
        gameInfoRecorder = GameInfoRecorder.create(inputData.get());
    }

    public int getPart1Result() {
        return gameInfoRecorder.calculateSumOfPossibleGameIds();
    }
}

package aoc2023.controller;

import aoc2023.controller.input.annotation.Day3;
import aoc2023.model.day3.GondolaLiftEngine;
import aoc2023.model.day3.GondolaLiftEngineFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.function.Supplier;

@Singleton
public class Day3Controller {
    private final GondolaLiftEngine engine;

    @Inject
    public Day3Controller(GondolaLiftEngineFactory engineFactory, @Day3 Supplier<List<String>> inputData) {
        engine = engineFactory.create(inputData.get());
    }

    public long getPart1Result() {
        return engine.calculateSumOfPartNumbers();
    }

    public long getPart2Result() {
        return engine.calculateSumOfGearRatios();
    }
}

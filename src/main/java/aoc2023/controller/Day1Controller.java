package aoc2023.controller;

import aoc2023.controller.annotation.Day1;
import aoc2023.model.day1.CalibrationDocument;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.function.Supplier;

@Singleton
public class Day1Controller {
    private final CalibrationDocument calibrationDocument;

    @Inject
    public Day1Controller(@Day1 Supplier<List<String>> inputData) {
        calibrationDocument = CalibrationDocument.of(inputData.get());
    }

    public int getPart1Result() {
        return calibrationDocument.calculateCalibration();
    }
}

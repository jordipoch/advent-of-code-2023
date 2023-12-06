package aoc2023.model.day1;

import aoc2023.library.string.StringUtils;

import java.util.List;

public class CalibrationDocument {
    private final List<String> textLines;

    private CalibrationDocument(List<String> textLines) {
        this.textLines = textLines;
    }

    public static CalibrationDocument of(List<String> textLines) {
        return new CalibrationDocument(textLines);
    }

    public int calculateCalibration() {
        return textLines.stream()
                .mapToInt(this::extractCalibrationValue)
                .sum();
    }

    private int extractCalibrationValue(String line) {
        var lineDigits = StringUtils.stringToCharList(line).stream()
                .filter(Character::isDigit)
                .toList();

        var firstAndLastDigit = lineDigits.get(0) + "" + lineDigits.get(lineDigits.size()-1);
        return Integer.parseInt(firstAndLastDigit);
    }
}

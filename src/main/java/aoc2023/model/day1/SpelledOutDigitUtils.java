package aoc2023.model.day1;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

class SpelledOutDigitUtils {
    private SpelledOutDigitUtils() {
    }

    public static String insertDigitBeforeFirstSpelledOutDigit(String line) {
        var digitPosition = findFirstDigitPosition(line);
        return digitPosition.map(digit -> addDigitAtPosition(line, digit)).orElse(line);
    }

    public static String insertDigitBeforeLastSpelledOutDigit(String line) {
        var digitPosition = findLastDigitPosition(line);
        return digitPosition.map(digit -> addDigitAtPosition(line, digit)).orElse(line);
    }

    private static Optional<DigitPosition> findFirstDigitPosition(String line) {
        Map<Integer, Digit> indexToDigitSortedMap = new TreeMap<>();

        for (var digit : Digit.values()) {
            var firstIndex = StringUtils.indexOf(line, digit.name().toLowerCase());
            if (firstIndex >= 0) {
                indexToDigitSortedMap.put(firstIndex, digit);
            }
        }

        return getOptionalDigitPosition(indexToDigitSortedMap);
    }

    private static Optional<DigitPosition> findLastDigitPosition(String line) {
        Map<Integer, Digit> indexToDigitReverseSortedMap = new TreeMap<>(Comparator.reverseOrder());

        for (var digit : Digit.values()) {
            var lastIndex = StringUtils.lastIndexOf(line, digit.name().toLowerCase());
            if (lastIndex >= 0) {
                indexToDigitReverseSortedMap.put(lastIndex, digit);
            }
        }
        return getOptionalDigitPosition(indexToDigitReverseSortedMap);
    }

    private static Optional<DigitPosition> getOptionalDigitPosition(Map<Integer, Digit> indexToDigitSortedMap) {
        Iterator<Integer> iterator = indexToDigitSortedMap.keySet().iterator();
        if (iterator.hasNext()) {
            var position = iterator.next();
            return Optional.of(DigitPosition.of(indexToDigitSortedMap.get(position), position));
        } else {
            return Optional.empty();
        }
    }

    private static String addDigitAtPosition(String line, DigitPosition digitPosition) {
        return new StringBuilder(line)
                .insert(digitPosition.position(), digitPosition.digit().getValue())
                .toString();
    }
}

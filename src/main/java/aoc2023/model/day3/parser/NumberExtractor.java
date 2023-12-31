package aoc2023.model.day3.parser;

import aoc2023.library.string.StringUtils;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class NumberExtractor {
    List<ExtractedNumber> extractNumbersAndPositions(String text) {
        var chars = StringUtils.stringToCharList(text);

        List<ExtractedNumber> extractedNumbers = new ArrayList<>();
        var currentNumber = new StringBuilder();
        var currentNumberPosition = 0;
        
        for (int i = 0; i < chars.size(); i++) {
            var currentChar = chars.get(i);
            if (Character.isDigit(currentChar)) {
                if (currentNumber.isEmpty()) {
                    currentNumberPosition = i;
                }
                currentNumber.append(currentChar);
            } else {
                if (!currentNumber.isEmpty()) {
                    extractedNumbers.add(new ExtractedNumber(currentNumber.toString(), currentNumberPosition));
                    currentNumber = new StringBuilder();
                }
            }
        }

        if(!currentNumber.isEmpty()) {
            extractedNumbers.add(new ExtractedNumber(currentNumber.toString(), currentNumberPosition));
        }

        return extractedNumbers;
    }
}

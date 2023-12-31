package aoc2023.model.day3.parser;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class NumberExtractorTest {
    private final NumberExtractor extractor = new NumberExtractor();

    @Test (dataProvider = "getTestData")
    public void testExtractNumbersAndPositions(String inputText, List<ExtractedNumber> expectedExtractedNumbers) {
        Assertions.assertThat(extractor.extractNumbersAndPositions(inputText)).containsExactlyElementsOf(expectedExtractedNumbers);
    }

    @DataProvider
    private Iterator<Object[]> getTestData() {
        return Arrays.asList(new Object[][] {
                { "123", List.of(new ExtractedNumber("123", 0)) },
                { ".123#", List.of(new ExtractedNumber("123", 1)) },
                { "123#456", List.of(new ExtractedNumber("123", 0), new ExtractedNumber("456", 4)) },
                { "..123#456.@78/.", List.of(new ExtractedNumber("123", 2), new ExtractedNumber("456", 6), new ExtractedNumber("78", 11)) }
        }).iterator();
    }
}
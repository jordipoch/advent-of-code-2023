package aoc2023.model.day1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

public class SpelledOutDigitUtilsTest {

    @Test(dataProvider = "getFirstDigitReplacementTestData")
    public void testReplaceFirstSpelledOutDigits(String line, String expectedResult) {
        assertThat(SpelledOutDigitUtils.insertDigitBeforeFirstSpelledOutDigit(line)).isEqualTo(expectedResult);
    }

    @Test(dataProvider = "getLastDigitReplacementTestData")
    public void testReplaceLastSpelledOutDigits(String line, String expectedResult) {
        assertThat(SpelledOutDigitUtils.insertDigitBeforeLastSpelledOutDigit(line)).isEqualTo(expectedResult);
    }

    @DataProvider
    private Iterator<Object[]> getFirstDigitReplacementTestData() {
        return Arrays.asList(new Object[][] {
                {"one2", "1one2"},
                {"3one2", "31one2"},
                {"two1three", "2two1three"},
                {"1abthreeight23z", "1ab3threeight23z"},
                {"nine", "9nine"},
                {"one5nine", "1one5nine"},
                {"neninfiv5", "neninfiv5"},
                {"2fourfour8anine", "24fourfour8anine"}
        }).listIterator();
    }

    @DataProvider
    private Iterator<Object[]> getLastDigitReplacementTestData() {
        return Arrays.asList(new Object[][] {
                {"one2", "1one2"},
                {"3one2", "31one2"},
                {"two1three", "two13three"},
                {"1abthreeight23z", "1abthre8eight23z"},
                {"nine", "9nine"},
                {"one5nine", "one59nine"},
                {"neninfiv5", "neninfiv5"},
                {"2fourfour8aninenine", "2fourfour8anine9nine"}
        }).listIterator();
    }

}
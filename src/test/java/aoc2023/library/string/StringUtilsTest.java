package aoc2023.library.string;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    @Test(dataProvider = "data for stringToCharList test")
    public void testStringToCharList(String s, List<Character> expectedResult) {
        assertThat(StringUtils.stringToCharList(s)).containsExactlyElementsOf(expectedResult);
    }

    @DataProvider(name = "data for stringToCharList test")
    protected Iterator<Object[]> getStringToCharListTestData() {
        return Arrays.asList(new Object[][] {
                {"", Collections.emptyList()},
                {"abc", List.of('a', 'b', 'c')},
                {"aabbcc123", List.of('a', 'a', 'b', 'b', 'c', 'c', '1', '2', '3')}
        }).iterator();
    }
}
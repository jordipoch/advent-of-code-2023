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

    @Test(dataProvider = "getReplaceFirstTestData")
    public void testReplaceFirst(String s, String search, String replacement, String expectedResult) {
        assertThat(StringUtils.replaceFirst(s, search, replacement)).isEqualTo(expectedResult);
    }

    @Test(dataProvider = "getReplaceLastTestData")
    public void testReplaceLast(String s, String search, String replacement, String expectedResult) {
        assertThat(StringUtils.replaceLast(s, search, replacement)).isEqualTo(expectedResult);
    }

    @DataProvider(name = "data for stringToCharList test")
    protected Iterator<Object[]> getStringToCharListTestData() {
        return Arrays.asList(new Object[][] {
                {"", Collections.emptyList()},
                {"abc", List.of('a', 'b', 'c')},
                {"aabbcc123", List.of('a', 'a', 'b', 'b', 'c', 'c', '1', '2', '3')}
        }).iterator();
    }

    @DataProvider
    protected Iterator<Object[]> getReplaceFirstTestData() {
        return Arrays.asList(new Object[][] {
                {"abc", "a", "d", "dbc"},
                {"abc", "non-existing", "e", "abc"},
                {"abcc", "c", "e", "abec"},
                {"ab text cd text", "text", "new", "ab new cd text"},
                {"aaaaa", "aaa", "bbb", "bbbaa"}
        }).iterator();
    }
    @DataProvider
    protected Iterator<Object[]> getReplaceLastTestData() {
        return Arrays.asList(new Object[][] {
                {"abc", "a", "d", "dbc"},
                {"abc", "non-existing", "e", "abc"},
                {"abcc", "c", "e", "abce"},
                {"ab text cd text", "text", "new", "ab text cd new"},
                {"aaaaa", "aaa", "bbb", "aabbb"}
        }).iterator();
    }
}
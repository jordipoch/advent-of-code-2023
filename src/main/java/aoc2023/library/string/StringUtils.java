package aoc2023.library.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StringUtils {
    private StringUtils() {
    }

    public static List<Character> stringToCharList(String s) {
        Objects.requireNonNull(s);
        return s.chars()
                .mapToObj(i -> (char) i)
                .toList();
    }

    public static String replaceFirst(String s, String search, String replacement) {
        var builder = new StringBuilder(s);
        var lastIndex = builder.indexOf(search);
        return replaceIfFound(builder, search, replacement, lastIndex);
    }

    public static String replaceLast(String s, String search, String replacement) {
        var builder = new StringBuilder(s);
        var lastIndex = builder.lastIndexOf(search);
        return replaceIfFound(builder, search, replacement, lastIndex);
    }

    public static List<String> split(String s, String separator) {
        return Arrays.asList(s.split(separator));
    }

    private static String replaceIfFound(StringBuilder builder, String search, String replacement, int lastIndex) {
        if (lastIndex >= 0) {
            return builder.replace(lastIndex, lastIndex + search.length(), replacement).toString();
        } else {
            return builder.toString();
        }
    }
}

package aoc2023.library.string;

import java.util.ArrayList;
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
}

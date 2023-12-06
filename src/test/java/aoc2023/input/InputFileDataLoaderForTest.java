package aoc2023.input;

import aoc2023.data.Environment;
import aoc2023.data.InputFileDataLoader;

public class InputFileDataLoaderForTest extends InputFileDataLoader {
    public InputFileDataLoaderForTest(int day, String fileName) {
        super(day, fileName, Environment.TEST);
    }

    public InputFileDataLoaderForTest(int day) {
        super(day, Environment.TEST);
    }
}

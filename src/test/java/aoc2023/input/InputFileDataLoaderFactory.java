package aoc2023.input;

import aoc2023.controller.input.InputDataLoader;
import aoc2023.controller.input.InputDataLoaderFactory;

public class InputFileDataLoaderFactory implements InputDataLoaderFactory {
    @Override
    public InputDataLoader createFromFile(int day) {
        return new InputFileDataLoaderForTest(day);
    }
}

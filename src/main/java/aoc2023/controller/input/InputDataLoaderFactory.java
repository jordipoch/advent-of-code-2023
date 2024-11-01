package aoc2023.controller.input;

public interface InputDataLoaderFactory {
    InputDataLoader createFromFile(int day);
}

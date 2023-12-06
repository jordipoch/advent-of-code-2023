package aoc2023.controller.input;

import com.google.inject.assistedinject.Assisted;

public interface InputDataLoaderFactory {
    InputDataLoader createFromFile(int day);
}

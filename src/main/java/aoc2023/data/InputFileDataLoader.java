package aoc2023.data;

import aoc2023.controller.input.InputDataLoader;
import aoc2023.data.exception.DataLoadingException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public abstract class InputFileDataLoader implements InputDataLoader {
    private static final Path BASE_PATH = Path.of("resources", "aoc2023");
    private static final String DEFAULT_FILENAME = "input.txt";

    private final Path filePath;

    protected InputFileDataLoader(int day, String fileName, Environment environment) {
        filePath = environment.getResourcePath().resolve(BASE_PATH).resolve(createFolderForDay(day)).resolve(fileName);
    }

    protected InputFileDataLoader(int day, Environment environment) {
        this(day, DEFAULT_FILENAME, environment);
    }

    @Override
    public List<String> loadData() {
        try {
            return TextFileReader.readAllLinesFromFile(filePath);
        } catch (IOException e) {
            throw new DataLoadingException(String.format("Error loading data from file %s", filePath.getFileName().toString()),  e);
        }
    }

    private String createFolderForDay(int day) {
        return "day" + day;
    }
}

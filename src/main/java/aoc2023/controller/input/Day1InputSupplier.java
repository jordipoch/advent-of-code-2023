package aoc2023.controller.input;

import aoc2023.controller.annotation.Day1;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.function.Supplier;

@Singleton
public class Day1InputSupplier implements Supplier<List<String>> {
    private final InputDataLoader dataLoader;

    @Inject
    public Day1InputSupplier(InputDataLoaderFactory dataLoaderFactory) {
        this.dataLoader = dataLoaderFactory.createFromFile(1);
    }
    @Override
    public List<String> get() {
        return dataLoader.loadData();
    }
}

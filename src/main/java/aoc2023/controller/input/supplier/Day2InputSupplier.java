package aoc2023.controller.input.supplier;

import aoc2023.controller.input.InputDataLoader;
import aoc2023.controller.input.InputDataLoaderFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.function.Supplier;

@Singleton
public class Day2InputSupplier implements Supplier<List<String>> {
    private final InputDataLoader dataLoader;

    @Inject
    public Day2InputSupplier(InputDataLoaderFactory dataLoaderFactory) {
        this.dataLoader = dataLoaderFactory.createFromFile(2);
    }
    @Override
    public List<String> get() {
        return dataLoader.loadData();
    }
}

package aoc2023.data;

import com.google.inject.assistedinject.Assisted;

import javax.inject.Inject;

public class InputFileDataLoaderForProd extends InputFileDataLoader {
    public InputFileDataLoaderForProd(int day, String fileName) {
        super(day, fileName, Environment.PRODUCTION);
    }

    @Inject
    public InputFileDataLoaderForProd(@Assisted int day) {
        super(day, Environment.PRODUCTION);
    }
}

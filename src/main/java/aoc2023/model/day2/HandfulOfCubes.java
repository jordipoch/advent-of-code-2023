package aoc2023.model.day2;

import aoc2023.library.string.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class HandfulOfCubes {
    private final List<CubeQuantity> cubeQuantities;

    HandfulOfCubes(List<CubeQuantity> cubeQuantities) {
        this.cubeQuantities = cubeQuantities;
    }

    static HandfulOfCubes create(String text) {
        var cubeQuantityTexts = parse(text).stream()
                .map(CubeQuantity::create)
                .toList();
        return new HandfulOfCubes(cubeQuantityTexts);
    }

    static List<String> parse(String text) {
        return StringUtils.split(text, ", ");
    }

    boolean isAllowedByConfiguration(GameConfiguration configuration) {
        return cubeQuantities.stream()
                .allMatch(configuration::isCubeQuantityAllowed);
    }

    public GameConfiguration updateMinConfiguration(GameConfiguration configuration) {
        for (var cubeQuantity : cubeQuantities) {
            configuration.updateMinConfiguration(cubeQuantity);
        }
        return configuration;
    }

    List<CubeQuantity> getCubeQuantities() {
        return Collections.unmodifiableList(cubeQuantities);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandfulOfCubes that = (HandfulOfCubes) o;
        return Objects.equals(cubeQuantities, that.cubeQuantities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cubeQuantities);
    }

    @Override
    public String toString() {
        return cubeQuantities.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", "));
    }
}

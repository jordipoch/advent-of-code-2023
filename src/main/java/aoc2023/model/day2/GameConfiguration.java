package aoc2023.model.day2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class GameConfiguration {
    public static GameConfiguration DEFAULT = createDefault();
    private final Map<Cube, Integer> allowedQuantities;


    public static GameConfiguration of(int redCubes, int greenCubes, int blueCubes) {
        Map<Cube, Integer> allowedQuantities = new HashMap<>(Map.of(
                Cube.RED, redCubes,
                Cube.GREEN, greenCubes,
                Cube.BLUE, blueCubes
        ));
        return new GameConfiguration(allowedQuantities);
    }


    private static GameConfiguration createDefault() {
        return of(12, 13, 14);
    }

    public static GameConfiguration createEmpty() {
        return of(0, 0, 0);
    }

    public GameConfiguration(Map<Cube, Integer> allowedQuantities) {
        this.allowedQuantities = allowedQuantities;
    }

    boolean isCubeQuantityAllowed(CubeQuantity cubeQuantity) {
        return allowedQuantities.get(cubeQuantity.cube()) >= cubeQuantity.quantity();
    }

    GameConfiguration updateMinConfiguration(CubeQuantity cubeQuantity) {
        allowedQuantities.merge(cubeQuantity.cube(), cubeQuantity.quantity(), (oldValue, newValue) -> newValue > oldValue ? newValue : oldValue);
        return this;
    }

    int calculatePower() {
        return allowedQuantities.values().stream()
                .mapToInt(Integer::intValue)
                .reduce(1, (a, b) -> a * b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameConfiguration that = (GameConfiguration) o;
        return Objects.equals(allowedQuantities, that.allowedQuantities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowedQuantities);
    }

    @Override
    public String toString() {
        return allowedQuantities.toString();
    }
}

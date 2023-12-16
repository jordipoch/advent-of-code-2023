package aoc2023.model.day2;

import java.util.Map;

class GameConfiguration {
    private final Map<Cube, Integer> allowedQuantities = Map.of(
        Cube.RED, 12,
        Cube.GREEN, 13,
        Cube.BLUE, 14
    );

    boolean isCubeQuantityAllowed(CubeQuantity cubeQuantity) {
        return allowedQuantities.get(cubeQuantity.cube()) >= cubeQuantity.quantity();
    }

}

package aoc2023.model.day2;

import java.util.Objects;
import java.util.regex.Pattern;

record CubeQuantity(Cube cube, int quantity) {
    private static final Pattern PATTERN = Pattern.compile("^(\\d{1,2}) (\\p{Lower}+)$");

    static CubeQuantity create(String textToParse) {
        return parse(textToParse);
    }

    private static CubeQuantity parse(String textToParse) {
        var matcher = PATTERN.matcher(textToParse);
        if (matcher.find()) {
            var quantity = Integer.parseInt(matcher.group(1));
            var cube = Cube.valueOf(matcher.group(2).toUpperCase());
            return new CubeQuantity(cube, quantity);
        } else {
            throw new IllegalArgumentException(String.format("Wrong format for cube-quantity: %s", textToParse));
        }
    }

    static CubeQuantity of(Cube cube, int quantity) {
        return new CubeQuantity(cube, quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CubeQuantity that = (CubeQuantity) o;
        return quantity == that.quantity && cube == that.cube;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cube, quantity);
    }

    @Override
    public String toString() {
        return quantity + " " + cube.name().toLowerCase();
    }
}

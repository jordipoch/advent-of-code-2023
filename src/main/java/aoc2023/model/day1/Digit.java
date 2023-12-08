package aoc2023.model.day1;

enum Digit {
    ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9");

    private final String value;
    Digit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return name().toLowerCase();
    }
}

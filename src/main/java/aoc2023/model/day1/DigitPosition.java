package aoc2023.model.day1;

public record DigitPosition(Digit digit, int position) {
    public static DigitPosition of(Digit digit, int position) {
        return new DigitPosition(digit, position);
    }
}

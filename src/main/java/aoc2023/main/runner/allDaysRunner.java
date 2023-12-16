package aoc2023.main.runner;

public class allDaysRunner extends BaseRunner {
    public static void main(String... args) {
        createInjector();

        runDay1();
        runDay2();
    }

    private static void runDay1() {
        Day1.runPart1();
        Day1.runPart2();
    }

    private static void runDay2() {
        Day2.runPart1();
    }
}

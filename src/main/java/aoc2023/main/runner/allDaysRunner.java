package aoc2023.main.runner;

public class allDaysRunner extends BaseRunner {
    public static void main(String... args) {
        createInjector();

        runDay1();
        runDay2();
        runDay3();
    }

    private static void runDay1() {
        Day1.runPart1();
        Day1.runPart2();
    }

    private static void runDay2() {
        Day2.runPart1();
        Day2.runPart2();
    }

    private static void runDay3() {
        Day3.runPart1();
        Day3.runPart2();
    }
}

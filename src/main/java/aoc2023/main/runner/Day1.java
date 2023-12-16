package aoc2023.main.runner;

import aoc2023.controller.Day1Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Day1 extends BaseRunner {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String... args) {
        createInjector();

        runPart1();
        runPart2();
    }

    public static int runPart1() {
        var controller = injector.getInstance(Day1Controller.class);

        int result = controller.getPart1Result();
        logger.info("The sum of calibration values is {}", result);
        return result;
    }

    public static int runPart2() {
        var controller = injector.getInstance(Day1Controller.class);

        int result = controller.getPart2Result();
        logger.info("The sum of calibration values including spelled out digits is {}", result);
        return result;
    }
}

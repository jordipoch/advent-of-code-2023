package aoc2023.main.runner;

import aoc2023.controller.Day3Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Day3 extends BaseRunner {
    private static final Logger logger = LogManager.getLogger();
    public static void main(String... args) {
        createInjector();

        runPart1();
    }

    public static long runPart1() {
        var controller = injector.getInstance(Day3Controller.class);

        long result = controller.getPart1Result();
        logger.info("The sum of all of the part numbers in the engine schematic is: {}", result);
        return result;
    }
}

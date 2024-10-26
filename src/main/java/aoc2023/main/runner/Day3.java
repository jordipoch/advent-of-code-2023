package aoc2023.main.runner;

import aoc2023.controller.Day3Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.System.currentTimeMillis;

public class Day3 extends BaseRunner {
    private static final Logger logger = LogManager.getLogger();
    public static void main(String... args) {
        createInjector();

        runPart1();
        runPart2();
    }

    public static long runPart1() {
        var controller = injector.getInstance(Day3Controller.class);

        long result = controller.getPart1Result();
        logger.info("The sum of all of the part numbers in the engine schematic is: {}", result);
        return result;
    }

    public static long runPart2() {
        var controller = injector.getInstance(Day3Controller.class);

        long startTime = currentTimeMillis();
        long result = controller.getPart2Result();
        logger.info("The sum of all gear ratios in the engine schematic is: {}", result);
        logger.debug("Time taken = {} ms", currentTimeMillis() - startTime);
        return result;
    }
}

package aoc2023.main.runner;

import aoc2023.controller.Day2Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Day2 extends BaseRunner {
    private static final Logger logger = LogManager.getLogger();
    public static void main(String... args) {
        createInjector();

        runPart1();
    }

    public static int runPart1() {
        var controller = injector.getInstance(Day2Controller.class);

        int result = controller.getPart1Result();
        logger.info("The sum of ID's of games for which the game would have been possible: {}", result);
        return result;
    }
}

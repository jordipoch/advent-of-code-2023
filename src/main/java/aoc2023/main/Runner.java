package aoc2023.main;

import aoc2023.controller.Day1Controller;
import aoc2023.main.config.InjectorModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    private static final Logger logger = LogManager.getLogger();
    static Injector injector;
    public static void main(String... args) {
        createInjector();

        runDay1Part1();
    }

    static void createInjector() {
        injector = Guice.createInjector(new InjectorModule());
    }

    public static int runDay1Part1() {
        var controller = injector.getInstance(Day1Controller.class);

        int result = controller.getPart1Result();
        logger.info("The sum of calibration values is {}", result);
        return result;
    }
}

package aoc2023.main.config;

import aoc2023.controller.Day1Controller;
import aoc2023.controller.Day2Controller;
import com.google.inject.Guice;
import org.testng.annotations.Test;

public class InjectorModuleTest {
    @Test
    public void day1InjectorTest() {
        var injector = Guice.createInjector(new InjectorModule());
        injector.getInstance(Day1Controller.class);
    }

    @Test
    public void day2InjectorTest() {
        var injector = Guice.createInjector(new InjectorModule());
        injector.getInstance(Day2Controller.class);
    }
}
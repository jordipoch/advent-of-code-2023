package aoc2023.main.runner;

import aoc2023.main.config.InjectorModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class BaseRunner {
    protected static Injector injector;

    protected static void createInjector() {
        injector = Guice.createInjector(new InjectorModule());
    }
}

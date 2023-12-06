package aoc2023.main.config;

import aoc2023.controller.annotation.Day1;
import aoc2023.controller.input.Day1InputSupplier;
import aoc2023.controller.input.InputDataLoader;
import aoc2023.controller.input.InputDataLoaderFactory;
import aoc2023.data.InputFileDataLoaderForProd;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.assistedinject.FactoryModuleBuilder;

import java.util.List;
import java.util.function.Supplier;

public class InjectorModule extends AbstractModule {

    @Override
    protected void configure() {
        configureInputDataLoaderFactory();

        configureDay1();
    }

    private void configureInputDataLoaderFactory() {
        install(new FactoryModuleBuilder()
                .implement(InputDataLoader.class, InputFileDataLoaderForProd.class)
                .build(InputDataLoaderFactory.class));
    }

    private void configureDay1() {
        bind(new TypeLiteral<Supplier<List<String>>>() {})
                .annotatedWith(Day1.class)
                .to(Day1InputSupplier.class);
    }
}

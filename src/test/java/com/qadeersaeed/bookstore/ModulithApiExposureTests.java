package com.qadeersaeed.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
public class ModulithApiExposureTests {

    @Test
    void generateApiExposureView() {

        ApplicationModules modules = ApplicationModules.of(BookstoreModulithApplication.class);

        new Documenter(modules)
                .writeModulesAsPlantUml() // high-level dependency graph
                .writeModuleCanvases();    // canvases show controllers, services, repos, events
    }
}

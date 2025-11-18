package com.qadeersaeed.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class BookstoreModulithDocumentationTests {

    @Test
    void generateModulithDocumentation() {

        ApplicationModules modules = ApplicationModules.of(BookstoreModulithApplication.class);
        new Documenter(modules)
                .writeDocumentation()
                .writeIndividualModulesAsPlantUml();
        // generates everything into /target/spring-modulith-docs
    }
}

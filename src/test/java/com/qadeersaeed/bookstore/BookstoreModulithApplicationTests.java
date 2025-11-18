package com.qadeersaeed.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
class BookstoreModulithApplicationTests {

//	@Test
//	void contextLoads() {
//	}

    @Test
    void createApplicationModuleModel() {
        ApplicationModules modules = ApplicationModules.of(BookstoreModulithApplication.class);
        modules.forEach(System.out::println);
        modules.verify();
    }

}

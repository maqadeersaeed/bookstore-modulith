package com.qadeersaeed.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreModulithApplication {

	public static void main(String[] args) {
//        ApplicationModules.of(Application.class).verify();
        SpringApplication.run(BookstoreModulithApplication.class, args);
	}

}

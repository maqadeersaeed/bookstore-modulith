package com.qadeersaeed.bookstore;

import org.springframework.modulith.Modulith;
import org.springframework.context.annotation.Configuration;

@Configuration
@Modulith(
        // optional, but nice: forces Modulith to use your base package
        // as root for module scanning
        sharedModules = {}
)
public class ModulithConfig {
}

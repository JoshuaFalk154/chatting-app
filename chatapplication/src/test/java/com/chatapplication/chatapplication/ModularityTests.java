package com.chatapplication.chatapplication;

import org.springframework.modulith.core.ApplicationModules;
import org.junit.jupiter.api.Test;


public class ModularityTests {

    @Test
    void verifyModularity() {
        ApplicationModules.of(ChatapplicationApplication.class).verify();
    }
}

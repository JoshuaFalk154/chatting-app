package com.chatapplication.chatapplication;

import org.springframework.modulith.core.ApplicationModules;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.docs.Documenter;


public class ModularityTests {

    ApplicationModules modules = ApplicationModules.of(ChatapplicationApplication.class);

    @Test
    void verifyModularity() {
        ApplicationModules.of(ChatapplicationApplication.class).verify();
    }

    @Test
    void writeDocumentationSnippets() {

        new Documenter(modules)
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml();
    }
}

package com.myorg;

import software.amazon.awscdk.core.App;

import java.util.Arrays;

public class HelloAlexaSkillApp {
    public static void main(final String[] args) {
        App app = new App();

        new HelloAlexaSkillStack(app, "HelloAlexaSkillStack");

        app.synth();
    }
}

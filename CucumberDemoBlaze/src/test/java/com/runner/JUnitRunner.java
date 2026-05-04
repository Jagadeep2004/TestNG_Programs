package com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:com/features", 
    glue = "com.stepDefinition",
    plugin = {
        "pretty",
        "html:target/cucumber-report.html"
    },
    monochrome = true,
    tags = "@Smoke or @Regression"
)

public class JUnitRunner {
}
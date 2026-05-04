package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "classpath:com/features",
    glue = "com.stepDefinition",
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true,
    tags = "@validCredentials"
    
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
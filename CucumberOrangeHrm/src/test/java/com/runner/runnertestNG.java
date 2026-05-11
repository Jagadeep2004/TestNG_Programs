package com.runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Test
@CucumberOptions(
		features = "src/test/resources/features/LoginPage.feature",
		glue = "com.stepDefinition",
		plugin = {
				"usage",
				"html:target/cucumber-reports.html",
				"json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		},
		monochrome = true)
public class runnertestNG extends AbstractTestNGCucumberTests{

}

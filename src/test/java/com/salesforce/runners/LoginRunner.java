package com.salesforce.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features/SFDCLogin.feature"},
glue = {"com.salesforce.steps"},
monochrome = true,
dryRun = false,
plugin = {"pretty","html:target/Salesforce-cucumber-pom-selenium.html"}
)


public class LoginRunner extends AbstractTestNGCucumberTests{

}


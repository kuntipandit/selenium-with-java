package org.Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@CartItem", features = {"src/test/resources/features"}, glue = {"org/stepdefinition"}, plugin = {"pretty", "html:target/cucumber-report.html"})
public
class CucumberRunnertest extends AbstractTestNGCucumberTests {



}

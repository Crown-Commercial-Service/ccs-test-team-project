package com.qtp.project.bdd.framework.testrunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"com.qtp.project.bdd.framework.stepdefinitions"},
        tags = "@searchFramework or @axe"
        )
public class TestRunner {

}

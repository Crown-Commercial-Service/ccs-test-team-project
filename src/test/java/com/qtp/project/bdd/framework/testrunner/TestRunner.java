package com.qtp.project.bdd.framework.testrunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"com.qtp.project.bdd.framework.stepdefinitions"},
        plugin = { "de.monochromata.cucumber.report.PrettyReports:target/cucumber" }
     //   tags = "@Energy or @axe or @legal or @cctv"
        //mvn test -Dcucumber.filter.tags="@cctv"
        )
public class TestRunner {

}

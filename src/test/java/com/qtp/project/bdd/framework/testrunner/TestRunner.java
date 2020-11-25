package com.qtp.project.bdd.framework.testrunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"com.qtp.project.bdd.framework.stepdefinitions"},
       // plugin = { "de.monochromata.cucumber.report.PrettyReports:target/cucumber" },
        plugin = {"pretty", "html:target/report/cucumber.html", "json:target/report/cucumber.json", "junit:target/report/cucumber.xml"},
        tags = "@cctv"
        //mvn test -Dcucumber.filter.tags="@cctv"
        )
public class TestRunner {

}

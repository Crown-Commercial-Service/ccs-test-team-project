package com.qtp.project.bdd.framework.stepdefinitions;

import com.deque.axe.AXE;
import com.qtp.project.bdd.framework.webdriver.WebConnector;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import java.net.URL;

import static org.junit.Assert.assertTrue;


public class GenericStpes {
    private static final URL scriptUrl = GenericStpes.class.getResource("/axe.min.js");

    WebConnector connector;

    public GenericStpes(WebConnector connector) {
        this.connector = connector;
    }

    @Before
    public void before(Scenario s) {
        System.out.println("before..");
        connector.initReports(s.getName());
    }

    @After
    public void CloseBrowser() {
       connector.closeConnection();
    }

    @Given("I open browser")
    public void i_open_browser() {
        System.out.println("Opening browser..");
        connector.openBrowser();
    }

    @Given("I am on CCS homepage")
    public void i_am_on_CCS_homepage() {
        connector.navigateTo(connector.properties.getProperty("base.url"));
    }

    @Then("I verify accessibility issues")
    public void i_verify_accessibility_issues() {
        testAccessibility();
    }


    public void testAccessibility() {

        JSONObject responseJSON = new AXE.Builder(connector.driver, scriptUrl).skipFrames().analyze();

        JSONArray violations = responseJSON.getJSONArray("violations");

        if (violations.length() == 0) {
            Assert.assertTrue( "No violations found", true);
        } else {
            AXE.writeResults("AxeError", responseJSON);
            assertTrue(AXE.report(violations), false);
        }
    }

}

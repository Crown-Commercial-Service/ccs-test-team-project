package com.qtp.project.bdd.framework.stepdefinitions;

import com.qtp.project.bdd.framework.pages.HomePage;
import com.qtp.project.bdd.framework.webdriver.*;
import io.cucumber.java.en.When;

public class HomePageSteps {
    WebConnector connector;
    private HomePage homePage;

    public HomePageSteps(WebConnector connector) {
        this.connector = connector;
        homePage = new HomePage(connector);
    }

    @When("I click Search Framework")
    public void i_press_Search_Framework() throws InterruptedException {
        homePage.clickSearchFramework();
        connector.waitForPageLoad();
    }
}

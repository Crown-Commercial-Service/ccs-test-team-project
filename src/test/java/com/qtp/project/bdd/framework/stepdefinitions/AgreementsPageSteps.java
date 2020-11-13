package com.qtp.project.bdd.framework.stepdefinitions;

import com.qtp.project.bdd.framework.pages.AgreementsPage;
import com.qtp.project.bdd.framework.webdriver.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AgreementsPageSteps {

    WebConnector connector;
    AgreementsPage agreementsPage;

    public AgreementsPageSteps(WebConnector connector) {
        this.connector = connector;
        agreementsPage = new AgreementsPage(connector);
    }

    @Then("I am on {string} page")
    public void i_am_on_page(String string) {
        String currentURL = agreementsPage.getCurrentURL();
        //Assert.assertEquals(currentURL.contains(string),
          //      "Expected page is not displayed : Expected " + string + " Actual " + currentURL);
    }

    @And("I search {string} Framework")
    public void iSearchEnergyFramework(String term) {
        agreementsPage.searchFramework(term);
    }
}

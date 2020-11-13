package com.qtp.project.bdd.framework.pages;

import com.qtp.project.bdd.framework.webdriver.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AgreementsPage extends UIActions {

    @FindBy(css = "input[id='q']")
    public WebElement frameworkSearchBox;

    @FindBy(css = "button[type='submit']")
    public WebElement searchButton;

    public AgreementsPage(WebConnector connector) {
        super(connector);
    }


    public void searchFramework(String term) {
        typeInTextBox(frameworkSearchBox, term);
        hitEnter(searchButton);
    }



}

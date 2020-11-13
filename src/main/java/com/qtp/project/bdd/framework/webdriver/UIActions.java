package com.qtp.project.bdd.framework.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UIActions {
    public WebDriver driver;

    public UIActions(WebConnector connector) {
        this.driver = connector.driver;
        PageFactory.initElements(connector.driver, this);
    }

    public void click(WebElement element) {

        element.click();
    }

    public void typeInTextBox(WebElement element, String term) {
        element.sendKeys(term);
    }

    public void hitEnter(WebElement frameworkSearchBox) {
        frameworkSearchBox.click();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
}

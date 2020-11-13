package com.qtp.project.bdd.framework.pages;

import com.qtp.project.bdd.framework.webdriver.UIActions;
import com.qtp.project.bdd.framework.webdriver.WebConnector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends UIActions {

    @FindBy(css = "nav.global-navigation [href='/agreements']")
    public WebElement searchframework;

    public HomePage(WebConnector connector) {
        super(connector);
    }

    public void clickSearchFramework() {
        click(searchframework);
    }
}

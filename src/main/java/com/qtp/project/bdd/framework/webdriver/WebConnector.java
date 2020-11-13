package com.qtp.project.bdd.framework.webdriver;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebConnector {

    public WebDriver driver;
    public Properties properties;
    public Scenario scenario;
//    ExtentReporter reporter;
//    ExtentTest extentTest;

    public WebConnector() throws IOException {
        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/properties/project.properties");
        properties.load(fileInputStream);
    }

    public void openBrowser() {
        String browser = properties.getProperty("browser");
        if (browser.equals("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-extensions");
            options.setExperimentalOption("useAutomationExtension", false);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        } else if (browser.equals("Firefox")) {
          //  System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.manage().window().setSize(new Dimension(1260, 1545));
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void initReports(String scenario) {
        //TODO
    }

    public void waitForPageLoad() throws InterruptedException {
        Thread.sleep(600);
    }

    public void closeConnection() {
        driver.quit();
    }



}

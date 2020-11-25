package com.qtp.project.bdd.framework.webdriver;

import io.cucumber.java.Scenario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import com.assertthat.selenium_shutterbug.core.PageSnapshot;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import javax.imageio.ImageIO;

public class WebConnector {

    public WebDriver driver;
    public Properties properties;
    public Scenario scenario;

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
        } else if (browser.equals("Chrome_headless")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-extensions");
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.setExperimentalOption("useAutomationExtension", false);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void waitForPageLoad() throws InterruptedException {
        Thread.sleep(600);
    }

    public void closeConnection() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public void takeSnapShot() {
        if (scenario.isFailed()) {
            //Code to take full page screenshot
            ByteArrayOutputStream imageStream = new ByteArrayOutputStream();
            scenario.log("URL - " + driver.getCurrentUrl());
           // Shutterbug.shootPage(driver).withThumbnail(0.4).save();
            PageSnapshot snapshot = Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS, true);
            snapshot.withThumbnail(2.0);
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");

            try {
                ImageIO.write(snapshot.getImage(), "png", imageStream);
                imageStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] source = imageStream.toByteArray();


//            final byte[] source = ((TakesScreenshot) driver)
//                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(source, "image/png", scenario.getName());
        }
    }



}

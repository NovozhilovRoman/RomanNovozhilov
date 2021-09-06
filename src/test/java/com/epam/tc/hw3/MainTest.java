package com.epam.tc.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public abstract class  MainTest {
    protected WebDriver webDriver;
    protected TestStepsHomePage homePageTestSteps;
    protected TestPageElementsSteps differentElementsPageTestSteps;
    private String siteURL = "https://jdi-testing.github.io/jdi-light/index.html";
    private String userPropertiesFile = "src/test/resources/user.properties";
    protected String username;
    protected String password;
    protected String expectedUsername;

    @BeforeMethod(alwaysRun = true)
    public void prepare() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(siteURL);
        getUserData(userPropertiesFile);
        homePageTestSteps = new TestStepsHomePage(webDriver);
        differentElementsPageTestSteps = new TestPageElementsSteps(webDriver);
    }

    public void getUserData(String properties) {
        Properties userProperties = new Properties();
        try (FileInputStream fis = new FileInputStream(userPropertiesFile)) {
            userProperties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        username = userProperties.getProperty("UserName");
        password = userProperties.getProperty("UserPassword");
        expectedUsername = userProperties.getProperty("ExpectedUserName");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        webDriver.quit();
    }
}

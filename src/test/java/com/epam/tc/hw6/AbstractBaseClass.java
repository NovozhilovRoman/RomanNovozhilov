package com.epam.tc.hw6;

import com.epam.tc.hw6.driver.WebDriverSingleton;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractBaseClass {
    protected TestHomePageSteps testHomePageSteps;
    protected TestPageElementsSteps testPageElementsSteps;
    private final String siteURL = "https://jdi-testing.github.io/jdi-light/index.html";
    private final String userPropertiesFile = "src/test/resources/user.properties";
    protected String username;
    protected String password;
    protected String expectedUsername;

    @BeforeMethod
    public void setUp(ITestContext context) {
        var webDriver = WebDriverSingleton.getDriver();

        webDriver.manage().window().maximize();
        webDriver.get(siteURL);
        getUserData(userPropertiesFile);
        testHomePageSteps = new TestHomePageSteps(webDriver);
        testPageElementsSteps = new TestPageElementsSteps(webDriver);
        context.setAttribute("webDriver", webDriver);
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

    @AfterMethod
    public void tearDownDriver() {
        WebDriverSingleton.closeDriver();
    }
}


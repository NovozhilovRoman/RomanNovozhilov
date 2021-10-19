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

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestContext context) {
        var driver = WebDriverSingleton.getDriver();

        driver.manage().window().maximize();
        driver.get(siteURL);
        getUserData(userPropertiesFile);
        testHomePageSteps = new TestHomePageSteps(driver);
        testPageElementsSteps = new TestPageElementsSteps(driver);
        context.setAttribute("driver", driver);
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
        WebDriverSingleton.closeDriver();
    }
}


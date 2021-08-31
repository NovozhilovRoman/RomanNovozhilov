package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class MainTest {
    public WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }
    // 12 Close Browser
    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        webDriver.close();
    }
}
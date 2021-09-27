package com.epam.tc.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver webDriver;

    public BasePage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getBrowserTitle() {
        return webDriver.getTitle();
    }
}

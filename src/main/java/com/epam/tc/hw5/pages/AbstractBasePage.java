package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.pages.component.Components;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractBasePage extends Components {
    protected Components loginForm;
    protected Components headerMenu;
    protected Components logsPanel;
    protected HomePage homePage;
    protected DifferentElementPage differentElementsPage;
    protected UserTablePage userTablePage;

    private static final String BASEURL = "https://jdi-testing.github.io/jdi-light/index.html";

    protected AbstractBasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        loginForm = new Components(driver);
        logsPanel = new Components(driver);
        headerMenu = new Components(driver);
    }

    public void openSite() {
        driver.get(BASEURL);
    }

    public String getBrowserTitle() {
        return driver.getTitle();
    }
}

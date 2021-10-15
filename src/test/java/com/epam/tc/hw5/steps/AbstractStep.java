package com.epam.tc.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.context.TestContext;
import com.epam.tc.hw5.pages.DifferentElementPage;
import com.epam.tc.hw5.pages.HomePage;
import com.epam.tc.hw5.pages.UserTablePage;
import com.epam.tc.hw5.pages.component.Components;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractStep {
    protected HomePage homePage;
    protected DifferentElementPage differentElementsPage;
    protected UserTablePage userTablePage;
    protected Components loginForm;
    protected Components headerMenu;
    protected Components logsPanel;

    public AbstractStep() {
        WebDriver driver = TestContext.getInstance().getDriver();
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementPage(driver);
        userTablePage = new UserTablePage(driver);
        loginForm = new Components(driver);
        headerMenu = new Components(driver);
        logsPanel = new Components(driver);
    }

    public void isElementDisplayed(WebElement element) {
        assertThat(element.isDisplayed())
            .as("element not found");
    }
}

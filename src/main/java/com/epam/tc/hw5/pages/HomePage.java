package com.epam.tc.hw5.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractBasePage {

    @FindBy(id = "user-name")
    private WebElement loginedUsername;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openSiteHomePage() {
        openSite();
    }

    public void performLogin() {
        loginForm.login();
    }

    public String getLogginedUsername() {
        return loginedUsername.getText();
    }

    public DifferentElementPage openDifferentElementsPage() {
        headerMenu.clickServiceMenuItem();
        headerMenu.clickDifferentElementItem();
        return new DifferentElementPage(driver);
    }

    public void clickOnServiceButton() {
        headerMenu.clickServiceMenuItem();
    }

    public UserTablePage clickUserTableButton() {
        headerMenu.clickUserTableItem();
        return new UserTablePage(driver);
    }
}


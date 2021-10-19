package com.epam.tc.hw6.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "user-icon")
    private WebElement icon;

    @FindBy(id = "name")
    private WebElement loginUsername;

    @FindBy(id = "password")
    private WebElement loginUserPassword;

    @FindBy(id = "login-button")
    private WebElement enter;

    @FindBy(id = "user-name")
    private WebElement logginedUsername;

    @FindBy(xpath = "//ul[contains(@class, 'm-l8')]/li")
    private List<WebElement> headerItems;

    @FindBy(className = "benefit-icon")
    private List<WebElement> indexImages;

    @FindBy(xpath = "//span[@class='benefit-txt']")
    private List<WebElement> indexTextsUnderIcons;

    @FindBy(xpath = "//iframe[@id='frame']")
    private WebElement iframeWithFrameButton;

    @FindBy(xpath = "//input[@class='btn btn-info']")
    private WebElement frameButton;

    @FindBy(xpath = "//ul[contains(@class,'left')]/li/a")
    private List<WebElement> leftSectionItems;

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@class='dropdown-toggle']")
    private WebElement serviceHeaderMenuItemDropdown;

    @FindBy(xpath = "//a[@href='different-elements.html']")
    private WebElement differentElementsItem;

    public void login(String username, String password) {
        icon.click();
        loginUsername.sendKeys(username);
        loginUserPassword.sendKeys(password);
        enter.click();
    }

    public void switchToIFrame() {
        webDriver.switchTo().frame(iframeWithFrameButton);
    }

    public void switchToOriginalWindow() {
        webDriver.switchTo().defaultContent();
    }

    public void clickServiceMenuItem() {
        serviceHeaderMenuItemDropdown.click();
    }

    public void clickDifferentElementsItem() {
        differentElementsItem.click();
    }

    public String getLogginedUsername() {
        return logginedUsername.getText();
    }

    public List<WebElement> getHeaderItems() {
        return headerItems;
    }

    public List<WebElement> getIndexImages() {
        return indexImages;
    }

    public List<WebElement> getIndexTextsUnderIcons() {
        return indexTextsUnderIcons;
    }

    public WebElement getiFrameWithFrameButton() {
        return iframeWithFrameButton;
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

    public List<WebElement> getLeftSectionItems() {
        return leftSectionItems;
    }
}


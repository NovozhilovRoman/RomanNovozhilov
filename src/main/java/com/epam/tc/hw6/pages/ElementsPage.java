package com.epam.tc.hw6.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ElementsPage extends BasePage {

    public ElementsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//label[text()[contains(.,'Water')]]/input")
    private WebElement water;

    @FindBy(xpath = "//label[text()[contains(.,'Wind')]]/input")
    private WebElement wind;

    @FindBy(xpath = "//label[text()[contains(.,'Selen')]]/input")
    private WebElement selenRadio;

    @FindBy(xpath = "//select[@class='uui-form-element']/option[text()='Yellow']")
    private WebElement yellowColorDropdown;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']")
    private WebElement logsPanel;

    @FindBy(xpath = "//li[text()[contains(.,'%s: %s changed to %s')]]")
    private List<WebElement> logRows;

    public void clickWater() {
        water.click();
    }

    public void clickWind() {
        wind.click();
    }

    public void clickSelenRadio() {
        selenRadio.click();
    }

    public void clickYellowColorDropdown() {
        yellowColorDropdown.click();
    }

    public List<WebElement> getLogRows() {
        return logRows;
    }
}

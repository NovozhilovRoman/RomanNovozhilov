package com.epam.tc.hw5.pages.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends AbstractComponent   {
    @FindBy(css = "[data-widget='catalogMenu'] button")
    private WebElement catalogButton;

    @FindBy(css = ".search-bar-wrapper input")
    private WebElement searchInputField;

    @FindBy(css = ".search-bar-wrapper button")
    private WebElement searchButton;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public CatalogComponent openCatalog() {
        wait.until(visibilityOf(catalogButton)).click();
        return new CatalogComponent(driver);
    }

    public void sendKeysToSearchInputField(String text) {
        wait.until(visibilityOf(searchInputField)).sendKeys(text);
    }

    public void clickToSearchButton() {
        wait.until(elementToBeClickable(searchButton)).click();
    }
}

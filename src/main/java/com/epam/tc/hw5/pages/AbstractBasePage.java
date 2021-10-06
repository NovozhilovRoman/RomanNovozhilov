package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.pages.component.AbstractComponent;
import org.openqa.selenium.WebDriver;

public class AbstractBasePage extends AbstractComponent {
    private static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/";

    protected HeaderComponent header;

    protected AbstractBasePage(WebDriver driver) {
        super(driver);
        header = new HeaderComponent(driver);
    }

    public CatalogComponent openCatalog() {
        return header.openCatalog();
    }

    public void sendKeysToSearchInputField(String searchText) {
        header.sendKeysToSearchInputField(searchText);
    }

    public void clickToSearchButton() {
        header.clickToSearchButton();
    }

    protected void open(String url) {
        driver.navigate().to(BASE_URL + url);
    }
}
    }
}

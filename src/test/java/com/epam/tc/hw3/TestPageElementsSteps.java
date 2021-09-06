package com.epam.tc.hw3;

import com.epam.tc.hw3.pages.ElementsPage;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TestPageElementsSteps {
    private ElementsPage elementsPage;
    SoftAssertions softAssert = new SoftAssertions();

    public TestPageElementsSteps(WebDriver webDriver) {
        elementsPage = new ElementsPage(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void selectWaterCheckbox() {
        elementsPage.clickWaterCheckbox();
    }

    public void selectWindCheckbox() {
        elementsPage.clickWindCheckbox();
    }

    public void selectSelenRadioButton() {
        elementsPage.clickSelenRadioButton();
    }

    public void selectYellowColorInDropdown() {
        elementsPage.clickYellowColorDropdownItem();
    }

    public void assertThatLogRowsAreDisplayed(List<String> expectedTexts) {
        List<WebElement> logRows = elementsPage.getLogRows();
        for (WebElement element : logRows) {
            softAssert.assertThat(element.isDisplayed());
        }
        for (int i = 0; i < logRows.size(); i++) {
            softAssert.assertThat(logRows.get(i).getText()).isEqualTo(expectedTexts.get(i));
        }
        softAssert.assertAll();
    }
}

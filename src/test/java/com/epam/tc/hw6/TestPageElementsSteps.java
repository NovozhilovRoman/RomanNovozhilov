package com.epam.tc.hw6;


import com.epam.tc.hw4.pages.ElementsPage;
import io.qameta.allure.Step;
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

    @Step("Select checkbox water")
    public void selectWaterCheckbox() {
        elementsPage.clickWaterCheckbox();
    }

    @Step ("Select checkbox wind")
    public void selectWindCheckbox() {
        elementsPage.clickWindCheckbox();
    }

    @Step ("Select selenradio button")
    public void selectSelenRadioButton() {
        elementsPage.clickSelenRadioButton();
    }

    @Step ("Select yellow color in dropdown")
    public void selectYellowColorInDropdown() {
        elementsPage.clickYellowColorDropdownItem();
    }

    @Step ("assert that log rows are displayed ")
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

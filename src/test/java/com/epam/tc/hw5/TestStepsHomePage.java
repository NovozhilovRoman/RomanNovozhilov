package com.epam.tc.hw5;

import com.epam.tc.hw4.pages.HomePage;
import java.util.Arrays;
import java.util.List;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class TestStepsHomePage {
    private HomePage homePage;
    SoftAssertions softAssert = new SoftAssertions();

    public TestStepsHomePage(WebDriver webDriver) {
        homePage = new HomePage(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Step("assert browser title")
    public void assertBrowserTitle(String browserTitle) {
        softAssert.assertThat(homePage.getBrowserTitle())
                .as("Browser title is incorrect")
                .isEqualTo(browserTitle);
    }

    @Step("perform login")
    public void performLogin(String username, String password) {
        homePage.login(username, password);
    }

    @Step("assert username loggined")
    public void assertUsernameLoggined(String username) {
        softAssert.assertThat(homePage.getLogginedUsername())
                .as("Incorrect username").isEqualTo(username);
    }

    @Step("assert four header items")
    public void assertFourHeaderItemsHaveProperTexts() {
        List<WebElement> headerItems = homePage.getHeaderItems();

        int expectedHeaderItemsNumber = 4;
        softAssert.assertThat(headerItems.size())
                .as("Incorrect texts number")
                .isEqualTo(expectedHeaderItemsNumber);

        List<String> expectedHeaderItems = Arrays
                .asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        for (WebElement item : headerItems) {
            softAssert.assertThat(item.isDisplayed())
                    .as("Items are not displayed");
        }
        for (int i = 0; i < headerItems.size(); i++) {
            softAssert.assertThat(headerItems.get(i).getText())
                    .as("Text is incorrect")
                    .isEqualTo(expectedHeaderItems.get(i));
        }
        softAssert.assertAll();
    }

    @Step("assert four index page")
    public void assertFourIndexPageImagesDisplayed() {
        List<WebElement> indexImages = homePage.getIndexImages();

        int expectedIndexImagesNumber = 4;
        softAssert.assertThat(indexImages.size())
                .as("Images number is incorrect")
                .isEqualTo(expectedIndexImagesNumber);

        for (WebElement image : indexImages) {
            softAssert.assertThat(image.isDisplayed())
                    .as("Images are not displayed");
        }
        softAssert.assertAll();
    }

    @Step("assert four texts under icons")
    public void assertFourTextsUnderIconsHaveProperText() {
        List<WebElement> indexTextsUnderIcons = homePage.getIndexTextsUnderIcons();

        int expectedIndexTextsUnderIconsNumber = 4;
        softAssert.assertThat(indexTextsUnderIcons.size())
                .as("Texts number is incorrect")
                .isEqualTo(expectedIndexTextsUnderIconsNumber);

        List<String> expectedIndexTextsUnderIcons = Arrays
                .asList("To include good practices\n"
                        + "and ideas from successful\n"
                        + "EPAM project", "To be flexible and\n"
                        + "customizable", "To be multiplatform", "Already have good base\n"
                        + "(about 20 internal and\n"
                        + "some external projects),\n"
                        + "wish to get more…");

        for (int i = 0; i < indexTextsUnderIcons.size(); i++) {
            softAssert.assertThat(indexTextsUnderIcons.get(i).getText())
                    .as("Text is incorrect")
                    .isEqualTo(expectedIndexTextsUnderIcons.get(i));
        }
        softAssert.assertAll();
    }

    @Step("assert iframe with frame button")
    public void assertIFrameWithFrameButtonExists() {
        softAssert.assertThat(homePage.getiFrameWithFrameButton().isDisplayed());
    }

    public void switchToIFrameAndCheckFrameButtonDisplayed() {
        homePage.switchToIFrame();
        softAssert.assertThat(homePage.getFrameButton().isDisplayed())
                .as("Frame Button is not displayed");
    }

    @Step("switch to original window")
    public void switchToOriginalWindow() {
        homePage.switchToOriginalWindow();
    }

    @Step("assert five left sections items")
    public void assertFiveLeftSectionItemsHaveProperText() {
        List<WebElement> leftSectionItems = homePage.getLeftSectionItems();

        int expectedLeftSectionItemsNumber = 5;
        softAssert.assertThat(leftSectionItems.size())
                .as("Left Section items number is incorrect")
                .isEqualTo(expectedLeftSectionItemsNumber);

        List<String> expectedLeftSectionItems = Arrays
                .asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

        for (WebElement item : leftSectionItems) {
            softAssert.assertThat(item.isDisplayed())
                    .as("Left Section items are not displayed");
        }

        for (int i = 0; i < leftSectionItems.size(); i++) {
            softAssert.assertThat(leftSectionItems.get(i).getText())
                    .as("Text is incorrect")
                    .isEqualTo(expectedLeftSectionItems.get(i));
        }
        softAssert.assertAll();
    }

    @Step("click service menu item")
    public void clickServiceMenuItem() {
        homePage.clickServiceMenuItem();
    }

    @Step("click different element item")
    public void clickDifferentElementsItem() {
        homePage.clickDifferentElementsItem();
    }
}

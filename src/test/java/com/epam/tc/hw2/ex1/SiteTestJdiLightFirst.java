package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.MainTest;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SiteTestJdiLightFirst extends MainTest {

    @Test
    public void testExerciseOne() {
        SoftAssertions softAssertions = new SoftAssertions();

        // 1 Open test site by URL
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 2 Assert Browser title
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo("Home Page");

        // 3 Perform login
        WebElement button = webDriver.findElement(By.id("user-icon"));
        button.click();

        WebElement login = webDriver.findElement(By.id("name"));
        login.sendKeys("Roman");

        WebElement password = webDriver.findElement(By.id("password"));
        password.sendKeys("Jdi1234");

        WebElement buttonEnter = webDriver.findElement(By.id("login-button"));
        buttonEnter.click();

        // 4 Assert Username is loggined
        softAssertions.assertThat(webDriver.findElement(By.id("user-name")).getText())
                .as("Username is wrong")
                .isEqualTo("ROMAN IOVLEV");

        // 5 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerElements = webDriver.findElements(By.xpath("//ul[contains(@class, 'm-l8')]/li"));

        softAssertions.assertThat(headerElements.size())
                .as("Header items number is wrong")
                .isEqualTo(4);

        List<String> expectedHeaderElements = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        for (WebElement item : headerElements) {
            softAssertions.assertThat(item.isDisplayed())
                    .as("Items are not displayed");
        }
        for (int i = 0; i < headerElements.size(); i++) {
            softAssertions.assertThat(headerElements.get(i).getText())
                    .as("Header item text is wrong")
                    .isEqualTo(expectedHeaderElements.get(i));
        }

        // 6 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = webDriver.findElements(By.className("benefit-icon"));

        softAssertions.assertThat(images.size())
                .as("Images number is wrong")
                  .isEqualTo(4);

        for (WebElement image : images) {
            softAssertions.assertThat(image.isDisplayed()).as("Images are not displayed");
        }

        // 7 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textsUnder = webDriver.findElements(By.xpath("//span[@class='benefit-txt']"));
        softAssertions.assertThat(textsUnder.size())
                .as("Texts number is wrong")
                .isEqualTo(4);

        List<String> expectedIndexTextsUnderIcons = Arrays.asList("To include good practices\n"
                    + "and ideas from successful\n"
                    + "EPAM project", "To be flexible and\n"
                    + "customizable", "To be multiplatform", "Already have good base\n"
                    + "(about 20 internal and\n"
                    + "some external projects),\n"
                    + "wish to get more…");

        for (int i = 0; i < textsUnder.size(); i++) {
            softAssertions.assertThat(textsUnder.get(i).getText())
                .as("Text is wrong")
                .isEqualTo(expectedIndexTextsUnderIcons.get(i));
        }

        //A 8 Assert that there is the iframe with “Frame Button” exist
        softAssertions.assertThat(webDriver.findElement(By.xpath("//iframe[@id='frame']")).isDisplayed())
            .as("Iframe with 'Frame Button' does not exist");

        // 9 Switch to the iframe and check that there is “Frame Button” in the iframe
        WebElement iframe = webDriver.findElement(By.xpath("//iframe[@id='frame']"));
        webDriver.switchTo().frame(iframe);
        softAssertions.assertThat(webDriver.findElement(By.xpath("//input[@class='btn btn-info']")).isDisplayed())
            .as("There is no 'Frame Button' in the iframe");

        // 10 Switch to original window back
        webDriver.switchTo().defaultContent();

        // 11 Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftSection = webDriver.findElements(By.xpath("//ul[contains(@class,'left')]/li/a"));

        softAssertions.assertThat(leftSection.size())
                .as("Left Section elements count is wrong")
                  .isEqualTo(5);

        List<String> expectedLeftSectionItems = Arrays
                .asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        for (WebElement item : leftSection) {
            softAssertions.assertThat(item.isDisplayed())
                .as("Left Section elements are not displayed");
        }
        for (int i = 0; i < leftSection.size(); i++) {
            softAssertions.assertThat(leftSection.get(i).getText())
                .as("Text is wrong")
                .isEqualTo(expectedLeftSectionItems.get(i));
        }
        softAssertions.assertAll();
    }
}

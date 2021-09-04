package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.MainTest;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SiteTestJdiLightSecond extends MainTest {
    @Test
    public void testExerciseTwo() {
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

        // 4 Assert User name in the left-top side of screen that user is loggined
        softAssertions.assertThat(webDriver.findElement(By.id("user-name")).getText())
                .as("Username is wrong")
                .isEqualTo("ROMAN IOVLEV");

        // 5 Open through the header menu Service
        WebElement element = webDriver.findElement(By
            .xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@class='dropdown-toggle']"));
            element.click();
        element = webDriver.findElement(By.xpath("//a[@href='different-elements.html']"));
        element.click();

        // 6 Select checkboxes
        WebElement checkboxeWater = webDriver.findElement(By.xpath("//label[text()[contains(.,'Water')]]/input"));
        checkboxeWater.click();

        WebElement checkboxeWind = webDriver.findElement(By.xpath("//label[text()[contains(.,'Wind')]]/input"));
        checkboxeWind.click();

        // 7 Select radio
        WebElement radioSelen = webDriver.findElement(By.xpath("//label[text()[contains(.,'Selen')]]/input"));
        radioSelen.click();

       // 8 Select in dropdown
       WebElement dropdownYellow = webDriver.findElement(By.xpath("//select[@class='uui-form-element']/option[text()='Yellow']"));
       dropdownYellow.click();

        /*
         Assert that
         for each checkbox there is an individual log row and value is corresponded to the status of checkbox
         for radio button there is a log row and value is corresponded to the status of radio button
         for dropdown there is a log row and value is corresponded to the selected value.
         */

        softAssertions.assertThat(webDriver.findElement(By.xpath("//ul[@class='panel-body-list logs']")).isDisplayed())
            .as("Log rows are absent");

        softAssertions.assertThat(webDriver.findElement(By
                .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Water: condition changed to true')]"))
                .isDisplayed()).as("Water log is not displayed");

        softAssertions.assertThat(webDriver.findElement(By
                .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Wind: condition changed to true')]"))
                .isDisplayed())
            .as("Wind log is not displayed");

        softAssertions.assertThat(webDriver.findElement(By
                .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'metal: value changed to  Selen')]"))
                .isDisplayed())
            .as("Selen log is not displayed");

        softAssertions.assertThat(webDriver.findElement(By
                .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Colors: value changed to Yellow')]"))
                .isDisplayed())
                .as("Yellow color log is not displayed");

        softAssertions.assertAll();
    }
}


package com.epam.tc.hw6.ex2;

import com.epam.tc.hw6.AbstractBaseClass;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import java.util.List;
import jdk.jfr.Description;
import org.testng.annotations.Test;


public class TestDifferentElements extends AbstractBaseClass {

    @Test (description = "Test different elements")
    @Description("Test different elements")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test different elements")
    @Feature("Test different elements")
    public void testExerciseTwo() {
        //Assert Browser title
        testHomePageSteps.assertBrowserTitle("Home Page");

        //Perform login
        testHomePageSteps.performLogin(username, password);

        //Assert User name in the left-top side of screen that user is logined
        testHomePageSteps.assertUsernameLoggined(expectedUsername);

        //Open through the header menu Service - Different Elements Page
        testHomePageSteps.clickServiceMenuItem();
        testHomePageSteps.clickDifferentElementsItem();

        //Select checkboxes (Water, Wind)
        testPageElementsSteps.selectWaterCheckbox();
        testPageElementsSteps.selectWindCheckbox();

        //Select radio (Selen)
        testPageElementsSteps.selectSelenRadioButton();

        //Select in dropdown (Yellow)
        testPageElementsSteps.selectYellowColorInDropdown();

        /*
         Assert that
         for each checkbox there is an individual log row and value is corresponded to the status of checkbox
         for radio button there is a log row and value is corresponded to the status of radio button
         for dropdown there is a log row and value is corresponded to the selected value.
         */

        testPageElementsSteps.assertThatLogRowsAreDisplayed(List.of(
                "value changed to Yellow",
                "value changed to Selen",
                "condition changed to true",
                "condition changed to true"));
    }
}



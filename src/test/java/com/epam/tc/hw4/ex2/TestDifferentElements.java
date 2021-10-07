package com.epam.tc.hw4.ex2;


import com.epam.tc.hw4.MainTestForAllureProject;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import java.util.List;
import org.testng.annotations.Test;

public class TestDifferentElements extends MainTestForAllureProject {

    @Test (description = "Test different elements")
    @Description("Test different elements")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test different elements")
    @Feature("Test different elements")
    public void differentElementsTestExerciseTwo() {
        //Assert Browser title
        homePageTestSteps.assertBrowserTitle("Home Page");

        //Perform login
        homePageTestSteps.performLogin(username, password);

        //Assert User name in the left-top side of screen that user is loggined
        homePageTestSteps.assertUsernameLoggined(expectedUsername);

        //Open through the header menu Service -> Different Elements Page
        homePageTestSteps.clickServiceMenuItem();
        homePageTestSteps.clickDifferentElementsItem();

        //Select checkboxes (Water, Wind)
        differentElementsPageTestSteps.selectWaterCheckbox();
        differentElementsPageTestSteps.selectWindCheckbox();

        //Select radio (Selen)
        differentElementsPageTestSteps.selectSelenRadioButton();

        //Select in dropdown (Yellow)
        differentElementsPageTestSteps.selectYellowColorInDropdown();

        /*
         Assert that
         for each checkbox there is an individual log row and value is corresponded to the status of checkbox
         for radio button there is a log row and value is corresponded to the status of radio button
         for dropdown there is a log row and value is corresponded to the selected value.
         */

        differentElementsPageTestSteps.assertThatLogRowsAreDisplayed(List.of(
                "value changed to Yellow",
                "value changed to Selen",
                "condition changed to true",
                "condition changed to true"));
    }
}



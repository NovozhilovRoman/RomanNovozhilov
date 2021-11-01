package com.epam.tc.hw6.ex1;

import com.epam.tc.hw6.AbstractBaseClass;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class TestHomePage extends AbstractBaseClass {

    @Test (description = "Test home page")
    @Description("Test home page")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Test home page")
    @Feature("Test home page")
        public void testExerciseOne() {

        //Assert Browser title
        testHomePageSteps.assertBrowserTitle("Home Page");

        //Perform login
        testHomePageSteps.performLogin(username, password);

        //Assert Username is loggined
        testHomePageSteps.assertUsernameLoggined(expectedUsername);

        //Assert that there are 4 items on the header section are displayed and they have proper texts
        testHomePageSteps.assertFourHeaderItemsHaveProperTexts();

        //Assert that there are 4 images on the Index Page and they are displayed
        testHomePageSteps.assertFourIndexPageImagesDisplayed();

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        testHomePageSteps.assertFourTextsUnderIconsHaveProperText();

        //Assert that there is the iframe with “Frame Button” exist
        testHomePageSteps.assertIFrameWithFrameButtonExists();

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        testHomePageSteps.switchToIFrameAndCheckFrameButtonDisplayed();

        //Switch to original window back
        testHomePageSteps.switchToOriginalWindow();

        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        testHomePageSteps.assertFiveLeftSectionItemsHaveProperText();
    }
}

package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.context.TestContext;
import com.epam.tc.hw5.pages.ElementsPage;
import com.epam.tc.hw5.pages.HomePage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {
    protected HomePage homePage;
    protected ElementsPage elementsPage;

    public AbstractStep() {
        WebDriver driver = TestContext.getInstance().getTestObject("driver");
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);

    }
}

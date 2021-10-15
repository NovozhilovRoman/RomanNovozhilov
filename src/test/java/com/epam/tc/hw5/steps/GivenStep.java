package com.epam.tc.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import lombok.var;

public class GivenStep extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openJdiGitHubHomePage() {
        homePage.openSiteHomePage();
    }

    @And("I login as user 'Roman Iovlev'")
    public void performLoginAsUser() {
        homePage.performLogin();
    }

    @And("I open through the header menu Service -> Different Elements Page")
    public void openThroughTheHeaderMenuServiceDifferentElementsPage() {
        var differentElementsPage = homePage.openDifferentElementsPage();
    }
}

package com.epam.tc.hw5.steps;

import io.cucumber.java.en.Given;

public class GivenStep extends AbstractStep {
    @Given("I open Ozon Home page")
    public void openHomePage() {
        homePage.open();
    }
}

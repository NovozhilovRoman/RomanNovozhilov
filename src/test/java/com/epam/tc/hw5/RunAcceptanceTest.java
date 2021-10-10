package com.epam.tc.hw5;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/com.epam.tc.hw5.cucumber/Homework5CucumberExercise1.feature",
                             "src/test/resources/com.epam.tc.hw5.cucumber/Homework5CucumberExercise2.feature",
                             "src/test/resources/com.epam.tc.hw5.cucumber/Homework5CucumberExercise3.feature"})

public class RunAcceptanceTest extends AbstractTestNGCucumberTests {
}

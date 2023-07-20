package com.trello.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Runner class for the tests.
 *
 * @author Saul Caspa
 */
@CucumberOptions(
    glue = {"com.jalasoft.marksystems"},
    features = {"src/test/resources/features"},
    tags = "@TC-00001")
public class TestRunner extends AbstractTestNGCucumberTests {

}

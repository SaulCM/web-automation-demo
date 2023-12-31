package com.trello.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Runner class for the tests.
 *
 * @author Saul Caspa
 */
@CucumberOptions(
    glue = {"com.trello"},
    features = {"src/test/resources/features"},
    tags = "@Boards")
public class TestRunner extends AbstractTestNGCucumberTests {

}

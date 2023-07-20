package com.trello.steps;

import static org.testng.Assert.assertTrue;

import com.trello.pages.DashboardPage;
import com.trello.pages.common.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DashboardSteps {

  private TestContext testContext;
  private DashboardPage dashboardPage;

  /**
   * Initializes a new instance of SearchSectionSteps class.
   *
   * @param testContext Test context instance, see {@link TestContext} class.
   */
  public DashboardSteps(TestContext testContext) {
    this.testContext = testContext;
    this.dashboardPage = new DashboardPage();
  }

  @And("(I )click {string} board card on 'Dashboard' page")
  public void clickBoardCard(final String board) {
    dashboardPage.clickBoardCard(board);
  }

  @Then("the {string} menu option on 'Dashboard' page should be displayed")
  public void menuOptionShouldBeDisplayed(final String optionName) {
    final boolean isOptionDisplayed = dashboardPage.isSideMenuOptionDisplayed(optionName);
    assertTrue(isOptionDisplayed);
  }
}

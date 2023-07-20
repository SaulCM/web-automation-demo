package com.trello.steps;

import static org.testng.Assert.assertTrue;

import com.trello.pages.board.BoardPage;
import com.trello.pages.common.TestContext;
import io.cucumber.java.en.Then;

public class BoardSteps {

  private TestContext testContext;
  private BoardPage boardPage;

  /**
   * Initializes a new instance of SearchSectionSteps class.
   *
   * @param testContext Test context instance, see {@link TestContext} class.
   */
  public BoardSteps(TestContext testContext) {
    this.testContext = testContext;
    this.boardPage = new BoardPage();
  }

  @Then("the 'Board' button on 'Boards' page should be displayed")
  public void boardButtonShouldBeDisplayed() {
    assertTrue(boardPage.isBoardButtonDisplayed());
  }

  @Then("the 'Visibility' button on 'Boards' page should be displayed")
  public void visibilityButtonShouldBeDisplayed() {
    assertTrue(boardPage.isVisibiilityButtonDisplayed());
  }

  @Then("the {string} list on 'Boards' page should be displayed")
  public void listWithNameShouldBeDisplayed(final String listName) {
    assertTrue(boardPage.isListWithNameDisplayed(listName));
  }
}

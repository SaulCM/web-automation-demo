package com.trello.pages.board;

import static com.trello.selenium.WebDriverActions.getLocator;

import com.trello.selenium.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Represents a board page and all the elements displayed there.
 */
public class BoardPage extends BasePage {

  @FindBy(css = "a[aria-label='Board']")
  private WebElement BOARD_BUTTON_LOCATOR;

  @FindBy(css = "button[aria-label='Private']")
  private WebElement VISIBILITY_BUTTON_LOCATOR;

  private String LIST_LOCATOR = "textarea[aria-label='%s']";

  @Override
  public void waitUntilPageIsLoaded() {
    wait.until(ExpectedConditions.visibilityOf(BOARD_BUTTON_LOCATOR));
  }

  /**
   * Determines if 'Board' button is displayed.
   *
   * @return true if the element is displayed, false otherwise.
   */
  public boolean isBoardButtonDisplayed() {
    return driverTools.isElementDisplayed(BOARD_BUTTON_LOCATOR);
  }

  /**
   * Determines if 'Visibility' button is displayed.
   *
   * @return true if the element is displayed, false otherwise.
   */
  public boolean isVisibiilityButtonDisplayed() {
    return driverTools.isElementDisplayed(VISIBILITY_BUTTON_LOCATOR);
  }

  /**
   * Determines if the given list with name is displayed.
   *
   * @param listName the list name,
   * @return true if the element is displayed, false otherwise.
   */
  public boolean isListWithNameDisplayed(final String listName) {
    return driverTools.isElementDisplayed(getLocator(LIST_LOCATOR, listName));
  }
}

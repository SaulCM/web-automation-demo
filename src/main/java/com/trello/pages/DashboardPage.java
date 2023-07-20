package com.trello.pages;

import static com.trello.selenium.WebDriverActions.getLocator;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import com.trello.selenium.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

  private String SIDE_BAR_BUTTON_LOCATOR = "//nav[@class='home-left-sidebar-container']/div[1]//span[text()='%s']";

  private String SIDE_BAR_WORKSPACES_LOCATOR = "//nav[@class='home-left-sidebar-container']/div[2]//span[text()='%s']";

  @FindBy(css = "div[data-testid='TeamTabSection']")
  private WebElement WORKSPACES_LABEL_LOCATOR;

  private static final String BOARD_CARD_LOCATOR = "//div/h3/..//ul[@class='boards-page-board-section-list']//div[text()='%s']";

  @Override
  public void waitUntilPageIsLoaded() {
    wait.until(visibilityOf(WORKSPACES_LABEL_LOCATOR));
  }

  public DashboardPage clickBoardCard(final String boardName) {
    driverTools.clickElement(getLocator(BOARD_CARD_LOCATOR, boardName));
    return this;
  }

  public boolean isSideMenuOptionDisplayed(final String elementName) {
    return driverTools.isElementDisplayed(
        getLocator(SIDE_BAR_BUTTON_LOCATOR, elementName));
  }
}

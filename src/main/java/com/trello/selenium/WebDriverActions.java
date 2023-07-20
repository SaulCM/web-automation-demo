package com.trello.selenium;

import static java.lang.String.format;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.Keys.TAB;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class to manage Web Driver actions.
 *
 * @author Saul Caspa
 */
public class WebDriverActions {

  private static final Logger log = Logger.getLogger(WebDriverActions.class);
  private WebDriver driver;
  private WebDriverWait wait;

  /**
   * Class constructor.
   *
   * @param driver the web driver.
   * @param wait   the web driver wait.
   */
  public WebDriverActions(final WebDriver driver, final WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }

  /**
   * Clears the text field of a WebElement.
   *
   * @param webElement the WebElement.
   */
  public void clearTextField(final WebElement webElement) {
    wait.until(visibilityOf(webElement));
    webElement.clear();
  }

  /**
   * Enters a value in the WebElement text field.
   *
   * @param webElement the WebElement.
   * @param text       the text value.
   * @return WebDriverTools instance.
   */
  public WebDriverActions enterTextField(final WebElement webElement, final String text) {
    wait.until(visibilityOf(webElement));
    clearTextField(webElement);
    webElement.sendKeys(text);
    webElement.sendKeys(TAB);
    return this;
  }

  /**
   * Enters a value in the WebElement text field and sends Enter.
   *
   * @param webElement the WebElement.
   * @param text       the text value.
   * @return WebDriverTools instance.
   */
  public WebDriverActions enterTextFieldAndPressEnter(final WebElement webElement,
      final String text) {
    wait.until(visibilityOf(webElement));
    clearTextField(webElement);
    webElement.sendKeys(text);
    webElement.sendKeys(ENTER);
    return this;
  }

  /**
   * Enters a value in the WebElement using By locator.
   *
   * @param locator locator value to find input element.
   * @param text    the text value.
   */
  public void enterTextField(By locator, String text) {
    wait.until(visibilityOfElementLocated(locator));
    WebElement webElement = getWebElement(locator);
    clearTextField(webElement);
    webElement.sendKeys(text);
  }

  /**
   * Clicks on the WebElement.
   *
   * @param webElement the WebElement.
   * @return WebDriverTools instance.
   */
  public WebDriverActions clickElement(WebElement webElement) {
    wait.until(elementToBeClickable(webElement));
    webElement.click();
    return this;
  }

  /**
   * Clicks on the webElement using By option.
   *
   * @param by By value to locate the WebElement.
   * @return WebDriverTools instance.
   */
  public WebDriverActions clickElement(By by) {
    wait.until(elementToBeClickable(by));
    getWebElement(by).click();
    return this;
  }

  /**
   * Double clicks on the webElement using By option.
   *
   * @param by By value to locate the WebElement.
   */
  public void doubleClickElement(final By by) {
    wait.until(elementToBeClickable(by));
    Actions action = new Actions(driver);
    action.doubleClick(getWebElement(by)).build().perform();
  }

  /**
   * Gets Javascript executor instance.
   *
   * @return JavascriptExecutor instance.
   */
  private JavascriptExecutor getJavascriptExecutor() {
    return (JavascriptExecutor) driver;
  }

  /**
   * Hover mouse over an specific WebElement.
   *
   * <p>This method does not work with Safari browser.
   *
   * @param webElement the WebElement.
   */
  public void hoverMouseOverElement(final WebElement webElement) {
    wait.until(visibilityOf(webElement));
    Actions action = new Actions(driver);
    action.moveToElement(webElement).build().perform();
  }

  /**
   * Hover mouse over an element using By locator.
   *
   * @param locator locator value to find an element.
   */
  public void hoverMouseOverElement(final By locator) {
    hoverMouseOverElement(getWebElement(locator));
  }


  /**
   * Selects an item from ListBox by its value.
   *
   * @param element ListBox WebElement.
   * @param value   value to select in the ListBox.
   * @return WebDriverTools instance.
   */
  public WebDriverActions selectListBoxByValue(WebElement element, String value) {
    new Select(element).selectByValue(value);
    return this;
  }

  /**
   * Selects an option by text from a select element.
   *
   * @param selector locator to find the select element
   * @param option   value to select
   */
  public void selectOptionListBox(By selector, String option) {
    wait.until(visibilityOfElementLocated(selector));
    new Select(getWebElement(selector)).selectByValue(option);
  }

  /**
   * Gets selected option in this 'Select' element.
   *
   * @param webElement the WebElement.
   * @return the selected option text in select element.
   */
  public String getSelectedOption(final WebElement webElement) {
    return new Select(webElement).getFirstSelectedOption().getText().trim();
  }

  /**
   * Determines if web element is displayed.
   *
   * @param webElement the web element.
   * @return true if the web element is displayed, false otherwise.
   */
  public boolean isElementDisplayed(final WebElement webElement) {
    waitUntilElementPresent(webElement);
    try {
      return webElement.isDisplayed();
    } catch (NoSuchElementException exception) {
      log.info(format("Exception when waiting for element invisibility: %s", exception));
    }
    return false;
  }

  /**
   * Determines if web element is enabled.
   *
   * @param locator locator value to find element.
   * @return true if the web element is enabled, false otherwise.
   */
  public boolean isElementEnabled(final By locator) {
    wait.until(visibilityOf(getWebElement(locator)));
    return getWebElement(locator).isEnabled();
  }

  /**
   * Determines if web element is enabled.
   *
   * @param webElement the web element.
   * @return true if the web element is enabled, false otherwise.
   */
  public boolean isElementEnabled(final WebElement webElement) {
    wait.until(visibilityOf(webElement));
    return webElement.isEnabled();
  }

  /**
   * Gets Location X for a element.
   *
   * @param webElement the web element.
   * @return int value as location X.
   */
  public int getLocationX(final WebElement webElement) {
    wait.until(visibilityOf(webElement));
    return webElement.getLocation().getX();
  }

  /**
   * Gets the Location Y of a WebElement using By locator.
   *
   * @param locator locator value to find element.
   * @return int value as location Y.
   */
  public int getLocationY(final By locator) {
    return getLocationY(getWebElement(locator));
  }

  /**
   * Gets Location Y for a element.
   *
   * @param webElement the web element.
   * @return int value as location Y.
   */
  public int getLocationY(final WebElement webElement) {
    wait.until(visibilityOf(webElement));
    return webElement.getLocation().getY();
  }

  /**
   * Determines if web element is displayed using By option.
   *
   * @param by By value to locate the web element.
   * @return true if the web element is displayed, false otherwise.
   */
  public boolean isElementDisplayed(final By by) {
    try {
      return isElementDisplayed(getWebElement(by));
    } catch (NoSuchElementException | StaleElementReferenceException exception) {
      log.info(format("Exception when waiting for element invisibility: %s", exception));
    }
    return false;
  }

  /**
   * Scrolls to the WebElement.
   *
   * @param webElement the webElement.
   */
  public void scrollToWebElement(final WebElement webElement) {
    getJavascriptExecutor().executeScript("arguments[0].scrollIntoView();", webElement);
  }

  /**
   * Gets the text of a WebElement.
   *
   * @param webElement the WebElement.
   * @return the text of web element.
   */
  public String getText(final WebElement webElement) {
    wait.until(visibilityOf(webElement));
    return webElement.getText();
  }

  /**
   * Gets the text of a WebElement using By locator.
   *
   * @param locator locator value to find input element.
   * @return the locator text.
   */
  public String getText(final By locator) {
    return getText(getWebElement(locator));
  }

  /**
   * Gets the text of a list of WebElements.
   *
   * @param webElements the list of WebElements.
   * @return a list of texts of the WebElements.
   */
  public List<String> getText(final List<WebElement> webElements) {
    List<String> sections = new ArrayList<>();
    webElements.forEach(element -> sections.add(element.getText()));
    return sections;
  }

  /**
   * Gets Web element given by a locator.
   *
   * @param locator locator value to find an element.
   * @return the web element.
   */
  private WebElement getWebElement(final By locator) {
    return driver.findElement(locator);
  }

  /**
   * Waits until a WebElement is present.
   *
   * @param webElement the WebElement.
   * @return WebDriverTools instance.
   */
  public WebDriverActions waitUntilElementPresent(final WebElement webElement) {
    try {
      wait.until(visibilityOf(webElement));
    } catch (NoSuchElementException | TimeoutException e) {
      log.info(format("Exception when waiting for element visibility: %s", webElement));
    }
    return this;
  }

  /**
   * Gets the value of the given attribute of the element.
   *
   * @param locator   locator value to find an element.
   * @param attribute the name of the attribute.
   * @return the attribute/property's current value or null if the value is not set.
   */
  public String getAttribute(final By locator, final String attribute) {
    return getWebElement(locator).getAttribute(attribute);
  }

  /**
   * Gets the locator from a string.
   *
   * @param locator    the string locator.
   * @param parameters the parameters.
   * @return By locator, xpath if the locator starts with "//", css otherwise.
   */
  public static By getLocator(final String locator, final String... parameters) {
    final String builtLocator = format(locator, (Object[]) parameters);
    return builtLocator.startsWith("//") ? xpath(builtLocator) : cssSelector(builtLocator);
  }
}

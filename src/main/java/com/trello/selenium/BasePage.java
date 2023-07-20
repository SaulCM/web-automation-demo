package com.trello.selenium;

import static java.time.Duration.ofSeconds;

import com.trello.selenium.webdriver.DriverFactory;
import com.trello.selenium.webdriver.WebDriverConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Represents a Trello page..
 *
 * @author Saul Caspa
 */
public abstract class BasePage {

  protected WebDriver driver;
  protected WebDriverWait wait;
  protected WebDriverActions driverTools;
  private WebDriverConfigReader webDriverConfigReaderInstance;

  /**
   * Initializes the web driver, wait and web driver tools and web elements.
   */
  public BasePage() {
    driver = DriverFactory.getDriver();
    webDriverConfigReaderInstance = WebDriverConfigReader.getInstance();
    wait = new WebDriverWait(driver,
        ofSeconds(webDriverConfigReaderInstance.getExplicitWaitTime()),
        ofSeconds(webDriverConfigReaderInstance.getSleepTime()));
    driverTools = new WebDriverActions(driver, wait);
    PageFactory.initElements(driver, this);
    waitUntilPageIsLoaded();
  }

  /**
   * Waits until page object is loaded.
   */
  public abstract void waitUntilPageIsLoaded();

  /**
   * Sets the amount of implicitly Wait timeout to zero.
   */
  public void setMinImplicitWait() {
    driver.manage().timeouts().implicitlyWait(ofSeconds(0));
  }

  /**
   * Sets the default amount of implicitly Wait timeout.
   */
  public void setDefaultImplicitWait() {
    driver.manage().timeouts()
        .implicitlyWait(ofSeconds(webDriverConfigReaderInstance.getImplicitWaitTime()));
  }
}

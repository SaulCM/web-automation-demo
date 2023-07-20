package com.trello.selenium.webdriver;

import static com.trello.selenium.utils.PropertiesReader.getWindowHeight;
import static com.trello.selenium.utils.PropertiesReader.getWindowWidth;
import static com.trello.selenium.webdriver.DriverFactory.getDriver;
import static java.time.Duration.ofSeconds;

import com.trello.selenium.browser.BrowserType;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

/**
 * Creates a concrete driver object and adds it to the thread.
 *
 * @author Saul Caspa
 */
public class SharedDriver {

  /**
   * Creates the driver, maximize it and manage its timeouts.
   */
  public SharedDriver() {
    if (getDriver() == null) {
      WebDriverConfigReader webDriverConfigReaderInstance = WebDriverConfigReader.getInstance();
      final String browser = webDriverConfigReaderInstance.getBrowser();
      WebDriver driver = BrowserFactory.getDriver(BrowserType.valueOf(browser));
      final int width = getWindowWidth();
      final int height = getWindowHeight();
      driver.manage().window().setSize(new Dimension(width, height));
      driver.manage().timeouts()
          .implicitlyWait(ofSeconds(WebDriverConfigReader.getInstance().getImplicitWaitTime()));
      DriverFactory.addDriver(driver);
    }
  }
}

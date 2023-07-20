package com.trello.selenium.webdriver;

import static com.trello.selenium.utils.PropertyInput.BROWSER_TYPE;
import static com.trello.selenium.utils.PropertyInput.EXPLICIT_WAIT_TIME;
import static com.trello.selenium.utils.PropertyInput.IMPLICIT_WAIT_TIME;
import static com.trello.selenium.utils.PropertyInput.SLEEP_TIME;
import static java.lang.Integer.parseInt;
import static org.apache.log4j.PropertyConfigurator.configure;

import com.trello.selenium.utils.PropertiesManager;
import org.apache.log4j.Logger;

/**
 * Class to manage the configuration of the Web Driver.
 *
 * @author Marcelo Guzman
 */
public class WebDriverConfigReader {

  private static final Logger log = Logger.getLogger(WebDriverConfigReader.class);
  private static WebDriverConfigReader webDriverConfigReaderInstance;
  private static PropertiesManager properties = PropertiesManager.getInstance();
  private String browser;
  private int implicitWaitTime;
  private int explicitWaitTime;
  private int sleepTime;

  /**
   * Private constructor.
   */
  private WebDriverConfigReader() {
    init();
  }

  /**
   * WebDriverConfigReader constructor.
   *
   * <p>Gets WebDriverConfigReader as singleton.
   *
   * @return WebDriverConfigReader instance.
   */
  public static WebDriverConfigReader getInstance() {
    if (webDriverConfigReaderInstance == null) {
      webDriverConfigReaderInstance = new WebDriverConfigReader();
    }
    return webDriverConfigReaderInstance;
  }

  /**
   * Initializes according to config file.
   */
  private void init() {
    configure("log.properties");
    log.info("WebDriverConfigReader initialize: Reading driver configuration settings.");
    browser = properties.getProperty(BROWSER_TYPE);
    log.info("Browser name --> ".concat(browser));
    implicitWaitTime = parseInt(properties.getProperty(IMPLICIT_WAIT_TIME));
    explicitWaitTime = parseInt(properties.getProperty(EXPLICIT_WAIT_TIME));
    sleepTime = parseInt(properties.getProperty(SLEEP_TIME));
  }

  /**
   * Gets the browser in which the tests will be executed.
   *
   * @return browser.
   */
  public String getBrowser() {
    return browser;
  }

  /**
   * Gets the implicit wait time set for the WebDriver.
   *
   * @return the implicit time.
   */
  public int getImplicitWaitTime() {
    return implicitWaitTime;
  }

  /**
   * Gets the explicit wait time set for the WebDriver.
   *
   * @return the explicit time.
   */
  public int getExplicitWaitTime() {
    return explicitWaitTime;
  }

  /**
   * Gets the sleep time wait set for the WebDriver.
   *
   * @return the sleep wait time.
   */
  public int getSleepTime() {
    return sleepTime;
  }
}

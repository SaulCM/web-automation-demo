package com.trello.selenium.webdriver;

import static com.trello.selenium.browser.BrowserType.CHROME;
import static com.trello.selenium.browser.BrowserType.EDGE;
import static com.trello.selenium.browser.BrowserType.FIREFOX;
import static com.trello.selenium.browser.BrowserType.SAFARI;

import com.trello.selenium.browser.BrowserType;
import com.trello.selenium.browser.Chrome;
import com.trello.selenium.browser.Driver;
import com.trello.selenium.browser.Edge;
import com.trello.selenium.browser.Firefox;
import com.trello.selenium.browser.Safari;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import org.openqa.selenium.WebDriver;

/**
 * Returns the correct instance of the driver.
 *
 * @author Saul Caspa
 */
public class BrowserFactory {

  private static final Map<BrowserType, Supplier<Driver>> BROWSERS = new EnumMap<>(
      BrowserType.class);

  static {
    BROWSERS.put(CHROME, Chrome::new);
    BROWSERS.put(EDGE, Edge::new);
    BROWSERS.put(FIREFOX, Firefox::new);
    BROWSERS.put(SAFARI, Safari::new);
  }

  /**
   * Constructor class.
   */
  private BrowserFactory() {
  }

  /**
   * Gets the Driver instance according the name given by the parameter.
   *
   * @param browserType the browser type.
   * @return WebDriver instance.
   */
  public static WebDriver getDriver(final BrowserType browserType) {
    return BROWSERS.getOrDefault(browserType, Chrome::new).get().initDriver();
  }
}

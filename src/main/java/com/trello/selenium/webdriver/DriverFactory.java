package com.trello.selenium.webdriver;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;

/**
 * Class containing static methods to add, get or remove the driver of a thread.
 *
 * @author Marcelo Guzman
 */
public class DriverFactory {

  private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

  // To quit the drivers and browsers at the end of the execution.
  private static List<WebDriver> storedDrivers = new ArrayList<>();

  static {
    Runtime.getRuntime().addShutdownHook(new Thread(() -> storedDrivers.forEach(WebDriver::quit)));
  }

  /**
   * Default constructor
   */
  private DriverFactory() {
  }

  /**
   * Gets the current driver
   *
   * @return WebDriver instance.
   */
  public static WebDriver getDriver() {
    return drivers.get();
  }

  /**
   * Adds a driver to the list.
   *
   * @param driver the driver.
   */
  public static void addDriver(final WebDriver driver) {
    storedDrivers.add(driver);
    drivers.set(driver);
  }
}

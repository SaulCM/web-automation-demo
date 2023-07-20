package com.trello.selenium.utils;

/**
 * This class contains all properties for the framework.
 *
 * @author Saul Caspa
 */
public enum PropertyInput {

  BASE_URL("baseUrl"),
  USER_EMAIL("userEmail"),
  PASSWORD("password"),
  BROWSER_TYPE("browserType"),
  WINDOW_WIDTH("width"),
  WINDOW_HEIGHT("height"),
  IMPLICIT_WAIT_TIME("implicitWaitTime"),
  EXPLICIT_WAIT_TIME("explicitWaitTime"),
  SLEEP_TIME("sleepTime"),
  DOWNLOADS_PATH("downloadsPath");


  private String property;

  /**
   * Create a new instance with String as parameter.
   *
   * @param property name.
   */
  PropertyInput(final String property) {
    this.property = property;
  }

  /**
   * Gets the Property.
   *
   * @return property as String.
   */
  public String getProperty() {
    return property;
  }
}

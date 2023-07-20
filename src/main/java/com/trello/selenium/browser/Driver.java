package com.trello.selenium.browser;

import org.openqa.selenium.WebDriver;

/**
 * Initializes the Selenium Web Driver.
 *
 * @author Saul Caspa
 */
public interface Driver {

  /**
   * Initializes the Web Driver.
   *
   * @return WebDriver instance.
   */
  WebDriver initDriver();
}

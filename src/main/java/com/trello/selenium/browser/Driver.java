package com.trello.selenium.browser;

import org.openqa.selenium.WebDriver;

/**
 * Initializes the Selenium Web Driver.
 *
 * @author Marcelo Guzman
 */
public interface Driver {

  /**
   * Initializes the Web Driver.
   *
   * @return WebDriver instance.
   */
  WebDriver initDriver();
}

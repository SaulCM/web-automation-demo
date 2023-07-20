package com.trello.selenium.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Handles Safari driver initialization.
 *
 * @author Saul Caspa
 */
public class Safari implements Driver {

  /**
   * {@inheritDoc}
   */
  @Override
  public WebDriver initDriver() {
    return new SafariDriver();
  }
}

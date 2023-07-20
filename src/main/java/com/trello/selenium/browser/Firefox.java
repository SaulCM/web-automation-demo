package com.trello.selenium.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Handles Firefox driver initialization.
 *
 * @author Saul Caspa
 */
public class Firefox implements Driver {

  /**
   * {@inheritDoc}
   */
  @Override
  public WebDriver initDriver() {
    WebDriverManager.firefoxdriver().setup();
    return new FirefoxDriver(getFirefoxOptions());
  }

  /**
   * Gets Firefox options.
   *
   * @return FirefoxOptions instance.
   */
  private FirefoxOptions getFirefoxOptions() {
    // Creates FireFox Option object.
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    firefoxOptions
        // Sets Location to store files after downloading.
        .addPreference("browser.download.folderList", 2)
        // Sets Preference to not show file download confirmation dialogue using MIME types
        // Of different file extension types.
        .addPreference("browser.download.manager.showWhenStarting", false)
        .addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf")
        // Sets Preference to not open the Pdf files.
        .addPreference("pdfjs.disabled", true);
    return firefoxOptions;
  }
}

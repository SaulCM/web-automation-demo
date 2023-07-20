package com.trello.selenium.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Handles Chrome driver initialization.
 *
 * @author Saul Caspa
 */
public class Chrome implements Driver {

  /**
   * {@inheritDoc}
   */
  @Override
  public WebDriver initDriver() {
    WebDriverManager.chromedriver().setup();
    return new ChromeDriver(getChromeOptions());
  }

  /**
   * Gets Chrome options and capabilities.
   *
   * @return ChromeOptions instance.
   */
  private ChromeOptions getChromeOptions() {
    ChromeOptions chromeOptions = new ChromeOptions();
    // Passing the disable-infobars ChromeOption to the WebDriver, prevents Chrome from
    // displaying this notification.
    chromeOptions.setExperimentalOption("prefs", getChromePreferences());
    chromeOptions.addArguments("--remote-allow-origins=*");
    chromeOptions.addArguments("--headless=new");
    chromeOptions.addArguments("--disable-gpu");
    chromeOptions.addArguments("--no-sandbox");
    chromeOptions.addArguments("--start-maximized");
    chromeOptions.addArguments("--window-size=1920,1080");
    chromeOptions.addArguments("--allow-insecure-localhost");
    chromeOptions.addArguments("--disable-dev-shm-usage");
    DesiredCapabilities capability = new DesiredCapabilities();
    capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
    capability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
    return chromeOptions;
  }

  /**
   * Gets Chrome preferences.
   *
   * @return Map that contains Chrome preferences.
   */
  private Map<String, Object> getChromePreferences() {
    HashMap<String, Object> chromePref = new HashMap<>();
    // Boolean to ask the user to download a file (true) or download automatically (false).
    chromePref.put("download.prompt_for_download", false);
    chromePref.put("profile.default_content_settings.popups", 0);
    // Sets Preference to not open the Pdf files.
    chromePref.put("plugins.always_open_pdf_externally", true);
    return chromePref;
  }
}

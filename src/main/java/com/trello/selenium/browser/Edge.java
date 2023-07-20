package com.trello.selenium.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Handles Edge driver initialization.
 *
 * @author Saul Caspa
 */
public class Edge implements Driver {

  /**
   * {@inheritDoc}
   */
  @Override
  public WebDriver initDriver() {
    WebDriverManager.edgedriver().setup();
    return new EdgeDriver(getEdgeOptions());
  }

  /**
   * Gets Edge options and capabilities.
   *
   * @return EdgeOptions instance.
   */
  private EdgeOptions getEdgeOptions() {
    EdgeOptions edgeOptions = new EdgeOptions();
    // Passing the disable-infobars EdgeOption to the WebDriver, prevents Edge from
    // displaying this notification.
    edgeOptions.addArguments("disable-infobars");
    edgeOptions.setExperimentalOption("prefs", getEdgePreferences());
    edgeOptions.addArguments("disable-popup-blocking");
    edgeOptions.addArguments("disable-out-of-process-pdf");
    DesiredCapabilities capability = new DesiredCapabilities();
    capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
    capability.setCapability(EdgeOptions.CAPABILITY, edgeOptions);
    return edgeOptions;
  }

  /**
   * Gets Edge preferences.
   *
   * @return Map that contains Edge preferences.
   */
  private Map<String, Object> getEdgePreferences() {
    HashMap<String, Object> edgePref = new HashMap<>();
    // Sets Location to store files after downloading.
    edgePref.put("download.default_directory", "");
    // Boolean to ask the user to download a file (true) or download automatically (false).
    edgePref.put("download.prompt_for_download", false);
    edgePref.put("profile.default_content_settings.popups", 0);
    // Sets Preference to not open the Pdf files.
    edgePref.put("plugins.always_open_pdf_externally", true);
    return edgePref;
  }
}

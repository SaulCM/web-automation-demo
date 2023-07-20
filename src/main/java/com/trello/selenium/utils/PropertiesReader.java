package com.trello.selenium.utils;

import static com.trello.selenium.utils.PropertyInput.BROWSER_TYPE;
import static com.trello.selenium.utils.PropertyInput.WINDOW_HEIGHT;
import static com.trello.selenium.utils.PropertyInput.WINDOW_WIDTH;
import static java.lang.Integer.parseInt;

import java.io.File;
import org.apache.log4j.Logger;

/**
 * Class to read the framework properties.
 *
 * @author Saul Caspa
 */
public class PropertiesReader {

  private static final Logger log = Logger.getLogger(PropertiesReader.class);
  public static final String FILE_SEPARATOR = File.separator;

  /**
   * Class to manage the framework Properties from gradle.properties File.
   */
  private static final PropertiesManager propertiesManager = PropertiesManager.getInstance();

  /**
   * Privates constructor.
   */
  private PropertiesReader() {
  }

  /**
   * Gets 'Browser Type' value.
   *
   * @return the current browserType value.
   */
  public static String getBrowserType() {
    return propertiesManager.getProperty(BROWSER_TYPE);
  }

  /**
   * Gets 'Window width' value.
   *
   * @return the current width value.
   */
  public static int getWindowWidth() {
    return parseInt(propertiesManager.getProperty(WINDOW_WIDTH));
  }

  /**
   * Gets 'Window Height' value.
   *
   * @return the current heigth value.
   */
  public static int getWindowHeight() {
    return parseInt(propertiesManager.getProperty(WINDOW_HEIGHT));
  }
}

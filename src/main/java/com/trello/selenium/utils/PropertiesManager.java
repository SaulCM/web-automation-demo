package com.trello.selenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Class to manage the framework Properties.
 *
 * @author Saul Caspa
 */
public final class PropertiesManager {

  private static final Logger log = LogManager.getLogger(PropertiesManager.class);
  private static PropertiesManager propertiesManager;
  private Properties properties;

  /**
   * Initializes PropertiesManager class.
   */
  private PropertiesManager() {
    properties = new Properties();
    try (InputStream input = new FileInputStream("gradle.properties")) {
      properties.load(input);
    } catch (IOException e) {
      log.error("Exception when Initialize Properties", e);
    }
  }

  /**
   * Gets a PropertiesManager instance.
   *
   * @return PropertiesManager instance.
   */
  public static synchronized PropertiesManager getInstance() {
    if (propertiesManager == null) {
      propertiesManager = new PropertiesManager();
    }
    return propertiesManager;
  }

  /**
   * Gets the property indicated by the specified key.
   *
   * @param key the name of the system property.
   * @return the property value.
   */
  private String getPropertyValue(final String key) {
    final String property = System.getProperty(key);
    return property == null ? properties.getProperty(key) : property;
  }

  /**
   * Gets the property.
   *
   * @param property An Enum value of the property.
   * @return the property value.
   */
  public String getProperty(final PropertyInput property) {
    return getPropertyValue(property.getProperty());
  }
}

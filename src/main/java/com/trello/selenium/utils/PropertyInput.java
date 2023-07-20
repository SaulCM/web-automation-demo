package com.trello.selenium.utils;

/**
 * This class contains all properties for the framework.
 *
 * @author Ovidio Miranda
 */
public enum PropertyInput {

  BASE_URL("baseUrl"),
  USERNAME("username"),
  PASSWORD("password"),
  SUPER_USERNAME("superUsername"),
  SUPER_PASSWORD("superPassword"),
  VENDOR_USERNAME("vendorUsername"),
  VENDOR_PASSWORD("vendorPassword"),
  ADMIN_USERNAME("AdminUsername"),
  ADMIN_PASSWORD("AdminPassword"),
  LENDER_USERNAME("lenderUsername"),
  SALESADMIN_USERNAME("salesAdminUsername"),
  COMMON_PASSWORD("commonPassword"),
  BROWSER_TYPE("browserType"),
  WINDOW_WIDTH("width"),
  WINDOW_HEIGHT("height"),
  IMPLICIT_WAIT_TIME("implicitWaitTime"),
  EXPLICIT_WAIT_TIME("explicitWaitTime"),
  SLEEP_TIME("sleepTime"),
  IHMS_HOST_NAME("ihmsHostName"),
  JDBCNAME("jdbcName"),
  JDBCSSL("jdbcSsl"),
  JDBCDRIVER("jdbcDriver"),
  JDBCUSER("jdbcUser"),
  JDBCPASS("jdbcPass"),
  DOWNLOADS_PATH("downloadsPath"),
  PDF_TEMPLATE("pdfTemplate"),
  PDF_OUTPUT("pdfOutput"),
  IMAGE_OUTPUT("imageOutput"),
  IMAGE_TEMPLATE("imageTemplate"),
  FILE_RESOURCES_PATH("fileResourcesPath");

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

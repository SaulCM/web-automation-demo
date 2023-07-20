package com.trello.pages.common;

import static java.lang.String.valueOf;

import com.trello.constants.TestContextKeys;
import java.util.EnumMap;
import org.apache.log4j.Logger;

/**
 * TestContext class that contains Entities and their names to get and set.
 *
 * @author Saul Caspa
 */
public class TestContext {

  private static final Logger log = Logger.getLogger(TestContext.class);
  private EnumMap<TestContextKeys, Object> context;

  /**
   * Class constructor.
   */
  public TestContext() {
    context = new EnumMap<>(TestContextKeys.class);
  }

  /**
   * Gets the value.
   *
   * @param name the element to return.
   * @return the object.
   */
  public Object get(final TestContextKeys name) {
    return context.get(name);
  }

  /**
   * Gets the string value.
   *
   * @param name the element to return.
   * @return a string instance.
   */
  public String getStringValue(final TestContextKeys name) {
    return valueOf(context.get(name));
  }

  /**
   * Sets data.
   *
   * @param name   key name.
   * @param object the object to save.
   */
  public void setData(final TestContextKeys name, final Object object) {
    context.put(name, object);
  }
}

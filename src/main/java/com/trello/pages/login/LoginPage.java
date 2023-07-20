package com.trello.pages.login;

import com.trello.selenium.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Represents the Trello login page.
 *
 * @author Saul Caspa
 */
public class LoginPage extends BasePage {

  @FindBy(css = "input[id='user']")
  private WebElement EMAIL_TEXT_FIELD_LOCATOR;

  @FindBy(css = "input[id='password']")
  private WebElement PASSWORD_TEXT_FIELD_LOCATOR;

  @FindBy(css = "input[id][type='submit']")
  private WebElement CONTINUE_BUTTON_LOCATOR;

  @FindBy(css = "button[id='login-submit']")
  private WebElement LOGIN_BUTTON_LOCATOR;

  @Override
  public void waitUntilPageIsLoaded() {
    wait.until(ExpectedConditions.visibilityOf(EMAIL_TEXT_FIELD_LOCATOR));
  }

  /**
   * Enters 'Email' text field.
   *
   * @param email the email to enter.
   * @return Login Page instance.
   */
  public LoginPage enterEmail(final String email) {
    driverTools.enterTextField(EMAIL_TEXT_FIELD_LOCATOR, email);
    return this;
  }

  /**
   * Enters 'Password' text field.
   *
   * @param password the password to enter.
   * @return Login Page instance.
   */
  public LoginPage enterPassword(final String password) {
    driverTools.enterTextField(PASSWORD_TEXT_FIELD_LOCATOR, password);
    return this;
  }

  /**
   * Clicks 'Continue' button.
   *
   * @return Login Page instance.
   */
  public LoginPage clickContinueButton() {
    driverTools.clickElement(CONTINUE_BUTTON_LOCATOR);
    return this;
  }

  /**
   * Clicks 'Login' button.
   *
   * @return Login Page instance.
   */
  public LoginPage clickLoginButton() {
    driverTools.clickElement(LOGIN_BUTTON_LOCATOR);
    return this;
  }
}

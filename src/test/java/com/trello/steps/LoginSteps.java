package com.trello.steps;

import static com.trello.selenium.webdriver.WebDriverConfigReader.getInstance;

import com.trello.pages.common.TestContext;
import com.trello.pages.login.LoginPage;
import com.trello.selenium.webdriver.DriverFactory;
import com.trello.selenium.webdriver.SharedDriver;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

/**
 * Represents the actions related to login page.
 */
public class LoginSteps {

  private TestContext testContext;
  private LoginPage loginPage;

  /**
   * Initializes a new instance of SearchSectionSteps class.
   *
   * @param sharedDriver Shared Driver instance, see {@link SharedDriver} class.
   * @param testContext  Test context instance, see {@link TestContext} class.
   */
  public LoginSteps(SharedDriver sharedDriver, TestContext testContext) {
    this.testContext = testContext;
  }

  /**
   * Navigates to Dashboard.
   *
   * @param url the Dashboard URL.
   */
  private void navigateToDashboard(final String url) {
    WebDriver driver = DriverFactory.getDriver();
    driver.get(url);
  }

  @And("(I )navigate to the 'Login' page")
  public void navigateToLoginPage() {
    navigateToDashboard("https://trello.com/login");
    loginPage = new LoginPage();
  }

  @And("(I )enter 'Email' text field on 'Login' page")
  public void enterEmailTextField() {
    loginPage.enterEmail(getInstance().getUserEmail());
  }

  @And("(I )enter 'Password' text field on 'Login' page")
  public void enterPasswordTextField() {
    loginPage.enterPassword(getInstance().getPassword());
  }

  @And("(I )click 'Continue' button on 'Login' page")
  public void clickContinueButton() {
    loginPage.clickContinueButton();
  }

  @And("(I )click 'Login' button on 'Login' page")
  public void clickLoginButton() {
    loginPage.clickLoginButton();
  }
}

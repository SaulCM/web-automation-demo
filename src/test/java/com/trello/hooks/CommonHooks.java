package com.trello.hooks;


import com.trello.pages.common.TestContext;
import com.trello.selenium.webdriver.SharedDriver;
import com.trello.steps.LoginSteps;
import io.cucumber.java.Before;

/**
 * Class containing common Hooks.
 *
 * @author Saul Caspa
 */
public class CommonHooks {

  private TestContext testContext;
  private LoginSteps loginSteps;
  public static boolean isLogged = false;

  /**
   * Initializes a new instance of CommonHooks class.
   *
   * @param sharedDriver Shared Driver instance, see {@link SharedDriver} class.
   * @param testContext  Test context instance, see {@link TestContext} class.
   * @param loginSteps   Login steps instance, see {@link LoginSteps} class.
   */
  public CommonHooks(SharedDriver sharedDriver, TestContext testContext, LoginSteps loginSteps) {
    this.testContext = testContext;
    this.loginSteps = loginSteps;
  }

  /**
   * Login to ITK dashboard as Super.
   *
   * <p>Order = 2.
   */
  @Before(value = "@Login", order = 5)
  public void login() {
    if (!isLogged) {
      loginSteps.navigateToLoginPage();
      loginSteps.enterEmailTextField();
      loginSteps.clickContinueButton();
      loginSteps.enterPasswordTextField();
      loginSteps.clickLoginButton();
      isLogged = true;
    } else {
      loginSteps.navigateToDashboardPage();
    }
  }

  /**
   * Login to ITK dashboard as Super.
   *
   * <p>Order = 2.
   */
  @Before(value = "@NavigateToDashboard", order = 10)
  public void navigateToDashboard() {
    loginSteps.navigateToDashboardPage();
  }
}

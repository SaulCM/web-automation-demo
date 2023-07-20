Feature: Login

  As a user
  I want to login to the dashboard
  so I can use the application

  @TC-1
  Scenario: I want to login to the application and see the dashboard
    Given I navigate to the 'Login' page
    When I enter 'Email' text field on 'Login' page
      And click 'Continue' button on 'Login' page
      And click 'Login' button on 'Login' page
      And enter 'Password' text field on 'Login' page
    Then the "Boards" menu option on 'Dashboard' page should be displayed
      And the "Template" menu option on 'Dashboard' page should be displayed
      And the "Home" menu option on 'Dashboard' page should be displayed

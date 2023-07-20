Feature:

  As a user
  I want to login to the dashboard
  so I can use the application

  @TC-1
  Scenario: I want to login to the application and see the dashboard
    Given I navigate to the login page
    When I enter valid credentials
    Then the dashboard page should be displayed

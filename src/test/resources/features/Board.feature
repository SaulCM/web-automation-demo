Feature: Boards

  As a user
  I want to access a board
  so I can manage cards on the board

  @TC-2 @Login
  Scenario: A user can open a board
    Given I click 'Day Planning' board card on 'Dashboard' page
    Then the 'Board' button on 'Boards' page should be displayed
      And the 'Visibility' button on 'Boards' page should be displayed
      And the 'To Do' list on 'Boards' page should be displayed
      And the 'In Progress' list on 'Boards' page should be displayed
      And the 'Done' list on 'Boards' page should be displayed

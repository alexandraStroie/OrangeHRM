Feature: User log Time at Work

  As a user I want to log time at work

  @SmokeTest
  Scenario: Successful logging time at work
    Given I navigate to the login page
    When I enter the username "Admin" and the password "admin123"
    And I click the login button
    Then I should be redirected to the dashboard url
    And I click the time at work clock
    Then I should be redirected to the attendance punch in time page
    And I should select the today date at 8:30 o'clock


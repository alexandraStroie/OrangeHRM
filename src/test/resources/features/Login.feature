Feature: Login into OrangeHRM

  As a user, I want to log into OrangeHRM with the correct credentials so that I can access the dashboard.

  @SmokeTest
  Scenario: Successful login with valid credentials
    Given I navigate to the login page
    #When I enter the username "username" and the password "password"
    When I enter the following credentials
      | username | password  |
      | Admin    | admin123  |
    And I click the login button
    Then I should be redirected to the dashboard url

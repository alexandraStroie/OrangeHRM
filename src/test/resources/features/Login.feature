Feature: Login into OrangeHRM

  As a user, I want to log into OrangeHRM with the correct credentials so that I can access the dashboard.

  @SmokeTest
  Scenario: Successful login with valid credentials
    When I enter the username "Admin" and the password "admin123"
    And I click the login button
    Then I should be redirected to the dashboard page

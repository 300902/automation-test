Feature: DemoBlaze Website Login
  As a user of DemoBlaze website
  I want to login to my account
  So that I can access personalized features

  Background:
    Given I am on the DemoBlaze website

  @ui @positive
  Scenario: Successful login with valid credentials
    Given I click on the login button
    When I enter valid username "testuser123"
    And I enter valid password "testpass123"
    And I click the login submit button
    Then I should be logged in successfully
    And I should see welcome message with username

  @ui @negative
  Scenario: Failed login with invalid username
    Given I click on the login button
    When I enter invalid username "invaliduser"
    And I enter valid password "testpass123"
    And I click the login submit button
    Then I should see login failure alert
    And I should remain on the login page

  @ui @negative
  Scenario: Failed login with invalid password
    Given I click on the login button
    When I enter valid username "testuser123"
    And I enter invalid password "wrongpassword"
    And I click the login submit button
    Then I should see login failure alert
    And I should remain on the login page

  @ui @negative
  Scenario: Failed login with empty credentials
    Given I click on the login button
    When I leave username field empty
    And I leave password field empty
    And I click the login submit button
    Then I should see validation error for empty fields

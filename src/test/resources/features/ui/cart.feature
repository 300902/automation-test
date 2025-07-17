Feature: DemoBlaze Shopping Cart
  As a customer of DemoBlaze
  I want to add products to cart and checkout
  So that I can purchase products

  Background:
    Given I am on the DemoBlaze website

  @ui @positive
  Scenario: Successfully add product to cart
    Given I navigate to a product page "Samsung galaxy s6"
    When I click the "Add to cart" button
    Then I should see cart confirmation alert
    And the product should be added to cart

  @ui @negative
  Scenario: Add to cart without selecting product
    Given I am on the home page
    When I try to add to cart without selecting any product
    Then the add to cart action should fail
    And no product should be added to cart

  @ui @positive
  Scenario: Successful checkout with complete information
    Given I have products in my cart
    And I navigate to cart page
    When I click "Place Order" button
    And I fill in all required checkout information
      | name       | country | city     | card            | month | year |
      | John Doe   | USA     | New York | 1234567890123456| 12    | 2025 |
    And I click "Purchase" button
    Then I should see successful purchase confirmation
    And order details should be displayed

  @ui @negative
  Scenario: Failed checkout with incomplete information
    Given I have products in my cart
    And I navigate to cart page
    When I click "Place Order" button
    And I leave required fields empty
    And I click "Purchase" button
    Then I should see validation error for empty fields
    And the purchase should not be completed

  @ui @negative
  Scenario: Failed checkout with invalid card information
    Given I have products in my cart
    And I navigate to cart page
    When I click "Place Order" button
    And I fill in checkout information with invalid card
      | name     | country | city     | card     | month | year |
      | John Doe | USA     | New York | invalid  | 12    | 2025 |
    And I click "Purchase" button
    Then I should see error for invalid card information
    And the purchase should not be completed

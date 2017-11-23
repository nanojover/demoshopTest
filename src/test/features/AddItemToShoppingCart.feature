@AddItems
Feature: As a customer I want to add items so they are added to the Shopping Cart

  Scenario: The cart is initialy empty
    Given customer is in Home page
    Then the cart is empty

  Scenario: The item selected is added to the cart
    Given customer is in Home page
    When click on Add to cart button for 'Flying Ninja' item
    Then the item 'Flying Ninja' is added to the cart

  Scenario: A non selected item is not added to the cart
    Given customer is in Home page
    When click on Add to cart button for 'Flying Ninja' item
    Then the item 'Happy Ninja' is not added to the cart

@ShoppingCartProcess
Feature: As a customer I want to process the Shopping Cart so I can apply a payment

  Scenario: Add items to the shopping cart 
    Given customer is in Home page
    And click on Add to cart button for 'Flying Ninja' item
    And the item 'Flying Ninja' is added to the cart
    And customer Proceed to Checkout
    And customer information is entered
      | firstName | lastName | email       | phone     | country | address             | postalCode | townCity  | province  |
      | Mariano   | Jover    | a@gmail.com | 603111111 | Spain   | Avinguda Diagonal 1 | 08901      | Barcelona | Barcelona |
    When customer click on Place order button
    Then 'Paga+Tarde' page is displayed


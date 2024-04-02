Feature: End to end test
  The user add products to the cart remove one product fills out the form and perform the checkout

  Background:
    Given the user is in the TheShop page

  Scenario: the user add a products in the cart and remove one
    When the user clicks on the All Products button
    And the user clicks on the Add to cart button to add a product
    And the user clicks on the Add to cart button to add a new product
    And the user clicks on the Checkout button
    And the user clicks on the Remove button to remove a product
    And the user with first-name "john" with last-name "doe" with email "jdoe@hotmail.com" with address "ankegatan 1" with country "Sweden" with city "Stockholm" with zip "123" with name-on-card "john doe" with credit-card-number "1234567" with expiration "09/26" with CVV "123" fills out the form
    And the user clicks on the Continue to check button
    Then the user would succeed with the order
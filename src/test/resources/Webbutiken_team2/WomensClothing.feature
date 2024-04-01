Feature:Viewing Women's Clothing Products
  US:   As a user
  I want to view Women's Clothing products
  So that I can browse their selection

  Scenario: Checking that all the products from the Women's Clothing category are present
    Given User is on the Shop page
    When User selects the 'Women's Clothing' section
    And User scrolls down to the 'Women's Clothing' section
    Then User should see total 6 products from Women's Clothing section


  Scenario: Viewing the details of first product from the Women's Clothing category
    Given User is on the Shop page
    When User selects the 'Women's Clothing' section
    Then User sees the first product's image
    And User sees the first product's name
    And User sees the first product's price
    And User sees the first product's description


  Scenario: Adding first product to the Cart
    Given User is on the Shop page
    When User selects the 'Women's Clothing' section
    And the user clicks the Add to cart button for the first product
    Then the product should be added to the cart
    And the cart count should increase by 1

  Scenario: Viewing the details of second product from the Women's Clothing category
    Given User is on the Shop page
    When User selects the 'Women's Clothing' section
    Then User sees the second product's image
    And User sees the second product's name
    And User sees the second product's price
    And User sees the second product's description

  Scenario: Adding second product to the Cart
    Given User is on the Shop page
    When User selects the 'Women's Clothing' section
    And the user clicks the Add to cart button for the second product
    Then the product should be added to the cart
    And the cart count should increase by 1

  Scenario: Viewing the details of third product from the Women's Clothing category
    Given User is on the Shop page
    When User selects the 'Women's Clothing' section
    Then User sees the third product's image
    And User sees the third product's name
    And User sees the third product's price
    And User sees the third product's description

  Scenario: Adding third product to the Cart
    Given User is on the Shop page
    When User selects the 'Women's Clothing' section
    And the user clicks the Add to cart button for the third product
    Then the product should be added to the cart
    And the cart count should increase by 1

  Scenario: Viewing the details of fourth product from the Women's Clothing category
    Given User is on the Shop page
    When User selects the 'Women's Clothing' section
    Then User sees the fourth product's image
    And User sees the fourth product's name
    And User sees the fourth product's price
    And User sees the fourth product's description

  Scenario: Adding fourth product to the Cart
    Given User is on the Shop page
    When User selects the 'Women's Clothing' section
    And the user clicks the Add to cart button for the fourth product
    Then the product should be added to the cart
    And the cart count should increase by 1

  Scenario: Viewing the details of fifth product from the Women's Clothing category
    Given User is on the Shop page
    When User selects the 'Women's Clothing' section
    Then User sees the fifth product's image
    And User sees the fifth product's name
    And User sees the fifth product's price
    And User sees the fifth product's description

  Scenario: Adding fifth product to the Cart
    Given User is on the Shop page
    When User selects the 'Women's Clothing' section
    And the user clicks the Add to cart button for the fifth product
    Then the product should be added to the cart
    And the cart count should increase by 1

  Scenario: Viewing the details of sixth product from the Women's Clothing category
    Given User is on the Shop page
    When User selects the 'Women's Clothing' section
    Then User sees the sixth product's image
    And User sees the sixth product's name
    And User sees the sixth product's price
    And User sees the sixth product's description

  Scenario: Adding sixth product to the Cart
    Given User is on the Shop page
    When User selects the 'Women's Clothing' section
    And the user clicks the Add to cart button for the sixth product
    Then the product should be added to the cart
    And the cart count should increase by 1

  Scenario Outline: End to end test-Completing a Purchase in the Women's Clothing Section Using a Credit Card
    Given User is on the Shop page
    When User selects the 'Women's Clothing' section
    And the user clicks the Add to cart button for the first product
    And the user navigates the cart page
    And the user enters "<First Name>" in the first name field
    And the user enters "<Last Name>" in the last name field
    And the user enters "<Email>" in the email field
    And the user enters "<Address>" in the address field
    And the user enter "<Country>" in the country field
    And the user enters "<City>" in the city field
    And the user enters "<Zip>" in the zip code field
    And the user selects the "credit card" as payment method
    And the user enters "<Name on Card>" in the name on card field
    And the user enters "<Credit Card Number>" in the credit card number field
    And the user enters "<Expiration>" in the expiration field
    And the user enters "<CVV>" in the CVV field
    Then the user submits the checkout form


    Examples:
      | First Name | Last Name | Email                | Address       | Country        | City       | Zip      | Name on Card | Credit Card Number | Expiration | CVV |
      | Sven       | Stevenson | svense@email.com     | 123 Tullgatan | Sweden         | Stockholm  | 10001    | C John Doe   | 1234567890123456   | 12/24      | 123 |
      | Samuel     | Berg      | samuelberg@email.com | 456 Lomvagen  | Sweden         | Gothenburg | M5H 2N2  | Jane Smith   | 2345678901234567   | 11/25      | 456 |
      | Alex       | Johnson   | alexj@email.com      | 789 Pine Rd   | United Kingdom | London     | SW1A 1AA | Tom Dayton   | 6745678901234567   | 10/26      | 356 |


  Scenario Outline: End to end test-Completing a Purchase in the Women's Clothing Section Using Pay Pal
    Given User is on the Shop page
    When User selects the 'Women's Clothing' section
    And the user clicks the Add to cart button for the first product
    And the user navigates the cart page
    And the user enters "<First Name>" in the first name field
    And the user enters "<Last Name>" in the last name field
    And the user enters "<Email>" in the email field
    And the user enters "<Address>" in the address field
    And the user enter "<Country>" in the country field
    And the user enters "<City>" in the city field
    And the user enters "<Zip>" in the zip code field
    And the user selects the "paypal" as payment method
    Then the user sees a warning about redirecting to paypal
    Then the user submits the checkout form


    Examples:
      | First Name | Last Name | Email                | Address       | Country        | City       | Zip      |
      | Alice      | Ek        | aliceek@email.com    | 123 Tullgatan | Sweden         | Stockholm  | 10001    |
      | Samuel     | Bergson   | samuelberg@email.com | 456 Lomvagen  | Sweden         | Gothenburg | M5H 2N2  |
      | Alexis     | Wright    | alexw@email.com      | 789 Pine Rd   | United Kingdom | London     | SW1A 1AA |

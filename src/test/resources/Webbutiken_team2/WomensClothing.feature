Feature:Viewing Women's Clothing Products //Turgay
  US:   As a user
  I want to view Women's Clothing products
  So that I can browse their selection

  Scenario: Checking that all the products from the Women's Clothing category are present //Turgay
    Given User is on the Shop page
    When User selects the 'Women's Clothing' section
    Then User should see total 6 products from Women's Clothing section


  Scenario Outline: End to end test-Completing a Purchase in the Women's Clothing Section Using a Credit Card //Turgay
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


  Scenario Outline: End to end test-Completing a Purchase in the Women's Clothing Section Using Pay Pal //Turgay
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







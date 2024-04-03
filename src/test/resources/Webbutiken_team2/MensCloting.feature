Feature:Access to Men's Clothing Page //Salim

  Scenario: Navigating to Men's Clothing Page
    Given user on the Products page
    When click on the men's clothing link
    Then the amount of men's clothing products equal 4

  Scenario: Viewing products on Men's Clothing Page
    Given user on the Products page
    Then A list of men's clothing products with their names, descriptions, and prices should be displayed
    Then The product names on the Men's Clothing page should be descriptive and easy to understand
    Then The product descriptions on the Men's Clothing page should provide relevant information about the items
    Then The product prices on the Men's Clothing page should be clearly visible and accurate
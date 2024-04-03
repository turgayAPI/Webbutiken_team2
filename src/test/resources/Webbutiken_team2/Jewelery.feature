Feature: Jewelery on the products page
  Scenario: check than jewelery present on the products page
    Given the user on the Products page
    When click on the jewelery link
    Then jewelery is present on the page
    And the amount of jewelery products equal 4

  Scenario: Product Information on Jewelery Page is Verified
    Given the user on the Products page
    When click on the jewelery link
    Then jewelery is present on the page
    And Each product has a name, description, and price

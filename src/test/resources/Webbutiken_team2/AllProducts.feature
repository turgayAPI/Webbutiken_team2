Feature: All products on the products page //Yevheniia Kornilova

  Scenario: check than all products present on the products page
    Given  the user on the products page
    When click on the All products link
    Then all products are present on the page
    And  the amount of products equal 20
Feature: the Search function
  The search function should display the correct products

  Background:
    Given the user is in the products page

  Scenario Outline: The searched product will display correct product
    When the user search for <searched_product>
    Then the result should display <expected_product>
    Examples:
      | searched_product                                        | expected_product |
      | "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops" | "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"               |







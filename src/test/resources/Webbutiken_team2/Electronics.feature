Feature: Electronics page content
  Content of the Electronics page

  Background: The user navigate to the products page of the shop
    Given the user is on the products page of the shop

  Scenario: The user is to the products page
    Then the user should be in the correct products page

  Scenario: The user navigate to the Elektronics page from Shop page
    When the user clicks on the Electronics link
    Then the user get the electronics page

  Scenario: the user navigates to the home page
    When the user clicks on the Electronics link
    And the user clicks on the home link
    Then the user should be in the home page

  Scenario:the user navigates to the About page
    When the user clicks on the Electronics link
    And the user clicks on the about link
    Then the user should be in the about page






Feature: Home page //Yevheniia Kornilova
  Background:
    Given the user on the home page

  Scenario: check home pages title
    Then home pages title is "The Shop"

  Scenario: Check if the "Home" link is on the toolbar and leads on the home page
    Then Home link is present
    When click on the Home link
    And the user goes to the home page

  Scenario: Check if the "Shop" link is on the toolbar and leads on the home page
    Then Shop link is present
    When click on the Shop link
    And the user goes to the shop page

  Scenario: Check if the "Checkout" button is on the toolbar and leads on the checkout page
    Then Checkout button is present
    When click on the Checkout button
    And the user goes to the checkout page

  Scenario: check if title on home page is present
    Then title on the home page is present

  Scenario: check if description of Webshop is present on the home page
    Then description of Webshop is present on the home page

  Scenario: check if image of product is present on the home page
    Then the image with the product is present on the home page

  Scenario: check if [All products] button is present on the home page and navigates to the Product page with all products
    Then the [All products] button is present on the home page
    When click on the [All products] button
    Then the user navigates to the Products page

  Scenario: check if copyright is present on the home page
    Then the copyright is present on the page

  Scenario: check if navigation links are present on the button of home page
    Then titles of navigation links should match:
      |Home|
      |Shop|
      |Checkout|
      |About |
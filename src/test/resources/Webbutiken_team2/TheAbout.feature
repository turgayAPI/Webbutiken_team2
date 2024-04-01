Feature: About Page Content and Navigation //Turgay
  US:   As a user
  I want to  read information about the web shop on the About page,
  So that I can learn more about the web shop's mission  and products.


  Scenario: Navigating to the About page from the Homepage //Turgay
    Given the user is  on the Homepage
    When the user clicks on the "About" link in the navigation bar
    Then I should be redirected to the About page
    And the title of the page should be "The Shop | About"

  Scenario: Navigating to the About page from the Homepage //Turgay
    Given the user is on the About page
    When the user scrolls down the webpage
    Then the user sees the heading "About The Shop"
    And the user sees the text about the shop

  Scenario: Presence of essential navigation links and footer text //Turgay
    Given the user is on the About page
    Then the user sees a navigation link for the The Shop logo
    And the user sees navigation link for Home
    And the user sees a navigation link for Shop
    And the user sees a navigation link for About
    And the user sees a navigation link for Checkout
    And the user sees see a link or button for To all products
    And I should see the footer text "© 2024 The Shop"


  Scenario: All navigation links should lead to the correct pages //Turgay
    Given the user is on the About page
    When the user clicks on the Shop navigation link
    Then the user is redirected to the shop page
    When the user clicks on the Home navigation link
    Then the user is redirected to the homepage
    When the user clicks on the About navigation link
    Then the user is redirected to the about page
    When the user clicks on the Checkout navigation link
    Then the user is redirected to the checkout page
    When the user clicks on the To all products link
    Then the user is redirected to the products page

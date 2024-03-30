Feature: Checkout page //Yevheniia Kornilova
  Background:
    Given the user on the checkout page

  Scenario: check the header of the checkout pages
    Then checkout pages title is "The Shop | Checkout"

  Scenario: check if the title present on checkout form
    Then the title is present

  Scenario: check if the page has a welcome message for the buyer
    Then the welcome message is present

  Scenario: check filling  fields
    When fill fields with values "Adam", "Korn", "test@gmail.com", "Stadsbacken 123", "Sverige", "Stockholm", "123456"
    And choose [debit card] radio button
    When continue filling the fields with values "Adam Korn", "1212 3434 5656 7878", "01/26", "123"
    And click on the [Continue to checkout] button
    Then no error is present

  Scenario: check if credit card fields disappear when PayPal method chosen
    When choose PayPal by radiobutton
    Then credit card fields disappear

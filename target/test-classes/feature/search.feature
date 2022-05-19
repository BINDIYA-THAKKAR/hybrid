@Regression
Feature:  Search on Tesco Website
  AS a User.
  I want to open Tesco webpage.
  So that I can find Tesco search

  Background:
    Given User must be on Tesco Website

  @smoke
  Scenario Outline: Verify the search Functionality on Tesco website
    When  User search for "<product>"  on search bar
    And   User click on Search button
    Then  User will able to see the "<product>" on webpage.
    Examples:
      |product|
      | milk  |
      |cheese |
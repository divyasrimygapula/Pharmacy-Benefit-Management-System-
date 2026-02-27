Feature: Pharmacy Benefit Management System

  Scenario: Purchase medicine successfully
    Given user opens the pharmacy application
    When user logs in with valid credentials
    And user searches for a medicine
    And user adds medicine to cart
    Then user places the order successfully
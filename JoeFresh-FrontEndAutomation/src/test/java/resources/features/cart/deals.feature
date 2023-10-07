Feature: Deals


  Scenario: J.1A - Regular priced product
    Given I am on a PDP Page added with two of fifty dollar product
    When I calculate the price of the product J1A
    Then It should be as expected

  @Deals
  Scenario: J.1B - Clearance Price Product
    Given J1B product is added in the cart
    When I calculate the price of the product J1B
    Then the price should be as expected



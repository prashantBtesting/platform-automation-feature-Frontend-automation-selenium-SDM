Feature: PC Optimum Points

  Scenario: When the user has only ot1 products in the cart
    Given the user has the products that belong to OT1 only
    When the user navigate to the cart
    Then the points should be as per the ot1 rules in the cart

    Scenario: When the user has only ot4a products in the cart
      Given the user has the products that belong to OT4a only
      When the user navigate to the cart
      Then the points should be as per the ot4a rules in the cart

      Scenario: When the user has only ot4b products in the cart
        Given the user has the products that belong to OT4a only
        When the user navigate to the cart
        Then the points should be as per the ot4a rules in the cart

        Scenario: When the user has only ot6 products in the cart
          Given the user has the products that belong to OT6 only
          When the user navigate to the cart
          Then the points should be as per the ot6 rules in the cart

          Scenario: When the user has the combination of products from the rules
            Given the user has the products that belong all types of product rules
            When the user navigate to the cart
            Then the points should be as per the applicable rules in the cart
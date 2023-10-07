Feature: PCO Points

  Scenario: Loyalty Bonus-OT1
    Given an end user searches the product as per OT1
    When he visit the cart
    Then he will see PCOptimum points as per OT1

  Scenario: Loyalty Bonus-OT6
    Given an end user searches the product as per OT6
    When he visit the cart
    Then he will see PCOptimum points as per OT6

  Scenario: Loyalty Bonus-OT4B
    Given an end user searches the product as per OT4B
    When he visit the cart
    Then he will see PCOptimum points as per OT4B

  Scenario: Loyalty Bonus-OT4A
    Given an end user searches the product as per OT4A
    When he visit the cart
    Then he will see PCOptimum points as per OT4A

  Scenario: Loyalty Bonus-Combined
    Given an end user searches the product from different categories
    When he visit the cart
    Then he will see PCOptimum points as per the rules combined

    Scenario: Loyalty Bonus - OT1 Multiple
      Given an end user searches the product as per OT1
      When he visit the cart and increase the quantity
      Then he will see PCOptimum points as per OT1 and quantity
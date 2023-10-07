Feature: Search ,add and checkout product without promo - F1GK023005001
@E2E
  Scenario Outline: Search the product and Add to Cart : PDP and Standard Delivery
    Given an end user lands on Joe Fresh Home Page and searches the product <Product>
    When the Search Result is displayed
    Then he should be able to add the items to cart from PDP
    And checkout using Guest Checkout and Standard shipping mode
    Examples:
      |Product|
      |F1GK023005001|
  @E2E
  Scenario Outline: Search the product and Add to Cart Logged In user : PDP and Standard Delivery
      Given an end user signed in Joe Fresh and searches the product <Product>
      When the Search Result is displayed
      Then he should be able to add the items to cart from PDP
      And checkout using Logged in Checkout and Standard shipping mode
    Examples:
      |Product|
    |F1GK023005001|
  @E2E
  Scenario Outline: Search the product and Add to Cart : PDP and Express Delivery
    Given an end user lands on Joe Fresh Home Page and searches the product <Product>
    When the Search Result is displayed
    Then he should be able to add the items to cart from PDP
    And checkout using Guest Checkout and Express shipping mode
    Examples:
    |Product|
      |F1GK023005001|
  @E2E
  Scenario Outline: Search the product and Add to Cart Logged In user : PDP and Express Delivery
    Given an end user signed in Joe Fresh and searches the product <Product>
    When the Search Result is displayed
    Then he should be able to add the items to cart from PDP
    And checkout using Logged in Checkout and Express shipping mode
    Examples:
    |Product|
      |F1GK023005001|
  @E2E
  Scenario Outline: Search the product and Add to Cart : PLP and Standard Delivery
    Given an end user lands on Joe Fresh Home Page and searches the product <Product>
    When the Search Result is displayed on PLP
    Then he should be able to add the items to cart using PLP
    And checkout using Guest Checkout and Standard shipping mode
    Examples:
      |Product|
    |F1GK023005001|
  @E2E
  Scenario Outline: Search the product and Add to Cart Logged In user : PLP and Standard Delivery
    Given an end user signed in Joe Fresh and searches the product <Product>
    When the Search Result is displayed on PLP
    Then he should be able to add the items to cart using PLP
    And checkout using Logged in Checkout and Standard shipping mode
    Examples:
      |Product|
    |F1GK023005001|
  @E2E
  Scenario Outline: Search the product and Add to Cart : PLP and Express Delivery
    Given an end user lands on Joe Fresh Home Page and searches the product <Product>
    When the Search Result is displayed on PLP
    Then he should be able to add the items to cart using PLP
    And checkout using Guest Checkout and Express shipping mode
    Examples:
    |Product|
      |F1GK023005001|
  @E2E
  Scenario Outline: Search the product and Add to Cart Logged In user : PLP and Express Delivery
    Given an end user signed in Joe Fresh and searches the product <Product>
    When the Search Result is displayed on PLP
    Then he should be able to add the items to cart using PLP
    And checkout using Guest Checkout and Express shipping mode
    Examples:
    |Product|
      |F1GK023005001|


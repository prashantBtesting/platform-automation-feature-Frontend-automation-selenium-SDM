Feature: Search , add and checkout product with different variance (sizes/colour) - U1WR017905002
  @E2E
  Scenario Outline: Search the product and Add to Cart : PDP and Standard Delivery
    Given an end user lands on Joe Fresh Home Page and searches the product <Product>
    When the Search Result is displayed with variant on PDP
    Then he should be able to add all the variant items to cart from PDP
    And checkout using Guest Checkout and Standard shipping mode
    Examples:
      |Product|
      |U1WR017905002|
  @E2E
  Scenario Outline: Search the product and Add to Cart Logged In user : PDP and Standard Delivery
    Given an end user signed in Joe Fresh and searches the product <Product>
    When the Search Result is displayed with variant on PDP
    Then he should be able to add all the variant items to cart from PDP
    And checkout using Logged in Checkout and Standard shipping mode
    Examples:
      |Product|
      |U1WR017905002|
  @E2E
  Scenario Outline: Search the product and Add to Cart : PDP and Express Delivery
    Given an end user lands on Joe Fresh Home Page and searches the product <Product>
    When the Search Result is displayed with variant on PDP
    Then he should be able to add all the variant items to cart from PDP
    And checkout using Guest Checkout and Express shipping mode
    Examples:
      |Product|
      |U1WR017905002|
  @E2E
  Scenario Outline: Search the product and Add to Cart Logged In user : PDP and Express Delivery
    Given an end user signed in Joe Fresh and searches the product <Product>
    When the Search Result is displayed with variant on PDP
    Then he should be able to add all the variant items to cart from PDP
    And checkout using Logged in Checkout and Express shipping mode
    Examples:
      |Product|
      |U1WR017905002|
  @E2E
  Scenario Outline: Search the product and Add to Cart : PLP and Standard Delivery
    Given an end user lands on Joe Fresh Home Page and searches the product <Product>
    When the Search Result is displayed with variant on PLP
    Then he should be able to add all the variant items to cart from PLP
    And checkout using Guest Checkout and Standard shipping mode
    Examples:
      |Product|
      |U1WR017905002|
  @E2E
  Scenario Outline: Search the product and Add to Cart Logged In user : PLP and Standard Delivery
    Given an end user signed in Joe Fresh and searches the product <Product>
    When the Search Result is displayed with variant on PLP
    Then he should be able to add all the variant items to cart from PLP
    And checkout using Logged in Checkout and Standard shipping mode
    Examples:
      |Product|
      |U1WR017905002|
  @E2E
  Scenario Outline: Search the product and Add to Cart : PLP and Express Delivery
    Given an end user lands on Joe Fresh Home Page and searches the product <Product>
    When the Search Result is displayed with variant on PLP
    Then he should be able to add all the variant items to cart from PLP
    And checkout using Guest Checkout and Express shipping mode
    Examples:
      |Product|
      |U1WR017905002|
  @E2E
  Scenario Outline: Search the product and Add to Cart Logged In user : PLP and Express Delivery
    Given an end user signed in Joe Fresh and searches the product <Product>
    When the Search Result is displayed with variant on PLP
    Then he should be able to add all the variant items to cart from PLP
    And checkout using Guest Checkout and Express shipping mode
    Examples:
      |Product|
      |U1WR017905002|


Feature: Auth

  @Auth
  Scenario: Create an account TC-12
    Given I am on the Joe fresh site
    When I navigate to the PC Account page and sign up
    Then I should redirect back to Joe Fresh site

    @Auth @Pilot
    Scenario: Sign In Route To Checkout TC-13
      Given I have added products to my bag and I proceed to checkout
      When I reached Checkout page
      Then I am able to sign in and reach auth checkout

      @Auth @Pilot
      Scenario: Merge Cart TC-14
        Given I have added products to my bag and I proceed to cart
        When I signed into the website
        Then my cart should be merged




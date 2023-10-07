Feature: Other Header Elements

  @Header @Pilot
  Scenario: Header : Find A Store
    Given I am a user on any of the page
    When I hit Find a store link on the left side of the header
    Then It should take me to Find a Store page

  @Header @Pilot
  Scenario: Header : Login Pc
    Given I am a user on any of the page
    When I hit Login link on the header
    Then It should redirect to Pcid Login Page

  @Header @Pilot
  Scenario: Header : My Bag
    Given I am a user on any of the page
    When I hit MyBag button on the header
    Then It should redirect to Cart Page

  @Header @Pilot
  Scenario: Header : Logo
    Given I am a user on any of the page
    When I hit Logo on the header
    Then It should redirect to Home Page

  @Header @Pilot
  Scenario: Search : Logo
    Given I am a user on any of the page
    When I hit Search on the header
    Then It should be visible

  @Header @Pilot
  Scenario: Store Locator Page-Search term
    Given I am on the store locator page
    When I begin to type a search term in the search field
    Then I should see the suggestions of stores based on the search term.

  @Header @Pilot
  Scenario: Store Locator Page - Directions
    Given a user enter the postal code or city or address and hit enter
    When the user hit the Direction
    Then It should redirect to Google Maps

  @Header @Pilot
  Scenario: Store Locator - Details
    Given a user enter the postal code or city or address and hit enter
    When the user hit the Details
    Then It should show store details

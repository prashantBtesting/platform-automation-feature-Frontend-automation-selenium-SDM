Feature: HomePage Test Cases

  @Homepage @Pilot

  Scenario: Recommended options
    Given I  am on home page
    When I click on recommended option
    Then I am Able to add them in a cart

  @Homepage @Pilot
  Scenario:  Trending Options
    Given I  am on home page
    When I click on Trending options
    Then I am Able to add them in a cart

  @Homepage @Pilot
  Scenario: Shop Now button
    Given I  am on home page
    When I clicked on shop now
    Then  I am Redirected to that page

  @Homepage @Pilot
  Scenario: Marvel Page
    Given I  am on home page
    When I clicked on shopnow marvel
    Then I am redirected to Marvel page

  @Homepage @Pilot
  Scenario: Disney Page
    Given I  am on home page
    When I clicked on shopnow Disney
    Then  I am redirected to tha disney page





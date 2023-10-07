Feature: Navigation

  @Navigation @Pilot
  Scenario: Navigation : New
    Given I am on the Joe fresh site
    When I click on the New link
    Then as a user I should see the links under Shop new category
    And each link is clickable & should redirect to correct pages.

  @Navigation @Pilot
  Scenario: Navigation : Women
    Given I am on the Joe fresh site
    When I click on the Women link
    Then as a user I should see the links under Shop Women category
    And each link is clickable & should redirect to correct Women pages.

  @Navigation @Pilot
  Scenario: Navigation : Women Plus
    Given I am on the Joe fresh site
    When I click on the Women Plus link
    Then as a user I should see the links under Shop Women Plus category
    And each link is clickable & should redirect to correct Women Plus pages.

  @Navigation @Pilot
  Scenario: Navigation : Men
    Given I am on the Joe fresh site
    When I click on the Women link
    Then as a user I should see the links under Shop Women category
    And each link is clickable & should redirect to correct Men pages.

  @Navigation @Pilot
  Scenario: Navigation : Girls
    Given I am on the Joe fresh site
    When I click on the Boys link
    Then as a user I should see the links under Shop Girls category
    And each link is clickable & should redirect to correct Girls pages.

  @Navigation @Pilot
  Scenario: Navigation : Boys
    Given I am on the Joe fresh site
    When I click on the Boys link
    Then as a user I should see the links under Shop Boys category
    And each link is clickable & should redirect to correct Boys pages.

  @Navigation @Pilot
  Scenario: Navigation : Baby
    Given I am on the Joe fresh site
    When I click on the Todlers link
    Then as a user I should see the links under Shop Baby category
    And each link is clickable & should redirect to correct Baby pages.

  @Navigation @Pilot
  Scenario: Navigation : Active
    Given I am on the Joe fresh site
    When I click on the Active link
    Then as a user I should see the links under Shop Active category
    And each link is clickable & should redirect to correct Active pages.

  @Navigation @Pilot
  Scenario: Navigation : Toddlers
    Given I am on the Joe fresh site
    When I click on the Active link
    Then as a user I should see the links under Shop Toddlers category
    And each link is clickable & should redirect to correct Toddlers pages.

  @Navigation @Pilot
  Scenario: Navigation : Rain Shop
    Given I am on the Joe fresh site
    When I want to visit Rain Shop
    Then as a user I should see the links under various header associated with children and redirect to Rain Shop

  @Navigation @Pilot
  Scenario: Navigation : Back To School
    Given I am on the Joe fresh site
    When I click on the Todlers link
    Then as a user I should see the links under various header associated with children and redirect to Back To School

  @Navigation @Pilot
  Scenario: Navigation : PC Childeren Charity
    Given I am on the Joe fresh site
    When I click on the Todlers link
    Then as a user I should see the links under various header associated with children and redirect to PC Children

  @Navigation @Pilot
  Scenario: Navigation: Disney
    Given I am on the Joe fresh site
    When I click on the Disney and Marvel and then Disney
    Then as a user I should redirect to Disney Page

  @Navigation @Pilot
  Scenario: Navigation : Marvel
    Given I am on the Joe fresh site
    When I click on the Disney and Marvel and then Disney
    Then as a user I should redirect to Marvel Page




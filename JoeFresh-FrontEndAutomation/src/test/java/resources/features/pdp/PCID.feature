Feature: Login


  Scenario: Login flow
    Given I on the homepage
    When I clicked on Sign In button
    Then I am able to sign in
    And I am Able to sign out

  @PCID
  Scenario:  PCO page - display points balance
    Given I am on the PCO page and have a PCO account
    When the page loads
    Then I am presented with a section that shows my current number of PCO, redeemable value, email, option to manage PCO account

  @PCID
  Scenario: PCO page - offers display (?)d
    Given I am on the PCO page and have PCO (regardless if I have PCOI or not)
    When the page loads and there are special JF offers available
    Then I am presented with a list of JF offers and a link to all PCO offers

  @PCID
  Scenario: PCO page - offers display (?)
    Given I am on the PCO page and have PCO (regardless if I have PCOI or not)
    When there are no offers
    Then I am presented an empty list with the empty state text (ex. Your Joe Fresh offers list is empty...)

  @PCID
  Scenario: PCO page - non-member state
    Given I am on the PCO page and I am not a PCO user (but have PC ID)
    When tthe page loads
    Then I am presented with information on PCO and a link to join PCO
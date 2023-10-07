Feature: Footer : Get Help

  @Footer @Pilot
  Scenario: Get Help Pop Up
    Given a user arrived at My Bag Page
    When I navigate to the footer area
    Then I should see the Get Help tile at the bottom of the footer area.

  @Footer @Pilot
  Scenario: Get Help Pop Up Access
    Given a user arrived at My Bag Page
    When I navigate to the footer area
    Then I should see the Get Help chatbox when I click the button

  @Footer @Pilot
  Scenario: Get Help Pop Up Minimize
    Given a user arrived at My Bag Page
    When I navigate to the footer area
    Then I open the chat box and click minimize, then it should be minimized

  @Footer @Pilot
  Scenario: Get Help Pop Up Close
    Given a user arrived at My Bag Page
    When I navigate to the footer area
    Then I open the chat box and click close, then it should be closed

  @Footer @Pilot
  Scenario: Get Help Pop Up Chat Area
    Given a user arrived at My Bag Page
    When I navigate to the footer area
    Then I should able to select options and it should repsonse

  @Footer @Pilot
  Scenario: Get Help Pop Up Settings
    Given a user arrived at My Bag Page
    When I navigate to the footer area
    Then I click Settings and the settings section should displayed



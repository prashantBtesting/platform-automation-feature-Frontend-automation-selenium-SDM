Feature: Newsletters

  @Newsletters @Pilot
  Scenario: Newsletter : Success
    Given User is on the Newsletter Page
    When User enters all details and submit
    Then the sucess message is displayed

  @Newsletters @Pilot
  Scenario: Newsletters:Email Error
    Given User is on the Newsletter Page
    When User enters all details except email and submit
    Then the email error message is displayed

  @Newsletters @Pilot
  Scenario: Newsletters:First Name Error
    Given User is on the Newsletter Page
    When User enters all details except name and submit
    Then the first name error is displayed

  @Newsletters @Pilot
  Scenario: Newsletters : Checkbox Error
    Given User is on the Newsletter Page
    When User enters all details except checkbox and submit
    Then the checkbox error is displayed

  @Newsletters @Pilot
  Scenario: Newsletters : No Error Message
    Given User is on the Newsletter Page
    When User enters no details and submit
    Then all errors are displayed

  @Newsletters @Pilot
  Scenario: Newsletters Terms and Conditions
    Given User is on the Newsletter Page
    When I navigate to agreeTerms condition
    Then I click Terms and Conditions check statement and it should redirect to Terms and Conditions page

  @Newsletters @Pilot
  Scenario: Newsletters Privacy Policy
    Given User is on the Newsletter Page
    When I navigate to agreeTerms condition
    Then I click Terms and Conditions check statement and it should redirect to Privacy page

  @Newsletters @Pilot
  Scenario: Newsletter Sign Up Success
    Given I have navigate to Joe Fresh site
    When I navigate to the footer area
    Then I am able to submit the subscription form

  @Newsletters @Pilot
  Scenario: Newsletter sign up no agree to terms
    Given I have navigate to Joe Fresh site
    When I navigate to the footer area
    Then I am unable to submit the subscription form and see error message to check the box

  @Newsletters @Pilot
  Scenario: Newsletter invalid email
    Given I have navigate to Joe Fresh site
    When I navigate to the footer area
    Then I am unable to submit the subscription form and see an error message

  @Newsletters @Pilot
  Scenario: Newsletter no email
    Given I have navigate to Joe Fresh site
    When I navigate to the footer area
    Then I am unable to submit the subscription form and see an error message for no email

  @Newsletters @Pilot
  Scenario: Newsletters Terms and Conditions
    Given I have navigate to Joe Fresh site
    When I navigate to the footer area
    Then I click Terms and Conditions and it should redirect to Terms and Conditions page

  @Newsletters @Pilot
  Scenario: Newsletters Privacy Policy
    Given I have navigate to Joe Fresh site
    When I navigate to the footer area
    Then I click Privacy Policy and it should redirect to Privacy page
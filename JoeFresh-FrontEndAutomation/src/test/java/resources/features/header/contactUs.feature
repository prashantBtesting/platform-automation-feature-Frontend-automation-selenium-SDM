Feature: Contact Us

  @ContactUs
  Scenario: Successful Submission
    Given an end user visited the Contact Us page
    When he fills all the valid details
    Then the form should be submitted

  @ContactUs
  Scenario: Name Error
    Given an end user visited the Contact Us page
    When he fills all details except name
    Then the form should not be submitted and name error should be displayed

  @ContactUs
  Scenario: Email Error
    Given an end user visited the Contact Us page
    When he fills all details except email
    Then the form should not be submitted and email error should be displayed

  @ContactUs
  Scenario: Dropdown Error
    Given an end user visited the Contact Us page
    When he fills all details except dropdown
    Then the form should not be submitted and dropdown error should be displayed

  @ContactUs
    Scenario: Message Error
      Given an end user visited the Contact Us page
      When he fills all details except message
      Then the form should not be submitted and message error should be displayed


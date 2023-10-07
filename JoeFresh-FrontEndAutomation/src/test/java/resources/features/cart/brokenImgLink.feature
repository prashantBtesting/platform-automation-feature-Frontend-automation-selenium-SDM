Feature: BrokenImgLinks


  Scenario: Find broken images and links from Homepage
    Given I open Homepage
    When find all the broken links and images available with count
    Then I click on the available links and broken images


  Scenario: Find broken images and links from Homepage
    Given I open Homepage(women Jackets and coats)
    When find all the broken links and images available with count
    Then I click on the available links and broken images

  Scenario: Find broken images and links from Homepage
    Given I open Homepage(todlers boy)
    When find all the broken links and images available with count
    Then I click on the available links and broken images





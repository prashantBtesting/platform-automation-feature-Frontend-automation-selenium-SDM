Feature: Search Dropdown

  @Search @Pilot

  Scenario Outline: Search auto-complete : Valid Products TC-1
    Given I am on any page with search
    When I begin typing a search term <Term>
    Then Then I'll see matching product results in the dropdown
    Examples:
      | Term |
      | Shirt         |
      | Skirt          |
      | Boy's Sweater |
      | Outerwear    |
      | Trouser      |

  @Search @Pilot
  Scenario Outline: Search auto-complete : Invalid Product Name TC-2
    Given I am on any page with search
    When I begin typing a incomplete or invalid search term <Term>
    Then I will see no results
    Examples:
      | Term |
      | Shi          |
      | Out          |
      | Atcghj          |

  @Search @Pilot
  Scenario Outline: Search results product grid TC-3 & 4
    Given I have entered a search term in the search box <Term>
    When I hit enter
    Then I should see a search grid with three items across
    And Then I should see my search term on the top left
    Examples:
      | Term |
      |Outerwear       |

  @Search @Pilot
  Scenario: Verify the navigation of Suggested Products
    Given I am on the search field with prepopulated search term and list of suggested products are displayed
    When I hit a product in the suggestion list
    Then It should take me to the PDP page
    And I should see the Breadcrumps on the left side.
  @Search @Pilot
  Scenario: Search by style code
    Given I have entered a valid style code into the Search bar
    When I execute the search
    Then the product with that style code should be retrieved on the Search results page

  @Search @Pilot
  Scenario: Search Result Filter : Same Numbers as Filters TC-6
    Given I entered a search term in the search box and have a grid of results
    When I choose the filter on the left hand side for a category, colour or price
    Then I should see the same number of results as noted in the filter name
  @Search @Pilot
  Scenario: Search Result Filter : Same Chips as Filters TC-7
    Given I entered a search term in the search box and have a grid of results
    When I choose the filter on the left hand side for a category, colour or price
    Then I should see the chips above the search results that reflect the filters chosen.
  @Search @Pilot
  Scenario: Search Result Filter : Remove Filter TC-8
    Given I have a grid of results and choose multiple filters on the left Nav
    When  I remove the filters selected
    Then Then I should see the full results of the search reflected in the page

  @Search @Pilot
  Scenario: Search Result Filter : Remove Chip TC- 8
    Given I have a grid of results and choose multiple filters on the left Nav
    When I remove single filter pill
      | 1 |
    Then the count displayed on top should be updated correctly

    @Search @Pilot
  Scenario: Search No results page TC-9 and 10
    Given I entered a search term in the search box that has no match
    When I hit enter
    Then I should see a message telling me that my item was not found
    And I should see a carousel of recommended items, and chips to take me to common categories

  @Search @Pilot
  Scenario: Verify that Breadcrumbs are not displayed on search page
    Given I entered a search term in the search box and have a grid of results
    When I choose the filter on the left hand side for a category, colour or price
    Then I do not see the breadcrumbs on the search page
  @Search @Pilot
  Scenario: Sort on Search PLP
    Given I entered a search term in the search box and have a grid of results
    When I click on sort
    Then proper sort options should be displayed.


  Scenario: OOS Search
    Given I entered a search term in the search box and have a grid of results to check OOS
    When I checked for items
    Then no sizes should be out of stock

















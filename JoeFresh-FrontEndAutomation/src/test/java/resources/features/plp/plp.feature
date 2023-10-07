Feature: PLP

    Scenario: PLP tile colour selection TC-29 (Test case-Need an update)
    Given I am on the PLP with results
    When I click on the colour swatch of the tile
    Then I should see the image change to an item of that colour

  @PLP @Pilot
  Scenario: PLP Size selection
    Given I am on the PLP with results
    When I click on the add to bag button
    Then I should see the size selector

  @PLP @Pilot
  Scenario: PLP Select size and add to cart TC-33
    Given I am on the PLP with results
    When I click on the add to bag button, and select a size
    Then when I hit the add to bag button again, it should add it to cart

  @PLP @Pilot
  Scenario: PLP product grid load
    Given I am on the PLP with results
    When the page is loaded
    Then they see products that belong in the category or assortment load in a grid
  @PLP @Pilot
  Scenario: PLP out of stock - sizes
    Given I am on the PLP with results having out of stock sizes
    When I view the sizes on the product tile
    Then I should see out of stock sizes marked with a line through them, and not be able to select them.
  @PLP @Pilot
  Scenario: PLP item count : Showing Result
    Given I am on the PLP with results
    When the page is loaded
    Then they see -Showing number of products visible on page of total products in category products near the top of the page
    And they see -Showing number of products visible on page of total products in category products bottom of the page
  @PLP @Pilot
  Scenario: PLP load more
    Given I am on the PLP with results
    When they click Load more
    Then they see the next 30 products that belong in the category or assortment loaded in a grid
  @PLP @Pilot
  Scenario: PLP back to top
    Given a user is viewing a PLP displaying all available products in the category
    When they scroll to the bottom of the PLP
    Then they see a Back to top button
  @PLP @Pilot
  Scenario: PLP breadcrumb
    Given I am on the PLP with results
    When the page is loaded
    Then they see breadcrumb links at the top left


  Scenario: PLP category tree
    Given I am on the PLP with results
    When the page is loaded
    Then they see an an accordion style heading button with the text Category displayed in the expanded state on the left of the page.
    And each category name is displayed as a link to the respective category page
  @PLP @Pilot
  Scenario: PLP category tree : Collapse
    Given I am on the PLP with results
    When they click on the Category accordion style heading button in the expanded state
    Then they see the Category accordion style heading button in the collapsed state
  @PLP @Pilot
  Scenario: PLP filtering
    Given I am on the PLP with results
    When the page is loaded
    Then they see four accordion style text boxes displayed in the expanded state on the left of page
    And The attributes are listed as list boxes on the left in the unselected state
  @PLP @Pilot
  Scenario: PLP filtering
    Given I am on the PLP with results
    When they click on an empty filter checkbox
    Then they see a checkmark in the list box they selected,
    And products that belong in the assortment relevant to their filter selection loaded in a grid
  @PLP @Pilot
  Scenario: PLP Filtering
    Given I am on the PLP with results
    When they click on the accordion container when the accordion in in the expanded state
    Then Then they see the accordion style heading button in the collapsed state
  @PLP @Pilot
  Scenario: PLP filtering
    Given I am on the PLP with results
    When they click on the accordion style text box when the accordion is in the collapsed state
    Then they see the accordion style heading button in the expanded state
  @PLP @Pilot
  Scenario: PLP sorting
    Given I am on the PLP with results
    When the page is loaded
    Then they see a drop down menu near the top right of the page to Sort by Newest
  @PLP @Pilot
  Scenario: PLP sorting : Dropdown
    Given I am on the PLP with results
    When they click on a sorting option from the drop down menu
    Then they see products rearranged in the grid based on the sorting option selected
  @PLP @Pilot
  Scenario: PLP sorting : Price : Low to High
    Given I am on the PLP with results
    When they click on a Price Low To High from the drop down menu
    Then they see products rearranged in the grid based on the price Low To High
  @PLP @Pilot
  Scenario: PLP sorting : Price : High To Low
    Given I am on the PLP with results
    When they click on a Price High To Low from the drop down menu
    Then they see products rearranged in the grid based on the price High To Low

  @PLP @Pilot
  Scenario: PLP - refresh page with applied filters
    Given that I am on PLP and filters are applied
    When I refresh the page
    Then the applied filters are retained
  @PLP @Pilot
  Scenario: PLP : Load More with applied filters
    Given that I am on PLP with more than thirty products and filters are applied
    When I clicked on Load more
    Then the applied filters are retained after loadMore
  @PLP @Pilot
  Scenario: PLP - sort on pagination
    Given that I am on PLP with more than thirty products and filters are applied
    When I click sort and load more products
    Then the more items are loaded in the same sort option
  @PLP @Pilot
  Scenario: PLP - retain filter on navigating back to PLP from PDP
    Given that I am on PLP and filters are applied
    When I scroll to a particular tile And I click tile to view PDP And I click the browser back arrow
    Then I should see the same tile position And the applied filters should be retained
  @PLP @Pilot
  Scenario: PLP : 404 Error
    Given I am on the PLP with results
    When the page is loaded
    Then they see a fourofour page
  @PLP @Pilot
  Scenario: PLP Collection/Shop Page : Product Grid
    Given I am on shop or collection Page
    When I am viewing the page
    Then I should see products that exist within that collection
  @PLP @Pilot
  Scenario: PLP Collection/Shop Page : Filter and Sort Not Displayed
    Given I am on shop or collection Page
    When I am viewing the page
    Then the filters & Sort options should not be displayed
  @PLP @Pilot
  Scenario: PLP Collection/Shop Page : Product Information Displayed
    Given I am on shop or collection Page
    When I am viewing the page
    Then the item images, price, color swatch, sizes, tags should be displayed correctly for the items
  @PLP @Pilot
  Scenario: PLP Deals Page: Product Discount Displayed
    Given I am on Sales and Deals page
    When I am viewing the Sales page
    Then the clearance price,regular price and product badge should be displayed

    @PLP @Pilot
    Scenario: PLP extended sizes
      Given I am on page with regular and extended sizes
      When I select the product
      Then the size at Plp should be equal to Pdp

      @PLP
      Scenario: PLP: Same information on PDP
        Given I am on the PLP with results
        When I select the product
        Then the PDP information should be same as PLP









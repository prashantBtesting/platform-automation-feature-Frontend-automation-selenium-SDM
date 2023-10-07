Feature: PDP
  @browserstack
  @PDP @Pilot
  Scenario: bag page - items display1
    Given I am on the bag page
    When I have added products to my bag
    Then I am shown the prompt Dont miss out! Items in your bag are not held and may be sold.

  @PDP @Pilot
  Scenario: PDP Colour selection
    Given PDP Colour selection
    When When I click the colour swatch
    Then I should see the pictures change to a picture of the item of that colour

  @PDP @Pilot
  Scenario: PDP image gallery
    Given I am viewing a PDP page
    When we see the page is loaded
    Then thumbnail images are shown vertically at the left in this order And the images are ordered according to their filenames one to five

  @PDP @Pilot
  Scenario: PDP size selection
    Given I am on PDP
    When  I click the size selector on an available size
    Then  I should see the size selected, and be able to add to cart

  @PDP @Pilot
  Scenario: PDP size selection, PDP add to cart success + modal
    Given I am on a PDP
    When I click the size selector on an unavailable size
    Then Then I should not be able to select the size

  @PDP @Pilot
  Scenario: PDP product name
    Given I am viewing a PDP Prod Name
    When  the page is loaded Prod Name
    Then product name is displayed in full

  @PDP @Pilot
  Scenario: PDP size chart link + modal
    Given I am on a PDP AND the product belongs to a category with a defined size chart mapping
    When when the page is loaded
    Then There is a link displayed for Sizing Chart

  @PDP @Pilot
  Scenario: PDP Continue Shopping
    Given I am on the PDP Page
    When  I clicked on add to bag button
    Then  modal pop-ed up
    And I am able to click on continue shopping button

  @PDP @Pilot
  Scenario: PDP pricing
    Given I am viewing a PDP for a regularly priced product
    When that page is loaded
    Then The product's discounted price is displayed in red font

  @PDP @Pilot
  Scenario: PDP details display
    Given I am on a PDP
    When  The page is loaded
    Then  an accordion style text box is displayed in collapsed state below Add to bag button with the heading Details

  @PDP @Pilot
  Scenario: PDP - User browser back button on PDP
    Given I have accessed the maximized view of a product by clicking the zoom lens icon on the product image on PDP
    When Click on back button
    Then I should go back to the category page(e.g. women page)

  @PDP @Pilot
  Scenario: PDP recommendation containers
    Given I am on the pdp
    When pdp page is opened in front of me
    Then I should be able to add products in the bag

  @PDP @Pilot
  Scenario: PDP recommendation containers
    Given am On the PDP page
    When  I see you may also like this
    Then  I should be able to access the products

  @PDP @Pilot
  Scenario: PDP breadcrumb
    Given I clicked on any product
    When I am on that PDP Page
    Then I am able to see breadcrumb of the respected product links

  @PDP @Pilot
  Scenario: PDP-Verify Image gallery
    Given PDP Page is open
    When product is loaded
    Then thumbnail images are shown vertically at the left in this order

  @PDP @Pilot
  Scenario: PDP - Verify zoom in for product image
    Given I am On PDP page and
    When product is open in front of me
    Then I am able to zoom in the respected image of the product

  @PDP @Pilot
  Scenario: PDP-Verify items added to bag modal cross button
    Given I am on the PDP Page
    When  I clicked on add to bag button
    Then  modal pop up
    And   I am able to click on cross button


  @PDP @Pilot
  Scenario: Then the main large image switched to the one I clicked
    Given I am on the PDP Page
    When I am switching images of the product
    Then I am able to switch the Images
    And I am able to close the Image

  @PDP @Pilot
  Scenario: PDP pricing
    Given PDP Page is open for regular price product
    When product is loaded
    Then Then the product's regular price is displayed in black font

  @PDP @Pilot
  Scenario: PDP-Verify Shipping & Returns
    Given PDP Page is open
    When product is loaded
    Then Shipping & Returns heading is present

  @PDP @Pilot
  Scenario: PDP-Verify Shipping & Returns
    Given PDP Page is open
    When product is loaded
    Then Shipping and returns data should be present

  @PDP @Pilot
  Scenario: PDP-Verify Free shipping is not displayed below fifty dollar amount
    Given I am on the PDP Page
    When  I clicked on add to bag button
    And Value of product is less than fifty dollars
    Then check Shipping charge is applicable

  @PDP @Pilot
  Scenario: Shipping charges
    Given I am on a PDP page
    When I click on Shipping and return
    Then free shipping above fifty dollar message should be available.

  @PDP @Pilot
  Scenario: PDP image gallery
    Given I am viewing the full-screen image gallery from a PDP page
    When i click on of the five thumbnail images
    Then the main large image switched to the one i clicked

  @PDP @Pilot
  Scenario: PDP badging
    Given I am on a PDP
    When the page is load
    Then the badge text with the highest priority for this product is displayed above the product name.

  @PDP @Pilot
  Scenario: Refresh Page After adding product
    Given I have selected a product and added to cart
    When I try to refresh the page
    Then The prices of the product should not be changed











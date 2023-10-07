Feature: cart

  @Cart @Pilot
  Scenario: bag page -item display
    Given  I am on the bag page
    When I have not added products to my bag
    Then I am presented with the message that my bag is currently empty

  @Cart @Pilot
  Scenario: bag page - items display1
    Given I am on the bag page
    When I have added products to my bag
    Then I am shown the prompt Dont miss out! Items in your bag are not held and may be sold.

  @Cart @Pilot
  Scenario: bag page - order summary calculations
    Given I am on the bag page
    When I have added products to my bag and I have not signed in
    Then I am presented the summary calculations of my order, but not the tax value

  @Cart @Pilot
  Scenario: bag page - quantity adjustment
    Given I am on the bag page
    When I select the quantity adjustment dropdown
    Then I am given the option to modify the quantity from one to nine for that item


  @Cart @Pilot
 Scenario: Registered user should have tax displayed
   Given I have logged as a registered user
   When I have added product to the bag
   Then Tax value should be displyed

  @Cart @Pilot
  Scenario:  bag page - quantity restriction errors
    Given I am on the bag page to check quantity restriction
    When an item has a restricted quantity (less than the global restriction of nine) based at the colour or size level.
    Then I cannot select to add more than the maximum allowed quantity of that item in that colour or size (as applicable), but I can add other colour variants of that item in addition.

  @Cart @Pilot
  Scenario: bag page - order summary calculations
    Given I am onn the bag page
    When I have added products to my bag and my order is under $fifty with Discounted Price
    Then I am presented the summary calculations of my order and the shipping costs is shown as $3.99 Discounted

  @Cart @Pilot
  Scenario: bag page - order summary calculations
    Given I am on the bag page- Product without discount
    When I have added products to my bag and my order is under $fifty without Discounted Price
    Then I am presented the summary calculations of my order and the shipping costs is shown as $3.99 (Without Discount)

  @Cart @Pilot
  Scenario: bag page - order summary calculations
    Given I am on the bag page of the product
    When I have added products to my bag and my order is above $fifty
    Then I am presented the summary calculations of my order and the shipping costs is shown as Free

  @Cart @Pilot
  Scenario: bag page - promo code entry (multiple types & error scenarios here)
    Given I am on the bag page
    When I enter a promo code that applies to the item(s) in the bag
    Then the appropriate discount will be applied to the order and displayed in the order summary calculation

  @Cart @Pilot
  Scenario: bag page - promo code entry (multiple types & error scenarios here)
    Given I am on the bag page
    When I enter an invalid promo code
    Then an error message will be displayed The promo code you have entered is invalid or expired


  @Cart
  Scenario: bag page - promo code entry (multiple types & error scenarios here)
    Given I am on the bag page
    When I enter a promo code that applies to the item(s) in the bag
    Then Saving price should be visible

  @Cart
    Scenario: bag page - promo code entry (multiple types & error scenarios here)
      Given I am on the bag page
      When I enter a promo code that applies to the item(s) in the bag
      Then Refresh the page and message should not be changed.


  @Cart @Pilot
  Scenario: bag page - PCO tile states
    Given I am on the bag page
    When I am not signed in and have no items in my bag
    Then tthe PCO tile will not display on the bag page

  @Cart @Pilot
  Scenario: bag page - PCO tile states
    Given I am on the bag page
    When I am not signed in and have items in my bag
    Then the PCO tile will display with the message To earn and redeem PC Optimum™ points, sign in or create an account. as well as offering the options to sign in or to create an account.

  @Cart @Pilot
  Scenario: bag page - PCO tile states2
    Given I am on the bag page
    When I amm signed in and have items in my bag
    Then the PCO tile will display with the message Redeem PC Optimum™ points in checkout. Watch out for personalized offers and points events!

  @Cart @Pilot
  Scenario: bag page - empty bag w/ certona containers
    Given I am on the bag page
    When I have an empty bag
    Then I will see a horizontal carousel of recommended products with the title Perhaps you may like these instead?

  @Cart @Pilot
  Scenario: bag page - continue to checkout
    Given I am on the bag page
    When I have items in my bag
    Then I will see a Checkout CTA on the right of the page under the order summary calculation.

  @Cart @Pilot
  Scenario: Product Selection From slider On PDP
    Given I am on the bag page
    When I click on product from you may like this
    Then I am able to open and add to bag the product from the you may like this Slider.

  @Cart @Pilot
  Scenario: Product Selection From slider On PDP
    Given I am on the bag page
    When I click on product from customer also like this.
    Then I am able to open and add to bag the product from the customer also like this.

  @Cart @Pilot
  Scenario: Cart-Order Summary_shipping amount
    Given I on business site and started check out flow and selected a delivery shipping method
    When I go back to my cart page
    Then I should see the selected shipping fee instead of the standard estimated shipping fee

  @Cart @Pilot
  Scenario: Cart-Order Summary_Price calculation.
    Given I am on the bag page
    When price is calculated
    Then calculated price of the product should be equal to Estimated Price Of the product

  @Cart @Pilot
  Scenario: Cart- Order Tax Calculation Against Product Added in Cart.
    Given I am on the bag pagee
    When price is calculated
    Then HST Tax Value should be calculated as expected

  @Cart @Pilot
  Scenario: Cart-Item count_display -119, 154
    Given I am on the bag page
    When When I click on the Cart page
    Then the item count against the text My Bag should be displayed correctly

  @Cart @Pilot
  Scenario: Cart-Item count_display -120
    Given I am on the bag page
    When When I click on the Cart page
    Then the item count against the text My Bag should be updated correctly based on the items in the cart

  @Cart @Pilot
  Scenario: Cart-Item count_display -121
    Given I am on the bag page
    When When I click on the Cart page
    And I remove the item from cart
    Then the item count against the text My Bag should be updated correctly based on the items in the cart after Removing Item From my Bag

  @Cart @Pilot
  Scenario: Cart - Item display -129
    Given I am on the bag page
    When When I click on the Cart page
    Then I should see the the contents of my cart including item image, Item title, quantities, Style, color and Item Price.


  @Cart @Pilot
  Scenario: Cart- Quantity decrease_shipping check -150,153
    Given I am on the bag page
    When I click on the Bag icon and decrease the quantity such that the order total is below $Fifty
    Then the shipping amount of $3.99 should be applied
    And order summary should be updated

  @Cart @Pilot
  Scenario: Cart sync _GuestCheckout -159
    Given I am on the bag page
    When I enter my email in the guest checkout field email has items earlier in the cart
    Then cart is not synced

    @CartTEST
    Scenario: TestDemo
      Given I am on The Home Page
      When  I add a string
      Then  I should be able to replace the function


























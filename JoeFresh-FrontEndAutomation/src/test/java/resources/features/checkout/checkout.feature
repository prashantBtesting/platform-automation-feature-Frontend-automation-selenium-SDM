Feature: Checkout

  @GuestCheckout
  Scenario: Guest checkout - delivery method selection 161
    Given that I am on the guest checkout page
    When I am on the delivery mode selection step
    Then on click of continue to payment the selected delivery mode is saved and the customer continues to billing address

  @GuestCheckout
  Scenario: Guest checkout - delivery method selection 162
    Given that I am on the guest checkout page
    When I am on the delivery mode selection step
    Then the cost of the selected shipping option is added to the order summary, plus applicable taxes

  @GuestCheckout @Pilot
  Scenario: Guest checkout - delivery method selection 163 and 164
    Given that I am on the guest checkout page
    When I am on the delivery mode selection step
    Then for guest users, or logged-in users with no payment details saved, the billing address is by default set to match the shipping address -box appears checked

  @GuestCheckout @Pilot
  Scenario: Guest checkout - delivery method selection 165
    Given that I am on the guest checkout page
    When I am on the delivery mode selection step
    Then by unselecting the billing same as shipping checkbox, the billing address form will appear

  @GuestCheckout @Pilot
    Scenario: Guest - Checkout Billing Address Entry 170 and 171
      Given that I am on the guest checkout page
      When I am on the billing address entry step
      Then invalid inputs by customer are handled gracefully, show appropriate error messaging, and are recoverable upon valid retry
  @GuestCheckout @Pilot
      Scenario: Guest checkout - billing address entry 173
        Given that I am on the guest checkout page
        When I am on the billing address entry step
        Then after confirming billing address, the credit card details iframe is shown

  @GuestCheckout @Pilot
  Scenario: Guest checkout - order review & placement : 185
    Given that I am on the guest checkout page
    When I am on the billing address entry step
    Then  invalid or empty inputs in credit card fields are handled gracefully, show appropriate error messaging and are recoverable upon valid retry

  @GuestCheckout
    Scenario: Guest checkout - order review and placement : 185-2
      Given that I am on the guest checkout page
      When I am on the credit card form step
      Then the user proceeds to order confirmation page

  @GuestCheckout
      Scenario: Guest checkout - order confirmation : 186
        Given that I am on the guest checkout page
        When I am on the credit card form step and place order
        Then the user should redirect to order confirmation page

  @GuestCheckout @Pilot
  Scenario: Checkout - PCO promo tiles states 195
    Given that I am on cart page
    When I an not signed in and have no items in my bag
    Then the PCO tile will not display on the bag page

  @GuestCheckout @Pilot
  Scenario: Checkout - PCO promo tiles states 196
    Given that I am on cart page with items
    When I an not signed in and have items in my bag
    Then Then the PCO tile will display with the message as well as offering the options to sign in or to create an account.

  @GuestCheckout @Pilot
  Scenario: Guest checkout - delivery method selection 161
    Given that I am on the guest checkout page
    When I attempt to navigate away from the checkout page
    Then  Only the Joe Fresh logo remains at the top of the page on checkout.

    @GuestCheckout @Pilot
    Scenario: GuestCheckout- Item details Display
      Given that I am on cart page with items
      When I click on the the arrow displayed against Items in bag Link
      Then the item details should be dislayed correctly.
      And Items should have the price associated with it.

      @GuestCheckout @Pilot
      Scenario: Guest Checkout - Order Summary
        Given that I am on the guest checkout page
        When I check the order details
         Then order details should be visible with valid total

        @GuestCheckout @Pilot
        Scenario: Guest Checkout - Tax Updated
          Given that I am on the guest checkout page
          When I check the order details
          Then the tax should be update if province change after updating shipping address

          @GuestCheckout
          Scenario: Guest Checkout - Confirmation Page
            Given that I am on the guest checkout page
            When I make successful payment as guest user
            Then details on Order Confirmation should be displayed
  @GuestCheckout @Pilot
  Scenario: Guest checkout - email entry & editing
    Given I am on the bag page
    When When I click to check out from the bag page
    Then Then I will be taken to a sign in page where I can choose to sign in or to enter my email in order to check out as a guest.

  @GuestCheckout @Pilot
  Scenario: Guest checkout - shipping address form
    Given I am on the guest checkout page
    When I enter a valid shipping address and proceed to the next step
    Then my address is displayed in the summary format after proceeding to the next step.

  @GuestCheckout @Pilot
  Scenario: Guest checkout - shipping address form
    Given I am on the guest checkout page
    When I enter a valid shipping address and proceed to the next step
    Then customer can return to step one to edit their address by clicking Edit Address, which re-opens the form with values accurately re-populated in each fied

  @GuestCheckout @Pilot
  Scenario: Guest checkout - delivery method selection
    Given I am on the guest checkout page
    When I am on the delivery mode of selection step
    Then standard shipping is selected by default

  @GuestCheckout @Pilot
  Scenario: Guest checkout - delivery method selection
    Given I am on the guest checkout page
    When I am on the delivery mode of selection step
    Then the customer can select a different delivery mode by clicking anywhere in that option's box, and the previously selected option is deselected (radio button functionality)

  @GuestCheckout @Pilot
  Scenario: Guest checkout - delivery method selection
    Given I am on the guest checkout page
    When I am on the delivery mode of selection step
    Then standard shipping is discounted to free if the bag subtotal exceeds the defined free shipping threshold currently dollar fifty

  @GuestCheckout @Pilot
  Scenario: Guest checkout - shipping address form
    Given I am on the guest checkout page
    When I enter a valid shipping address and proceed to the next step
    Then After entering a valid shipping address in step one, delivery modes are displayed in step two for the customer to choose between

  @GuestCheckout @Pilot
  Scenario:  Guest checkout - shipping address form
    Given I am on the guest checkout page
    When I enter a valid shipping address and proceed to the next step
    Then invalid shipping address inputs by customer are handled gracefully, show appropriate error messaging, and are recoverable upon valid retry

  @GuestCheckout
  Scenario:  Guest checkout - shipping address form
    Given I am on the guest checkout page
    When I enter a valid shipping address and proceed to the next step
    Then change from standred delivery to express delivery

  @AuthCheckout @Pilot
  Scenario: Auth checkout - saved address selection 187
    Given that I am on the logged-in checkout page with saved details
    When I am on the delivery address step and address is displayed in summary format
    Then Customer can return to step to edit their address by clicking Edit Address, which re-opens the form with values accurately re-populated in each field

  @AuthCheckout @Pilot
  Scenario: Auth checkout - saved address selection 188,189 and 191
    Given that I am on the logged-in checkout page with saved details
    When I am on the delivery address step and address is displayed in summary format
    Then  invalid shipping address inputs by customer are handled gracefully, show appropriate error messaging, and are recoverable upon valid retry

  @AuthCheckout @Pilot
  Scenario: Auth checkout - saved address selection : 192
    Given that I am on the logged-in checkout page with saved details
    When I am on the delivery address step and address is displayed in summary format
    Then In the case of multiple saved addresses, and the first one is selected by default.
    And User can opt to Add a new address, in which case the saved addresses are replaced with the form to add a new address.

  @AuthCheckout @Pilot
  Scenario: Auth checkout - saved address selection : 192
    Given that I am on the logged-in checkout page with saved details
    When I am on the delivery address step and address is displayed in summary format
    Then user with addresses saved to account can select from saved addresses and proceed successfully to next step with the saved address applied to their order

  @AuthCheckout @Pilot
  Scenario: Auth checkout - saved address selection : 165 and 167
    Given that I am on the logged-in checkout page with saved details
    When I am on the delivery address step and address is displayed in summary format
    Then for logged-in users with one or more saved payment cards, saved cards are listed with radio button selection

  @AuthCheckout @Pilot
  Scenario: Auth checkout - saved address selection : 168
    Given that I am on the logged-in checkout page with saved details
    When I am on the delivery address step and address is displayed in summary format
    Then the customer can select add a new card, which follows same path as if the customer did not have any saved cards (starts with defaulting billing address to shipping address)

  @AuthCheckout
  Scenario: Auth checkout - saved address selection :  169
    Given that I am on the logged-in checkout page with saved details
    When I am on the delivery address step and address is displayed in summary format
    Then the customer can select cancel button to return to select from one of their saved payment cards at card details step
    And the customer can select cancel button to return to select from one of their saved payment cards at billing address step

  @AuthCheckout
  Scenario: Signed In Checkout - order confirmation : 186
    Given that I am on the logged-in checkout page with saved details
    When I am on the saved details form step and place order
    Then the user should redirect to order confirmation page

  @AuthCheckout @Pilot
  Scenario: Checkout - PCO promo tiles states 196
    Given that I am on cart page
    When I am signed in and have no items in my bag
    Then the PCO tile will not display on the bag page

  @AuthCheckout @Pilot
  Scenario: Checkout - PCO promo tiles states 197
    Given that I am on cart page
    When I am signed in and have items in my bag
    Then Then the PCO tile will display with the message to redee.

  @AuthCheckout
  Scenario: Registered User- Saved billing address & PCO points above 10K 327
    Given that I am on logged-in checkout page
    When  I click on checkout, enter shipping address & select delivery method
    Then PCO tile to select PCO points should be displayed along with the saved card & billing address

  @AuthCheckout
  Scenario: Save the shipping address in Account
    Given that I am on the logged-in checkout page with saved details
    When I click save the address checkbox.
    Then the address should be saved in Shipping Address on My Account

  @AuthCheckout
  Scenario: Registered User- Unsaved Card details & PCO points above 10K 329
    Given that I am on logged-in checkout page
    When  I click on checkout, enter shipping address & select delivery method
    Then PCO tile to select the PCO points should be displayed & I need to enter my card details

  @AuthCheckout
  Scenario: Registered User- Order with loyalty points & card 341
    Given that I am on logged-in checkout page
    When  I click on checkout, enter shipping address & select delivery method
    Then Place order with loyalty points & card

  @AuthCheckout
  Scenario: Registered User- Saved billing address & PCO points below 10K 328
    Given that I am on logged-in with test user and I am in checkout page
    When  I click on checkout, enter shipping details & select delivery method
    Then PCO tile is displayed which indicates I don't have sufficient points along with the saved card & billing address

  @AuthCheckout
  Scenario: Registered User- Unsaved card details & PCO points below 10K 330
    Given that I am on logged-in with test user and I am in checkout page
    When  I click on checkout, enter shipping details & select delivery method
    Then PCO tile is displayed which indicates I dont have sufficient points & I need to enter my card details

  @AuthCheckout
  Scenario: Checkout- Adding duplicate card on checkout 339
    Given that I have entered a payment method on the checkout I am on logged-in checkout page & have the same method already saved to my account
    When  I click Place Order
    Then Order is successfully placed, and I am not able to save the same card again to my account




























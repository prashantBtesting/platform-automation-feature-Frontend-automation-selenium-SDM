Feature: Account Profile

  @Account @Pilot
  Scenario: Shipping Addresses - view saved
    Given I am on the Shipping Addresses page and have purchased from JF
    When the page loads
    Then I see tiles of addresses that I have saved from previous orders with options to remove and edit
    @Account @Pilot
  Scenario: Shipping Addresses - add new address 211
      Given I am on the Shipping Addresses page and have purchased from JF
      When the page loads
      Then I select the Add new address tab & I land on a page to input my address, save it, or cancel
  @Account @Pilot
  Scenario: Shipping Addresses - add new address 213
        Given I am on the Shipping Addresses page and have purchased from JF
        When I select the matching address from Address Select
        Then remaining address section is populated

  @Account @Pilot
  Scenario: Shipping Addresses - add new address 214
    Given I am on the Shipping Addresses page and have purchased from JF
    When I select the matching address not available in Address Select
    Then Then address is added anyways
  @Account @Pilot
  Scenario: Shipping Addresses - delete address
    Given I am on the Shipping Addresses page and have purchased from JF
    When I select the remove link below a given address
    Then click remove button then the address disappears in the list of saved address and a notification appears at the top of the list to confirm the address has been removed
    And can exit the notification
  @Account @Pilot
  Scenario: Shipping Addresses - add new address 212
    Given I am on the Shipping Addresses page and have purchased from JF
    When I add a new address
    Then the address appears in the list of saved address
    And a notification appears at the top of the list to confirm a new address has been added
    And can exit the notification
  @Account @Pilot
  Scenario: Shipping Addresses - add new address 215
    Given I am on the Shipping Addresses page and have purchased from JF
    When I attempt to enter add new address and fill invalid details
    Then Then there is a message that appears to notifiy the customer to fill it out.
  @Account @Pilot
  Scenario: Shipping Addresses - add new address 216
    Given I am on the Shipping Addresses page and have purchased from JF
    When When I select the Edit address link below a given address
    Then I am presented with the address page where I can edit my address, save it or cancel the changes
    And edited address should be available on the card
  @Account @Pilot
  Scenario: Shipping Addresses - delete address -217
    Given I am on the Shipping Addresses page and have purchased from JF
    When  I select the remove link below a given address
    Then a prompt appears to confirm or decline the address deletion
    And clicking cancel will remove the modal

  @Account
  Scenario: Payment Methods - display saved cards 219
        Given I am on the Payment Info tab
        When the Payment page loads
      Then I am presented with the list of cards I have saved from previous JF orders, including the card company, cardholder name, last four digits of credit card and expiry date and I also have the option to add a new card and remove saved cards
  @Account
  Scenario: Payment Methods - add new card 223
    Given I am on the Payment Info tab
    When I select Add New card
    Then I am presented with an option to add a billing address and then continue to enter credit card info
  @Account
  Scenario: Payment Methods - add new card 224
    Given I am on the Payment Info tab
    When I select Add New card
    Then while filling invalid details in cardNumber section, it should display the error message
  @Account
  Scenario: Payment Methods - add new card 225
    Given I am on the Payment Info tab
    When I select Add New card
    Then while filling valid details in cardNumber section, it should display the success message
  @Account
  Scenario: Payment Methods - remove card 226
    Given I am on the Payment Info tab
    When I select remove credit card
    Then I am presented a pop up asking to confirm or cancel the credit card removal
  @Account
  Scenario: Payment Methods - remove card 227
      Given I am on the Payment Info tab
      When I select remove credit card
      Then I click remove card button and message should
  @Account
  Scenario: order history - detail view
        Given I am in the Order history tab and have ordered from JF
        When I select the order number
        Then the page reloads to a full page view of the order detail
  @Account
  Scenario: order history - detail view -243
          Given I am in the Order history tab and have ordered from JF
          When I select the images of the product from details page
          Then it links to the product detail page in the same tab
  @Account
    Scenario: order history - detail view - 244 and 245
      Given I am in the Order history tab and have ordered from JF
      When I select Returns and Exchange Policy or FAQ pages
      Then I will land on the respecitive information pages
  @Account @Pilot
      Scenario: Manage PCID account
        Given I am on the Shipping Addresses page and have purchased from JF
        When I select Manage your PC ID account
        Then I will land on the PC id Account page

    @Account @Pilot
    Scenario: Shipping Addresses - empty state
      Given I am on the Shipping Addresses page and have no addresses saved
      When the page loads
      Then I see a No saved addresses and a button to prompt that allows me to add an address

      @Account @Pilot
      Scenario: Payment Cards - empty state
        Given I am on the Payment Cards page and have no cards saved
        When the Payment page loads
        Then I see a No saved cards and a button to prompt that allows me to add a card

















































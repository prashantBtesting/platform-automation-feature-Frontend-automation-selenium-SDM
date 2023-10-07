package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.Log;
import utils.TestContextSetup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheckoutStepDefinition {
    TestContextSetup tcs;

    public CheckoutStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("that I am on the guest checkout page")
    public void thatIAmOnTheGuestCheckoutPage() {
        tcs.pom.getNavigation().navigatingSanity();
        tcs.pom.getPlp().addTheItemToCart();
        Assert.assertTrue(tcs.pom.getPlp().itemAddedToCart());
        tcs.pom.getPlp().clickViewBagButton();
    }

    @When("I am on the delivery mode selection step")
    public void iAmOnTheDeliveryModeSelectionStep() throws IOException {
        tcs.pom.getCart().navigateToGuestCheckout();
        tcs.pom.getCart().enterShippingDetails();
        tcs.pom.getCheckout().selectDefaultDeliveryMode();
    }

    @Then("on click of continue to payment the selected delivery mode is saved and the customer continues to billing address")
    public void onClickOfContinueToPaymentTheSelectedDeliveryModeIsSavedAndTheCustomerContinuesToBillingAddress() {
        Assert.assertTrue(tcs.pom.getCheckout().validateBillingAddress());
    }

    @Then("for guest users, or logged-in users with no payment details saved, the billing address is by default set to match the shipping address -box appears checked")
    public void forGuestUsersOrLoggedInUsersWithNoPaymentDetailsSavedTheBillingAddressIsByDefaultSetToMatchTheShippingAddressBoxAppearsChecked() {
        Assert.assertTrue(tcs.pom.getCheckout().validateSameAsBillingAddress());
        Assert.assertTrue(tcs.pom.getCheckout().validateShippingAndBillingAddress());
    }

    @Then("the cost of the selected shipping option is added to the order summary, plus applicable taxes")
    public void theCostOfTheSelectedShippingOptionIsAddedToTheOrderSummaryPlusApplicableTaxes() {
        Assert.assertTrue(tcs.pom.getCheckout().validateShippingPrice());
        Assert.assertTrue(tcs.pom.getCheckout().validateTaxes());
    }

    @Then("by unselecting the billing same as shipping checkbox, the billing address form will appear")
    public void byUnselectingTheBillingSameAsShippingCheckboxTheBillingAddressFormWillAppear() {
        Assert.assertTrue(tcs.pom.getCheckout().validateBillingFormDisplayed());
    }

    @When("I am on the billing address entry step")
    public void iAmOnTheBillingAddressEntryStep() throws IOException {
        tcs.pom.getCart().navigateToGuestCheckout();
        tcs.pom.getCart().enterShippingDetails();
        tcs.pom.getCheckout().selectDefaultDeliveryMode();
    }

    @Then("invalid inputs by customer are handled gracefully, show appropriate error messaging, and are recoverable upon valid retry")
    public void invalidInputsByCustomerAreHandledGracefullyShowAppropriateErrorMessagingAndAreRecoverableUponValidRetry() {
        Assert.assertTrue(tcs.pom.getCheckout().emptySubmitBillingAddress());
        Assert.assertTrue(tcs.pom.getCheckout().validateInvalidEntry());
        Assert.assertTrue(tcs.pom.getCheckout().invalidCharacterEntry());
    }

    @Then("after confirming billing address, the credit card details iframe is shown")
    public void afterConfirmingBillingAddressTheCreditCardDetailsIframeIsShown() throws InterruptedException {
        tcs.pom.getCheckout().enterBillingAddressDetails();
        Assert.assertTrue(tcs.pom.getCheckout().validateCardFormVisible());
    }

    @Then("invalid or empty inputs in credit card fields are handled gracefully, show appropriate error messaging and are recoverable upon valid retry")
    public void invalidOrEmptyInputsInCreditCardFieldsAreHandledGracefullyShowAppropriateErrorMessagingAndAreRecoverableUponValidRetry() throws InterruptedException {
        // tcs.pom.getCheckout().enterBillingAddressDetails();
        Assert.assertTrue(tcs.pom.getCheckout().emptySubmitCardForm());
        Assert.assertTrue(tcs.pom.getCheckout().invalidCreditCardFormDetails());
    }

    @When("I am on the credit card form step")
    public void iAmOnTheCreditCardFormStep() throws IOException, InterruptedException {
        tcs.pom.getCart().navigateToGuestCheckout();
        tcs.pom.getCart().enterShippingDetails();
        tcs.pom.getCheckout().selectDefaultDeliveryMode();
        tcs.pom.getCheckout().proceedToPayment();
        tcs.pom.getCheckout().submitCardDetails();
    }

    @Then("the user proceeds to order confirmation page")
    public void theUserProceedsToOrderConfirmationPage() throws InterruptedException {
        tcs.base.driver.switchTo().defaultContent();
        Thread.sleep(3000);
        Assert.assertTrue(tcs.pom.getCheckout().validateCardDetailsSubmitted());
    }

    @When("I am on the credit card form step and place order")
    public void iAmOnTheCreditCardFormStepAndPlaceOrder() throws IOException, InterruptedException {
        tcs.pom.getCart().navigateToGuestCheckout();
        tcs.pom.getCart().enterShippingDetails();
        tcs.pom.getCheckout().selectDefaultDeliveryMode();
        tcs.pom.getCheckout().directToPayment();
    }

    @Then("the user should redirect to order confirmation page")
    public void theUserShouldRedirectToOrderConfirmationPage() {
        Assert.assertTrue(tcs.pom.getCheckout().validateOrderSuccess());
    }

    @When("I am on the delivery address step and address is displayed in summary format")
    public void iAmOnTheDeliveryAddressStepAndAddressIsDisplayedInSummaryFormat() {
        tcs.pom.getCart().authCheckout();

    }

    @Given("that I am on the logged-in checkout page")
    public void thatIAmOnTheLoggedInCheckoutPage() throws IOException {
        tcs.pom.getAuth().signInWithNoSavedDetails();
        tcs.pom.getAuth().validateSignedIn();
        if (tcs.pom.getCart().returnCartProductsNumber() >= 1) {
            tcs.pom.getHeader().clickMyBag();
        } else {
            tcs.pom.getNavigation().navigatingSanity();
            tcs.pom.getPlp().visitPdp();
            tcs.pom.getPdpPage().itemAddToCart();
        }
    }


    @Then("Customer can return to step to edit their address by clicking Edit Address, which re-opens the form with values accurately re-populated in each field")
    public void customerCanReturnToStepToEditTheirAddressByClickingEditAddressWhichReOpensTheFormWithValuesAccuratelyRePopulatedInEachField() {
        Assert.assertTrue(tcs.pom.getCheckout().validateEditAddressButton());
        Assert.assertTrue(tcs.pom.getCheckout().validateSaveShippingAddress());
    }

    @Then("invalid shipping address inputs by customer are handled gracefully, show appropriate error messaging, and are recoverable upon valid retry")
    public void invalidShippingAddressInputsByCustomerAreHandledGracefullyShowAppropriateErrorMessagingAndAreRecoverableUponValidRetry() {
        Assert.assertTrue(tcs.pom.getCheckout().emptySubmissionShippingDetails());
        Assert.assertTrue(tcs.pom.getCheckout().invalidShippingDetailsEntry());
    }

    @Then("In the case of multiple saved addresses, and the first one is selected by default.")
    public void inTheCaseOfMultipleSavedAddressesAndTheFirstOneIsSelectedByDefault() {
        Assert.assertTrue(tcs.pom.getCheckout().validateSavedAddressSelection());

    }

    @And("User can opt to Add a new address, in which case the saved addresses are replaced with the form to add a new address.")
    public void userCanOptToAddANewAddressInWhichCaseTheSavedAddressesAreReplacedWithTheFormToAddANewAddress() {
        Assert.assertTrue(tcs.pom.getCheckout().validateNewAddressCanBeFilled());
    }

    @Then("user with addresses saved to account can select from saved addresses and proceed successfully to next step with the saved address applied to their order")
    public void userWithAddressesSavedToAccountCanSelectFromSavedAddressesAndProceedSuccessfullyToNextStepWithTheSavedAddressAppliedToTheirOrder() {
        tcs.pom.getCheckout().selectDefaultAddress();
        Assert.assertTrue(tcs.pom.getCheckout().validateShippingAddressDetailsSubmitted());
    }

    @Then("for logged-in users with one or more saved payment cards, saved cards are listed with radio button selection")
    public void forLoggedInUsersWithOneOrMoreSavedPaymentCardsSavedCardsAreListedWithRadioButtonSelection() {
        tcs.pom.getCheckout().selectDefaultAddress();
        tcs.pom.getCheckout().selectDefaultDeliveryMode();
        Assert.assertTrue(tcs.pom.getCheckout().validateSavedCards());
    }

    @Then("the customer can select add a new card, which follows same path as if the customer did not have any saved cards \\(starts with defaulting billing address to shipping address)")
    public void theCustomerCanSelectAddANewCardWhichFollowsSamePathAsIfTheCustomerDidNotHaveAnySavedCardsStartsWithDefaultingBillingAddressToShippingAddress() {
        tcs.pom.getCheckout().selectDefaultAddress();
        tcs.pom.getCheckout().selectDefaultDeliveryMode();
        Assert.assertTrue(tcs.pom.getCheckout().validateAddANewCard());
    }

    @Then("the customer can select cancel button to return to select from one of their saved payment cards at card details step")
    public void theCustomerCanSelectCancelButtonToReturnToSelectFromOneOfTheirSavedPaymentCardsAtCardDetailsStep() throws InterruptedException {
        tcs.pom.getCheckout().selectDefaultAddress();
        tcs.pom.getCheckout().selectDefaultDeliveryMode();
        Assert.assertTrue(tcs.pom.getCheckout().validateCancelPaymentSectionAfterPaymentDetails());
    }

    @And("the customer can select cancel button to return to select from one of their saved payment cards at billing address step")
    public void theCustomerCanSelectCancelButtonToReturnToSelectFromOneOfTheirSavedPaymentCardsAtBillingAddressStep() {
        //Assert.assertTrue(tcs.pom.getCheckout().validateCancelPaymentSectionAfterBillingDetails());
    }

    @Given("that I am on cart page")
    public void thatIAmOnCartPage() {
        tcs.pom.getHeader().clickMyBag();
    }

    @When("I an not signed in and have no items in my bag")
    public void iAnNotSignedInAndHaveNoItemsInMyBag() {
        tcs.pom.getHeader().clickMyBag();
    }

    @Then("the PCO tile will not display on the bag page")
    public void thePCOTileWillNotDisplayOnTheBagPage() {
        Assert.assertTrue(tcs.pom.getCart().pcOptimumNoItemInCart());
    }

    @When("I an not signed in and have items in my bag")
    public void iAnNotSignedInAndHaveItemsInMyBag() {
        tcs.pom.getNavigation().navigatingSanity();
        tcs.pom.getPlp().addTheItemToCart();
        Assert.assertTrue(tcs.pom.getPlp().itemAddedToCart());
        tcs.pom.getPlp().clickViewBagButton();
    }

    @Then("Then the PCO tile will display with the message as well as offering the options to sign in or to create an account.")
    public void thenThePCOTileWillDisplayWithTheMessageAsWellAsOfferingTheOptionsToSignInOrToCreateAnAccount() {
        //tcs.pom.getHeader().clickMyBag();
        Assert.assertTrue(tcs.pom.getCart().pcOptimumGuest());
    }

    @When("I am signed in and have no items in my bag")
    public void iAmSignedInAndHaveNoItemsInMyBag() throws IOException {
       tcs.pom.getAuth().navigateFromCartPage();
        //tcs.pom.getHeader().clickMyBag();
        Assert.assertTrue(tcs.pom.getCart().pcOptimumNoItemInCart());


    }

    @When("I am signed in and have items in my bag")
    public void iAmSignedInAndHaveItemsInMyBag() throws IOException {
        tcs.pom.getAuth().navigateFromCartPage();
        if (tcs.pom.getCart().returnCartItemSize()<1) {
            tcs.pom.getNavigation().navigatingSanity();
            tcs.pom.getPlp().addTheItemToCart();
            Assert.assertTrue(tcs.pom.getPlp().itemAddedToCart());
            tcs.pom.getPlp().clickViewBagButton();
        }
    }

    @Then("Then the PCO tile will display with the message to redee.")
    public void thenThePCOTileWillDisplayWithTheMessageToRedee() {
        Assert.assertTrue(tcs.pom.getCart().pcOptimumCardAuth());
    }

    @When("I attempt to navigate away from the checkout page")
    public void iAttemptToNavigateAwayFromTheCheckoutPage() throws IOException {
        //tcs.pom.getHeader().clickMyBag();
        tcs.pom.getCart().navigateToGuestCheckout();
    }

    @Then("Only the Joe Fresh logo remains at the top of the page on checkout.")
    public void onlyTheJoeFreshLogoRemainsAtTheTopOfThePageOnCheckout() {
        Assert.assertTrue(tcs.pom.getCheckout().headerOnlyLogo());
    }

    @Given("that I am on the logged-in checkout page with saved details")
    public void thatIAmOnTheLoggedInCheckoutPageWithSavedDetails() throws IOException, InterruptedException {
        tcs.pom.getAuth().signInWithSavedDetails();
        tcs.pom.getAuth().validateSignedIn();
        //Log.info("Cart Number: "+tcs.pom.getCart().returnCartAmount());
        if (tcs.pom.getCart().returnCartProductsNumber() >= 1) {
            tcs.pom.getHeader().clickMyBag();
            Thread.sleep(1000);
        } else {
            tcs.pom.getNavigation().navigatingSanity();
            tcs.pom.getPlp().addTheItemToCart();
            Assert.assertTrue(tcs.pom.getPlp().itemAddedToCart());
            tcs.pom.getPlp().clickViewBagButton();
        }
    }

    @When("I am on the saved details form step and place order")
    public void iAmOnTheSavedDetailsFormStepAndPlaceOrder() {
        tcs.pom.getCart().authCheckout();
        tcs.pom.getCheckout().loginSavedInformationCheckout();
    }

    @When("I click save the address checkbox.")
    public void iClickSaveTheAddressCheckbox() throws IOException, InterruptedException {
        tcs.pom.getCart().authCheckout();
        tcs.pom.getCheckout().clickAddANewAddress();
        tcs.pom.getCheckout().fillShippingAddressAuth();
    }

    @Then("the address should be saved in Shipping Address on My Account")
    public void theAddressShouldBeSavedInShippingAddressOnMyAccount() throws IOException, InterruptedException {
        String shippingAddress=tcs.pom.getCheckout().returnShippingAddressSelectedOrAdded();
        tcs.pom.getCheckout().selectDefaultDeliveryMode();
        tcs.pom.getCheckout().proceedToPayment();
        tcs.pom.getCheckout().directToPayment();
        Assert.assertTrue(tcs.pom.getCheckout().validateOrderSuccess());
        tcs.pom.getMyAccount().navigateToMyAccount();
        tcs.pom.getMyAccount().navigateToShipping();
        Assert.assertTrue(tcs.pom.getMyAccount().savedShippingAddressOnMyAccount(shippingAddress));
    }

    @When("I click on the the arrow displayed against Items in bag Link")
    public void iClickOnTheTheArrowDisplayedAgainstItemsInBagLink() {
        tcs.pom.getNavigation().navigatingSanity();
        tcs.pom.getPlp().addTheItemToCart();
        Assert.assertTrue(tcs.pom.getPlp().itemAddedToCart());
        tcs.pom.getPlp().clickViewBagButton();

    }

    @Then("the item details should be dislayed correctly.")
    public void theItemDetailsShouldBeDislayedCorrectly() {
        //tcs.pom.getHeader().clickMyBag();
        List<String> cartProductImage=tcs.pom.getCart().validateitemsOnOrderSummaryProducts();
        Log.info("Cart:"+cartProductImage);
        tcs.pom.getCart().navigateToGuestCheckout();
        List<String> checkOutUserSummary=tcs.pom.getCheckout().validateItemsOnCheckout();
        Log.info("Checkout: "+checkOutUserSummary);
        Assert.assertEquals(cartProductImage,checkOutUserSummary);
    }
    @And("Items should have the price associated with it.")
    public void itemsShouldHaveThePriceAssociatedWithIt() {
        Assert.assertTrue(tcs.pom.getCheckout().validateAmount());
    }
    @Given("that I am on cart page with items")
    public void thatIAmOnCartPageWithItems() {

    }
    @When("I check the order details")
    public void iCheckTheOrderDetails() {
        //tcs.pom.getHeader().clickMyBag();
        tcs.pom.getCart().navigateToGuestCheckout();
    }
    @Then("order details should be visible with valid total")
    public void orderDetailsShouldBeVisibleWithValidTotal() throws IOException {
        tcs.pom.getCart().enterShippingDetails();
        tcs.pom.getCheckout().selectDefaultDeliveryMode();
        Assert.assertTrue(tcs.pom.getCheckout().validateTotal());
    }
    @Then("the tax should be update if province change after updating shipping address")
    public void theTaxShouldBeUpdateIfProvinceChangeAfterUpdatingShippingAddress() throws IOException, InterruptedException {
        tcs.pom.getCart().shippingDetailsWithoutSave();
        String provinceBeforeEdit=tcs.pom.getCheckout().returnProvince();
        tcs.pom.getCheckout().proceedToDelivery();
        //tcs.pom.getCheckout().selectDefaultDeliveryMode();
        ArrayList<String> taxesBeforeEdit=tcs.pom.getCheckout().returnTax();
        Log.info("Tax Before Edit "+taxesBeforeEdit);
        tcs.pom.getCheckout().clickEditAddress();
        tcs.pom.getCheckout().editAddressWithNewAddress();
        String provinceAfterEdit=tcs.pom.getCheckout().returnProvince();
        tcs.pom.getCheckout().proceedToDelivery();
        ArrayList<String> taxesAfterEdit=tcs.pom.getCheckout().returnTax();
        Log.info("Tax After Edit: "+taxesAfterEdit);
        if(!provinceBeforeEdit.equals(provinceAfterEdit)){
            Assert.assertNotEquals(taxesBeforeEdit,taxesAfterEdit);
        }
        else {
            Assert.assertEquals(provinceBeforeEdit,provinceAfterEdit);
        }
    }

    @When("I make successful payment as guest user")
    public void iMakeSuccessfulPaymentAsGuestUser() throws IOException {
        //tcs.pom.getHeader().clickMyBag();
        tcs.pom.getCart().navigateToGuestCheckout();
        tcs.pom.getCart().enterShippingDetails();
        tcs.pom.getCheckout().selectDefaultDeliveryMode();

    }

    @Then("details on Order Confirmation should be displayed")
    public void detailsOnOrderConfirmationShouldBeDisplayed() throws IOException, InterruptedException {
       // HashMap<String,String> orderSummary=tcs.pom.getCheckout().getOrderMap();
        //Log.info("Order Summary: "+orderSummary);
        tcs.pom.getCheckout().directToPayment();
        Assert.assertTrue(tcs.pom.getCheckout().orderConfirmationId());
        Assert.assertTrue(tcs.pom.getCheckout().verifyCreatePcId());
        Assert.assertTrue(tcs.pom.getCheckout().verifyContinueShopping());
    }

    @Given("that I am on logged-in checkout page")
    public void that_i_am_on_logged_in_checkout_page() throws IOException, InterruptedException {
        tcs.pom.getAuth().sigInWithPCODetails();
        tcs.pom.getAuth().validateSignedIn();
        if (tcs.pom.getCart().returnCartProductsNumber() >= 1) {
            tcs.pom.getHeader().clickMyBag();
        } else {
            tcs.pom.getNavigation().navigateToCategory();
            tcs.pom.getPlp().visitPdp();
            tcs.pom.getPdpPage().itemAddToCart();
        }
    }

    @When("I click on checkout, enter shipping address & select delivery method")
    public void i_click_on_checkout_enter_shipping_address_select_delivery_method() throws IOException {
        tcs.pom.getCart().authCheckout();
        tcs.pom.getCheckout().continueToDelivery();
        tcs.pom.getCheckout().selectDefaultDeliveryMode();
    }

    @Then("PCO tile to select PCO points should be displayed along with the saved card & billing address")
    public void pco_tile_to_select_pco_points_should_be_displayed_along_with_the_saved_card_billing_address() {
        Assert.assertTrue(tcs.pom.getCheckout().selectPCO());
    }

    @Then("PCO tile to select the PCO points should be displayed & I need to enter my card details")
    public void pcoTileToSelectThePCOPointsShouldBeDisplayedINeedToEnterMyCardDetails() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getCheckout().selectPCO());
        tcs.pom.getCheckout().cardDetails();
    }
    @Then("Place order with loyalty points & card")
    public void placeOrderWithLoyaltyPointsCard() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getCheckout().selectPCO());
        tcs.pom.getCheckout().selectPCOPoints();
        Assert.assertTrue(tcs.pom.getCheckout().thankYouOrder());
    }

    @Given("that I am on logged-in with test user and I am in checkout page")
    public void that_i_am_on_logged_in_with_test_user_and_i_am_in_checkout_page() throws IOException, InterruptedException {
        tcs.pom.getAuth().sigInWithTestDetails();
        tcs.pom.getAuth().validateSignedIn();
        if (tcs.pom.getCart().returnCartProductsNumber() >= 1) {
            tcs.pom.getHeader().clickMyBag();
        } else {
            tcs.pom.getNavigation().navigateToCategory();
            tcs.pom.getPlp().visitPdp();
            tcs.pom.getPdpPage().itemAddToCart();
        }
    }

    @When("I click on checkout, enter shipping details & select delivery method")
    public void i_click_on_checkout_enter_shipping_details_select_delivery_method() {
        tcs.pom.getCart().authCheckout();
        tcs.pom.getCheckout().continueToDelivery();
        tcs.pom.getCheckout().selectDefaultDeliveryMode();
    }

    @Then("PCO tile is displayed which indicates I don't have sufficient points along with the saved card & billing address")
    public void pco_tile_is_displayed_which_indicates_i_don_t_have_sufficient_points_along_with_the_saved_card_billing_address() {
        Assert.assertTrue(tcs.pom.getCheckout().noPCO());
    }

    @Then("PCO tile is displayed which indicates I dont have sufficient points & I need to enter my card details")
    public void pcoTileIsDisplayedWhichIndicatesIDontHaveSufficientPointsINeedToEnterMyCardDetails() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getCheckout().noPCO());
        tcs.pom.getCheckout().billingAddressCheckbox();
    }
    @Given("that I have entered a payment method on the checkout I am on logged-in checkout page & have the same method already saved to my account")
    public void that_i_have_entered_a_payment_method_on_the_checkout_i_am_on_logged_in_checkout_page_have_the_same_method_already_saved_to_my_account() throws IOException, InterruptedException {
        tcs.pom.getAuth().sigInWithPCODetails();
        tcs.pom.getAuth().validateSignedIn();
        if (tcs.pom.getCart().returnCartProductsNumber() >= 1) {
            tcs.pom.getHeader().clickMyBag();
        } else {
            tcs.pom.getNavigation().navigateToCategory();
            tcs.pom.getPlp().addTheItemToCart();
            Assert.assertTrue(tcs.pom.getPlp().itemAddedToCart());
            tcs.pom.getPlp().clickViewBagButton();
        }
        tcs.pom.getCart().authCheckout();
        tcs.pom.getCheckout().continueToDelivery();
        tcs.pom.getCheckout().selectDefaultDeliveryMode();
    }

    @When("I click Place Order")
    public void i_click_place_order() throws InterruptedException {
        tcs.pom.getCheckout().duplicateCard();
    }

    @Then("Order is successfully placed, and I am not able to save the same card again to my account")
    public void order_is_successfully_placed_and_i_am_not_able_to_save_the_same_card_again_to_my_account() {
        Assert.assertTrue(tcs.pom.getCheckout().thankYouOrder());
        tcs.pom.getCheckout().shopping();
        if (tcs.pom.getCart().returnCartProductsNumber() >= 1) {
            tcs.pom.getHeader().clickMyBag();
        } else {
            tcs.pom.getNavigation().navigatingSanity();
            tcs.pom.getPlp().visitPdp();
            tcs.pom.getPdpPage().itemAddToCart();
        }
        tcs.pom.getCart().authCheckout();
        tcs.pom.getCheckout().continueToDelivery();
        tcs.pom.getCheckout().selectDefaultDeliveryMode();
    }
}

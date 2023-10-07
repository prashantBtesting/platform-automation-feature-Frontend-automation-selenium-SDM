package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.TestContextSetup;

import java.io.IOException;

public class AccountStepDefinition {
    TestContextSetup tcs;
    public AccountStepDefinition(TestContextSetup tcs)  {
     this.tcs=tcs;
    }
    @Given("I am on the Shipping Addresses page and have purchased from JF")
    public void iAmOnTheShippingAddressesPageAndHavePurchasedFromJF() throws IOException {
        tcs.pom.getAuth().signInWithSavedDetails();
    }
    @When("the page loads")
    public void thePageLoads() {
        tcs.pom.getMyAccount().navigateToShipping();
    }
    @Then("I see tiles of addresses that I have saved from previous orders with options to remove and edit")
    public void iSeeTilesOfAddressesThatIHaveSavedFromPreviousOrdersWithOptionsToRemoveAndEdit() {
        Assert.assertTrue(tcs.pom.getMyAccount().validateAllAddressVisibleWithEditAndRemove());
    }

    @Then("I select the Add new address tab & I land on a page to input my address, save it, or cancel")
    public void iSelectTheAddNewAddressTabILandOnAPageToInputMyAddressSaveItOrCancel() {
        Assert.assertTrue(tcs.pom.getMyAccount().validateAddNewAddressAccountsPage());
    }

    @When("I select the matching address from Address Select")
    public void iSelectTheMatchingAddress() {
        tcs.pom.getMyAccount().navigateToShipping();
    }

    @Then("remaining address section is populated")
    public void remainingAddressSectionIsPopulated() throws IOException, InterruptedException {
        tcs.pom.getMyAccount().validateAddNewAddressAccountsPage();
        Assert.assertTrue(tcs.pom.getMyAccount().validateAddressAddedFromAddressComplete());
    }

    @When("I select the matching address not available in Address Select")
    public void iSelectTheMatchingAddressNotAvailableInAddressSelect() throws IOException, InterruptedException {
        tcs.pom.getMyAccount().navigateToShipping();
        tcs.pom.getMyAccount().validateAddNewAddressAccountsPage();
        tcs.pom.getMyAccount().validateAddressNotFromAddressComplete();
    }

    @Then("Then address is added anyways")
    public void thenAddressIsAddedAnyways() {
        Assert.assertTrue(tcs.pom.getMyAccount().validateAddressSaved());
    }

    @When("I add a new address")
    public void iAddANewAddress() {
        tcs.pom.getMyAccount().navigateToShipping();
    }

    @Then("the address appears in the list of saved address")
    public void theAddressAppearsInTheListOfSavedAddress() throws IOException, InterruptedException {
       tcs.pom.getMyAccount().addNewAddress();
    }

    @And("a notification appears at the top of the list to confirm a new address has been added")
    public void aNotificationAppearsAtTheTopOfTheListToConfirmANewAddressHasBeenAdded() {
        Assert.assertTrue(tcs.pom.getMyAccount().validateAddressSaved());
    }

    @And("can exit the notification")
    public void canExitTheNotification() {
        Assert.assertTrue(tcs.pom.getMyAccount().validateCloseButtonNotification());
    }

    @When("I attempt to enter add new address and fill invalid details")
    public void iAttemptToEnterAddNewAddressAndFillInvalidDetails() {
        tcs.pom.getMyAccount().navigateToShipping();
        tcs.pom.getMyAccount().validateAddNewAddressAccountsPage();
        tcs.pom.getMyAccount().fillInvalidShippingDetails();
    }

    @Then("Then there is a message that appears to notifiy the customer to fill it out.")
    public void thenThereIsAMessageThatAppearsToNotifiyTheCustomerToFillItOut() {
        Assert.assertTrue(tcs.pom.getMyAccount().validateErrorMessages());
    }

    @When("When I select the Edit address link below a given address")
    public void whenISelectTheEditAddressLinkBelowAGivenAddress() {
        tcs.pom.getMyAccount().navigateToShipping();
    }

    @Then("I am presented with the address page where I can edit my address, save it or cancel the changes")
    public void iAmPresentedWithTheAddressPageWhereICanEditMyAddressSaveItOrCancelTheChanges() {
        Assert.assertTrue(tcs.pom.getMyAccount().editAddressForm());
    }
    @And("edited address should be available on the card")
    public void editedAddressShouldBeAvailableOnTheCard() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getMyAccount().editAndAddNewAddress());
    }

    @When("I select the remove link below a given address")
    public void whenISelectTheRemoveLinkBelowAGivenAddress() {
        tcs.pom.getMyAccount().navigateToShipping();
    }

    @Then("a prompt appears to confirm or decline the address deletion")
    public void aPromptAppearsToConfirmOrDeclineTheAddressDeletion() {
        Assert.assertTrue(tcs.pom.getMyAccount().removeAccountModal());
    }

    @And("clicking cancel will remove the modal")
    public void clickingCancelWillRemoveTheModal() {
        Assert.assertTrue(tcs.pom.getMyAccount().validateAddressRemoveCancel());
    }

    @Then("click remove button then the address disappears in the list of saved address and a notification appears at the top of the list to confirm the address has been removed")
    public void clickRemoveButtonThenTheAddressDisappearsInTheListOfSavedAddress() {
        Assert.assertTrue(tcs.pom.getMyAccount().validateAddressRemoved());
    }

    @Given("I am on the Payment Info tab")
    public void iAmOnThePaymentInfoTab() throws IOException {
        tcs.pom.getAuth().signInWithSavedDetails();
    }

    @When("the Payment page loads")
    public void thePaymentPageLoads() {
        tcs.pom.getMyAccount().navigateToPaymentInfo();
    }

    @Then("I am presented with the list of cards I have saved from previous JF orders, including the card company, cardholder name, last four digits of credit card and expiry date and I also have the option to add a new card and remove saved cards")
    public void iAmPresentedWithTheListOfCardsIHaveSavedFromPreviousJFOrdersIncludingTheCardCompanyCardholderNameLastDigitsOfCreditCardAndExpiryDate() {
        Assert.assertTrue(tcs.pom.getMyAccount().validateSavedCards());
    }

    @When("I select Add New card")
    public void whenISelectAddNewCard() {
        tcs.pom.getMyAccount().navigateToPaymentInfo();
        tcs.pom.getMyAccount().clickAddANewCard();
    }

    @Then("I am presented with an option to add a billing address and then continue to enter credit card info")
    public void iAmPresentedWithAnOptionToAddABillingAddressAndThenContinueToEnterCreditCardInfo() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getMyAccount().validateBillingAddressDisplayed());
        tcs.pom.getMyAccount().fillBillingDetails();
        Assert.assertTrue(tcs.pom.getMyAccount().validateCreditCardDetails());
    }

    @Then("while filling invalid details in cardNumber section, it should display the error message")
    public void whileFillingInvalidDetailsInCardNumberSectionItShouldDisplayTheErrorMessage() throws InterruptedException {
        tcs.pom.getMyAccount().fillBillingDetails();
        tcs.pom.getMyAccount().fillInvalidCardDetails();
        Assert.assertTrue(tcs.pom.getMyAccount().validateCardErrorMessages());
    }

    @Then("while filling valid details in cardNumber section, it should display the success message")
    public void whileFillingValidDetailsInCardNumberSectionItShouldDisplayTheSuccessMessage() throws IOException, InterruptedException {
        tcs.pom.getMyAccount().fillBillingDetails();
        tcs.pom.getMyAccount().fillValidDetails();
        Assert.assertTrue(tcs.pom.getMyAccount().validateCardSaved());
    }

    @Then("I am presented a pop up asking to confirm or cancel the credit card removal")
    public void iAmPresentedAPopUpAskingToConfirmOrCancelTheCreditCardRemoval() {
        Assert.assertTrue(tcs.pom.getMyAccount().removeCardModal());
    }

    @When("I select remove credit card")
    public void iSelectRemoveCreditCard() {
        tcs.pom.getMyAccount().navigateToPaymentInfo();
    }

    @Then("I click remove card button and message should")
    public void iClickRemoveCardButtonAndMessageShould() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getMyAccount().validateCardRemove());
    }

    @Given("I am in the Order history tab and have ordered from JF")
    public void iAmInTheOrderHistoryTabAndHaveOrderedFromJF() throws IOException {
        tcs.pom.getAuth().signInWithSavedDetails();
        tcs.pom.getMyAccount().navigateToOrderHistory();
    }

    @When("I select the order number")
    public void iSelectTheOrderNumber() {

    }

    @Then("the page reloads to a full page view of the order detail")
    public void thePageReloadsToAFullPageViewOfTheOrderDetail() {
        Assert.assertTrue(tcs.pom.getMyAccount().navigateToOrderDetails());
    }

    @When("I select the images of the product from details page")
    public void iSelectTheImagesOfTheProductFromDetailsPage() {
        tcs.pom.getMyAccount().navigateToOrderDetails();
    }

    @Then("it links to the product detail page in the same tab")
    public void itLinksToTheProductDetailPageInTheSameTab() {
        Assert.assertTrue(tcs.pom.getMyAccount().navigateToPdpFromOrderDetails());
    }

    @When("I select Returns and Exchange Policy or FAQ pages")
    public void iSelectReturnsAndExchangePolicyOrFAQPages() {
        tcs.pom.getMyAccount().navigateToOrderDetails();
    }

    @Then("I will land on the respecitive information pages")
    public void iWillLandOnTheRespecitiveInformationPages() {
        Assert.assertTrue(tcs.pom.getMyAccount().validateReturnsPage());
        tcs.base.driver.navigate().back();
        Assert.assertTrue(tcs.pom.getMyAccount().validateFaqPage());
    }

    @When("I select Manage your PC ID account")
    public void iSelectManageYourPCIDAccount() {
        tcs.pom.getMyAccount().navigateToAccountsSettings();
    }

    @Then("I will land on the PC id Account page")
    public void iWillLandOnThePCIdAccountPage() {
        Assert.assertTrue(tcs.pom.getMyAccount().validateManagePcAccount());
    }

    @Given("I am on the Shipping Addresses page and have no addresses saved")
    public void iAmOnTheShippingAddressesPageAndHaveNoAddressesSaved() throws IOException {
        tcs.pom.getAuth().signInWithNoSavedDetails();
    }

    @Then("I see a No saved addresses and a button to prompt that allows me to add an address")
    public void iSeeANoSavedAddressesAndAButtonToPromptThatAllowsMeToAddAnAddress() {
        Assert.assertTrue(tcs.pom.getMyAccount().noShippingAddress());
    }

    @Given("I am on the Payment Cards page and have no cards saved")
    public void iAmOnThePaymentCardsPageAndHaveNoCardsSaved() throws IOException {
        tcs.pom.getAuth().signInWithNoSavedDetails();
    }

    @Then("I see a No saved cards and a button to prompt that allows me to add a card")
    public void iSeeANoSavedCardsAndAButtonToPromptThatAllowsMeToAddACard() {
        Assert.assertTrue(tcs.pom.getMyAccount().noSavedCards());
    }
}

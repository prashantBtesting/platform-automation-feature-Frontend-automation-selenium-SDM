package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.TestContextSetup;

import java.io.IOException;

public class guestCheckoutStepDefinition {
    TestContextSetup tcs;
    public guestCheckoutStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
    }
    @When("When I click to check out from the bag page")
    public void when_i_click_to_check_out_from_the_bag_page() {
        Assert.assertTrue(tcs.pom.getPDP().SelectEnabledSize());
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getPDP().viewBag);
    }
    @Then("Then I will be taken to a sign in page where I can choose to sign in or to enter my email in order to check out as a guest.")
    public void then_i_will_be_taken_to_a_sign_in_page_where_i_can_choose_to_sign_in_or_to_enter_my_email_in_order_to_check_out_as_a_guest() {
        tcs.common.addExplicitWait(tcs.pom.getCartPage().checkoutButton);
        Assert.assertTrue(tcs.common.isDisplayedAndIsVisible(tcs.pom.getCartPage().checkoutButton));
        tcs.common.addExplicitWait(tcs.pom.getPcid().submitSignInOrCheckout);
        String  ActualText= tcs.pom.getPcid().signInButton.getText();
        String ExpectedText = "Sign in";
        Assert.assertEquals(ActualText,ExpectedText,"Redirected to the signIn Page but something went wrong");
    }


    @Given("I am on the guest checkout page")
    public void i_am_on_the_guest_checkout_page() throws IOException {
        tcs.pom.getHomePage().searchProduct1();
        tcs.common.enter(tcs.pom.getHomePage().searchBox);
        tcs.common.clickOn(tcs.pom.getPDP().TankDress);
        Assert.assertTrue(tcs.pom.getPDP().SelectEnabledSize());
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getCartPage().checkoutButton);
        tcs.common.addExplicitWait(tcs.pom.getPcid().submitSignInOrCheckout);
        System.out.println("User is on Guest Checkout Page");
    }
    @When("I enter a valid shipping address and proceed to the next step")
    public void i_enter_a_valid_shipping_address_and_proceed_to_the_next_step() {
        tcs.pom.getPcid().emailF.sendKeys("prashantbb5246@gmail.com");
        Assert.assertTrue(tcs.common.isDisplayedAndIsVisible(tcs.pom.getPcid().submitSignInOrCheckout));
        tcs.pom.getCheckout().checkAndValidateEditAddress();
        tcs.pom.getCheckout().validateExpressButtonEnabled();
        tcs.pom.getCheckout().validatePriceAfterCardContinueTODelivery();
        tcs.common.clickOn(tcs.pom.getCheckout().continueToPayment);

    }
    @Then("change from standred delivery to express delivery")
    public void change_from_standred_delivery_to_express_delivery() throws InterruptedException {
        Thread.sleep(2000);
        tcs.common.addExplicitWait(tcs.pom.getPDP().shippingPrice);
        String shippingValue = tcs.pom.getCheckout().validateSippingPrice();
        String ExpectedPrice = "$17.00";
        System.out.println("Shipping Price after continue To delivery:: " + shippingValue);
        Assert.assertEquals(shippingValue, ExpectedPrice, "Shipping Price Is not as Expected");
    }
    @Then("my address is displayed in the summary format after proceeding to the next step.")
    public void my_address_is_displayed_in_the_summary_format_after_proceeding_to_the_next_step() {

        Assert.assertTrue(tcs.pom.getCheckout().checkAndValidateEditAddress());
        System.out.println("Address Shown In this Format:: "
                + tcs.pom.getCheckout().validateAddressBeforeAndAfterContinueToDelivery());
    }

    @Then("customer can return to step one to edit their address by clicking Edit Address, which re-opens the form with values accurately re-populated in each fied")
    public void customer_can_return_to_step_to_edit_their_address_by_clicking_which_re_opens_the_form_with_values_accurately_re_populated_in_each_fied() {
        Assert.assertTrue(tcs.pom.getCheckout().checkAndValidateEditAddress());
        Assert.assertTrue(tcs.pom.getCheckout().validateAddressButtonClickableAfterContinueToDelivery(),"Edit Address Button Is Not Visible");

    }
    @When("I am on the delivery mode of selection step")
    public void i_am_on_the_delivery_mode_of_selection_step() {
        tcs.pom.getPcid().emailF.sendKeys("prashantbb5246@gmail.com");
        Assert.assertTrue(tcs.common.isDisplayedAndIsVisible(tcs.pom.getPcid().submitSignInOrCheckout));
        tcs.pom.getCheckout().checkAndValidateEditAddress();
       // tcs.pom.getCheckout().validateAddressButtonClickableAfterContinueToDelivery();
    }

    @Then("standard shipping is selected by default")
    public void standard_shipping_is_selected_by_default() {
        Assert.assertTrue(tcs.pom.getCheckout().validateShippingAddressDetailsSubmitted(),"Standard Radio Button Is Not Enabled");

    }

    @Then("the customer can select a different delivery mode by clicking anywhere in that option's box, and the previously selected option is deselected \\(radio button functionality)")
    public void the_customer_can_select_a_different_delivery_mode_by_clicking_anywhere_in_that_option_s_box_and_the_previously_selected_option_is_deselected_radio_button_functionality() {
       Assert.assertTrue(tcs.pom.getCheckout().validateExpressButtonEnabled(), "Not able to click on Express Radio Button");

    }
    @Then("standard shipping is discounted to free if the bag subtotal exceeds the defined free shipping threshold currently dollar fifty")
    public void standard_shipping_is_discounted_to_free_if_the_bag_subtotal_exceeds_the_defined_free_shipping_threshold_currently_$() {
       Assert.assertTrue(tcs.pom.getCheckout().validatePriceAfterCardContinueTODelivery());
    }

    @Then("After entering a valid shipping address in step one, delivery modes are displayed in step two for the customer to choose between")
    public void after_entering_a_valid_shipping_address_in_step_delivery_modes_are_displayed_in_step_for_the_customer_to_choose_between() {
        Assert.assertTrue(tcs.pom.getCheckout().checkAndValidateEditAddress());
        Assert.assertTrue(tcs.pom.getCheckout().validateShippingAddressDetailsSubmitted(),"Delivery Section is not Visible");
        Assert.assertTrue(tcs.pom.getCheckout().validateExpressButtonEnabled(),"Delivery Section is not Visible");

    }


}


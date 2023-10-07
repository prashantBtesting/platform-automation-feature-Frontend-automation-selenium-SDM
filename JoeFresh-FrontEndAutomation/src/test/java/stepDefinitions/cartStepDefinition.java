package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import util.Log;
import utils.TestContextSetup;

import java.io.IOException;
import java.text.DecimalFormat;

public class cartStepDefinition {
    TestContextSetup tcs;
   // WebDriverWait wait;
    WebDriver driver;

    public cartStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
       // wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    @When("I have not added products to my bag")
    public void i_have_not_added_products_to_my_bag() {


    }

    @Then("I am presented with the message that my bag is currently empty")
    public void i_am_presented_with_the_message_that_my_bag_is_currently_empty() {
        tcs.common.clickOn(tcs.pom.getPDP().MyBag);
        System.out.println("clicked on my bag button");
        Assert.assertTrue(tcs.common.addExplicitWait(tcs.pom.getPDP().carIsEmpty));
        System.out.println("Message Displayed - Your shopping bag is currently empty");
    }

    @When("I have added products to my bag and I have not signed in")
    public void i_have_added_products_to_my_bag_and_i_have_not_signed_in() {
        Assert.assertTrue(tcs.pom.getPDP().SelectEnabledSize());
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getPDP().viewBag);

    }

    @Then("I am presented the summary calculations of my order, but not the tax value")
    public void i_am_presented_the_summary_calculations_of_my_order_but_not_the_tax_value() {
        String ActualText = tcs.pom.getCartPage().validateTaxValue();
        System.out.println(ActualText);
        String ExpectedText = "--";
        Assert.assertEquals(ActualText, ExpectedText, "Tax value is not as expected");
    }

    @Given("I am onn the bag page")
    public void i_am_onn_the_bag_page() throws IOException {
        tcs.pom.getHomePage().searchProduct4();
        tcs.common.enter(tcs.pom.getHomePage().searchBox);
        tcs.common.clickOn(tcs.pom.getPDP().PonteDress);

    }
    @When("I have added products to my bag and my order is under $fifty with Discounted Price")
    public void i_have_added_products_to_my_bag_and_my_order_is_under_$fifty_with_Discounted_Price() {
        Assert.assertTrue(tcs.pom.getPDP().SelectEnabledSize());
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getPDP().viewBag);


    }
    @When("I have added products to my bag and my order is under $fifty without Discounted Price Discounted")
    public void i_have_added_products_to_my_bag_and_my_order_is_under_$fifty_without_Discounted_Price() {
        Assert.assertTrue(tcs.pom.getPDP().SelectEnabledSize());
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getPDP().viewBag);


    }

    @Then("I am presented the summary calculations of my order and the shipping costs is shown as $3.99 Discounted")
    public void i_am_presented_the_summary_calculations_of_my_order_and_the_shipping_costs_is_shown_as_$() {
        tcs.common.addExplicitWait(tcs.pom.getCartPage().ProductDiscountedPriceOnCartPageWithDiscount);
        tcs.common.addExplicitWait(tcs.pom.getPDP().shipping);
        String productPrice = tcs.pom.getCartPage().ProductDiscountedPriceOnCartPageWithDiscount.getText().replace("$","");
        System.out.println("Product Price:: "+productPrice);
        Float newProductPrice = Float.valueOf(productPrice);
        int BoundryPrice = 50;
        String shippingPrice = "$3.99";
        if (newProductPrice <= BoundryPrice) {
            String shippingValue = tcs.pom.getPDP().shipping.getText();
            System.out.println(shippingValue);
            if (shippingValue.equals(shippingPrice)) {
                System.out.println("Product Price Is:: " + productPrice + "and Shipping charges are:: " + shippingValue);

            }
        } else {
            String shippingValueFree = tcs.pom.getPDP().shipping.getText();
            System.out.println(shippingValueFree);
        }
    }
    @Given("I am on the bag page- Product without discount")
    public void i_am_on_the_bag_page_product_above_fifty_dollar() throws IOException {
        tcs.pom.getHomePage().searchProduct2();
        tcs.common.enter(tcs.pom.getHomePage().searchBox);
        tcs.common.clickOn(tcs.pom.getPDP().Jacket);
    }

    @When("I have added products to my bag and my order is under $fifty without Discounted Price")
    public void i_have_added_products_to_my_bag_and_my_order_is_under_$fifty_without_discounted_price() {
        Assert.assertTrue(tcs.pom.getPDP().SelectEnabledSize());
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getPDP().viewBag);
    }
    @Then("I am presented the summary calculations of my order and the shipping costs is shown as $3.99 \\(Without Discount)")
    public void i_am_presented_the_summary_calculations_of_my_order_and_the_shipping_costs_is_shown_as_$_without_discount() {
        tcs.common.addExplicitWait(tcs.pom.getCartPage().ProductRegularPriceOnCartPageWithOutDiscount);
        tcs.common.addExplicitWait(tcs.pom.getPDP().shipping);
        String productPrice = tcs.pom.getCartPage().ProductRegularPriceOnCartPageWithOutDiscount.getText().replace("$","");
        System.out.println("Product Price:: "+productPrice);
        Float newProductPrice = Float.valueOf(productPrice);
        int BoundryPrice = 50;
        String shippingPrice = "$3.99";
        if (newProductPrice <= BoundryPrice) {
            String shippingValue = tcs.pom.getPDP().shipping.getText();
            System.out.println(shippingValue);
            if (shippingValue.equals(shippingPrice)) {
                System.out.println("Product Price Is:: " + productPrice + "and Shipping charges are:: " + shippingValue);

            }
        } else {
            String shippingValueFree = tcs.pom.getPDP().shipping.getText();
            System.out.println(shippingValueFree);
        }
    }

    @Given("I am on the bag page of the product")
    public void i_am_on_the_bag_page_of_the_product() throws IOException {
        tcs.pom.getHomePage().searchProduct2();
        tcs.common.enter(tcs.pom.getHomePage().searchBox);
        tcs.common.clickOn(tcs.pom.getPDP().Jacket);
    }

    @When("I have added products to my bag and my order is above $fifty")
    public void i_have_added_products_to_my_bag_and_my_order_is_above_$fifty() throws IOException {
        Assert.assertTrue(tcs.pom.getPDP().SelectEnabledSize());
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getPDP().viewBag);

        Log.info("checking Price");
    }

    @Then("I am presented the summary calculations of my order and the shipping costs is shown as Free")
    public void i_am_presented_the_summary_calculations_of_my_order_and_the_shipping_costs_is_shown_as_free() {
        tcs.common.addExplicitWait(tcs.pom.getPDP().valueOfProductsAddedInCart);
        tcs.common.addExplicitWait(tcs.pom.getPDP().shipping);
        String productPrice = (tcs.pom.getPDP().valueOfProductsAddedInCart.getText());
        System.out.println(productPrice);
        try {
            int newProductPrice = Integer.parseInt(productPrice.replaceAll("[^\\d.]", ""));
            System.out.println(newProductPrice);
            int BoundryPrice = 50;
            String shippingPrice = "$3.99";
            if (newProductPrice <= BoundryPrice) {
                String shippingValue = tcs.pom.getPDP().shipping.getText();
                System.out.println(shippingValue);
                if (shippingValue.equals(shippingPrice)) {
                    System.out.println("Product Price Is:: " + productPrice + "and Shipping charges are:: " + shippingValue);

                }
            } else {
                String shippingValueFree = tcs.pom.getPDP().shipping.getText();
                System.out.println(shippingValueFree);
            }

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

    }

    @When("I select the quantity adjustment dropdown")
    public void i_select_the_quantity_adjustment_dropdown() {
        Assert.assertTrue(tcs.pom.getPDP().SelectEnabledSize());
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getPDP().viewBag);
    }

    @Given("I am on the bag page")
    public void i_am_on_the_bag_page() throws InterruptedException, IOException {
        tcs.pom.getPDP().selectRandomProduct();

    }
    @Given("I am on the bag page to check quantity restriction")
    public void  I_am_on_the_bag_page_to_check_quantity_restriction() throws InterruptedException, IOException {
        tcs.pom.getHomePage().searchProduct1();
        tcs.common.enter(tcs.pom.getHomePage().searchBox);
        tcs.common.clickOn(tcs.pom.getPDP().TankDress);
    }



    @Then("I am given the option to modify the quantity from one to nine for that item")
    public void i_am_given_the_option_to_modify_the_quantity_from_for_that_item() throws InterruptedException {
        tcs.common.implicitlyWait();
        Thread.sleep(3000);
        tcs.pom.getPDP().quantityFromDropdown();
        Assert.assertEquals(tcs.pom.getPDP().quantityFromDropdown(),9);
        String Text = tcs.pom.getPDP().myBagValue.getText();
        System.out.println(Text);
    }
    @Given("I am on the bag page\\(quantity Restriction)")
    public void i_am_on_the_bag_page_quantity_restriction() throws IOException {
        tcs.pom.getHomePage().searchProduct1();
        tcs.common.enter(tcs.pom.getHomePage().searchBox);
        tcs.common.clickOn(tcs.pom.getPDP().TankDress);
    }

    @When("an item has a restricted quantity \\(less than the global restriction of nine) based at the colour or size level")
    public void an_item_has_a_restricted_quantity_less_than_the_global_restriction_of_nine_based_at_the_colour_or_size_level() {
        tcs.common.implicitlyWait();
        tcs.pom.getPDP().SelectXSSize.click();
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getPDP().viewBag);
    }

    @Then("I cannot select to add more than the maximum allowed quantity of that item.")
    public void i_cannot_select_to_add_more_than_the_maximum_allowed_quantity_of_that_item() {
        tcs.common.implicitlyWait();
        tcs.pom.getPDP().quantityFromDropdown();
        tcs.common.Back();
        for (int i=0; i<9;i++){
            tcs.pom.getPDP().SelectXSSize.click();
        }
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().ErrorMessageForQuanty);
        String errorMessage = tcs.pom.getPDP().ErrorMessageForQuanty.getText();
        System.out.println(errorMessage);
        String value = "Unable to add to bag. Please refresh and try again.";
        Assert.assertEquals(errorMessage, value, "Test Failed");
    }

    @Given("I have logged as a registered user")
    public void i_have_logged_as_a_registered_user() throws IOException {
        tcs.pom.getPcid().signInMethod();
        tcs.pom.getHomePage().openProduct();

    }
    @When("I have added product to the bag")
    public void i_have_added_product_to_the_bag() {
        tcs.pom.getPDP().addProductInTheCart();
    }
    @Then("Tax value should be displyed")
    public void tax_value_should_be_displyed() {
        tcs.common.addExplicitWait(tcs.pom.getCartPage().TaxValueAfterLogin);
        Assert.assertFalse(tcs.pom.getCartPage().TaxPriceValue());
    }


    @When("an item has a restricted quantity \\(less than the global restriction of nine) based at the colour or size level.")
    public void when_an_item_has_a_restricted_quantity_less_than_the_global_restriction_of_nine_based_at_the_colour_or_size_level() {
        tcs.common.implicitlyWait();
        tcs.pom.getPDP().SelectXSSize.click();
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getPDP().viewBag);
        tcs.common.implicitlyWait();
        tcs.pom.getPDP().quantityFromDropdown();
        tcs.common.Back();
        tcs.pom.getPDP().SelectXSSize.click();

    }
    @Then("I cannot select to add more than the maximum allowed quantity of that item in that colour or size \\(as applicable), but I can add other colour variants of that item in addition.")
    public void i_cannot_select_to_add_more_than_the_maximum_allowed_quantity_of_that_item_in_that_colour_or_size_as_applicable_but_i_can_add_other_colour_variants_of_that_item_in_addition() {
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().ErrorMessageForQuanty);
        String errorMessage = tcs.pom.getPDP().ErrorMessageForQuanty.getText();
        System.out.println(errorMessage);
        Assert.assertEquals(errorMessage,"Quantity limit reached\n" +
                "We couldn’t add to your bag because you’ve reached the maximum quantity allowed for this item." ,"Test Case Failed");
        tcs.common.clickOn(tcs.pom.getPDP().CloseButton);
    }

    @When("I enter a promo code that applies to the item\\(s) in the bag")
    public void i_enter_a_promo_code_that_applies_to_the_item_s_in_the_bag() throws InterruptedException {
        tcs.pom.getPDP().SelectEnabledSize();
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getCartPage().promoCodeButton);

    }

    @Then("I am Able to remove the promo code successfully")
    public void i_am_able_to_remove_the_promo_code_successfully() throws InterruptedException {
        tcs.pom.getCartPage().PromoCodeList();
        tcs.pom.getCartPage().enterValueInPromoCodeBox();
      //
        Thread.sleep(3000);
      try {
          tcs.pom.getCartPage().removePromoCodeButton.click();
      }catch (StaleElementReferenceException e ){
          tcs.base.driver.navigate().refresh();
          tcs.pom.getCartPage().removePromoCodeButton.click();
      }
    }
    @Then("Refresh the page and message should not be changed.")
    public void refresh_the_page_and_message_should_not_be_changed() throws InterruptedException {
        tcs.pom.getCartPage().PromoCodeList();
        tcs.pom.getCartPage().enterValueInPromoCodeBox();
        tcs.base.driver.navigate().refresh();
        Thread.sleep(3000);
        Assert.assertTrue(tcs.pom.getCartPage().technicalErrorMessage());

    }

    @Then("the appropriate discount will be applied to the order and displayed in the order summary calculation")
    public void the_appropriate_discount_will_be_applied_to_the_order_and_displayed_in_the_order_summary_calculation() throws InterruptedException {
        tcs.pom.getCartPage().PromoCodeList();
        tcs.pom.getCartPage().enterValueInPromoCodeBox();
        String Text = String.valueOf(tcs.pom.getCartPage().calculateValue());
        System.out.println(Text);

    }


    @When("I enter an invalid promo code")
    public void i_enter_an_invalid_promo_code() throws InterruptedException {
        tcs.pom.getPDP().SelectEnabledSize();
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getCartPage().promoCodeButton);
        tcs.pom.getCartPage().fakePromoList();
        Assert.assertTrue(tcs.pom.getCartPage().enterFakeValueInPromoCodeBox());

    }

    @Then("an error message will be displayed The promo code you have entered is invalid or expired")
    public void an_error_message_will_be_displayed() {
        Assert.assertFalse(Boolean.parseBoolean(tcs.pom.getCartPage().invalidPromoCodeError.getText()));
    }

    @Then("Saving price should be visible")
    public void saving_price_should_be_visible() throws InterruptedException {
        tcs.pom.getCartPage().PromoCodeList();
        tcs.pom.getCartPage().enterValueInPromoCodeBox();
        Assert.assertTrue(tcs.pom.getCartPage().savingsAfterAddingPromoCode());

    }


    @When("I am not signed in and have no items in my bag")
    public void i_an_not_signed_in_and_have_no_items_in_my_bag() {
        tcs.common.clickOn(tcs.pom.getPDP().MyBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().carIsEmpty);
    }

    @Then("tthe PCO tile will not display on the bag page")
    public void tthe_pco_tile_will_not_display_on_the_bag_page() {
        Assert.assertFalse(tcs.common.isElementVisibleCss(".PCOCard_body__vp0KH.PCOCard_black__Tesqa"), "PcOptimum Tile is visible this tile should nod not be visible if cart is emty and user is not logged in ");

    }

    @When("I am not signed in and have items in my bag")
    public void i_an_not_signed_in_and_have_items_in_my_bag() {
        tcs.pom.getPDP().SelectEnabledSize();
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getPDP().viewBag);
    }

    @Then("the PCO tile will display with the message To earn and redeem PC Optimum™ points, sign in or create an account. as well as offering the options to sign in or to create an account.")
    public void the_pco_tile_will_display_with_the_message_to_earn_and_redeem_pc_optimum_points_sign_in_or_create_an_account_as_well_as_offering_the_options_to_sign_in_or_to_create_an_account() {
        tcs.common.addExplicitWait(tcs.pom.getPDP().PcOptimumTile);
        String pcOptimumText = tcs.pom.getPDP().PcOptimumTile.getText();
        System.out.println(pcOptimumText);
        String Text = "To earn and redeem PC Optimum™ points, sign in or create an account.";
        Assert.assertEquals(pcOptimumText, Text);
    }

    @When("I amm signed in and have items in my bag")
    public void i_amm_signed_in_and_have_items_in_my_bag() {
        tcs.pom.getHomePage().signIN();
        tcs.common.addExplicitWait(tcs.pom.getPcid().emailF);
        tcs.pom.getPcid().emailM("prashant.babar@knoldus.com");
        tcs.pom.getPcid().passM("8793440363@Pb");
        tcs.common.clickOn(tcs.pom.getPcid().submitSignInOrCheckout);
        Log.info("Successfully Logged in");

    }

    @Then("the PCO tile will display with the message Redeem PC Optimum™ points in checkout. Watch out for personalized offers and points events!")
    public void the_pco_tile_will_display_with_the_message() throws IOException {
        tcs.common.addExplicitWait(tcs.pom.getHomePage().searchBox);
        tcs.pom.getHomePage().searchProduct1();
        tcs.common.enter(tcs.pom.getHomePage().searchBox);
        tcs.common.clickOn(tcs.pom.getPDP().TankDress);
        tcs.pom.getPDP().SelectEnabledSize();
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getPDP().viewBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().PcOptimumTile);
        String ActualPcOptimumText = tcs.pom.getPDP().PcOptimumTile.getText();
        System.out.println(ActualPcOptimumText);
        String ExpectedText = "Get personalized PC Optimum™ offers and start earning points today!";
        Assert.assertEquals(ActualPcOptimumText, ExpectedText);
        tcs.common.addImplicitWait(tcs.pom.getPDP().RemoveItemFromBag);
        tcs.pom.getPDP().RemoveItemFromBag.click();
        System.out.println("Pc Optimum Tile Text is Visible");
    }


    @When("I have an empty bag")
    public void i_have_an_empty_bag() {
        tcs.common.addExplicitWait(tcs.pom.getPDP().MyBag);
        tcs.common.clickOn(tcs.pom.getPDP().MyBag);

    }

    @Then("I will see a horizontal carousel of recommended products with the title Perhaps you may like these instead?")
    public void i_will_see_a_horizontal_carousel_of_recommended_products_with_the_title() {
        tcs.common.addExplicitWait(tcs.pom.getCartPage().PerhapsYouMayLikeTheseInsteadText);
        String ActualText = tcs.pom.getCartPage().PerhapsYouMayLikeTheseInsteadText.getText();
        System.out.println("Text Present:: " + ActualText);
        String ExpectedText = "Perhaps you may like these instead?";
        Assert.assertEquals(ActualText, ExpectedText, "Same Text is not Found");

    }

    @When("I have items in my bag")
    public void i_have_items_in_my_bag() {
        tcs.pom.getPDP().SelectEnabledSize();
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getPDP().viewBag);

    }

    @Then("I will see a Checkout CTA on the right of the page under the order summary calculation.")
    public void i_will_see_a_checkout_cta_on_the_right_of_the_page_under_the_order_summary_calculation() {
        tcs.common.addExplicitWait(tcs.pom.getCartPage().checkout);
        String ActualText = tcs.pom.getCartPage().checkoutButton.getText();
        System.out.println(ActualText);
        String ExpectedText = "Checkout";
        Assert.assertEquals(ActualText, ExpectedText, "Checkout Name Is not Preset");
    }

    @When("I click on product from you may like this")
    public void i_click_on_product_from_you_may_like_this(){
        tcs.common.addExplicitWait(tcs.pom.getPDP().youMayLikeThisProduct);
    }

    @Then("I am able to open and add to bag the product from the you may like this Slider.")
    public void i_am_able_to_open_and_add_to_bag_the_product_from_the_you_may_like_this_slider() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getPDP().youMayLikeThisProduct.isDisplayed());
        Assert.assertTrue(tcs.pom.getPDP().youMayLikeThisProduct());
    }

    @When("I click on product from customer also like this.")
    public void i_click_on_product_from_customer_also_like_this(){
        tcs.common.addExplicitWait(tcs.pom.getPDP().customerAlsoLikeThis);
    }

    @Then("I am able to open and add to bag the product from the customer also like this.")
    public void i_am_able_to_open_and_add_to_bag_the_product_from_the_customer_also_like_this() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getPDP().customerAlsoLikeThis.isDisplayed());
        Assert.assertTrue(tcs.pom.getPDP().customerAlsoLikeThisProduct());
    }

    @Given("I on business site and started check out flow and selected a delivery shipping method")
    public void i_on_business_site_and_started_check_out_flow_and_selected_a_delivery_shipping_method() throws IOException {
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

    @When("I go back to my cart page")
    public void i_go_back_to_my_cart_page() throws InterruptedException {
        tcs.pom.getPcid().emailF.sendKeys("prashantbb5246@gmail.com");
        Assert.assertTrue(tcs.common.isDisplayedAndIsVisible(tcs.pom.getPcid().submitSignInOrCheckout));
        tcs.pom.getCheckout().checkAndValidateEditAddress();
        tcs.pom.getCheckout().validateExpressButtonEnabled();
        tcs.pom.getCheckout().validatePriceAfterCardContinueTODelivery();
        tcs.common.clickOn(tcs.pom.getCheckout().continueToPayment);
        Thread.sleep(3000);
      //  tcs.common.Back();


    }

    @Then("I should see the selected shipping fee instead of the standard estimated shipping fee")
    public void i_should_see_the_selected_shipping_fee_instead_of_the_standard_estimated_shipping_fee() {
        tcs.common.addExplicitWait(tcs.pom.getPDP().shippingPrice);
        String shippingValue = tcs.pom.getCheckout().validateSippingPrice();
        String ExpectedPrice = "$17.00";
        System.out.println("Shipping Price after continue To delivery:: " + shippingValue);
        Assert.assertEquals(shippingValue, ExpectedPrice, "Shipping Price Is not as Expected");

    }

    @When("price is calculated")
    public void price_is_calculated() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getPDP().SelectEnabledSize());
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getPDP().viewBag);
    }

    @Then("calculated price of the product should be equal to Estimated Price Of the product")
    public void calculated_price_of_the_product_should_be_equal_to_estimated_price_of_the_product() throws InterruptedException {
        System.out.println(tcs.pom.getCartPage().ValidateProductValuePrice());
        tcs.common.addExplicitWait(tcs.pom.getCartPage().estimatedPrice);
        Float estimatedPriceValue = Float.valueOf(tcs.pom.getCartPage().estimatedPrice.getText().replaceAll("[^\\d.]", ""));
        System.out.println(estimatedPriceValue);
        Assert.assertEquals(tcs.pom.getCartPage().validateEstimatedPriceAndTotalCalculation(), estimatedPriceValue, "Estimated Value Is Not Same");
    }

    @Then("HST Tax Value should be calculated as expected")
    public void hst_tax_value_should_be_calculated_as_expected() throws InterruptedException {
        tcs.common.clickOn(tcs.pom.getCartPage().checkout);
        tcs.common.addExplicitWait(tcs.pom.getPcid().emailF);
        tcs.pom.getPcid().emailF.sendKeys("prashantbb5246@gmail.com");
        Assert.assertTrue(tcs.common.isDisplayedAndIsVisible(tcs.pom.getPcid().submitSignInOrCheckout));
        tcs.pom.getCheckout().checkAndValidateEditAddress();
        //tcs.pom.getCheckout().validateExpressButtonEnabled();
        tcs.pom.getCheckout().validatePriceAfterCardContinueTODelivery();
        tcs.common.clickOn(tcs.pom.getCheckout().continueToPayment);
        Thread.sleep(10000);
        Float ProductPrice = tcs.pom.getCartPage().ValidateProductValuePrice().get(0);
        Float ShippingCharge = tcs.pom.getCartPage().ValidateProductValuePrice().get(1);
        Float ActualHSTTax = tcs.pom.getCartPage().ValidateProductValuePrice().get(2);
        double ExpectedHSTTaxCalculation = ((ProductPrice + ShippingCharge) / 100) * 13;
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        Float ExpectedHSTTAX = Float.valueOf(df.format(ExpectedHSTTaxCalculation));
        System.out.println("Actual Tax:: " + ActualHSTTax);
        System.out.println("Expected Actual Calculation:: " + ExpectedHSTTAX);
        Assert.assertEquals(ActualHSTTax,ExpectedHSTTAX);

    }

    @Given("I am on the bag pagee")
    public void i_am_on_the_bag_pagee() throws InterruptedException, IOException {
        Thread.sleep(9000);
        tcs.pom.getHomePage().searchProduct1();
        tcs.common.enter(tcs.pom.getHomePage().searchBox);
        tcs.common.clickOn(tcs.pom.getPDP().TankDress);
    }
    @When("When I click on the Cart page")
    public void when_i_click_on_the_cart_page() {
        tcs.pom.getPDP().SelectEnabledSize();
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getPDP().viewBag);

    }
    @Then("the item count against the text My Bag should be displayed correctly")
    public void the_item_count_against_the_text_should_be_displayed_correctly() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getPDP().validateMyBagProductCount());
    }

    @Then("the item count against the text My Bag should be updated correctly based on the items in the cart")
    public void the_item_count_against_the_text_should_be_updated_correctly_based_on_the_items_in_the_cart() throws InterruptedException {
        tcs.pom.getPDP().validateMyBagProductCount();
        tcs.pom.getPDP().quantityFromDropdown();
        tcs.pom.getPDP().validateMyBagProductCount();

        int value = Integer.parseInt(tcs.pom.getPDP().MyBagTextAboveSearch.getText().replaceAll("[^\\d.]", ""));
        System.out.println(value);
    }
    @When("I remove the item from cart")
    public void i_remove_the_item_from_cart() throws InterruptedException {
        tcs.pom.getPDP().validateMyBagProductCount();
        tcs.pom.getPDP().quantityFromDropdown();
        tcs.pom.getPDP().RemoveItemFromBag.click();
    }
    @Then("the item count against the text My Bag should be updated correctly based on the items in the cart after Removing Item From my Bag")
    public void the_item_count_against_the_text_my_bag_should_be_updated_correctly_based_on_the_items_in_the_cart_after_removing_item_from_my_bag() throws InterruptedException {
        tcs.common.addExplicitWait(tcs.pom.getPDP().cartIsEmpty);
        Assert.assertTrue(tcs.common.addExplicitWait(tcs.pom.getPDP().cartIsEmpty));
    }
    @Then("I should see the the contents of my cart including item image, Item title, quantities, Style, color and Item Price.")
    public void i_should_see_the_the_contents_of_my_cart_including_item_image_item_title_quantities_style_color_and_item_price() {
        Assert.assertTrue(tcs.pom.getCartPage().validateAllProductDetailsOnMyBag());

    }
    @Then("I should be able to see a separate line item of the discounted product, and the accompanying total regular and total promotional product price")
    public void i_should_be_able_to_see_a_separate_line_item_of_the_discounted_product_and_the_accompanying_total_regular_and_total_promotional_product_price() {
        tcs.pom.getCartPage().validateProductPricesOnCartPage();

    }

    @Given("that I browse JF site")
    public void that_i_browse_jf_site() throws IOException {
        tcs.pom.getHomePage().searchProduct1();
        tcs.common.enter(tcs.pom.getHomePage().searchBox);
        tcs.common.clickOn(tcs.pom.getPDP().TankDress);
        tcs.pom.getPDP().selectProducts();
    }
    @When("add multiple items to cart")
    public void add_multiple_items_to_cart() {

    }
    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {

    }
    @When("I click on the Bag icon and decrease the quantity such that the order total is below $Fifty")
    public void i_click_on_the_bag_icon_and_decrease_the_quantity_such_that_the_order_total_is_below_$fifty() {
        tcs.pom.getPDP().SelectEnabledSize();
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getPDP().viewBag);
    }

    @Then("the shipping amount of $3.99 should be applied")
    public void the_shipping_amount_of_$_should_be_applied() throws InterruptedException {
        tcs.pom.getPDP().quantityFromDropdown();
        Thread.sleep(5000);
        System.out.println(tcs.pom.getCartPage().ValidateProductValuePrice());

    }
    @Then("order summary should be updated")
    public void order_summary_should_be_updated() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(tcs.pom.getPDP().QuantityFromDropDown());
        Thread.sleep(5000);
        System.out.println(tcs.pom.getCartPage().ValidateProductValuePrice());
    }
    @When("I enter my email in the guest checkout field email has items earlier in the cart")
    public void i_enter_my_email_in_the_guest_checkout_field_email_has_items_earlier_in_the_cart() {
        Assert.assertTrue(tcs.pom.getPDP().SelectEnabledSize());
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getPDP().viewBag);
        tcs.common.clickOn(tcs.pom.getCartPage().checkoutButton);
        tcs.common.addExplicitWait(tcs.pom.getPcid().submitSignInOrCheckout);
        System.out.println("User is on Guest Checkout Page");
    }
    @Then("cart is not synced")
    public void cart_is_not_synced() {
        tcs.pom.getPcid().emailF.sendKeys("joefresh1@yopmail.com");
        tcs.pom.getPcid().submitSignInOrCheckout.click();
        tcs.common.addExplicitWait(tcs.pom.getCheckout().ProductCountOnCheckOut);
        Assert.assertEquals(tcs.pom.getCheckout().productsAvailableCountOnCheckOut(),1);

    }
    @Given("that I am on JF site with items in my cart")
    public void that_i_am_on_jf_site_with_items_in_my_cart() throws IOException {
        tcs.pom.getPcid().signInMethod();
        tcs.pom.getHomePage().openProduct();
        tcs.pom.getPDP().addProductInTheCart();
        System.out.println("Cart Count Before SignOut:: "+tcs.pom.getCartPage().myBagCount());
    }
    @When("I logout")
    public void i_logout() throws InterruptedException {
        tcs.common.addExplicitWait(tcs.pom.getHomePage().myAccount);
        tcs.common.clickOn(tcs.pom.getHomePage().myAccount);
        Thread.sleep(2000);
        tcs.common.clickOn(tcs.pom.getHomePage().signOut);
        tcs.common.addExplicitWait(tcs.pom.getHomePage().signInBtn);
    }
    @Then("the cart on the browser is empty")
    public void the_cart_on_the_browser_is_empty() throws IOException {
        int MyBagCountAfterSignOut = Integer.parseInt(tcs.pom.getPDP().MyBagTextAboveSearch.getText().replaceAll("[^\\d.]","0"));
        System.out.println("Cart Count After SignOut:: "+MyBagCountAfterSignOut);
    }
    @Given("I have selected a product and added to cart")
    public void i_have_selected_a_product_and_added_to_cart() throws IOException {
        tcs.pom.getHomePage().searchProduct1();
        tcs.common.enter(tcs.pom.getHomePage().searchBox);
        tcs.common.clickOn(tcs.pom.getPDP().TankDress);

    }
    @When("I try to refresh the page")
    public void i_try_to_refresh_the_page() throws IOException {
        Assert.assertTrue(tcs.pom.getPDP().SelectEnabledSize());
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);


    }
    @Then("The prices of the product should not be changed")
    public void the_values_of_the_product_should_not_be_changed() {
        tcs.pom.getPDP().validatePriceBeforeAndAfterRefresh();
       String AfterRefreshValue = tcs.pom.getPDP().productPrice.getText();
       Assert.assertEquals( tcs.pom.getPDP().validatePriceBeforeAndAfterRefresh(),AfterRefreshValue);

    }



}





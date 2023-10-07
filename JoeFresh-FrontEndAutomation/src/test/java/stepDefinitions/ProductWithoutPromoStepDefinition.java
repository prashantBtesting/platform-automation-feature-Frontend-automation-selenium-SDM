package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.Log;
import utils.TestContextSetup;

import java.io.IOException;

public class ProductWithoutPromoStepDefinition {
    TestContextSetup tcs;
    String cartAmount;
    public ProductWithoutPromoStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
    }
    @Given("an end user lands on Joe Fresh Home Page and searches the product (.+)$")
    public void an_end_user_lands_on_joe_fresh_home_page_and_searches_the_product(String product){
        tcs.pom.getSearch().setSearchBoxMultiple(product);
        tcs.pom.getSearch().searchProduct();
        Assert.assertTrue(tcs.pom.getSearchResult().sortDisplayed());
    }
    @Given("^an end user signed in Joe Fresh and searches the product (.+)$")
    public void an_end_user_signed_in_joe_fresh_and_searches_the_product(String product) throws IOException {
        tcs.pom.getAuth().signInWithSavedDetails();
        Assert.assertTrue(tcs.pom.getAuth().validateSignedIn());
        tcs.pom.getSearch().setSearchBoxMultiple(product);
        tcs.pom.getSearch().searchProduct();
        Assert.assertTrue(tcs.pom.getSearchResult().sortDisplayed());
    }
    @When("the Search Result is displayed")
    public void theSearchResultIsDisplayed()  {
        Assert.assertTrue(tcs.pom.getSearchResult().priceDisplayed());
        tcs.pom.getPlp().visitPdp();
    }

    @Then("he should be able to add the items to cart from PDP")
    public void heShouldBeAbleToAddTheItemsToCartFromPDP() throws IOException {
        Assert.assertTrue(tcs.pom.getPdpPage().priceDisplayed());
        String productPrice=tcs.pom.getPdpPage().returnPrice();
        Log.info("Product Price: "+productPrice);
        tcs.pom.getPdpPage().itemAddToCart();
        tcs.pom.getHeader().clickMyBag();
        Assert.assertTrue(tcs.pom.getCart().validateShippingOnCart());
        Log.info("Ammount added to cart: "+tcs.pom.getCart().returnCartAmount());
        Assert.assertEquals(tcs.pom.getCart().returnCartAmount(),productPrice);
    }

    @And("checkout using Guest Checkout and Standard shipping mode")
    public void checkoutUsingGuestCheckoutAndStandardShippingMode() throws IOException, InterruptedException {
        tcs.pom.getCart().navigateToGuestCheckout();
        tcs.pom.getCart().enterShippingDetails();
        tcs.pom.getCheckout().selectDefaultDeliveryMode();
        Assert.assertTrue(tcs.pom.getCheckout().validateShippingPrice());
        Assert.assertTrue(tcs.pom.getCheckout().validateShippingAndBillingAddress());
        tcs.pom.getCheckout().directToPayment();
        Assert.assertTrue(tcs.pom.getCheckout().validateOrderSuccess());
    }



    @And("checkout using Logged in Checkout and Standard shipping mode")
    public void checkoutUsingLoggedInCheckoutAndStandardShippingModes() {
        tcs.pom.getCart().authCheckout();
        tcs.pom.getCheckout().selectDefaultAddress();
        tcs.pom.getCheckout().selectDefaultDeliveryMode();
       // Assert.assertTrue(tcs.pom.getCheckout().validateShippingPriceAuth());
        Assert.assertTrue(tcs.pom.getCheckout().validateShippingAndBillingAddress());
        Assert.assertTrue(tcs.pom.getCheckout().validateSavedCards());
        tcs.pom.getCheckout().selectDefaultPayment();
        Assert.assertTrue(tcs.pom.getCheckout().validateOrderSuccess());

    }

    @And("checkout using Guest Checkout and Express shipping mode")
    public void checkoutUsingGuestCheckoutAndExpressShippingMode() throws IOException, InterruptedException {
        tcs.pom.getCart().navigateToGuestCheckout();
        tcs.pom.getCart().enterShippingDetails();
        Assert.assertTrue(tcs.pom.getCheckout().validateExpressDeliverySelected());
        Assert.assertTrue(tcs.pom.getCheckout().validateShippingAndBillingAddress());
        tcs.pom.getCheckout().directToPayment();
        Assert.assertTrue(tcs.pom.getCheckout().validateOrderSuccess());
    }

    @And("checkout using Logged in Checkout and Express shipping mode")
    public void checkoutUsingLoggedInCheckoutAndExpressShippingMode() {
        tcs.pom.getCart().authCheckout();
        tcs.pom.getCheckout().selectDefaultAddress();
        Assert.assertTrue(tcs.pom.getCheckout().validateExpressDeliverySelected());
        Assert.assertTrue(tcs.pom.getCheckout().validateShippingAndBillingAddress());
        Assert.assertTrue(tcs.pom.getCheckout().validateSavedCards());
        tcs.pom.getCheckout().selectDefaultPayment();
        Assert.assertTrue(tcs.pom.getCheckout().validateOrderSuccess());
    }

    @Then("he should be able to add the items to cart using PLP")
    public void heShouldBeAbleToAddTheItemsToCartUsingPLP() {
       tcs.pom.getPlp().navigateToMyCart();

    }
    @When("the Search Result is displayed on PLP")
    public void theSearchResultIsDisplayedOnPLP() {
        tcs.pom.getPlp().addTheItemToCart();
        cartAmount=tcs.pom.getPlp().returnPrice();
        Assert.assertTrue(tcs.pom.getPlp().itemAddedToCart());
        Assert.assertEquals(tcs.pom.getPlp().modalReturnPrice(),cartAmount);
    }

    @Then("he should be able to add the items to cart from PDP and add Promo code")
    public void heShouldBeAbleToAddTheItemsToCartFromPDPAndAddPromoCode() {
        Assert.assertTrue(tcs.pom.getPdpPage().priceDisplayed());
        String productPrice=tcs.pom.getPdpPage().returnPrice();
        Log.info("Product Price: "+productPrice);
        tcs.pom.getPdpPage().itemAddToCart();
        Assert.assertTrue(tcs.pom.getCart().addPromoCode());
        Assert.assertTrue(tcs.pom.getCart().validateShippingOnCart());
        Log.info("Ammount added to cart: "+tcs.pom.getCart().returnCartAmount());
        Assert.assertEquals(tcs.pom.getCart().returnCartAmount(),productPrice);
    }

    @Then("he should be able to add the items to cart using PLP and add Promo code")
    public void heShouldBeAbleToAddTheItemsToCartUsingPLPAndAddPromoCode() {
        tcs.pom.getPlp().navigateToMyCart();
        tcs.pom.getCart().addPromoCode();
    }

    @Then("he should be able to add all the variant items to cart from PDP")
    public void heShouldBeAbleToAddAllTheVariantItemsToCartFromPDP() {
        tcs.pom.getPlp().navigateToMyCart();
    }

    @Then("he should be able to add all the variant items to cart from PLP")
    public void heShouldBeAbleToAddAllTheVariantItemsToCartFromPLP() {
        tcs.pom.getPlp().navigateToMyCart();
    }

    @When("the Search Result is displayed with variant on PDP")
    public void theSearchResultIsDisplayedWithVariantOnPDP() {
        Assert.assertTrue(tcs.pom.getSearchResult().priceDisplayed());
        tcs.pom.getPlp().visitPdp();
        tcs.pom.getPdpPage().addAllVariants();
    }

    @When("the Search Result is displayed with variant on PLP")
    public void theSearchResultIsDisplayedWithVariantOnPLP() {
        tcs.pom.getPlp().addTheItemToCart();
        cartAmount=tcs.pom.getPlp().returnPrice();
    }
}

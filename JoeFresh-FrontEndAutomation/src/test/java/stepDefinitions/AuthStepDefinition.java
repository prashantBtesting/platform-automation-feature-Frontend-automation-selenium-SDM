package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.Log;
import utils.TestContextSetup;

import java.io.IOException;

public class AuthStepDefinition {
    TestContextSetup tcs;
    public AuthStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
    }
    @When("I navigate to the PC Account page and sign up")
    public void iNavigateToThePCAccountPageAndSignUp() throws InterruptedException {
        tcs.pom.getAuth().createNewAccount();
    }

    @Then("I should redirect back to Joe Fresh site")
    public void iShouldRedirectBackToJoeFreshSite() {
        Assert.assertTrue(tcs.pom.getAuth().validateUserSignedUp());
    }

    @Given("I have added products to my bag and I proceed to checkout")
    public void iHaveAddedProductsToMyBagAndIProceedToCheckout() throws IOException, InterruptedException {
        tcs.pom.getNavigation().navigatingSanity();
        tcs.pom.getPlp().addTheItemToCart();
        Assert.assertTrue(tcs.pom.getPlp().itemAddedToCart());
        tcs.pom.getPlp().clickViewBagButton();

    }

    @When("I reached Checkout page")
    public void iReachedCheckoutPage() {
        //tcs.pom.getHeader().clickMyBag();
        tcs.pom.getCart().cartToCheckoutPage();
    }

    @Then("I am able to sign in and reach auth checkout")
    public void iAmAbleToSignInAndReachAuthCheckout() throws IOException {
        tcs.pom.getAuth().signInFromCheckOutPage();
        Assert.assertTrue(tcs.pom.getAuth().validateUserSignedIn());
    }

    @Given("I have added products to my bag and I proceed to cart")
    public void iHaveAddedProductsToMyBagAndIProceedToCart() {
        tcs.pom.getNavigation().navigatingSanity();
        tcs.pom.getPlp().addTheItemToCart();
        Assert.assertTrue(tcs.pom.getPlp().itemAddedToCart());
    }

    @When("I signed into the website")
    public void iSignedIntoTheWebsite() throws IOException {
        tcs.pom.getPlp().clickViewBagButton();
        int noOfProducts=tcs.pom.getCart().returnCartItemSize();
        tcs.pom.getAuth().signInWithSavedDetails();
        //tcs.pom.getHeader().clickMyBag();
        int numberAfterSignIn=tcs.pom.getCart().returnCartItemSize();
        Log.info("Before Sign In: "+noOfProducts+" After Sign In: "+numberAfterSignIn);
        Assert.assertTrue(numberAfterSignIn>=noOfProducts);
    }

    @Then("my cart should be merged")
    public void myCartShouldBeMerged() {
        Assert.assertTrue(tcs.pom.getCart().validateCartMessageOnSignIn());
    }
}

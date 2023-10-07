package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class HeaderStepDefnition {
    TestContextSetup tcs;
    public HeaderStepDefnition(TestContextSetup tcs){
        this.tcs=tcs;
    }
    @Given("I am a user on any of the page")
    public void iAmAUserOnAnyOfThePage() {
    }

    @When("I hit Find a store link on the left side of the header")
    public void iHitFindAStoreLinkOnTheLeftSideOfTheHeader() {
        tcs.pom.getHeader().clickFindAStore();
    }

    @Then("It should take me to Find a Store page")
    public void itShouldTakeMeToFindAStorePage() {
        tcs.pom.getHeader().validateFindAStoreVisible();
    }

    @When("I hit Login link on the header")
    public void iHitLoginLinkOnTheHeader() {
        tcs.pom.getHeader().clickLogin();
    }

    @Then("It should redirect to Pcid Login Page")
    public void itShouldRedirectToPcidLoginPage() {
        tcs.pom.getHeader().validatePcLoginPage();
    }

    @When("I hit MyBag button on the header")
    public void iHitMyBagButtonOnTheHeader() {
        tcs.pom.getHeader().clickMyBag();
    }

    @Then("It should redirect to Cart Page")
    public void itShouldRedirectToCartPage() {
        tcs.pom.getHeader().validateMyBag();
    }

    @When("I hit Logo on the header")
    public void iHitLogoOnTheHeader() {
        tcs.pom.getHeader().clickHome();
    }

    @Then("It should redirect to Home Page")
    public void itShouldRedirectToHomePage() {
        tcs.pom.getHeader().validateHomePage();
    }

    @When("I hit Search on the header")
    public void iHitSearchOnTheHeader() {
    }

    @Then("It should be visible")
    public void itShouldBeVisible() {
        tcs.pom.getHeader().searchVisible();
    }
}

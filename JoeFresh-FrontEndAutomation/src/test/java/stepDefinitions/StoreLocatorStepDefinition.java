package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.TestContextSetup;

public class StoreLocatorStepDefinition{
    TestContextSetup tcs;
    public StoreLocatorStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
    }

    @Given("I am on the store locator page")
    public void iAmOnTheStoreLocatorPage() {
        tcs.pom.getStore().visitStoreLocator();
    }

    @When("I begin to type a search term in the search field")
    public void iBeginToTypeASearchTermInTheSearchField() {
        tcs.pom.getStore().clickToEnterAddress();
        tcs.pom.getStore().typeAddress();
    }

    @Then("I should see the suggestions of stores based on the search term.")
    public void iShouldSeeTheSuggestionsOfStoresBasedOnTheSearchTerm()  {
        tcs.pom.getStore().selectLocation();
        Assert.assertTrue(tcs.pom.getStore().storeListDisplayed());
    }

    @Given("a user enter the postal code or city or address and hit enter")
    public void aUserEnterThePostalCodeOrCityOrAddressAndHitEnter() {
        tcs.pom.getStore().visitStoreLocator();
        tcs.pom.getStore().clickToEnterAddress();
        tcs.pom.getStore().typeAddress();
        tcs.pom.getStore().selectLocation();
    }

    @When("the user hit the Direction")
    public void theUserHitTheDirection() {
        tcs.pom.getStore().selectDirection();

    }

    @Then("It should redirect to Google Maps")
    public void itShouldRedirectToGoogleMaps() throws InterruptedException {
        tcs.pom.getStore().googleMapsRedirected();
    }

    @When("the user hit the Details")
    public void theUserHitTheDetails() {
        tcs.pom.getStore().selectDetails();
    }

    @Then("It should show store details")
    public void itShouldShowStoreDetails() {
        tcs.pom.getStore().detailsVisible();
    }
}

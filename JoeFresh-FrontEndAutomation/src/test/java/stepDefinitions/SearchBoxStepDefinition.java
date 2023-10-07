package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import utils.TestContextSetup;

import java.io.IOException;

public class SearchBoxStepDefinition {

    TestContextSetup tcs;

    public SearchBoxStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("I am on any page with search")
    public void iAmOnAnyPageWithSearch() {
        /*
         * Step Definition for the Given Term.
         * Carried out the steps in the Hooks class
         * */
    }

    @When("^I begin typing a search term (.+)$")
    public void i_begin_typing_a_search_term(String term) throws Throwable {
        tcs.pom.getSearch().setSearchBoxMultiple(term);
    }

    @Then("^Then I'll see matching product results in the dropdown$")
    public void then_ill_see_matching_product_results_in_the_dropdown() throws Throwable {
        Assert.assertTrue(tcs.pom.getSearch().dropDownVisiblity());
    }

    @When("I begin typing a incomplete or invalid search term (.+)$")
    public void iBeginTypingAIncompleteOrInvalidSearchTerm(String term) throws IOException, InvalidFormatException {
        tcs.pom.getSearch().
                setSearchBoxMultiple(term);
    }

    @Then("^I will see no results$")
    public void i_will_see_no_results() throws Throwable {
        Assert.assertFalse(tcs.pom.getSearch().dropDownVisiblity());
    }

    @Given("I have entered a search term in the search box (.+)$")
    public void iHaveEnteredASearchTermInTheSearchBox(String term) throws IOException, InvalidFormatException {
        tcs.pom.getSearch().
                setSearchBoxMultiple(term);
    }

    @When("I hit enter")
    public void iHitEnter() {
        tcs.pom.getSearch().searchProduct();
    }

    @Given("I entered a search term in the search box and have a grid of results")
    public void iEnteredASearchTermInTheSearchBoxAndHaveAGridOfResults() throws IOException {
        tcs.pom.getSearch().setSearchBox("Valid Name");
        tcs.pom.getSearch().searchProduct();
    }

    @Given("I entered a search term in the search box that has no match")
    public void iEnteredASearchTermInTheSearchBoxThatHasNoMatch() throws InterruptedException, IOException {
        tcs.pom.getSearch().setSearchBox("Invalid Terms");
        Thread.sleep(2000);
        tcs.pom.getSearch().searchProduct();
    }

    @Given("I am on the search field with prepopulated search term and list of suggested products are displayed")
    public void iAmOnTheSearchFieldWithPrepopulatedSearchTermAndListOfSuggestedProductsAreDisplayed() throws InterruptedException, IOException {
        tcs.pom.getSearch().setSearchBox("Valid Name");
        Thread.sleep(3000);
    }

    @Given("I have entered a valid style code into the Search bar")
    public void iHaveEnteredAValidStyleCodeIntoTheSearchBar() throws IOException {
        tcs.pom.getSearch().setSearchBoxMultiple("F2WR032058");
    }

    @When("I execute the search")
    public void iExecuteTheSearch() {
        tcs.pom.getSearch().searchProduct();
    }
}
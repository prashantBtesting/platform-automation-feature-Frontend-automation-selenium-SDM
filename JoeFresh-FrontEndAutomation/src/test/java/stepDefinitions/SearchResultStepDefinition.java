package stepDefinitions;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import utils.TestContextSetup;

import java.io.IOException;

public class SearchResultStepDefinition {

    TestContextSetup tcs;

    public SearchResultStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
    }

    @Then("I should see a search grid with three items across")
    public void iShouldSeeASearchGridWithThreeItemsAcross() {
        Assert.assertTrue(tcs.pom.getSearchResult().productTileVisiblity());
    }

    @And("Then I should see my search term on the top left")
    public void thenIShouldSeeMySearchTermOnTheTopLeft() {
        Assert.assertTrue(tcs.pom.getSearchResult().getSearchTitle().contains("Outerwear"));
    }

    @When("I choose the filter on the left hand side for a category, colour or price")
    public void iChooseTheFilterOnTheLeftHandSideForACategoryColourOrPrice() throws InterruptedException, IOException {
       // tcs.pom.getSearchResult().checkFilter();
        tcs.pom.getSearchResult().checkRandomFilter();
        tcs.pom.getSearchResult().checkRandomFilter();
        tcs.pom.getSearchResult().checkRandomFilter();
    }

    @Then("I should see the same number of results as noted in the filter name")
    public void iShouldSeeTheSameNumberOfResultsAsNotedInTheFilterName() throws InterruptedException, IOException {
        tcs.pom.getPlp().loadMoreButton();
        Assert.assertEquals(tcs.pom.getSearchResult().getNumberOfProductsDisplayed(),tcs.pom.getSearchResult().getProductQuantity());
    }

    @Then("I should see the chips above the search results that reflect the filters chosen.")
    public void iShouldSeeTheChipsAboveTheSearchResultsThatReflectTheFiltersChosen() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getSearchResult().checkedItemsAndChips());
    }

    @When("I remove single filter pill")
    public void iRemoveSingleFilterPill(DataTable chip) throws IOException, InvalidFormatException, InterruptedException {
        tcs.pom.getSearchResult().removeFilterChip();
    }

    @Then("the count displayed on top should be updated correctly")
    public void theCountDisplayedOnTopShouldBeUpdatedCorrectly() throws InterruptedException, IOException {
        tcs.pom.getPlp().loadMoreButton();
        Assert.assertEquals(tcs.pom.getSearchResult().getNumberOfProductsDisplayed(),tcs.pom.getSearchResult().getProductQuantity());
    }

    @Given("^I have a grid of results and choose multiple filters on the left Nav")
    public void i_have_a_grid_of_results_and_choose_multiple_filters_on_the_left_nav() throws IOException, InvalidFormatException, InterruptedException {
        tcs.pom.getSearch().setSearchBoxMultiple("Dress");
        tcs.pom.getSearch().searchProduct();
        tcs.pom.getSearchResult().checkFilter();
    }

    @When("^I remove the filters selected")
    public void i_remove_the_filters_selected() throws IOException, InvalidFormatException, InterruptedException {
        tcs.pom.getSearchResult().removeFilter();
    }

    @Then("^Then I should see the full results of the search reflected in the page")
    public void then_i_should_see_the_full_results_of_the_search_reflected_in_the_page() throws InterruptedException, IOException {
        tcs.pom.getPlp().loadMoreButton();
        Assert.assertEquals(tcs.pom.getSearchResult().getNumberOfProductsDisplayed(),tcs.pom.getSearchResult().getProductQuantity());
    }

    @When("I hit a product in the suggestion list")
    public void iHitAProductInTheSuggestionList() {
        tcs.pom.getSearch().clickElementOnDropdown();
    }

    @Then("It should take me to the PDP page")
    public void itShouldTakeMeToThePDPPage() {
        tcs.pom.getPdpPage().isImageVisible();
    }

    @And("I should see the Breadcrumps on the left side.")
    public void iShouldSeeTheBreadcrumpsOnTheLeftSide() {
        tcs.pom.getPdpPage().isBreadCrumpsDisplayed();
    }

    @Then("I do not see the breadcrumbs on the search page")
    public void iDoNotSeeTheBreadcrumbsOnTheSearchPage() {
        Assert.assertFalse(tcs.pom.getSearchResult().isBreadCrumpsDisplayed());
    }

    @Then("the product with that style code should be retrieved on the Search results page")
    public void theProductWithThatStyleCodeShouldBeRetrievedOnTheSearchResultsPage() throws IOException, InterruptedException {
        Assert.assertEquals(tcs.pom.getSearchResult().getNumberOfProductsDisplayed(),1);
    }

    @When("I click on sort")
    public void iClickOnSort() {
        tcs.pom.getSearchResult().clickSort();

    }

    @Then("proper sort options should be displayed.")
    public void properSortOptionsShouldBeDisplayed() {
        tcs.pom.getSearchResult().validateSortCriteria();
    }


    @Given("I entered a search term in the search box and have a grid of results to check OOS")
    public void iEnteredASearchTermInTheSearchBoxAndHaveAGridOfResultsToCheckOOS() {
        tcs.pom.getSearch().setSearchBoxMultiple("Dress");
        tcs.pom.getSearch().searchProduct();
    }

    @When("I checked for items")
    public void iCheckedForItems() {
    }

    @Then("no sizes should be out of stock")
    public void noSizesShouldBeOutOfStock() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getPlp().outOfStockItems());
    }
}

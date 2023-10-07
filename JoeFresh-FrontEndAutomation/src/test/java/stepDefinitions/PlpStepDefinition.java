package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import utils.TestContextSetup;

import java.io.IOException;
import java.util.Random;

public class PlpStepDefinition {
    TestContextSetup tcs;
    Random random;
    public PlpStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
        random=new Random();
    }
    @When("I click on the colour swatch of the tile")
    public void iClickOnTheColourSwatchOfTheTile()  {
        //tcs.pom.getPlp().clickColourSwatch();
    }

    @Then("I should see the image change to an item of that colour")
    public void iShouldSeeTheImageChangeToAnItemOfThatColour() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getPlp().validateColourChange());
    }

    @When("I click on the add to bag button")
    public void iClickOnTheAddToBagButton() throws InterruptedException {
        tcs.pom.getPlp().selectSizeSelector();
    }

    @Then("I should see the size selector")
    public void iShouldSeeTheSizeSelector() {
        Assert.assertTrue(tcs.pom.getPlp().sizeBoxVisible());
    }

    @When("I click on the add to bag button, and select a size")
    public void iClickOnTheAddToBagButtonAndSelectASize() throws InterruptedException {
        tcs.pom.getPlp().addTheItemToCart();

    }

    @Then("when I hit the add to bag button again, it should add it to cart")
    public void whenIHitTheAddToBagButtonAgainItShouldAddItToCart() {
        Assert.assertTrue(tcs.pom.getPlp().itemAddedToCart());
    }

    @When("the page is loaded")
    public void thePageIsLoaded() {
        tcs.pom.getPlp().pageLoad();
    }

    @Then("they see products that belong in the category or assortment load in a grid")
    public void theySeeProductsThatBelongInTheCategoryAssortmentLoadInAGrid() {
        Assert.assertTrue(tcs.pom.getPlp().categorySelected());
    }

    @Then("I should see out of stock sizes marked with a line through them, and not be able to select them.")
    public void iShouldSeeOutOfStockSizesMarkedWithALineThroughThemAndNotBeAbleToSelectThem() throws IOException, InterruptedException {
        tcs.pom.getPlp().outOfStockSize();
    }

    @When("I view the sizes on the product tile")
    public void iViewTheSizesOnTheProductTile() throws InterruptedException {
       // tcs.pom.getPlp().addTheItemToCart();
    }

    @Then("they see -Showing number of products visible on page of total products in category products near the top of the page")
    public void theySeeShowingNumberOfProductsVisibleOnPageOfTotalProductsInCategoryProductsNearTheTopOfThePage() {
        tcs.pom.getPlp().topSearchResultDisplayed();
    }

    @And("they see -Showing number of products visible on page of total products in category products bottom of the page")
    public void theySeeShowingNumberOfProductsVisibleOnPageOfTotalProductsInCategoryProductsBottomOfThePage() {
        tcs.pom.getPlp().bottomSearchResultDisplayed();
    }

    @Then("they see the next 30 products that belong in the category or assortment loaded in a grid")
    public void theySeeTheNextProductsThatBelongInTheCategoryAssortmentLoadedInAGrid() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getPlp().allProductsLoaded());
    }

    @When("they click Load more")
    public void theyClickLoadmore() throws InterruptedException {
      // tcs.pom.getPlp().productLoaded();
    }

    @Given("a user is viewing a PLP displaying all available products in the category")
    public void aUserIsViewingAPLPDisplayingAllAvailableProductsInTheCategory() throws InterruptedException, IOException {
        tcs.pom.getNavigation().navigateToCategory();
        /*tcs.pom.getPlp().loadMoreButton();*/
        //tcs.pom.getNavigation().navigatingSanity();
        //tcs.base.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        //((JavascriptExecutor) tcs.base.driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @When("they scroll to the bottom of the PLP")
    public void theyScrollToTheBottomOfThePLP() {
       tcs.pom.getPlp().scrollBelow();
    }


    @Then("they see a Back to top button")
    public void theySeeABackToTopButton() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getPlp().backToTopVisible());
    }

    @Then("they see breadcrumb links at the top left")
    public void theySeeBreadcrumbLinksAtTheTopLeft() throws IOException {
        Assert.assertTrue(tcs.pom.getPlp().breadCrumbsVisible());
        //Assert.assertTrue(tcs.pom.getPlp().breadCrumbContent());
       // Assert.assertTrue(tcs.pom.getPlp().breadCrumbsHomeClickable());
        //Assert.assertTrue(tcs.pom.getPlp().breadCrumbCategoryClickable());
    }

    @Then("they see an an accordion style heading button with the text Category displayed in the expanded state on the left of the page.")
    public void theySeeAnAnAccordionStyleHeadingButtonWithTheTextCategoryDisplayedInTheExpandedStateOnTheLeftOfThePage() {
        Assert.assertTrue(tcs.pom.getPlp().categoryDisplayed());
    }

    @And("each category name is displayed as a link to the respective category page")
    public void eachCategoryNameIsDisplayedAsALinkToTheRespectiveCategoryPage() {
        Assert.assertTrue(tcs.pom.getPlp().linkHref());
    }


    @When("they click on the Category accordion style heading button in the expanded state")
    public void theyClickOnTheCategoryAccordionStyleHeadingButtonInTheExpandedState() {
        tcs.pom.getPlp().collapseCategory();
    }

    @Then("they see the Category accordion style heading button in the collapsed state")
    public void theySeeTheCategoryAccordionStyleHeadingButtonInTheCollapsedState() {
        Assert.assertTrue(tcs.pom.getPlp().validateCategoryCollapse());
    }

    @Then("they see four accordion style text boxes displayed in the expanded state on the left of page")
    public void theySeeFourAccordionStyleTextBoxesDisplayedInTheExpandedStateOnTheLeftOfPage() {
        Assert.assertTrue(tcs.pom.getPlp().validateFilters());
    }

    @And("The attributes are listed as list boxes on the left in the unselected state")
    public void theAttributesAreListedAsListBoxesOnTheLeftInTheUnselectedState() {
        Assert.assertTrue(tcs.pom.getPlp().validateFiltersUnchechecked());
    }

    @And("the relevant quantity of each")
    public void theRelevantQuantityOfEach() {
        Assert.assertTrue(tcs.pom.getPlp().numbersDisplayedInFilter());
    }

    @When("they click on an empty filter checkbox")
    public void theyClickOnAnEmptyFilterCheckbox() {
    }

    @Then("they see a checkmark in the list box they selected,")
    public void theySeeACheckmarkInTheListBoxTheySelected() {
       Assert.assertTrue(tcs.pom.getPlp().validateFilterChecked());
    }

    @And("products that belong in the assortment relevant to their filter selection loaded in a grid")
    public void productsThatBelongInTheAssortmentRelevantToTheirFilterSelectionLoadedInAGrid() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getPlp().validateFilterAndProductCount());
    }

    @When("they click on the accordion container when the accordion in in the expanded state")
    public void theyClickOnTheAccordionContainerWhenTheAccordionInInTheExpandedState() {

    }

    @Then("Then they see the accordion style heading button in the collapsed state")
    public void thenTheySeeTheAccordionStyleHeadingButtonInTheCollapsedState() {
        Assert.assertTrue(tcs.pom.getPlp().validateCollapse());
    }

    @When("they click on the accordion style text box when the accordion is in the collapsed state")
    public void theyClickOnTheAccordionStyleTextBoxWhenTheAccordionIsInTheCollapsedState() {
        tcs.pom.getPlp().collapseAllFilters();
    }

    @Then("they see the accordion style heading button in the expanded state")
    public void theySeeTheAccordionStyleHeadingButtonInTheExpandedState() {
        Assert.assertTrue(tcs.pom.getPlp().expandAccordion());
    }


    @Then("they see a drop down menu near the top right of the page to Sort by Newest")
    public void theySeeADropDownMenuNearTheTopRightOfThePageToSortByNewest() {
        Assert.assertTrue(tcs.pom.getPlp().sortDisplayed());
    }

    @When("they click on a sorting option from the drop down menu")
    public void theyClickOnASortingOptionFromTheDropDownMenu() {
        tcs.pom.getPlp().clickSortButton();
    }

    @Then("they see products rearranged in the grid based on the sorting option selected")
    public void theySeeProductsRearrangedInTheGridBasedOnTheSortingOptionSelected() {
        Assert.assertTrue(tcs.pom.getPlp().sortItemsDropdown());
    }

    @Given("that I am on PLP and filters are applied")
    public void thatIAmOnPLPAndFiltersAreApplied() throws InterruptedException, IOException {
        tcs.pom.getNavigation().navigateToCategory();
      //  tcs.pom.getNavigation().navigatingSanity();
    }

    @When("I refresh the page")
    public void iRefreshThePage() {

    }

    @Then("the applied filters are retained")
    public void theAppliedFiltersAreRetained() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getPlp().validateFilterAfterReload());
    }

    @When("I clicked on Load more")
    public void iClickedOnLoadMore() {
    }
    @Then("the applied filters are retained after loadMore")
    public void theAppliedFiltersAreRetainedAfterLoadMore() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getPlp().validateFilterAfterLoadMore());
    }

    @When("I click sort and load more products")
    public void iClickSortAndLoadMoreProducts() {
    }

    @Then("the more items are loaded in the same sort option")
    public void theMoreItemsAreLoadedInTheSameSortOption() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getPlp().validateSortAfterLoad());
    }

    @When("I scroll to a particular tile And I click tile to view PDP And I click the browser back arrow")
    public void iScrollToAParticularTileAndIClickTileToViewPDPAndIClickTheBrowserBackArrow() {
    }

    @Then("I should see the same tile position And the applied filters should be retained")
    public void iShouldSeeTheSameTilePositionAndTheAppliedFiltersShouldBeRetained() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getPlp().validateFilterAfterPdp());
    }

    @When("I am viewing the page")
    public void iAmViewingThePage() {
    }

    @Then("I should see products that exist within that collection")
    public void iShouldSeeProductsThatExistWithinThatCollection()  {
        Assert.assertTrue(tcs.pom.getPlp().getCollectionProducts().size()>=1);
    }

    @Then("the filters & Sort options should not be displayed")
    public void theFiltersSortOptionsShouldNotBeDisplayed() {
        Assert.assertTrue(tcs.pom.getPlp().filterSortNotDisplayed());
    }

    @Then("the item images, price, color swatch, sizes, tags should be displayed correctly for the items")
    public void theItemImagesPriceColorSwatchSizesTagsShouldBeDisplayedCorrectlyForTheItems() {
        Assert.assertTrue(tcs.pom.getPlp().productInfoDisplayed());
    }

    @When("they click on a Price Low To High from the drop down menu")
    public void theyClickOnAPriceLowToHighFromTheDropDownMenu() {

    }

    @Then("they see products rearranged in the grid based on the price High To Low")
    public void theySeeProductsRearrangedInTheGridBasedOnThePriceHighToLow() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getPlp().verifyPriceHighToLow());
    }

    @When("they click on a Price High To Low from the drop down menu")
    public void theyClickOnAPriceHighToLowFromTheDropDownMenu() {
    }

    @Then("they see products rearranged in the grid based on the price Low To High")
    public void theySeeProductsRearrangedInTheGridBasedOnThePriceLowToHigh() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getPlp().verifyPriceLowToHigh());
    }

    @Given("I am on Sales and Deals page")
    public void iAmOnSalesAndDealsPage() {

    }

    @When("I am viewing the Sales page")
    public void iAmViewingTheSalesPage() {
    }

    @Then("the clearance price,regular price and product badge should be displayed")
    public void theClearancePriceRegularPriceAndProductBadgeShouldBeDisplayed() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getPlp().salePriceAndBadgeDisplayed());
    }

    @Then("they see a fourofour page")
    public void theySeeAPage() {
        Assert.assertTrue(tcs.pom.getPlp().fourofour());
    }

    @When("They click on Checked filters")
    public void theyClickOnCheckedFilters() {
    }

    @Then("The filter should be removed")
    public void theFilterShouldBeRemoved() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getPlp().removeFilter());
    }

    @When("they click multiple filters")
    public void theyClickMultipleFilters() {
    }

    @Then("the multiple filters should be checked")
    public void theMultipleFiltersShouldBeChecked() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getPlp().multipleCheckFilters());
    }

    @Given("I am on page with regular and extended sizes")
    public void iAmOnPageWithRegularAndExtendedSizes() {
        tcs.pom.getNavigation().navigateWomenPlusCategory();
    }

    @When("I select the product")
    public void iSelectTheProduct() {
    }

    @Then("the size at Plp should be equal to Pdp")
    public void theSizeAtPlpShouldBeEqualToPdp() {
        Assert.assertTrue(tcs.pom.getPlp().plpSizesSameAsPdp());
    }

    @Then("the PDP information should be same as PLP")
    public void thePDPInformationShouldBeSameAsPLP() {
        int randomProduct=random.nextInt(tcs.pom.getPlp().getProductTiles().size());
        Assert.assertTrue(tcs.pom.getPlp().validatePdpProductInfoEqualsPlp(tcs.pom.getPlp().getProductTiles().get(randomProduct)));
    }

}

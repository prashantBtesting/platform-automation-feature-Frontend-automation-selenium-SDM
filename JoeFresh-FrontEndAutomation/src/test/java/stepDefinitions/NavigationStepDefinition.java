package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.TestContextSetup;

import java.io.IOException;

public class NavigationStepDefinition {

    TestContextSetup tcs;

    public NavigationStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
    }
    @Given("I am on the PLP with results")
    public void iAmOnThePLPWithResults() throws  IOException {
        tcs.pom.getNavigation().navigatingSanity();
       }


    @Given("I am on the PLP with results having out of stock sizes")
    public void iAmOnThePLPWithResultsHavingOutOfStockSizes() throws IOException, InterruptedException {
        tcs.pom.getNavigation().selectMentionedHeader("Out Of Stock-Size");
    }
    @Given("that I am on PLP with more than thirty products and filters are applied")
    public void thatIAmOnPLPWithMoreThanThirtyProductsAndFiltersAreApplied() {
        tcs.pom.getNavigation().navigationMoreThan30products();
    }

    @Given("I am on shop or collection Page")
    public void iAmOnShopOrCollectionPage() throws IOException {
        tcs.pom.getNavigation().navigateToCollection();
    }

    @When("I click on the New link")
    public void iClickOnTheNewLink() {

    }

    @And("each link is clickable & should redirect to correct pages.")
    public void eachLinkIsClickableShouldRedirectToCorrectPages()  throws IOException {
        Assert.assertTrue(tcs.pom.getNavigation().navigateNew());
    }

    @Given("I am on the Joe fresh site")
    public void iAmOnTheJoeFreshSite() {
    }

    @Then("as a user I should see the links under Shop new category")
    public void asAUserIShouldSeeTheLinksUnderShopNewCategory() {
    }

    @When("I click on the Women link")
    public void iClickOnTheWomenLink() {
    }

    @Then("as a user I should see the links under Shop Women category")
    public void asAUserIShouldSeeTheLinksUnderShopWomenCategory() {
    }

    @And("each link is clickable & should redirect to correct Women pages.")
    public void eachLinkIsClickableShouldRedirectToCorrectWomenPages() throws IOException, InterruptedException {
        Assert.assertTrue(tcs.pom.getNavigation().navigateWomen());
    }

    @When("I click on the Women Plus link")
    public void iClickOnTheWomenPlusLink() {
    }

    @Then("as a user I should see the links under Shop Women Plus category")
    public void asAUserIShouldSeeTheLinksUnderShopWomenPlusCategory() {
    }

    @And("each link is clickable & should redirect to correct Women Plus pages.")
    public void eachLinkIsClickableShouldRedirectToCorrectWomenPlusPages() throws IOException, InterruptedException {
        Assert.assertTrue(tcs.pom.getNavigation().navigateWomenPlus());
    }

    @And("each link is clickable & should redirect to correct Men pages.")
    public void eachLinkIsClickableShouldRedirectToCorrectMenPages() throws IOException, InterruptedException {
        Assert.assertTrue(tcs.pom.getNavigation().navigateMen());
    }

    @When("I click on the Toddler Boys link")
    public void iClickOnTheToddlerBoysLink() {
    }

    @Then("as a user I should see the links under Shop Girls category")
    public void asAUserIShouldSeeTheLinksUnderShopGirlsCategory() {
    }

    @And("each link is clickable & should redirect to correct Girls pages.")
    public void eachLinkIsClickableShouldRedirectToCorrectGirlsPages() throws IOException, InterruptedException {
        Assert.assertTrue(tcs.pom.getNavigation().navigateGirls());
    }

    @When("I click on the Boys link")
    public void iClickOnTheBoysLink() {
    }

    @Then("as a user I should see the links under Shop Boys category")
    public void asAUserIShouldSeeTheLinksUnderShopBoysCategory() {
    }

    @And("each link is clickable & should redirect to correct Boys pages.")
    public void eachLinkIsClickableShouldRedirectToCorrectBoysPages() throws IOException, InterruptedException {
        Assert.assertTrue(tcs.pom.getNavigation().navigateBoys());
    }

    @When("I click on the Todlers link")
    public void iClickOnTheTodlersLink() {

    }

    @Then("as a user I should see the links under Shop Toddlers category")
    public void asAUserIShouldSeeTheLinksUnderShopToddlersCategory() {
    }

    @And("each link is clickable & should redirect to correct Toddlers pages.")
    public void eachLinkIsClickableShouldRedirectToCorrectToddlersPages() throws IOException, InterruptedException {
        Assert.assertTrue(tcs.pom.getNavigation().navigateToddlersGirls());
        Assert.assertTrue(tcs.pom.getNavigation().navigateToddlersBoys());
        Assert.assertTrue(tcs.pom.getNavigation().navigateToddlerCommon());
    }
    @Then("as a user I should see the links under Shop Baby category")
    public void asAUserIShouldSeeTheLinksUnderShopBabyCategory()  {

    }

    @And("each link is clickable & should redirect to correct Baby pages.")
    public void eachLinkIsClickableShouldRedirectToCorrectBabyPages() throws IOException, InterruptedException {
        Assert.assertTrue(tcs.pom.getNavigation().navigateBabyGirls());
        Assert.assertTrue(tcs.pom.getNavigation().navigateBabyBoys());
        Assert.assertTrue(tcs.pom.getNavigation().navigateBabyCommon());
    }

    @Then("as a user I should see the links under Shop Active category")
    public void asAUserIShouldSeeTheLinksUnderShopActiveCategory() {

    }

    @When("I click on the Active link")
    public void iClickOnTheActiveLink() {
    }

    @And("each link is clickable & should redirect to correct Active pages.")
    public void eachLinkIsClickableShouldRedirectToCorrectActivePages() throws IOException, InterruptedException {
        Assert.assertTrue(tcs.pom.getNavigation().navigateActive());
    }

    @When("I want to visit Rain Shop")
    public void iWantToVisitRainShop() {
    }

    @Then("as a user I should see the links under various header associated with children and redirect to Rain Shop")
    public void asAUserIShouldSeeTheLinksUnderVariousHeaderAssociatedWithChildrenAndRedirectToRainShop() throws IOException, InterruptedException {
        Assert.assertTrue(tcs.pom.getNavigation().navigatingCollectionRainShop());
    }

    @Then("as a user I should see the links under various header associated with children and redirect to Back To School")
    public void asAUserIShouldSeeTheLinksUnderVariousHeaderAssociatedWithChildrenAndRedirectToBackToSchool() throws IOException, InterruptedException {
        Assert.assertTrue(tcs.pom.getNavigation().navigatingCollectionBackToSchool());
    }

    @Then("as a user I should see the links under various header associated with children and redirect to PC Children")
    public void asAUserIShouldSeeTheLinksUnderVariousHeaderAssociatedWithChildrenAndRedirectToPCChildren() throws IOException, InterruptedException {
        Assert.assertTrue(tcs.pom.getNavigation().navigatingChildrenCharity());
    }

    @When("I click on the Disney and Marvel and then Disney")
    public void iClickOnTheDisneyAndMarvelAndThenDisney() {
    }

    @Then("as a user I should redirect to Disney Page")
    public void asAUserIShouldRedirectToDisneyPage() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getNavigation().navigateDisney());
    }

    @Then("as a user I should redirect to Marvel Page")
    public void asAUserIShouldRedirectToMarvelPage() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getNavigation().navigateMarvel());
    }
}

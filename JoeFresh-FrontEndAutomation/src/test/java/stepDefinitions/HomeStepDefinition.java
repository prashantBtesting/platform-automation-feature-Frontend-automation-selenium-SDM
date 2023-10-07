package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.TestContextSetup;

import java.io.IOException;

public class HomeStepDefinition {

    TestContextSetup tcs;

    public HomeStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("I am on PDP")
    public void i_am_on_pdp_page1() throws IOException {
       // tcs.pom.getNavigation().navigatingSanity();
        tcs.pom.getPDP().selectRandomProduct();
    }

    @Given("I am on a PDP")
    public void i_am_on_a_pdp2() throws IOException {
       // tcs.pom.getNavigation().navigatingSanity();
        tcs.pom.getPDP().selectRandomProduct();
    }

    @Given("I  am on home page")
    public void i_am_on_home_page() {
        System.out.println("I am on Homepage");
    }

    @When("I click on recommended option")
    public void i_click_on_recommended_option() {
        tcs.common.clickOn(tcs.pom.getHomePage().recommendedOptions);
    }

    @Then("I am Able to add them in a cart")
    public void i_am_able_to_add_them_in_a_cart() {
        tcs.common.clickOn(tcs.pom.getPDP().SelectXSSize);
        Assert.assertTrue(tcs.common.clickOn(tcs.pom.getPDP().addToBag));
        System.out.println("I am abl to add to cart the item");
    }

    @When("I click on Trending options")
    public void i_click_on_trending_options() {
        Assert.assertTrue(tcs.common.clickOn(tcs.pom.getHomePage().TrendingOptions));

    }

    @When("I clicked on shop now")
    public void i_clicked_on_shop_now() {
        Assert.assertTrue(tcs.common.clickOn(tcs.pom.getHomePage().ShopWomenNewArrival));
        System.out.println("clicked on shopnow button");

    }

    @Then("I am Redirected to that page")
    public void i_am_redirected_to_that_page() {
        tcs.common.addExplicitWait(tcs.pom.getHomePage().PageNotFound);
        Assert.assertFalse(tcs.pom.getHomePage().PageNotFound.isDisplayed());
        System.out.println(tcs.common.getTitle());
    }

    @When("I clicked on shopnow marvel")
    public void i_clicked_on_shopnow_marval() {
        tcs.common.clickOn(tcs.pom.getHomePage().MarvalCollection);
        System.out.println("clicked on MarvalShopNow button");
    }

    @Then("I am redirected to Marvel page")
    public void i_am_redirected_to_marval_page() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertFalse(tcs.pom.getHomePage().PageNotFound.isDisplayed());
    }

    @When("I clicked on shopnow Disney")
    public void i_clicked_on_shopnow_disney() {
        tcs.common.clickOn(tcs.pom.getHomePage().DisneyCollection);
    }

    @Then("I am redirected to tha disney page")
    public void i_am_redirected_to_tha_disney_page() {
        tcs.common.addExplicitWait(tcs.pom.getHomePage().disneyHeading);
        Assert.assertTrue(tcs.pom.getHomePage().disneyHeading.isDisplayed(), "Disney Heading not found");
    }

}

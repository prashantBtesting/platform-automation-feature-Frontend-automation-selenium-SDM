package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.TestContextSetup;

import java.io.IOException;

public class DealsStepDefinition {
    TestContextSetup tcs;

    public DealsStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }
    @Given("I am on a PDP Page added with two of fifty dollar product")
    public void i_am_on_a_pdp_page_added_with_two_of_fifty_dollar_product() throws IOException {
        tcs.pom.getHomePage().DealsProductJA1();
        tcs.common.enter(tcs.pom.getHomePage().searchBox);
        tcs.common.clickOn(tcs.pom.getPDP().Hoodie);
    }
    @When("I calculate the price of the product J1A")
    public void i_calculate_the_price_of_the_product() {
        tcs.common.addExplicitWait(tcs.pom.getPDP().ProductImage);
        tcs.pom.getPDP().SelectEnabledSize();
        tcs.pom.getPDP().addToBag.click();
        tcs.common.clickOn(tcs.pom.getPDP().viewBag);
    }
    @Then("It should be as expected")
    public void it_should_be_as_expected() throws InterruptedException {
       Assert.assertTrue(tcs.pom.getCartPage().calculatePriceOfJA1Product());

    }

    @Given("J1B product is added in the cart")
    public void j1b_product_is_added_in_the_cart() throws IOException {
        tcs.pom.getHomePage().DealsProductJ1B();
        tcs.common.enter(tcs.pom.getHomePage().searchBox);
        tcs.common.clickOn(tcs.pom.getHomePage().J1BProduct);

    }

    @When("I calculate the price of the product J1B")
    public void i_calculate_the_price_of_the_product_j1b() {

        tcs.pom.getPDP().J1BProductValidations();
    }

    @Then("the price should be as expected")
    public void the_price_should_be_as_expected() {


    }
}

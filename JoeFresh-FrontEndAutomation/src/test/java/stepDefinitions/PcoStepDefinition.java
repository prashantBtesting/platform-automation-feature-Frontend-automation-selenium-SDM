package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.DataDriven;
import utils.TestContextSetup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class PcoStepDefinition {
    TestContextSetup tcs;
    Random random;
    public PcoStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
        random=new Random();
    }
    @Given("the user has the products that belong to OT1 only")
    public void theUserHasTheProductsThatBelongToOT1Only() throws IOException, InterruptedException {
        ArrayList<String> productLiams= DataDriven.getTestData("PCO","OT1");
      int randomLiam=random.nextInt(productLiams.size()-1)+1;

            tcs.pom.getSearch().setSearchBoxMultiple(productLiams.get(randomLiam));
            tcs.pom.getSearch().searchProduct();

        tcs.pom.getPlp().visitPdp();
        tcs.pom.getPdpPage().itemAddToCart();
    }

    @When("the user navigate to the cart")
    public void theUserNavigateToTheCart() {
        tcs.pom.getHeader().clickMyBag();
    }

    @Then("the points should be as per the ot1 rules in the cart")
    public void thePointsShouldBeAsPerTheOt1RulesInTheCart() throws IOException {
        tcs.pom.getMypcOptimumPoints().validateOt1();
    }

    @Given("the user has the products that belong to OT4a only")
    public void theUserHasTheProductsThatBelongToOT4AOnly() {
    }

    @Then("the points should be as per the ot4a rules in the cart")
    public void thePointsShouldBeAsPerTheOt4ARulesInTheCart() {
    }

    @Given("the user has the products that belong to OT4b only")
    public void theUserHasTheProductsThatBelongToOT4bOnly() {
    }

    @Then("the points should be as per the ot4b rules in the cart")
    public void thePointsShouldBeAsPerTheOt4bRulesInTheCart() {
    }

    @Given("the user has the products that belong all types of product rules")
    public void theUserHasTheProductsThatBelongAllTypesOfProductRules() {
    }


    @Then("the points should be as per the applicable rules in the cart")
    public void thePointsShouldBeAsPerTheApplicableRulesInTheCart() {

    }

    @Given("the user has the products that belong to OT6 only")
    public void theUserHasTheProductsThatBelongToOT6Only() {
    }

    @Then("the points should be as per the ot6 rules in the cart")
    public void thePointsShouldBeAsPerTheOt6RulesInTheCart() {
    }
}

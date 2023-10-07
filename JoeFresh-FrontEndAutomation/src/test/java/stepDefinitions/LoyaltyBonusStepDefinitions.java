package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import resources.DataDriven;
import util.Log;
import utils.TestContextSetup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class LoyaltyBonusStepDefinitions {
    TestContextSetup tcs;
    Random random;
    public LoyaltyBonusStepDefinitions(TestContextSetup tcs){
        this.tcs=tcs;
        random=new Random();
    }

    @Given("an end user searches the product as per OT1")
    public void anEndUserSearchesTheProductAsPerOT1() throws IOException {
        ArrayList<String> ot1Liams= DataDriven.getTestData("PCO","OT1");
        for (int i=0;i<5;i++){
            int randomNumber=random.nextInt(ot1Liams.size());
            if(randomNumber==0){
                randomNumber=1;
            }
            Log.info("Random Number: "+randomNumber);
            tcs.pom.getSearch().setSearchBoxMultiple(ot1Liams.get(randomNumber));
            tcs.pom.getSearch().searchProduct();
            tcs.pom.getPlp().addTheItemToCart();
            Assert.assertTrue(tcs.pom.getPlp().itemAddedToCart());
            tcs.pom.getPlp().clickViewBagButton();
        }
    }

    @When("he visit the cart")
    public void heVisitTheCart() {
        tcs.pom.getHeader().clickMyBag();
    }

    @Then("he will see PCOptimum points as per OT1")
    public void heWillSeePCOptimumPointsAsPerOT1() throws IOException {
        Assert.assertTrue(tcs.pom.getMypcOptimumPoints().validateOt1());
    }

    @Given("an end user searches the product as per OT6")
    public void anEndUserSearchesTheProductAsPerOT6() {
    }

    @Then("he will see PCOptimum points as per OT6")
    public void heWillSeePCOptimumPointsAsPerOT6() {
    }

    @Given("an end user searches the product as per OT4A")
    public void anEndUserSearchesTheProductAsPerOT4A() {
    }

    @Then("he will see PCOptimum points as per OT4A")
    public void heWillSeePCOptimumPointsAsPerOT4A() {
    }

    @Given("an end user searches the product from different categories")
    public void anEndUserSearchesTheProductFromDifferentCategories() {
    }

    @Then("he will see PCOptimum points as per the rules combined")
    public void heWillSeePCOptimumPointsAsPerTheRulesCombined() {
    }

    @Given("an end user searches the product as per OT4B")
    public void anEndUserSearchesTheProductAsPerOT4B() {
    }

    @Then("he will see PCOptimum points as per OT4B")
    public void heWillSeePCOptimumPointsAsPerOT4B() {
    }

    @When("he visit the cart and increase the quantity")
    public void heVisitTheCartAndIncreaseTheQuantity() {
        //tcs.pom.getHeader().clickMyBag();
        tcs.pom.getMypcOptimumPoints().addMoreQuantity(tcs.pom.getCart().getCartItems().get(0));

    }

    @Then("he will see PCOptimum points as per OT1 and quantity")
    public void heWillSeePCOptimumPointsAsPerOTAndQuantity() throws IOException {
        Assert.assertTrue(tcs.pom.getMypcOptimumPoints().validateOt1());

    }
}

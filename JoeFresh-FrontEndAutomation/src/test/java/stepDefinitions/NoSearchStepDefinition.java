package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import utils.TestContextSetup;

public class NoSearchStepDefinition {

    TestContextSetup tcs;

    public NoSearchStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
    }

    @Then("^I should see a message telling me that my item was not found$")
    public void i_should_see_a_message_telling_me_that_my_item_was_not_found() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getNoSearchPage().noSearchResultTextVisible());
    }


    @And("I should see a carousel of recommended items, and chips to take me to common categories")
    public void iShouldSeeACarouselOfRecommendedItemsAndChipsToTakeMeToCommonCategories() {
        Assert.assertTrue(tcs.pom.getNoSearchPage().recommendedProductVisible());
        Assert.assertTrue(tcs.pom.getNoSearchPage().productNavigationVisible());
    }
}

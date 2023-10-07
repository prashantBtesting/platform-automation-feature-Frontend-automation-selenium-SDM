package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import utils.TestContextSetup;

public class FooterGetHelpStepDefinition {
    TestContextSetup tcs;
    public FooterGetHelpStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
    }
    @Given("a user arrived at My Bag Page")
    public void aUserArrivedAtMyBagPage() {
        tcs.pom.getFooter().visitMyCartPage();
    }

    @Then("I should see the Get Help tile at the bottom of the footer area.")
    public void iShouldSeeTheGetHelpTileAtTheBottomOfTheFooterArea() {
    }

    @Then("I should see the Get Help chatbox when I click the button")
    public void iShouldSeeTheGetHelpChatboxWhenIClickTheButton() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getFooter().getHelpVisible());
    }

    @Then("I open the chat box and click minimize, then it should be minimized")
    public void iOpenTheChatBoxAndClickMinimizeThenItShouldBeMinimized() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getFooter().getHelpFrameMinimize());
    }

    @Then("I open the chat box and click close, then it should be closed")
    public void iOpenTheChatBoxAndClickCloseThenItShouldBeClosed() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getFooter().getHelpFrameClose());
    }

    @Then("I should able to select options and it should repsonse")
    public void iShouldAbleToSelectOptionsAndItShouldRepsonse() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getFooter().getHelpClickSuggestion());
    }

    @Then("I click Settings and the settings section should displayed")
    public void iClickSettingsAndTheSettingsSectionShouldDisplayed() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getFooter().getHelpSettings());
    }


}

package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.Log;
import utils.TestContextSetup;

import java.io.IOException;

public class NewsletterStepDefinition {
    TestContextSetup tcs;
    public NewsletterStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
    }
    @Given("User is on the Newsletter Page")
    public void userIsOnTheNewsletterPage() throws IOException {
        tcs.pom.getNewsletters().visitNewsletters();
    }

    @When("User enters all details and submit")
    public void userEntersAllDetailsAndSubmit() throws IOException, InterruptedException {
        Log.info(tcs.pom.getNewsletters().getData().get(1));
        tcs.pom.getNewsletters().typeFirstName();
        tcs.pom.getNewsletters().typeEmail();
        tcs.pom.getNewsletters().clickCheckBox();
        tcs.pom.getNewsletters().clickSubmit();
    }

    @Then("the sucess message is displayed")
    public void theSucessMessageIsDisplayed() {
        Assert.assertTrue(tcs.pom.getNewsletters().validateSucessMessage());
    }

    @When("User enters all details except email and submit")
    public void userEntersAllDetailsExceptEmailAndSubmit() throws IOException, InterruptedException {
        tcs.pom.getNewsletters().typeFirstName();
        tcs.pom.getNewsletters().clickCheckBox();
        tcs.pom.getNewsletters().clickSubmit();
    }

    @Then("the email error message is displayed")
    public void theEmailErrorMessageIsDisplayed() {
        Assert.assertTrue(tcs.pom.getNewsletters().validateEmailErrorIsDisplayed());
    }

    @When("User enters all details except name and submit")
    public void userEntersAllDetailsExceptNameAndSubmit() throws IOException, InterruptedException {
        tcs.pom.getNewsletters().typeEmail();
        tcs.pom.getNewsletters().clickCheckBox();
        tcs.pom.getNewsletters().clickSubmit();
    }

    @Then("the first name error is displayed")
    public void theFirstNameErrorIsDisplayed() {
        Assert.assertTrue(tcs.pom.getNewsletters().validateFirstNameError());
    }

    @When("User enters all details except checkbox and submit")
    public void userEntersAllDetailsExceptCheckboxAndSubmit() throws IOException, InterruptedException {
        tcs.pom.getNewsletters().typeFirstName();
        tcs.pom.getNewsletters().typeEmail();
        tcs.pom.getNewsletters().clickSubmit();
    }

    @Then("the checkbox error is displayed")
    public void theCheckboxErrorIsDisplayed() {
        Assert.assertTrue(tcs.pom.getNewsletters().validateCheckBoxErrorDisplayed());
    }

    @When("User enters no details and submit")
    public void userEntersNoDetailsAndSubmit() throws InterruptedException {
        tcs.pom.getNewsletters().clickSubmit();
    }

    @Then("all errors are displayed")
    public void allErrorsAreDisplayed() {
        Assert.assertTrue(tcs.pom.getNewsletters().validateFirstNameError());
        Assert.assertTrue(tcs.pom.getNewsletters().validateEmailErrorIsDisplayed());
        Assert.assertTrue(tcs.pom.getNewsletters().validateCheckBoxErrorDisplayed());
    }

    @When("I navigate to agreeTerms condition")
    public void iNavigateToAgreeTermsCondition() {

    }

    @Then("I click Terms and Conditions check statement and it should redirect to Terms and Conditions page")
    public void iClickTermsAndConditionsCheckStatementAndItShouldRedirectToTermsAndConditionsPage() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getNewsletters().validateTermsLink());
    }

    @Then("I click Terms and Conditions check statement and it should redirect to Privacy page")
    public void iClickTermsAndConditionsCheckStatementAndItShouldRedirectToPrivacyPage() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getNewsletters().validatePrivacyLink());
    }
}

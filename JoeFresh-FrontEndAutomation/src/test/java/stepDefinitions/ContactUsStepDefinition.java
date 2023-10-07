package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.TestContextSetup;

import java.io.IOException;

public class ContactUsStepDefinition {
    TestContextSetup tcs;
    public ContactUsStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
    }
    @Given("an end user visited the Contact Us page")
    public void anEndUserVisitedTheContactUsPage() throws IOException {
        tcs.pom.getContactUs().navigateContactUs();
    }

    @When("he fills all the valid details")
    public void heFillsAllTheValidDetails() {
        tcs.pom.getContactUs().enterFirstName();
        tcs.pom.getContactUs().enterLastName();
        tcs.pom.getContactUs().enterEmail();
        tcs.pom.getContactUs().dropDown();
        tcs.pom.getContactUs().enterMessage();
        tcs.pom.getContactUs().clickSubmit();
    }

    @Then("the form should be submitted")
    public void theFormShouldBeSubmitted() {
        Assert.assertTrue(tcs.pom.getContactUs().validateSuccessMessage());
    }

    @When("he fills all details except name")
    public void heFillsAllDetailsExceptName() {
        tcs.pom.getContactUs().enterEmail();
        tcs.pom.getContactUs().dropDown();
        tcs.pom.getContactUs().enterMessage();
        tcs.pom.getContactUs().clickSubmit();
    }

    @Then("the form should not be submitted and name error should be displayed")
    public void theFormShouldNotBeSubmittedAndNameErrorShouldBeDisplayed() {
        Assert.assertTrue(tcs.pom.getContactUs().visiblityOfFirstNameError());
        Assert.assertTrue(tcs.pom.getContactUs().visiblityOfLastNameError());
    }

    @When("he fills all details except email")
    public void heFillsAllDetailsExceptEmail() {
        tcs.pom.getContactUs().enterFirstName();
        tcs.pom.getContactUs().enterLastName();
        tcs.pom.getContactUs().dropDown();
        tcs.pom.getContactUs().enterMessage();
        tcs.pom.getContactUs().clickSubmit();
    }

    @Then("the form should not be submitted and email error should be displayed")
    public void theFormShouldNotBeSubmittedAndEmailErrorShouldBeDisplayed() {
        Assert.assertTrue(tcs.pom.getContactUs().visiblityOfEmailError());
    }

    @When("he fills all details except dropdown")
    public void heFillsAllDetailsExceptDropdown() {
        tcs.pom.getContactUs().enterFirstName();
        tcs.pom.getContactUs().enterLastName();
        tcs.pom.getContactUs().enterEmail();
        tcs.pom.getContactUs().enterMessage();
        tcs.pom.getContactUs().clickSubmit();
    }

    @Then("the form should not be submitted and dropdown error should be displayed")
    public void theFormShouldNotBeSubmittedAndDropdownErrorShouldBeDisplayed() {
        Assert.assertTrue(tcs.pom.getContactUs().visiblityOfDropdownError());
    }

    @When("he fills all details except message")
    public void heFillsAllDetailsExceptMessage() {
        tcs.pom.getContactUs().enterFirstName();
        tcs.pom.getContactUs().enterLastName();
        tcs.pom.getContactUs().enterEmail();
        tcs.pom.getContactUs().dropDown();
        tcs.pom.getContactUs().clickSubmit();
    }

    @Then("the form should not be submitted and message error should be displayed")
    public void theFormShouldNotBeSubmittedAndMessageErrorShouldBeDisplayed() {
        Assert.assertTrue(tcs.pom.getContactUs().visiblityOfMessageError());
    }
}

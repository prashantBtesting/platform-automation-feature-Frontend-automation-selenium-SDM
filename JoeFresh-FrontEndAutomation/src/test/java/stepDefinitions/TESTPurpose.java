package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class TESTPurpose {
    TestContextSetup tcs;
    public TESTPurpose(TestContextSetup tcs){
        this.tcs = tcs;
    }
    @Given("I am on The Home Page")
    public void i_am_on_the_home_page() {
     //   tcs.pom.getCartPage().ReplaceAllExample1();
        tcs.pom.getCartPage().isPalindromString();
    }

    @When("I add a string")
    public void i_add_a_string() {
        System.out.println("Hi2");
    }

    @Then("I should be able to replace the function")
    public void i_should_be_able_to_replace_the_function() {
        System.out.println("Hi3");
    }
}

package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.Log;
import utils.TestContextSetup;

public class PCIDStepDifination {
    TestContextSetup tcs;

    public PCIDStepDifination(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("I on the homepage")
    public void i_on_the_homepage() {
        System.out.println("I am On Home Page And going to click on Sign in button");
    }

    @When("I clicked on Sign In button")
    public void i_clicked_on_sign_in_button() {
        tcs.pom.getHomePage().signIN();
        tcs.common.addExplicitWait(tcs.pom.getPcid().emailF);
    }

    @Then("I am able to sign in")
    public void i_am_able_to_sign_in() {

        tcs.pom.getPcid().emailM("prashant.babar5246@gmail.com");
        tcs.pom.getPcid().passM("8793440363@Pb");
        tcs.common.clickOn(tcs.pom.getPcid().submitSignInOrCheckout);
        Log.info("Successfully Logged in");
    }

    @Then("I am Able to sign out")
    public void i_am_able_to_sign_out() {
        tcs.common.addExplicitWait(tcs.pom.getHomePage().myAccount);
        tcs.common.clickOn(tcs.pom.getHomePage().myAccount);
        tcs.common.clickOn(tcs.pom.getHomePage().signOut);
        Log.info("Successfully and signOut");
    }


    @Given("I am on the PCO page and have a PCO account")
    public void i_am_on_the_pco_page_and_have_a_pco_account() {
        tcs.pom.getPcid().signInToPCOptimumAccount("joefresh1@yopmail.com", "passwordisnew");
    }

    @When("tthe page loads")
    public void tthe_page_loads() {
        System.out.println("You are on PCOptimum Account");
    }

    @Then("I am presented with a section that shows my current number of PCO, redeemable value, email, option to manage PCO account")
    public void i_am_presented_with_a_section_that_shows_my_current_number_of_pco_redeemable_value_email_option_to_manage_pco_account() {
        Assert.assertTrue(tcs.pom.getPcid().CheckPCOptimumValuesDetails(), "element not visible");
    }

    @Given("I am on the PCO page and have PCO \\(regardless if I have PCOI or not)")
    public void i_am_on_the_pco_page_and_have_pco_regardless_if_i_have_pcoi_or_not() {
        tcs.pom.getPcid().signInToPCOptimumAccount("joefresh1@yopmail.com", "passwordisnew");
    }

    @When("the page loads and there are special JF offers available")
    public void the_page_loads_and_there_are_special_jf_offers_available() {


    }

    @Then("I am presented with a list of JF offers and a link to all PCO offers")
    public void i_am_presented_with_a_list_of_jf_offers_and_a_link_to_all_pco_offers() {
        tcs.common.addExplicitWait(tcs.pom.getPcid().noOffers);
        Assert.assertFalse(tcs.pom.getPcid().noOffers.isDisplayed());
    }

    @When("there are no offers")
    public void there_are_no_offers() {
        System.out.println("When There Are No Offers");
    }

    @Then("I am presented an empty list with the empty state text \\(ex. Your Joe Fresh offers list is empty...)")
    public void i_am_presented_an_empty_list_with_the_empty_state_text_ex_your_joe_fresh_offers_list_is_empty() {
        tcs.common.addExplicitWait(tcs.pom.getPcid().noOffers);
        Assert.assertTrue(tcs.pom.getPcid().noOffers.isDisplayed());
        String ActualText = tcs.pom.getPcid().noOffers.getText();
        System.out.println(ActualText);
    }

    @Given("I am on the PCO page and I am not a PCO user \\(but have PC ID)")
    public void i_am_on_the_pco_page_and_i_am_not_a_pco_user_but_have_pc_id() {
        tcs.pom.getPcid().signInToPCOptimumAccount("joefresh3@yopmail.com", "passwordisnew");
    }

    @Then("I am presented with information on PCO and a link to join PCO")
    public void i_am_presented_with_information_on_pco_and_a_link_to_join_pco() {
        tcs.common.addExplicitWait(tcs.pom.getPcid().pointsBalance);
        Assert.assertTrue(tcs.pom.getPcid().pcOptimumInsiders.isDisplayed());
    }


}

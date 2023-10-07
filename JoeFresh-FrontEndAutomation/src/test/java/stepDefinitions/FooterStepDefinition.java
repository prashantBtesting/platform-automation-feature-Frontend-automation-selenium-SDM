package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.TestContextSetup;

public class FooterStepDefinition {
    TestContextSetup tcs;
    public FooterStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
    }
    @Given("I have navigate to Joe Fresh site")
    public void iHaveNavigateToJoeFreshSite() {
    }

    @When("I navigate to the footer area")
    public void iNavigateToTheFooterArea() {
        tcs.pom.getFooter().scrollToBottom();
    }

    @Then("I should see the footer cards")
    public void iShouldSeeTheFooterCards() {
        Assert.assertTrue(tcs.pom.getFooter().validateFooterIcons());
    }

    @Then("About us link redirects to About Us page")
    public void aboutUsLinkRedirectsToAboutUsPage() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getFooter().validateAboutUs());
        Assert.assertTrue(tcs.pom.getFooter().validateStoreLocator());
        Assert.assertTrue(tcs.pom.getFooter().validateAppButton());
    }

    @Then("Let Us Help You redirects to respective options")
    public void letUsHelpYouRedirectsToRespectiveOptions() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getFooter().validateContactUs());
        Assert.assertTrue(tcs.pom.getFooter().validateShipping());
        Assert.assertTrue(tcs.pom.getFooter().validateReturns());
        Assert.assertTrue(tcs.pom.getFooter().validateOffer());
        Assert.assertTrue(tcs.pom.getFooter().productRecalls());
        Assert.assertTrue(tcs.pom.getFooter().validateSizeChart());
        Assert.assertTrue(tcs.pom.getFooter().validateFaq());
        Assert.assertTrue(tcs.pom.getFooter().validateOrderStatus());
    }

    @Then("Oppurtunities redirects you to respective options")
    public void oppurtunitiesRedirectsYouToRespectiveOptions() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getFooter().validateAffiliate());
        Assert.assertTrue(tcs.pom.getFooter().validateCareers());
        Assert.assertTrue(tcs.pom.getFooter().validateInternationalBusinessOpportunities());
    }

    @Then("French and Terms redirects you to respective pages")
    public void frenchAndTermsRedirectsYouToRespectivePages() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getFooter().validateTermsOfUseButton());
        Assert.assertTrue(tcs.pom.getFooter().validateFrenchButton());
    }

    @Then("Instagram redirects you to respective pages")
    public void instagramRedirectsYouToRespectivePages() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getFooter().validateInstagramLinks());
    }

    @Then("Tiktok redirects you to respective pages")
    public void tiktokRedirectsYouToRespectivePages() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getFooter().validateTikTokLink());
    }

    @Then("Facebook redirects you to respective pages")
    public void facebookRedirectsYouToRespectivePages() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getFooter().validateFacebook());
    }

    @Then("Pintrest redirects you to respective pages")
    public void pintrestRedirectsYouToRespectivePages() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getFooter().validatePintrest());
    }

    @Then("Twitter redirects you to respective pages")
    public void twitterRedirectsYouToRespectivePages() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getFooter().validateTwitter());
    }

    @Then("Youtube redirects you to respective pages")
    public void youtubeRedirectsYouToRespectivePages() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getFooter().validateYouTube());
    }

    @Then("Privacy redirects to correct page")
    public void privacyRedirectsToCorrectPage() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getFooter().validatePrivacyPolicy());
    }

    @Then("Accessibility redirects to correct page")
    public void accessibilityRedirectsToCorrectPage() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getFooter().validateAccessiblity());
    }

    @Then("I am able to submit the subscription form")
    public void iAmAbleToSubmitTheSubscriptionForm() {
        Assert.assertTrue(tcs.pom.getFooter().validateFooterSubscription());
    }

    @Then("I am unable to submit the subscription form and see error message to check the box")
    public void iAmUnableToSubmitTheSubscriptionFormAndSeeErrorMessageToCheckTheBox() {
        Assert.assertTrue(tcs.pom.getFooter().validateFooterCheckboxError());
    }

    @Then("I am unable to submit the subscription form and see an error message")
    public void iAmUnableToSubmitTheSubscriptionFormAndSeeAnErrorMessage() {
        Assert.assertTrue(tcs.pom.getFooter().validateFooterInvalidEmailMessage());
    }

    @Then("I am unable to submit the subscription form and see an error message for no email")
    public void iAmUnableToSubmitTheSubscriptionFormAndSeeAnErrorMessageForNoEmail() {
        Assert.assertTrue(tcs.pom.getFooter().validateNoEmailMessage());
    }

    @Then("I click Terms and Conditions and it should redirect to Terms and Conditions page")
    public void iClickTermsAndConditionsAndItShouldRedirectToTermsAndConditionsPage() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getFooter().footerSubscriptionTerms());
    }



    @Then("I click Privacy Policy and it should redirect to Privacy page")
    public void iClickPrivacyPolicyAndItShouldRedirectToPrivacyPage() {
        Assert.assertTrue(tcs.pom.getFooter().footerPrivacy());
    }
}

package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import resources.Base;

import java.io.IOException;
import java.time.Duration;

public class FooterPopupStepDefinitions {
    WebDriver driver;
    Base base;

    @When("the subscription Popup Appears")
    public void theSubscriptionPopupAppears() throws IOException {

    }

    @Given("An end user visits the Joe Fresh site")
    public void anEndUserVisitsTheJoeFreshSite() throws IOException {

    }

    @Then("User is able to submit the form")
    public void userIsAbleToSubmitTheForm() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.Modal_flexContent__RulrS h1.ModalNewsletter_successHeading__OpyNa"))));
        Assert.assertTrue(driver.findElement(By.cssSelector("div.Modal_flexContent__RulrS h1.ModalNewsletter_successHeading__OpyNa")).isDisplayed());
        driver.findElement(By.cssSelector("button.ModalNewsletter_button__mmVB_")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div[data-testid='modal']")).isDisplayed());

    }
}

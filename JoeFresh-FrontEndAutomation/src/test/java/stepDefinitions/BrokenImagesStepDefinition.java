package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestContextSetup;

import java.io.IOException;
import java.time.Duration;

public class BrokenImagesStepDefinition {
    TestContextSetup tcs;
    WebDriverWait wait;

    public BrokenImagesStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
        wait=new WebDriverWait(tcs.base.driver,Duration.ofSeconds(10));
    }

    @Given("I open Homepage")
    public void i_open_homepage() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='headerXL']//button[text()='New']")));
        tcs.base.driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='Women']")).click();
        tcs.base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        tcs.base.driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Dresses']")).click();

    }

    @Given("I open Homepage\\(women Jackets and coats)")
    public void i_open_homepage_women_jackets_and_coats() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='headerXL']//button[text()='New']")));
        tcs.base.driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='Women']")).click();
        tcs.base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        tcs.base.driver.findElement(By.xpath("//a[normalize-space()='Knits & Tees']")).click();
    }

    @Given("I open Homepage\\(todlers boy)")
    public void i_open_homepage_todlers_boy() throws IOException {

        tcs.pom.getHomePage().searchProduct5();
        tcs.common.enter(tcs.pom.getHomePage().searchBox);
    }

    @When("find all the broken links and images available with count")
    public void find_all_the_broken_links_and_images_available_with_count() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(tcs.pom.getPDP().productTilesAvailable));
        tcs.common.BrokenLinksAndImgValidation();
       // tcs.common.brokenImages();
       // tcs.common.BrokenImagesOnPages();
    }
    @Then("I click on the available links and broken images")
    public void i_click_on_the_available_links_and_broken_images() {

    }
}

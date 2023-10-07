package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestContextSetup;

import java.time.Duration;

public class addToCartStepDefinition {

    TestContextSetup tcs;
    WebDriverWait wait;

    public addToCartStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
        wait=new WebDriverWait(tcs.base.driver,Duration.ofSeconds(10));
    }

    @Given("Open all promotions from mens")
    public void open_all_promotions_from_mens() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='headerXL']//button[text()='New']")));
        tcs.base.driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='New']")).click();
        tcs.base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        tcs.base.driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_twoColumn__wiv9Y']//descendant::a[text()='Women']")).click();
        tcs.pom.getPDP().validateAllProductsCanBeAddedToCart();
    }
    @When("Open products one by one")
    public void open_products_one_by_one() {

    }
    @When("add to cart")
    public void add_to_cart() {

    }


}

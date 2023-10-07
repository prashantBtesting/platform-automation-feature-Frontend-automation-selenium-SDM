package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import resources.DataDriven;
import util.Log;
import utils.TestContextSetup;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AddToCartPlpStepDefinition {
    TestContextSetup tcs;
    WebDriverWait wait;
    public AddToCartPlpStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
        wait=new WebDriverWait(tcs.base.driver,Duration.ofSeconds(10));
    }
    @Given("I am on home page")
    public void iAmOnHomePage() {

    }

    @When("I click on New Button")
    public void iClickOnNewButton() {

    }

    @Then("I select Women Then can add all the items to the cart")
    public void iSelectWomenThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("New","Women"));
    }

    @Then("I select Women Plus Then can add all the items to Cart")
    public void iSelectWomenPlusThenCanAddAllTheItemsToCart() throws InterruptedException, IOException {
       Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("New","Women+"));
    }

    @Then("I select Men Then can add all the items to the cart")
    public void iSelectMenThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("New","Men"));
    }

    @Then("I select Girls Then can add all the items to the cart")
    public void iSelectGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("New","Girls"));
    }

    @Then("I select Boys Then can add all the items to the cart")
    public void iSelectBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("New","Boys"));
    }

    @Then("I select Toddler Girls Then can add all the items to the cart")
    public void iSelectToddlerGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("New","Toddler Girls"));
    }

    @Then("I select Toddler Boys Then can add all the items to the cart")
    public void iSelectToddlerBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("New","Toddler Boys"));
    }

    @Then("I select Baby Girl Then can add all the items to the cart")
    public void iSelectBabyGirlThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("New","Baby Girl"));
    }

    @Then("I select Baby Boys Then can add all the items to the cart")
    public void iSelectBabyBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("New","Baby Boys"));
    }

    @Then("I select Jackets Then Coats Then can add all the items to the cart")
    public void iSelectJacketsThenCoatsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women","Jackets & Coats"));
    }

    @Then("I select Dresses Then can add all the items to Cart")
    public void iSelectDressesThenCanAddAllTheItemsToCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women","Dresses"));
    }

    @Then("I select Sweaters Then can add all the items to the cart")
    public void iSelectSweatersThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women","Sweaters"));
    }

    @Then("I select Knit & Tees Then can add all the items to the cart")
    public void iSelectKnitTeesThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women","Knit & Tees"));
    }

    @Then("I select Shirts & Blouses Then can add all the items to the cart")
    public void iSelectShirtsBlousesThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women","Shirts & Blouses"));
    }

    @Then("I select Skirts Then can add all the items to the cart")
    public void iSelectSkirtsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women","Skirts"));
    }

    @Then("I select Denim Then can add all the items to the cart")
    public void iSelectDenimThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women","Denim"));
    }

    @Then("I select Pants Then can add all the items to the cart")
    public void iSelectPantsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women","Pants"));
    }

    @Then("I select Shorts Then can add all the items to the cart")
    public void iSelectShortsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women","Shorts"));
    }

    @Then("I select Swim Then can add all the items to the cart")
    public void iSelectSwimThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women","Swim"));
    }

    @Then("I select Activewear Then can add all the items to the cart")
    public void iSelectActivewearThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women","Activewear"));
    }

    @Then("I select Sleepwear Then can add all the items to the cart")
    public void iSelectSleepwearThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women","Sleepwear"));
    }

    @Then("I select Intimates Then can add all the items to the cart")
    public void iSelectIntimatesThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women","Intimates"));
    }

    @Then("I select Tights & Socks Then can add all the items to the cart")
    public void iSelectTightsSocksThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
       Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women","Tights & Socks"));
    }

    @Then("I select Shoes Then can add all the items to the cart")
    public void iSelectShoesThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women","Shoes"));
    }

    @Then("I select Accessories  Then can add all the items to the cart")
    public void iSelectAccessoriesThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women","Accessories"));
    }

    @Then("I select Clearance Then can add all the items to the cart")
    public void iSelectClearanceThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women","Clearance"));
    }

    @Then("I select All Promotions Then can add all the items to the cart")
    public void iSelectAllPromotionsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women","All Promotions"));
    }

    @Then("I select Back to Dorm Then can add all the items to the cart")
    public void iSelectBackToDormThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
       Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women","Back to Dorm"));
    }

    @Then("I select Borrowed from the Boys Then can add all the items to the cart")
    public void iSelectBorrowedFromTheBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women","Borrowed from the Boys"));
    }

    @Then("I select Halloween Shop Then can add all the items to the cart")
    public void iSelectHalloweenShopThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women","Halloween Shop"));
    }

    @Then("I select Jackets Then Coats in Women Plus Then can add all the items to the cart")
    public void iSelectJacketsThenCoatsInWomenPlusThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women+","Jackets & Coats"));
    }

    @Then("I select Dresses Then Skirts in Women Plus Then can add all the items to Cart")
    public void iSelectDressesThenSkirtsInWomenPlusThenCanAddAllTheItemsToCart() throws InterruptedException, IOException {
       Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women+","Dresses & Skirts"));
    }

    @Then("I select Sweaters in Women Plus Then can add all the items to the cart")
    public void iSelectSweatersInWomenPlusThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women+","Sweaters"));
    }

    @Then("I select Knit & Tees in Women Plus Then can add all the items to the cart")
    public void iSelectKnitTeesInWomenPlusThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women+","Knit & Tees"));
    }

    @Then("I select Shirts & Blouses in Women Plus Then can add all the items to the cart")
    public void iSelectShirtsBlousesInWomenPlusThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women+","Shirts & Blouses"));
    }

    @Then("I select Denim in Women Plus Then can add all the items to the cart")
    public void iSelectDenimInWomenPlusThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women+","Denim"));
    }

    @Then("I select Bottoms in Women Plus Then can add all the items to the cart")
    public void iSelectBottomsInWomenPlusThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women+","Bottoms"));
    }

    @Then("I select Active in Women Plus Then can add all the items to the cart")
    public void iSelectActiveInWomenPlusThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women+","Active"));
    }

    @Then("I select Swim in Women Plus Then can add all the items to the cart")
    public void iSelectSwimInWomenPlusThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women+","Swim"));
    }

    @Then("I select Intimates in Women Plus Then can add all the items to the cart")
    public void iSelectIntimatesInWomenPlusThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women+","Intimates"));
    }

    @Then("I select Sleepwear in Women Plus Then can add all the items to the cart")
    public void iSelectSleepwearInWomenPlusThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women+","Sleepwear"));
    }

    @Then("I select Tights in Women Plus Then can add all the items to the cart")
    public void iSelectTightsInWomenPlusThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women+","Tights"));
    }

    @Then("I select Clearance in Women Plus Then can add all the items to the cart")
    public void iSelectClearanceInWomenPlusThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women+","Clearance"));
    }

    @Then("I select All Promotions in Women Plus Then can add all the items to the cart")
    public void iSelectAllPromotionsInWomenPlusThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Women+","All Promotions"));
    }

    @Then("I select Active Leggings Shop in Active Then can add all the items to the cart")
    public void iSelectActiveLeggingsShopInActiveThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Active","Active Leggings Shop"));
    }

    @Then("I select Active Basics Shop in Active Then can add all the items to the cart")
    public void iSelectActiveBasicsShopInActiveThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Active","Active Basics Shop"));
    }

    @Then("I select Outerwear in Men Then can add all the items to the cart")
    public void iSelectOuterwearInMenThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Men","Outerwear"));
    }

    @Then("I select Sweaters in Men Then can add all the items to Cart")
    public void iSelectSweatersInMenThenCanAddAllTheItemsToCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Men","Sweaters"));
    }

    @Then("I select Tees & Polos Then can add all the items to the cart")
    public void iSelectTeesPolosThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Men","Tees & Polos"));
    }

    @Then("I select Shirts Then can add all the items to the cart")
    public void iSelectShirtsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Men","Shirts"));
    }

    @Then("I select Pants & Shorts in Men Then can add all the items to the cart")
    public void iSelectPantsShortsInMenThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Men","Pants & Shorts"));
    }

    @Then("I select Denim in Men Then can add all the items to the cart")
    public void iSelectDenimInMenThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Men","Denim"));
    }

    @Then("I select Activewear in Men Then can add all the items to the cart")
    public void iSelectActivewearInMenThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Men","Activewear"));
    }

    @Then("I select Swim in Men Then can add all the items to the cart")
    public void iSelectSwimInMenThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Men","Swim"));
    }

    @Then("I select Sleepwear in Men Then can add all the items to the cart")
    public void iSelectSleepwearInMenThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Men","Sleepwear"));
    }

    @Then("I select Socks & Underwear in Men Then can add all the items to Cart")
    public void iSelectSocksUnderwearInMenThenCanAddAllTheItemsToCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Men","Socks & Underwear"));
    }

    @Then("I select Shoes in Men Then can add all the items to the cart")
    public void iSelectShoesInMenThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Men","Shoes"));
    }

    @Then("I select Accessories in Men Then can add all the items to the cart")
    public void iSelectAccessoriesInMenThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Men","Accessories"));
    }

    @Then("I select Clearance in Men Then can add all the items to the cart")
    public void iSelectClearanceInMenThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Men","Clearance"));
    }

    @Then("I select All Promotions in Men Then can add all the items to the cart")
    public void iSelectAllPromotionsInMenThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Men","All Promotions"));
    }

    @Then("I select Outerwear in Girls Then can add all the items to the cart")
    public void iSelectOuterwearInGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Girls","Outerwear"));
    }

    @Then("I select Dresses in Girls Then can add all the items to Cart")
    public void iSelectDressesInGirlsThenCanAddAllTheItemsToCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Girls","Dresses"));
    }

    @Then("I select Tops in Girls Then can add all the items to the cart")
    public void iSelectTopsInGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Girls","Tops"));
    }

    @Then("I select Bottoms in Girls Then can add all the items to the cart")
    public void iSelectBottomsInMenThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Girls","Bottoms"));
    }

    @Then("I select Activewear in Girls Then can add all the items to the cart")
    public void iSelectActivewearInGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Girls","Activewear"));
    }

    @Then("I select Swim in Girls Then can add all the items to the cart")
    public void iSelectSwimInGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Girls","Swim"));
    }

    @Then("I select Sleepwear in Girls Then can add all the items to the cart")
    public void iSelectSleepwearInGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Girls","Sleepwear"));
    }

    @Then("I select Socks & Underwear in Girls Then can add all the items to Cart")
    public void iSelectSocksUnderwearInGirlsThenCanAddAllTheItemsToCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Girls","Socks & Underwear"));
    }

    @Then("I select Shoes in Girls Then can add all the items to the cart")
    public void iSelectShoesInGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Girls","Shoes"));
    }

    @Then("I select Accessories in Girls Then can add all the items to the cart")
    public void iSelectAccessoriesInGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Girls","Accessories"));
    }

    @Then("I select Clearance in Girls Then can add all the items to the cart")
    public void iSelectClearanceInGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Girls","Clearance"));
    }

    @Then("I select All Promotions in Girls Then can add all the items to the cart")
    public void iSelectAllPromotionsInGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Girls","All Promotions"));
    }

    @Then("I select Mix & Match in Girls Then can add all the items to the cart")
    public void iSelectMixMatchInGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Girls","Mix & Match"));
    }

    @Then("I select Children's Rain in Girls Then can add all the items to the cart")
    public void iSelectChildrenSRainInGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Girls","Children's Rain"));
    }

    @Then("I select PC Children's Charity in Girls Then can add all the items to the cart")
    public void iSelectPCChildrenSCharityInGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Girls","PC Children's Charity"));
    }

    @Then("I select Outerwear in Boys Then can add all the items to the cart")
    public void iSelectOuterwearInBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Boys","Outerwear"));
    }

    @Then("I select Tops in Boys Then can add all the items to the cart")
    public void iSelectTopsInBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Boys","Tops"));
    }

    @Then("I select Bottoms in Boys Then can add all the items to the cart")
    public void iSelectBottomsInBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Boys","Bottoms"));
    }

    @Then("I select Activewear in Boys Then can add all the items to the cart")
    public void iSelectActivewearInBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Boys","Activewear"));
    }

    @Then("I select Swim in Boys Then can add all the items to the cart")
    public void iSelectSwimInBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Boys","Swim"));
    }

    @Then("I select Sleepwear in Boys Then can add all the items to the cart")
    public void iSelectSleepwearInBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Boys","Sleepwear"));
    }

    @Then("I select Socks & Underwear in Boys Then can add all the items to Cart")
    public void iSelectSocksUnderwearInBoysThenCanAddAllTheItemsToCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Boys","Socks & Underwear"));
    }

    @Then("I select Shoes in Boys Then can add all the items to the cart")
    public void iSelectShoesInBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Boys","Shoes"));
    }

    @Then("I select Accessories in Boys Then can add all the items to the cart")
    public void iSelectAccessoriesInBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Boys","Accessories"));
    }

    @Then("I select Clearance in Boys Then can add all the items to the cart")
    public void iSelectClearanceInBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Boys","Clearance"));
    }

    @Then("I select All Promotions in Boys Then can add all the items to the cart")
    public void iSelectAllPromotionsInBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Boys","All Promotions"));
    }

    @Then("I select Mix & Match in Boys Then can add all the items to the cart")
    public void iSelectMixMatchInBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCart("Boys","Mix & Match"));
    }

    @Then("I select Outerwear in Toddler Girls Then can add all the items to the cart")
    public void iSelectOuterwearInToddlerGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Toddler Girls","Outerwear"));
    }

    @Then("I select Dresses in Toddler Girls Then can add all the items to Cart")
    public void iSelectDressesInToddlerGirlsThenCanAddAllTheItemsToCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Toddler Girls","Dresses"));
    }

    @Then("I select Tops in Toddler Girls Then can add all the items to the cart")
    public void iSelectTopsInToddlerGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Toddler Girls","Tops"));
    }

    @Then("I select Bottoms in Toddler Girls Then can add all the items to the cart")
    public void iSelectBottomsInToddlerGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Toddler Girls","Bottoms"));
    }

    @Then("I select Activewear in Toddler Girls Then can add all the items to the cart")
    public void iSelectActivewearInToddlerGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Toddler Girls","Bottoms"));
    }

    @Then("I select Swim in Toddler Girls Then can add all the items to the cart")
    public void iSelectSwimInToddlerGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Toddler Girls","Activewear"));
    }

    @Then("I select Sleepwear in Toddler Girls Then can add all the items to the cart")
    public void iSelectSleepwearInToddlerGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Toddler Girls","Sleepwear"));
    }

    @Then("I select Socks & Underwear in Toddler Girls Then can add all the items to Cart")
    public void iSelectSocksUnderwearInToddlerGirlsThenCanAddAllTheItemsToCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Toddler Girls","Socks & Underwear"));
    }

    @Then("I select Shoes in Toddler Girls Then can add all the items to the cart")
    public void iSelectShoesInToddlerGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Toddler Girls","Shoes"));
    }

    @Then("I select Accessories in Toddler Girls Then can add all the items to the cart")
    public void iSelectAccessoriesInToddlerGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Toddler Girls","Accessories"));
    }

    @Then("I select Clearance in Toddler Girls Then can add all the items to the cart")
    public void iSelectClearanceInToddlerGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Toddler Girls","Clearance"));
    }

    @Then("I select All Promotions in Toddler Girls Then can add all the items to the cart")
    public void iSelectAllPromotionsInToddlerGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Promotions","Toddler Girls"));
    }

    @Then("I select Mix & Match in Toddler Girls Then can add all the items to the cart")
    public void iSelectMixMatchInToddlerGirlsThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Features","Toddler Girl Mix & Match"));
    }

    @Then("I select Outerwear in Toddler Boys Then can add all the items to the cart")
    public void iSelectOuterwearInToddlerBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Toddler Boys","Outerwear"));
    }

    @Then("I select Tops in Toddler Boys Then can add all the items to the cart")
    public void iSelectTopsInToddlerBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Toddler Boys","Tops"));
    }

    @Then("I select Bottoms in Toddler Boys Then can add all the items to the cart")
    public void iSelectBottomsInToddlerBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Toddler Boys","Bottoms"));
    }

    @Then("I select Activewear in Toddler Boys Then can add all the items to the cart")
    public void iSelectActivewearInToddlerBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Toddler Boys","Activewear"));
    }

    @Then("I select Swim in Toddler Boys Then can add all the items to the cart")
    public void iSelectSwimInToddlerBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Toddler Boys","Swim"));
    }

    @Then("I select Sleepwear in Toddler Boys Then can add all the items to the cart")
    public void iSelectSleepwearInToddlerBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Toddler Boys","Sleepwear"));
    }

    @Then("I select Socks & Underwear in Toddler Boys Then can add all the items to Cart")
    public void iSelectSocksUnderwearInToddlerBoysThenCanAddAllTheItemsToCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Toddler Boys","Socks & Underwear"));
    }

    @Then("I select Shoes in Toddler Boys Then can add all the items to the cart")
    public void iSelectShoesInToddlerBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Toddler Boys","Shoes"));
    }

    @Then("I select Accessories in Toddler Boys Then can add all the items to the cart")
    public void iSelectAccessoriesInToddlerBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Toddler Boys","Accessories"));
    }

    @Then("I select Clearance in Toddler Boys Then can add all the items to the cart")
    public void iSelectClearanceInToddlerBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Toddler Boys","Clearance"));
    }

    @Then("I select All Promotions in Toddler Boys Then can add all the items to the cart")
    public void iSelectAllPromotionsInToddlerBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Promotions","Toddler Boys"));
    }

    @Then("I select Mix & Match in Toddler Boys Then can add all the items to the cart")
    public void iSelectMixMatchInToddlerBoysThenCanAddAllTheItemsToTheCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Toddlers","Features","Toddler Boys Mix & Match"));
    }



    @Then("I select items from Baby Girls menu items Then add to cart")
    public void iSelectItemsFromBabyGirlsMenuItemsThenAddToCart() throws IOException, InterruptedException {
        ArrayList<String> menuItems=DataDriven.getTestData("Navigation","Baby Girl");
        for (int i=1;i<menuItems.size();i++){
            Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Baby","Shop Baby Girls",menuItems.get(i)));
        }
    }

    @Then("I select items from Baby Boys menu items Then add to cart")
    public void iSelectItemsFromBabyBoysMenuItemsThenAddToCart() throws IOException, InterruptedException {
        ArrayList<String> menuItems=DataDriven.getTestData("Navigation","Baby Boy");
        for (int i=1;i<menuItems.size();i++){
            Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Baby","Shop Baby Boys",menuItems.get(i)));
        }
    }

    @Then("I select items from Featured menu items Then add to cart")
    public void iSelectItemsFromFeaturedMenuItemsThenAddToCart() throws IOException, InterruptedException {
        ArrayList<String> menuItems=DataDriven.getTestData("Navigation","Featured");
        for (int i=1;i<menuItems.size();i++){
            Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartCommonCategory("Baby","Features",menuItems.get(i)));
        }
    }

    @Then("I select items from Disney menu items Then add to cart")
    public void iSelectItemsFromDisneyMenuItemsThenAddToCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartDisneyAndMarvel("Disney Shop"));

           }

    @Then("I select items from Marvel menu items Then add to cart")
    public void iSelectItemsFromMarvelMenuItemsThenAddToCart() throws InterruptedException, IOException {
        Assert.assertTrue(tcs.pom.getPlp().validateAllProductsCanBeAddedToCartDisneyAndMarvel("Marvel Shop"));
    }
}

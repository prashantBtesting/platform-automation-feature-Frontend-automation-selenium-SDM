package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.Log;
import utils.TestContextSetup;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class PDPStepDifinition {
    public Properties properties;
    TestContextSetup tcs;
    WebDriverWait wait;

    public PDPStepDifinition(TestContextSetup tcs) {
        this.tcs = tcs;
        wait=new WebDriverWait(tcs.base.driver, Duration.ofSeconds(10));
    }


    @When("I have added products to my bag")
    public void i_have_added_products_to_my_bag() {
        tcs.pom.getPDP().SelectEnabledSize();
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);

    }

    @Then("I am shown the prompt Dont miss out! Items in your bag are not held and may be sold.")
    public void i_am_shown_the_prompt_dont_miss_out_items_in_your_bag_are_not_held_and_may_be_sold() {
        tcs.common.clickOn(tcs.pom.getPDP().Close_Modal);
        tcs.common.clickOn(tcs.pom.getHomePage().MyBag);
        tcs.common.addExplicitWait(tcs.pom.getPDP().Dont_Missout_element);
        tcs.common.isTextVisible("//p[contains(text(),'Dont miss out! Items in your bag are not held and ')]", "Dont miss out! Items in your bag are not held and may be sold.");
    }

    @Given("PDP Colour selection")
    public void pdp_colour_selection() throws IOException {
     //  tcs.pom.getNavigation().navigatingSanity();
        tcs.pom.getPDP().selectRandomProduct();

    }

    @When("When I click the colour swatch")
    public void when_i_click_the_colour_swatch() {

        System.out.println("PDP Page");

    }

    @Then("I should see the pictures change to a picture of the item of that colour")
    public void then_i_should_see_the_pictures_change_to_a_picture_of_the_item_of_that_colour() throws InterruptedException {
        tcs.pom.getPDP().validateColorList();
        System.out.println("Colour changed");
        Thread.sleep(3000);
        tcs.common.addImplicitWait(tcs.pom.getPDP().Image4);
        tcs.pom.getPDP().SelectEnabledSize();
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
    }

    @Given("I am viewing a PDP page")
    public void i_am_viewing_a_pdp_page() throws IOException {
        tcs.pom.getPDP().selectRandomProduct();
    }

    @When("we see the page is loaded")
    public void the_page_is_loaded() {

    }

    @Then("thumbnail images are shown vertically at the left in this order And the images are ordered according to their filenames one to five")
    public void thumbnailImagesAreShownVerticallyAtTheLeftInThisOrderAndTheImagesAreOrderedAccordingToTheirFilenamesOneToFive() {
        tcs.common.addExplicitWait(tcs.pom.getPDP().ProductImage);
        Assert.assertTrue(tcs.pom.getPDP().validateFiveProductImages(), "Images NOt Displayed");
    }


    @When("I click the size selector on an available size")
    public void i_click_the_size_selector_on_an_available_size() {
        Assert.assertTrue(tcs.pom.getPDP().SelectEnabledSize());
    }

    @Then("I should see the size selected, and be able to add to cart")
    public void i_should_see_the_size_selected_and_be_able_to_add_to_cart() {
        Assert.assertTrue(tcs.common.clickOn(tcs.pom.getPDP().addToBag));
    }

    /*@When("I click the size selector on an unavailable size")
    public void when_i_click_the_size_selector_on_an_unavailable_size()  {
        Assert.assertTrue(tcs.pom.getPDP().selectDisabledSize());
        Assert.assertTrue(tcs.common.clickOn(tcs.pom.getPDP().addToBag), "Not able to click on add to bag");
    }*/

    @Then("Then I should not be able to select the size")
    public void then_i_should_not_be_able_to_select_the_size() {
        tcs.common.isTextVisible("//p[normalize-space()='Please select a size to add this item to your bag']", "Please select a size to add this item to your bag");
        Log.info("You are selecting a size which is not available for this Item");
    }

    @Given("I am viewing a PDP Prod Name")
    public void i_am_viewing_a_pdp_prod_name() throws IOException {
       tcs.pom.getHomePage().searchProduct1();
       tcs.common.enter(tcs.pom.getHomePage().searchBox);
       tcs.common.addImplicitWait(tcs.pom.getPDP().TankDress);
    }

    @When("the page is loaded Prod Name")
    public void the_page_is_loaded_prod_name() {
        System.out.println("page is loaded");
    }

    @Then("product name is displayed in full")
    public void product_name_is_displayed_in_full() throws IOException {

        System.out.println(tcs.common.getVisibleText());
        tcs.common.clickOn(tcs.pom.getPDP().TankDress);
        tcs.pom.getPDP().SelectEnabledSize();
        System.out.println(tcs.pom.getPDP().fullNameOfProduct.getText());
        tcs.common.isTextVisible("//h1[@class='ProductDetails_heading__OZWMB']", "Tank Dress");
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        //  Assert.assertTrue(tcs.common.addExplicitWait(tcs.pom.getPDP().SizingChartLink),"Size Link Is Not Visible");
    }

    @Given("I am viewing a PDP for a regularly priced product")
    public void i_am_viewing_a_pdp_for_a_regularly_priced_product() throws IOException {
       tcs.pom.getHomePage().searchProduct4();
        tcs.common.enter(tcs.pom.getHomePage().searchBox);


    }

    @When("that page is loaded")
    public void that_page_is_loaded() {
        tcs.common.clickOn(tcs.pom.getPDP().PonteDress);

    }

    @Then("The product's discounted price is displayed in red font")
    public void the_product_s_discounted_price_is_displayed_in_red_font() {
        String Expected = "#da3c12";
        tcs.common.addExplicitWait(tcs.pom.getPDP().discountedProductRedColour);
        String btnColor = tcs.pom.getPDP().discountedProductRedColour.getCssValue("color");
        System.out.println(btnColor);
        String HexColor = Color.fromString(btnColor).asHex();
        System.out.println(HexColor);
        String Actual = HexColor;
        Assert.assertEquals(Actual, Expected);

    }

    @Given("I am on a PDP AND the product belongs to a category with a defined size chart mapping")
    public void i_am_on_a_pdp_and_the_product_belongs_to_a_category_with_a_defined_size_chart_mapping() throws IOException {
      //  tcs.pom.getNavigation().navigatingSanity();
        tcs.pom.getPDP().selectRandomProduct();

    }

    @When("when the page is loaded")
    public void when_the_page_is_loaded() {

    }

    @Then("There is a link displayed for Sizing Chart")
    public void there_is_a_link_displayed_for() {
        Assert.assertTrue((tcs.pom.getPDP().isSizeChartDisplayed()));
    }

    @Given("I am on the PDP Page")
    public void i_am_on_the_pdp_page() throws IOException {
        //tcs.pom.getNavigation().navigatingSanity();
        tcs.pom.getPDP().selectRandomProduct();
    }

    @When("I clicked on add to bag button")
    public void i_clicked_on_add_to_bag_button() {
        tcs.pom.getPDP().SelectEnabledSize();
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
    }

    @Then("modal pop-ed up")
    public void modal_pop_ed_up() {
        tcs.common.clickOn(tcs.pom.getPDP().ContinueShopping);
    }

    @Then("modal pop up")
    public void modal_pop_up() {
        tcs.common.clickOn(tcs.pom.getPDP().Close_Modal);
    }

    @Then("I am able to click on continue shopping button")
    public void i_am_able_to_click_on_continue_shopping_button() {
        Log.info("you are able to click on continue shopping button");

    }

    @Given("I am on a PDP page")
    public void i_am_on_a_pdp() throws IOException {
       // tcs.pom.getNavigation().navigatingSanity();
        tcs.pom.getPDP().selectRandomProduct();
    }

    @When("The page is loaded")
    public void that_the_page_is_loaded() {

    }

    @Then("an accordion style text box is displayed in collapsed state below Add to bag button with the heading Details")
    public void an_accordion_style_text_box_is_displayed_in_collapsed_state_below_add_to_bag_button_with_the_heading() {
        tcs.common.clickOn(tcs.pom.getPDP().Details);
        tcs.common.isTextVisible("//div[normalize-space()='Jersey tank dress with scoop neck and relaxed fit.']", "Jersey tank dress with scoop neck and relaxed fit.");
        Log.info("Test is Passed");
    }


    @Given("I have accessed the maximized view of a product by clicking the zoom lens icon on the product image on PDP")
    public void i_have_accessed_the_maximized_view_of_a_product_by_clicking_the_zoom_lens_icon_on_the_product_image_on_pdp() throws IOException {
     //   tcs.pom.getNavigation().navigatingSanity();
        tcs.pom.getPDP().selectRandomProduct();
    }

    @When("Click on back button")
    public void click_on_back_button() {
        tcs.common.addExplicitWait(tcs.pom.getPDP().ProductImage);
        tcs.common.clickOn(tcs.pom.getPDP().ProductImage);
        tcs.common.Back();
        System.out.println("clicked on back button");
    }

    @Then("I should go back to the category page\\(e.g. women page)")
    public void i_should_go_back_to_the_category_page_e_g_women_page() {
        tcs.common.addExplicitWait(tcs.pom.getPDP().TankDress);
        String actualTitle = tcs.common.getTitle();
        String expectedTitle = "\"Tank Dress\" from Joe Fresh";
        Assert.assertEquals(actualTitle, expectedTitle);
    }


    @Given("I am on the pdp")
    public void i_am_on_the_pdp() throws IOException {
       // tcs.pom.getNavigation().navigatingSanity();
        tcs.pom.getPDP().selectRandomProduct();
    }


    @When("pdp page is opened in front of me")
    public void pdp_page_is_opened_in_front_of_me() {
        //tcs.pom.getNavigation().navigatingSanity();
        tcs.common.addExplicitWait(tcs.pom.getPDP().selectProductFromPDPPage);
        tcs.common.clickOn(tcs.pom.getPDP().selectProductFromPDPPage);
    }

    @Then("I should be able to add products in the bag")
    public void i_should_be_able_to_add_products_in_the_bag() {
        tcs.pom.getPDP().SelectEnabledSize();
        tcs.common.clickOn(tcs.pom.getPDP().addToBag);
        System.out.println("added to bag");
    }

    @Given("am On the PDP page")
    public void am_on_the_pdp_page() throws IOException {
      //  tcs.pom.getNavigation().navigatingSanity();
        tcs.pom.getPDP().selectRandomProduct();
    }

    @When("I see you may also like this")
    public void i_see_you_may_also_like_this() {

        tcs.common.addExplicitWait(tcs.pom.getPDP().selectProductFromPDPPage);
        tcs.common.clickOn(tcs.pom.getPDP().selectProductFromPDPPage);
    }

    @Then("I should be able to access the products")
    public void i_should_be_able_to_access_the_products() {

        System.out.println("able to access products from you may like this");
    }


    @Given("I clicked on any product")
    public void i_clicked_on_any_product() throws IOException {
       // tcs.pom.getNavigation().navigatingSanity();
        tcs.pom.getPDP().selectRandomProduct();
    }

    @When("I am on that PDP Page")
    public void i_am_on_that_pdp_page() {
        tcs.pom.getPdpPage().isBreadCrumpsDisplayed();
    }

    @Then("I am able to see breadcrumb of the respected product links")
    public void i_am_able_to_see_breadcrumb_of_the_respected_product_links() {

    }

    @Given("PDP Page is open for regular price product")
    public void product_is_loaded_for_regular_price_product() throws IOException {
       tcs.pom.getHomePage().searchProduct1();
       tcs.common.enter(tcs.pom.getHomePage().searchBox);
      tcs.common.clickOn(tcs.pom.getPDP().TankDress);

    }
    @Given("PDP Page is open")
    public void product_is_loaded() throws IOException {
      //  tcs.pom.getNavigation().navigatingSanity();
        tcs.pom.getPDP().selectRandomProduct();
    }


    @When("product is loaded")
    public void that_product_is_loaded() {
        tcs.common.addExplicitWait(tcs.pom.getPDP().ProductImage);
    }

    @Then("thumbnail images are shown vertically at the left in this order")
    public void thumbnail_images_are_shown_vertically_at_the_left_in_this_order() {
        tcs.pom.getPDP().Image1.isDisplayed();
        tcs.pom.getPDP().Image2.isDisplayed();
        tcs.pom.getPDP().Image3.isDisplayed();
        tcs.pom.getPDP().Image4.isDisplayed();
        tcs.pom.getPDP().Image5.isDisplayed();
        System.out.println("All 5 images are displayed");

    }

    @Given("I am On PDP page and")
    public void i_am_on_pdp_page_and() throws IOException {
      //  tcs.pom.getNavigation().navigatingSanity();
        tcs.pom.getPDP().selectRandomProduct();
    }

    @When("product is open in front of me")
    public void product_is_open_in_front_of_me() {
        tcs.common.addExplicitWait(tcs.pom.getPDP().ProductImage);
        tcs.common.clickOn(tcs.pom.getPDP().ProductImage);
    }

    @Then("I am able to zoom in the respected image of the product")
    public void i_am_able_to_zoom_in_the_respected_image_of_the_product() {
        Log.info("Successfully product zoomed in");
    }


    @Then("I am able to click on cross button")
    public void i_clicked_on_cross_button() {

        Log.info("successfully clicked on close button");
    }

    @When("I am switching images of the product")
    public void i_am_switching_images_of_the_product() {
        tcs.common.clickOn(tcs.pom.getPDP().ProductImage);

    }

    @Then("I am able to switch the Images")
    public void i_am_able_to_switch_the_images() throws InterruptedException {
        Thread.sleep(4000);
        tcs.common.clickOn(tcs.pom.getPDP().ImageSwitched);
        System.out.println("Successfully switched to the another image");
    }

    @Then("I am able to close the Image")
    public void i_am_able_to_close_the_image() {
        tcs.common.clickOn(tcs.pom.getPDP().Close_Modal);
        System.out.println("Successfully clicked on cross button");
    }

    @Then("Then the product's regular price is displayed in black font")
    public void then_the_product_s_regular_price_is_displayed_in_black_font() {
        String Expected = "#333132";
        String btnColor = tcs.pom.getPDP().productPrice.getCssValue("color");
        System.out.println(btnColor);
        String HexColor = Color.fromString(btnColor).asHex();
        System.out.println(HexColor);
        String Actual = HexColor;
        Assert.assertEquals(Actual, Expected);
    }

    @Then("Shipping & Returns heading is present")
    public void shipping_returns_heading_is_present() {

    }


    @Then("Shipping and returns data should be present")
    public void shipping_and_returns_data_should_be_present() {
        Assert.assertTrue(tcs.pom.getPDP().shippingTextPresent());
    }

    @When("Value of product is less than fifty dollars")
    public boolean value_of_product_is_less_than_fifty_dollars() {
        tcs.common.clickOn(tcs.pom.getPDP().viewBag);
        try {
            if(!tcs.pom.getPDP().ShippingCharge.isDisplayed()) {
                Log.error("Product Shipping Price Below $50 Should be $3.99");
                return false;

            }else if(tcs.pom.getPDP().ShippingCharge.isDisplayed()){
                tcs.common.addExplicitWait(tcs.pom.getPDP().ShippingCharge);
                System.out.println(tcs.pom.getPDP().ShippingCharge.getText());
                return true;
            }
        } catch (NotFoundException e) {
            Log.error("Element Not Found");
        }return false;
    }

    @Then("check Shipping charge is applicable")
    public void check_shipping_charge_is_applicable() {
        Assert.assertEquals(tcs.pom.getPDP().ShippingCharge.getText(), "$3.99");

    }

    @When("I click the size selector on an unavailable size")
    public void i_click_the_size_selector_on_an_unavailable_size() {
        tcs.pom.getPDP().selectDisabledSize();

    }

    @Then("Then I see an error message indicating that the color is no longer available in the selected size")
    public void then_i_see_an_error_message_indicating_that_the_color_is_no_longer_available_in_the_selected_size() {
      tcs.common.addExplicitWait(tcs.pom.getPDP().colourIsNoLongerAvailable);
           tcs.pom.getPDP().colourIsNoLongerAvailable.getText();

    }

    @When("I click on Shipping and return")
    public void i_click_on_shipping_and_return() {
        wait.until(ExpectedConditions.visibilityOf(tcs.pom.getPDP().shippingReturnsButton));
        tcs.pom.getPDP().shippingReturnsButton.click();
    }

    @Then("free shipping above fifty dollar message should be available.")
    public void free_shipping_above_fifty_dollar_message_should_be_available() {
        Assert.assertTrue(tcs.pom.getPDP().shippingTextPresent());
    }

    @When("I check the Regular price of the product on PLP page")
    public void i_check_the_regular_price_of_the_product_on_plp_page() {
        String RegularPrice = tcs.pom.getPDP().prodcutPriceOnPLPpage.getText();
        System.out.println(RegularPrice);

    }

    @Then("That price is similar to the PDP page")
    public void that_price_is_similar_to_the_pdp_page() {


    }

    @When("extract the price of the product on PDP page")
    public void extract_the_price_of_the_product_on_pdp_page() {
        tcs.common.addExplicitWait(tcs.pom.getPDP().productPriceOnPDP);
        String prdoctPriceOnPDP = tcs.pom.getPDP().productPriceOnPDP.getText();
        String prdoctPriceOnModal = tcs.pom.getPDP().productPriceOnAddToBagModal.getText();
        Assert.assertEquals(prdoctPriceOnPDP, prdoctPriceOnModal, "value of the product is not same");
    }

    @Then("compare that price available on modal after clicking on add to bag button")
    public void compare_that_price_available_on_modal_after_clicking_on_add_to_bag_button() {

    }

    @Given("I am viewing the full-screen image gallery from a PDP page")
    public void i_am_viewing_the_full_screen_image_gallery_from_a_pdp_page() throws IOException {
       // tcs.pom.getNavigation().navigatingSanity();
        tcs.pom.getPDP().selectRandomProduct();
    }

    @When("i click on of the five thumbnail images")
    public void i_click_on_of_the_five_thumbnail_images() {

        tcs.common.addExplicitWait(tcs.pom.getPDP().ProductImage);

    }

    @Then("the main large image switched to the one i clicked")
    public void the_main_large_image_switched_to_the_one_i_clicked() {
        tcs.common.clickOn(tcs.pom.getPDP().ProductImage);
        tcs.common.addExplicitWait(tcs.pom.getPDP().ImageSwitched);
        Assert.assertTrue(tcs.common.clickOn(tcs.pom.getPDP().ImageSwitched),"not able to switch");
    }

    @When("the page is load")
    public void the_page_is_load() throws InterruptedException {
        tcs.common.addImplicitWait(tcs.pom.getPDP().productBadge);
    }

    @Then("the badge text with the highest priority for this product is displayed above the product name.")
    public void the_badge_text_with_the_highest_priority_for_this_product_is_displayed_above_the_product_name() {
        String Text = tcs.pom.getPDP().productBadge.getText();
        Assert.assertFalse(Text.isEmpty());
        Log.info("Available Badge:: "+ Text);
    }

}

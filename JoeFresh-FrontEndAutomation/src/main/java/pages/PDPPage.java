package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.Base;
import util.Common;
import util.Log;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;


public class PDPPage extends Base {
    WebDriver driver;
    PageObjectManager pom;
    WebDriverWait wait;
    Random random;
    HomePage homePage;
    Common common;


    public PDPPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        random = new Random();
    }
    By productName = By.xpath("//p[@class='ProductTile_name__eAKRK']");

    @FindBy(xpath = "(//span[@class='MyBagLink_label__tBH0d'][normalize-space()='My Bag'])[1]")
    public WebElement MyBag;
    @FindBy(xpath = "//h1[normalize-space()='Your shopping bag is currently empty']")
    public WebElement carIsEmpty;
    @FindBy(css = "div[class='Header_topMenuContainerDesktop__FtC7r'] a[class='MyBagLink_container__xcIvf MyBagLink_active__pPg0S']")
    public WebElement myBagValue;
    @FindBy(xpath = "//button[@data-testid='load-more-button']")
    WebElement loadMoreButton;

    @FindBy(xpath = "//h1[normalize-space()='Your shopping bag is currently empty']")
    public WebElement cartIsEmpty;
    @FindBy(xpath = "//button[normalize-space()='Continue shopping']")
    public WebElement ContinueShopping;

    @FindBy(xpath = "(//a[@aria-label='Shop Baby Girl new arrivals'])[1]")
    public WebElement Cute_Stuf;
    @FindBy(xpath = "(//img[@alt=\"Baby Girls' Printed Crop Legging - White\"])[1]")
    public WebElement SelectItem;
    @FindBy(xpath = "//label[@for='addToBagPdp0']")
    public WebElement SelectSize;
    @FindBy(xpath = "//button[normalize-space()='Add to bag']")
    public WebElement AddToBagItem;
    @FindBy(xpath = "//button[@aria-label='Close']//*[name()='svg']")
    public WebElement continueShoppingFalse;

    @FindBy(xpath = "(//a[@aria-label=\"Shop Women's New Arrivals\"])[2]")
    public WebElement Tied_dyed;
    @FindBy(css = "h1.ProductDetails_heading__OZWMB")
    public WebElement fullNameOfProduct;
    @FindBy(css = "span.SwatchList_container__jbEXF")
    public WebElement colourSwatch;
    @FindBy(xpath = "//button[text()='ConallSizestinue shopping']") WebElement continueShopping;

    @FindBy(xpath = "//img[@alt='Stripe Tank Dress - Dark Blue']")
    public WebElement TankDress;
    @FindBy(xpath = "//img[@alt='Women+ Ponte Dress - JF Black']")
    public WebElement PonteDress;

    @FindBy(xpath = "//img[@alt='Baby Boys’ French Terry Romper - JF Black']")
    public WebElement TerryRomper;

    @FindBy(xpath = "//img[@alt='Plaid Coat - Black']")
    public WebElement Jacket;


    @FindBy(xpath = "(//span[@class='SwatchList_image__uJXCk'])[5]")
    public WebElement TankDressColour;

    @FindBy(xpath = "//label[@for='addToBagPdp4']")
    public WebElement TDSize;


    @FindBy(xpath = "(//button[@aria-label='Close'])[1]")
    public WebElement closePopUp;

    @FindBy(xpath = "//button[normalize-space()='View bag']")
    public WebElement viewBag;

    @FindBy(xpath = "//p[contains(text(),'Dont miss out! Items in your bag are not held and ')]")
    public WebElement DontMissOut;
    @FindBy(xpath = "//a[normalize-space()='Jackets & Coats']")
    public WebElement jackets_and_coats;
    @FindBy(xpath = "(//a[@aria-label='Go to JF Midnight Blue Flutter Sleeve Blouse Details'])[1]")
    public WebElement SelectProduct;

    @FindBy(xpath = "//img[@alt='Button Vest Cardi - Pale Grey']")
    public WebElement SelectProduct2;

    @FindBy(xpath = "//span[@class='SwatchList_image__uJXCk'])[2]")
    public WebElement BlackColour;

    @FindBy(xpath = "(//span[@class='SwatchList_image__uJXCk'])[1]")
    public WebElement KhakiColour;

    @FindBy(xpath = "//label[@for='addToBagPdp4']")
    public WebElement SelectXLSize;
    @FindBy(xpath = "//label[@for='addToBagPdp0']")
    public WebElement SelectXSSize;

    @FindBy(xpath = "//label[@for='addToBagPdp1']")
    public WebElement SelectSmallSize;
    @FindBy(xpath = "//label[@for='U2WR028237_93002']//span[@class='SwatchList_image__uJXCk']")
    public WebElement SwitchColour;

    @FindBy(css = "button.ProductDetails_sizeChart__1lEXG")
    WebElement sizingChartLink;
    @FindBy(css = "div.SizeChart_container__BYYZg h1")
   WebElement sizeChartModal;
    @FindBy(xpath = "//button[@id='laballedby-accordion2']")
    public WebElement shippingReturnsButton;
    @FindBy(css = "#controls-accordion2 p")
    public WebElement shippingAndReturnData;

    @FindBy(xpath = "//button[text()='Add to bag']")
    public WebElement addToBag;
    @FindBy(xpath = "//input[@id='imgRadio0']")
    public WebElement Image1;
    @FindBy(xpath = "//img[@alt='image 2 out of 5']")
    public WebElement ImageSwitched;
    @FindBy(xpath = "//input[@id='imgRadio2']")
    public WebElement Image2;
    @FindBy(xpath = "//input[@id='imgRadio2']")
    public WebElement Image3;
    @FindBy(xpath = "//input[@id='imgRadio3']")
    public WebElement Image4;
    @FindBy(xpath = "//input[@id='imgRadio4']")
    public WebElement Image5;
    @FindBy(xpath = "//button[@aria-label='Close']")
    public WebElement Close_Modal;

    @FindBy(xpath = "//button[@aria-label='Close']")
    public WebElement CloseButton;

    @FindBy(xpath = "//p[contains(text(),'Dont miss out! Items in your bag are not held and ')]")
    public WebElement Dont_Missout_element;

    @FindBy(xpath = "//label[@for='addToBagPdp4']")
    public WebElement selectSizeWhichIsNotAllowed;

    @FindBy(xpath = "//img[@alt='Printed V-Neck Dress - JF Midnight Blue']")
    public WebElement SelectItemWithNoSizeAvailable;
    @FindBy(xpath = "//button[@id='labelledby-accordion1']")
    public WebElement Details;

    @FindBy(css = "div.ProductPrice_large__haiZ8 span.ProductPrice_price__XUX4C")
    public WebElement productPrice;
    @FindBy(css = "div.ProductPrice_large__haiZ8 span.ProductPrice_salePrice__uPZ5p")
    public WebElement discountedProductRedColour;



    @FindBy(xpath = "//img[@data-testid='zoomImg0']")
    public WebElement ProductImage;

    @FindBy(xpath = "//body//div[@id='__next']//main//div//div//div[1]//div[1]//ul[1]//li[1]//a[1]//img[1]")
    public WebElement selectProductFromPDPPage;

    @FindBy(xpath = "//span[normalize-space()='$3.99']")
    public WebElement ShippingCharge;

    @FindBy(css = "div.ProductPrice_small__iGJNZ span.ProductPrice_salePrice__uPZ5p")
    public WebElement prodcutPriceOnPLPpage;
    @FindBy(css = "div.ProductPrice_small__iGJNZ span.ProductPrice_price__XUX4C")
    public WebElement productPriceOnPDP;

    @FindBy(css = "div.ProductPrice_modal__lHPlr span.ProductPrice_regularPrice__P7kc1")
    public WebElement productPriceOnAddToBagModal;

    @FindBy(xpath = "//article//div[2]//span[2]")
    public WebElement shipping;

    @FindBy(css = "div.Pricing_priceItem__P62SZ>span.small-8")
    public WebElement shippingPrice;

    @FindBy(xpath = "//span[@aria-live='polite']")
    public WebElement valueOfProductsAddedInCart;

    @FindBy(css = "span.Badge_large__dASni.Badge_badge__pcjzB")
    public WebElement productBadge;
    @FindBy(xpath = "//Select[@aria-label=\"Quantity\"]")
    public WebElement Quantity_dropdown;

    @FindBy(css = "div.ModalError_content__AZACs")
    public WebElement ErrorMessageForQuanty;
    @FindBy(css = "h1.ModalAddToBag_heading___YF19")
    WebElement successHeading;

    @FindBy(xpath = "//p[@class='PCOCard_body__vp0KH PCOCard_black__Tesqa']")
    public WebElement PcOptimumTile;

    @FindBy(xpath = "//p[text()='This colour is no longer available']")
    public WebElement colourIsNoLongerAvailable;
    @FindBy(xpath = "//button[text()='Details']")
    public WebElement detailsButton;
    @FindBy(xpath = "(//img[@class='RecommendationTile_image__eO9Um'])[1]")
   public WebElement youMayLikeThisProduct;

    @FindBy(xpath ="(//img[@class='RecommendationTile_image__eO9Um'])[16]")
    public WebElement customerAlsoLikeThis;
    @FindBy(xpath = "//h1[text()='My Bag (']")
    WebElement MyBagText;
    @FindBy(css = "div[class='Header_topMenuContainerDesktop__FtC7r'] span[class='MyBagLink_label__tBH0d']")
    public  WebElement MyBagTextAboveSearch;
    @FindBy(css = "button[aria-label='Remove']")
    public WebElement RemoveItemFromBag;

    @FindBy(css = "div[class='ProductPrice_large__haiZ8'] span[class='ProductPrice_eachPrice__0hB2Z']")
    public WebElement ProductRegularPriceDeals;
    @FindBy(xpath = "//img[@alt='Women+ Skinny Jean - Dark Blue']")
    public WebElement buyTwoOfferProduct;
    @FindBy(xpath = "//img[@alt=\"Men's Active Essential Hoodie - Navy Mix\"]")
    public WebElement Hoodie;
    @FindBy(xpath = "//img[@alt=\"Men's Active Essential Hoodie - Navy Mix\"]")
    public WebElement FleeceJogger_J2AProduct;
    @FindBy(css = "div.grid-x div.ProductTile_productTile__LOg79")
    public WebElement productTilesAvailable;

    By productTileCss=By.cssSelector("div.grid-x div.ProductTile_productTile__LOg79") ;

   By productList = By.cssSelector("div[class=ProductTile_image__sBbV_]");

    By imageContainer = By.cssSelector("ul[aria-label='dots'] input[name='pdpThumbs']");
    By fiveProductImages = By.xpath("//input[@name='pdpThumbs']");
    By enabledSizeSwatches = By.cssSelector("input[name='addToBagPdp'][aria-disabled='false']");
    By disabledSizeSwatches = By.cssSelector("input[name='addToBagPdp'][aria-disabled='true']");
    By colourList = By.cssSelector("span[class=\"SwatchList_image__uJXCk\"]");
    @FindBy(css = "h1.ModalAddToBag_heading___YF19") WebElement addToBagDialogBox;
    By youMayLikeThisContainer = By.xpath("//h2[text()='You May Also Like']//ancestor::div[@class='RecommendationSlider_container__iminZ']//descendant::li");
    public boolean elementIsVisible() {
        PcOptimumTile.isDisplayed();
        return true;
    }

    public String selectRandomProduct() throws IOException {
        homePage = new HomePage(driver);
        homePage.searchProduct1();
        homePage.searchBox.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTileCss));
        List<WebElement> products=driver.findElements(productTileCss);
        int selectProduct = random.nextInt(products.size());
        String productName = products.get(selectProduct).getText();
        products.get(selectProduct).click();
        wait.until(ExpectedConditions.visibilityOf(ProductImage));
        Log.info("ProductName is:: "+ productName);
        return productName;
    }


    public int quantityFromDropdown() {
        wait.until(ExpectedConditions.visibilityOf(Quantity_dropdown));
        WebElement Quantity_dropdown = driver.findElement(By.xpath("//Select[@aria-label=\"Quantity\"]"));
        Select value = new Select(Quantity_dropdown);
        List<WebElement> dropdown = value.getOptions();
        for (int i = 0; i < dropdown.size(); i++) {
            String drop_down_values = dropdown.get(i).getText();
        }
        System.out.println("Total DropdownSize Count:: "+ dropdown.size());
        value.selectByIndex(dropdown.size() - 1);
        return dropdown.size();
    }
    public boolean QuantityFromDropDown(){
        WebElement Quantity_dropdown = driver.findElement(By.xpath("//Select[@aria-label=\"Quantity\"]"));
        Select value = new Select(Quantity_dropdown);
        value.selectByVisibleText("1");
        return true;
    }


    public void itemAddToCart() {
        wait.until(ExpectedConditions.visibilityOf(ProductImage));
        List<WebElement> availableSizes = driver.findElements(enabledSizeSwatches);
        int sizeSelected = random.nextInt(availableSizes.size());
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", availableSizes.get(sizeSelected));
        AddToBagItem.click();
        wait.until(ExpectedConditions.visibilityOf(successHeading));
        viewBag.click();
    }

    public boolean SelectEnabledSize() {
        try {
            wait.until(ExpectedConditions.visibilityOf(ProductImage));
            List<WebElement> availableSizes = driver.findElements(enabledSizeSwatches);
            int sizeSelected = random.nextInt(availableSizes.size());
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", availableSizes.get(sizeSelected));
            return true;
        } catch (IllegalArgumentException I) {
            System.out.println("Colour Is not available that's why not able to select the size");
        }
        return false;
    }
    public boolean SelectEnabledSizeFromPLP() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(productList));
            List<WebElement> availableSizes = driver.findElements(enabledSizeSwatches);
            int sizeSelected = random.nextInt(availableSizes.size());
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", availableSizes.get(sizeSelected));
            return true;
        } catch (IllegalArgumentException I) {
            System.out.println("Colour Is not available that's why not able to select the size");
        }
        return false;
    }

    public boolean selectDisabledSize() {
        wait.until(ExpectedConditions.visibilityOf(ProductImage));
        List<WebElement> unavailableSizes = driver.findElements(disabledSizeSwatches);
        int sizeSelected = random.nextInt(unavailableSizes.size());
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", unavailableSizes.get(sizeSelected));
        try {
            return !sizeChartModal.isDisplayed();
        }
        catch (NoSuchElementException nsee){
            return true;
        }
    }

    public WebElement selectAndReturnEnabledSize(){
        wait.until(ExpectedConditions.visibilityOf(ProductImage));
        List<WebElement> availableSizes = driver.findElements(enabledSizeSwatches);
        int sizeSelected = random.nextInt(availableSizes.size());
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", availableSizes.get(sizeSelected));
        return availableSizes.get(sizeSelected);
    }


    public boolean validateFiveProductImages() {
        List<WebElement> productImages = driver.findElements(imageContainer);
       int imageCount= productImages.size();
            if (imageCount==5) {
                System.out.println("Image Count:: "+imageCount+" -All 5 Images are Displayed");
                return true;
            } else {
                System.out.println("Image Count Is not Equal To 5");
                return false;
            }
    }

    public boolean isSizeChartDisplayed() {
        if(sizingChartLink.isDisplayed()){
            wait.until(ExpectedConditions.visibilityOf(sizingChartLink));
            sizingChartLink.click();
            wait.until(ExpectedConditions.visibilityOf(sizeChartModal));
            return sizeChartModal.getText().contains("Size Chart");
        } else if (!sizingChartLink.isDisplayed()) {
            return false;
        }
        return true;
    }

    public boolean validateColorList() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ProductImage));
        List<WebElement> availableColours = driver.findElements(colourList);
        int colourSelected = random.nextInt(availableColours.size());
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", availableColours.get(colourSelected));
        Thread.sleep(3000);
        try {
            if (colourIsNoLongerAvailable.isDisplayed()) {
                return false;
            }
        } catch (NoSuchElementException e) {
            addToBag.click();
        }
        return true;
    }

    public void S() {
        SelectXLSize.click();
    }

    public boolean youMayLikeThisProduct() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(youMayLikeThisProduct));
        youMayLikeThisProduct.click();
        Thread.sleep(12000);
        wait.until(ExpectedConditions.visibilityOf(ProductImage));
        SelectEnabledSize();
        addToBag.click();
        Log.info("Able to add product from the You May Like This Slider");
        return true;
    }

    public boolean customerAlsoLikeThisProduct() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(customerAlsoLikeThis));
        customerAlsoLikeThis.click();
        Thread.sleep(12000);
        wait.until(ExpectedConditions.visibilityOf(ProductImage));
        SelectEnabledSize();
        addToBag.click();
        Log.info("Able to add product from the Customer Also Like This");
        return true;
    }
    public boolean validateMyBagProductCount() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(MyBagText));
        int MyBagCount1 = Integer.parseInt(MyBagText.getText().replaceAll("[^\\d.]", ""));
        int MyBagCount2 = Integer.parseInt(MyBagTextAboveSearch.getText().replaceAll("[^\\d.]", ""));
        System.out.println(MyBagCount1);
        System.out.println(MyBagCount2);
        if (MyBagCount1==MyBagCount2){
            System.out.println("My bag Count is same");
            return true;
        }else {
            System.out.println("My bag Count is not same");
            return false;
        }
    }
    public void selectProducts(){
        for(int i =1; i<4; i++){
            wait.until(ExpectedConditions.visibilityOfElementLocated(productList));
            List<WebElement> availableProducts = driver.findElements(productList);
            int selectProduct =random.nextInt(availableProducts.size());
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", availableProducts.get(selectProduct));
            SelectEnabledSize();
            addToBag.click();
            wait.until(ExpectedConditions.visibilityOf(Close_Modal));
            Close_Modal.click();
            driver.navigate().back();
        }

    }
    public void addProductInTheCart(){
        wait.until(ExpectedConditions.visibilityOf(ProductImage));
        SelectEnabledSize();
        addToBag.click();
        wait.until(ExpectedConditions.visibilityOf(viewBag));
        viewBag.click();
    }
    public void validateComplexMultiRegularPriceIsHigherThanCBBY(){
        wait.until(ExpectedConditions.visibilityOf(ProductRegularPriceDeals));
        float ProductRP = Float.parseFloat(ProductRegularPriceDeals.getText().replaceAll("[^\\d.]", ""));
        float ProductClearenceP = Float.parseFloat(productBadge.getText().replaceAll("[^\\d.]", ""));
        System.out.println(ProductRP);
        System.out.println(ProductClearenceP);
        float sum = (ProductRP/100)*ProductClearenceP;
        System.out.println(sum);

    }
    public void AddProductAndBack(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(productList));
        List<WebElement> availableProducts = driver.findElements(productList);
        for(int i = 1;i<=availableProducts.size();i++){
            int selectProduct =random.nextInt(availableProducts.size());
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", availableProducts.get(selectProduct));
            SelectEnabledSize();
            addToBag.click();
            wait.until(ExpectedConditions.visibilityOf(Close_Modal));
            Close_Modal.click();
            driver.navigate().back();
        }

    }
    public void loadMoreButton() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(productTileCss));
            List<WebElement> products=driver.findElements(productTileCss);
            for (int i=0; i<=products.size() ;i++){
                products.get(i).click();
            }
            while (loadMoreButton.isDisplayed()){
                loadMoreButton.click();
                Thread.sleep(1000);
            }
        } catch (NoSuchElementException | org.openqa.selenium.StaleElementReferenceException exception) {
            Log.info("all items loaded");
        }
    }
public void addAllAvailableSizesFromPDP(){
    try {
        wait.until(ExpectedConditions.visibilityOf(ProductImage));
        List<WebElement> availableSizes = driver.findElements(enabledSizeSwatches);
      //  int avaSize = availableSizes.size()-1;
        //System.out.println(avaSize);
        for (int i=1;i<=availableSizes.size();i++){
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", availableSizes.get(i-1));
            addToBag.click();
            wait.until(ExpectedConditions.visibilityOf(continueShopping));
            continueShopping.click();
             if (i==availableSizes.size()){
                 driver.navigate().back();
             }

        }

    } catch (NoSuchElementException I) {
        System.out.println("Colour Is not available that's why not able to select the size");
    }

}
   public boolean validateAllProductsCanBeAddedToCart() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTileCss));
        List<WebElement> products=driver.findElements(productTileCss);
        try {
            for (int i=0;i<products.size();i++){
                Log.info("Product: "+driver.findElements(productName).get(i).getText());

                try {
                    products.get(i).click();
                }catch (StaleElementReferenceException SE){
                    Log.info("StaleElementException occurs");
                    List<WebElement> productsStale=driver.findElements(productTileCss);
                    productsStale.get(i).click();
                }

                addAllAvailableSizesFromPDP();
            }
        }
        catch (NoSuchElementException nsee){
            return false;
        }
        return true;
    }

    public void J1BProductValidations(){
        common.addExplicitWait(pom.getPDP().ProductImage);
        pom.getPDP().SelectEnabledSize();
        String badge = productBadge.getText();
        System.out.println(badge);
        pom.getPDP().addToBag.click();
        System.out.println(ProductRegularPriceDeals.getText());
        common.clickOn(pom.getPDP().viewBag);
    }

    public String validatePriceBeforeAndAfterRefresh(){
        wait.until(ExpectedConditions.visibilityOf(productPrice));
        String Value =  productPrice.getText();
        driver.navigate().refresh();
        SelectEnabledSize();
        System.out.println(Value);
        return Value;
    }

    public boolean shippingTextPresent(){
        wait.until(ExpectedConditions.visibilityOf(shippingReturnsButton));
        shippingReturnsButton.click();
        wait.until(ExpectedConditions.visibilityOf(shippingAndReturnData));
        Log.info("Shipping and Return Data: "+shippingAndReturnData.getText());
        return shippingAndReturnData.getText().equals("Free shipping on orders over $50.\n" +
                "Free returns in-store. $8 returns online.");
    }
}



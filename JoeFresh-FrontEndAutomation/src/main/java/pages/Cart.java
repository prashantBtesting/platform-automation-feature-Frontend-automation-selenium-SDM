package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.DataDriven;
import util.Log;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Cart {
    WebDriver driver;
    WebDriverWait wait;
    FluentWait fluentWait;
    Actions action;
    Random random;
    public Cart(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        fluentWait=new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1));
        action=new Actions(driver);
        random=new Random();
    }
    @FindBy(id = "voucherId") WebElement promoCodeInputBox;
    @FindBy(id = "voucherLabelledbyId") WebElement promoCodeButton;
    @FindBy(css=".Pricing_checkoutBtnWrapper__DcP2E button") WebElement checkOutButton;
    @FindBy(css = "#headerXL a.MyBagLink_container__xcIvf") WebElement myBagButton;
    @FindBy(css = "input#email") WebElement email;
    @FindBy(xpath = "//button[text()='Checkout as guest']") WebElement checkoutGuest;
    @FindBy(css = "ul.ProductSummar_products__HPzWQ") WebElement productList;
    @FindBy(id="firstName") WebElement firstName;
    @FindBy(id = "lastName") WebElement lastName;
    @FindBy(id = "addressLine1") WebElement addressLine;
    By cartItems=By.cssSelector("ul.ProductSummar_products__HPzWQ");
    By dropdownList=By.xpath("//div[@class='pca pcalist']/div[@class='pcaitem']");
    By pricingItems=By.cssSelector("div.Pricing_priceItem__P62SZ");
    @FindBy(xpath = "//div[@class='pcaautocomplete pcatext'][@style='top: 470.75px; left: 126.75px; min-width: 294px;']") WebElement dropdown;
    @FindBy(xpath = "//button[text()='Continue to delivery']") WebElement buttonContinueToDelivery;
    @FindBy(css = "section.PCOptimun_container__Aitj8") WebElement pcOptimumContainer;
    @FindBy(xpath = "//button[text()='Create an Account']") WebElement pcOptimumRegisterButton;
    @FindBy(xpath = "//section//button[text()='Sign in']") WebElement pcOptimumLink;
    @FindBy(css = "p.PCOCard_body__vp0KH") WebElement pcOptimumAuthCartText;
    @FindBy(css = "h1.EmptyBag_heading__F_2ow") WebElement emptyCartHeading;
    By cartCloseButton=By.cssSelector("button.Product_removeButton__aOS8s");
    @FindBy(xpath = "//button[text()='Apply']") WebElement applyPromoCodeButton;
    @FindBy(css = "p.Voucher_promoSuccessNotes__TRHh4") WebElement voucherSuccessMessage;
    @FindBy(css = "h3.Pricing_total__Pgjlw span:nth-of-type(2)") WebElement totalCartAmount;
    @FindBy(css = "button.CheckoutSteps_signInButton__phFqQ") WebElement signInButtonGuestCheckout;
    @FindBy(xpath = "//span[@class='cell small-8']//following-sibling::span") WebElement shippingPrice;
    By cartProductImages=By.cssSelector("ul.ProductSummar_products__HPzWQ li.ProductSummar_product__PEBrn img");



    public void  navigateToGuestCheckout()  {
        wait.until(ExpectedConditions.visibilityOf(productList));
        fluentWait.until(ExpectedConditions.elementToBeClickable(checkOutButton));
        action.moveToElement(checkOutButton).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys("test@yopmail.com");
        checkoutGuest.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#firstName")));
    }

    public boolean checkoutOptions(){
        wait.until(ExpectedConditions.visibilityOf(productList));
        fluentWait.until(ExpectedConditions.elementToBeClickable(checkOutButton));
        action.moveToElement(checkOutButton).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(email));
        signInButtonGuestCheckout.click();
        wait.until(ExpectedConditions.urlToBe("https://accounts.pcid.ca/login"));
        wait.until(ExpectedConditions.visibilityOf(email));
        return email.isDisplayed();
    }


    public String returnCartAmount()  {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItems));
        List<WebElement> prices=driver.findElements(pricingItems);
        return prices.get(0).findElement(By.cssSelector("span.shrink:nth-of-type(2)")).getText();
    }

    public boolean validateShippingOnCart(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItems));
                Log.info("Shipping on cart: "+driver.findElement(By.xpath("//span[@class='cell small-8']//following-sibling::span")).getText());
                return driver.findElement(By.xpath("//span[@class='cell small-8']//following-sibling::span")).getText().contains("3.99");
            }


    public void enterShippingDetails() throws IOException{
        ArrayList<String> shippingData= DataDriven.getTestData("Checkout","Shipping address");
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys(shippingData.get(1));
        lastName.sendKeys(shippingData.get(2));
        addressLine.sendKeys("17 ");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dropdownList));
        int dropdownOption=random.nextInt(driver.findElements(dropdownList).size());
        action.moveToElement(driver.findElements(dropdownList).get(dropdownOption)).click().build().perform();
        buttonContinueToDelivery.click();
    }

    public void shippingDetailsWithoutSave() throws IOException {
        ArrayList<String> shippingData= DataDriven.getTestData("Checkout","Shipping address");
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys(shippingData.get(1));
        lastName.sendKeys(shippingData.get(2));
        addressLine.sendKeys("17 ");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dropdownList));
        int dropdownOption=random.nextInt(driver.findElements(dropdownList).size());
        action.moveToElement(driver.findElements(dropdownList).get(dropdownOption)).click().build().perform();
    }

    public void authCheckout(){
        wait.until(ExpectedConditions.visibilityOf(productList));
        fluentWait.until(ExpectedConditions.elementToBeClickable(checkOutButton));
        action.moveToElement(checkOutButton).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(buttonContinueToDelivery));
    }

    public boolean pcOptimumCardAuth(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItems));
        Log.info("PC Optimum Text: "+pcOptimumAuthCartText.getText());
        return pcOptimumContainer.isDisplayed()&&pcOptimumAuthCartText.getText().equals("Get personalized PC Optimum™ offers and start earning points today!");
    }
    public boolean pcOptimumGuest(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItems));
        return pcOptimumContainer.isDisplayed()&&pcOptimumRegisterButton.isDisplayed()&&pcOptimumLink.isDisplayed();
    }

    public boolean pcOptimumNoItemInCart(){
        wait.until(ExpectedConditions.visibilityOf(emptyCartHeading));
        return driver.findElements(By.cssSelector("section.PCOptimun_container__Aitj8")).size()<1;
    }

    public void removeProductsFromCart(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItems));
        if(driver.findElements(cartCloseButton).size()>=1){
            for (WebElement closeButton:driver.findElements(cartCloseButton)){
                wait.until(ExpectedConditions.elementToBeClickable(closeButton));
                closeButton.click();
            }
        }
    }

    public int returnCartProductsNumber() {
        wait.until(ExpectedConditions.visibilityOf(myBagButton));
        String number=driver.findElement(By.cssSelector("div.Header_topMenuContainerDesktop__FtC7r a.MyBagLink_container__xcIvf span.MyBagLink_label__tBH0d")).getText();
        if(number.contains("(")){
            Log.info("My Bag : "+number);
            return Integer.parseInt(number.replaceAll("\\D+",""));
        }
        else {
            return 0;
        }
    }
    public boolean addPromoCode(){
        wait.until(ExpectedConditions.elementToBeClickable(promoCodeButton));
        float amountBeforePromo=Float.parseFloat(totalCartAmount.getText().replace("$", ""));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",promoCodeButton);
        wait.until(ExpectedConditions.visibilityOf(promoCodeInputBox));
        promoCodeInputBox.sendKeys("DANIMARIE20");
        applyPromoCodeButton.click();
        wait.until(ExpectedConditions.visibilityOf(voucherSuccessMessage));
        Log.info("Amount Before Promo: "+amountBeforePromo);
        Log.info("Amount after promo:"+Float.parseFloat(returnCartAmount().replace("$","")));
        return amountBeforePromo>Float.parseFloat(totalCartAmount.getText().replace("$",""));
    }

    public boolean validatePCOptimumShipping() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(checkOutButton));
        Log.info("Shipping Amount: "+shippingPrice);
        if(!( shippingPrice.getText().equals("FREE"))){
            return false;
        }
          checkOutButton.click();
        return shippingPrice.getText().equals("FREE");
    }
    public List<String> validateitemsOnOrderSummaryProducts(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartProductImages));
        List<String> productLink=new ArrayList<>();
        for (WebElement product:driver.findElements(cartProductImages)){
            productLink.add(product.getAttribute("src"));
            Log.info(product.getAttribute("src"));
        }
        return productLink;
    }

    public boolean validateCartMessageOnSignIn(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItems));
        WebElement cartMessage=driver.findElement(By.cssSelector("div.CartNotification_container__SwtMP p"));
        return cartMessage.getText().contains("includes item(s) added before Sign In");
    }

    public void cartToCheckoutPage(){
        wait.until(ExpectedConditions.visibilityOf(checkOutButton));
        checkOutButton.click();
    }

    public List<String> validateOrderSummaryOnCart(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartProductImages));
        List<String> imageSrc=new ArrayList<>();
        for (WebElement productInCart:driver.findElements(cartProductImages)){
            imageSrc.add(productInCart.getAttribute("src"));
        }
        return imageSrc;
    }

    public int returnCartItemSize(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItems));
        return driver.findElements(cartProductImages).size();
    }

    public HashMap<String,String> getCartMap(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.Pricing_priceItem__P62SZ span.shrink")));
        HashMap<String,String> cartPrices=new HashMap<>();
        for (WebElement priceTitle:driver.findElements(By.cssSelector("div.Pricing_priceItem__P62SZ span.cell:nth-of-type(1)"))){
            cartPrices.put(priceTitle.getText(),priceTitle.findElement(By.xpath("//following-sibling::span")).getText());
        }
        Log.info("Cart Prices: "+cartPrices);
        return cartPrices;
    }

    public List<WebElement> getCartItems(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItems));
        return driver.findElements(cartItems);
    }

}

package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.DataDriven;
import util.Log;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Checkout {
    WebDriver driver;
    WebDriverWait wait;
    FluentWait fluentWait;
    Random random;
    Actions action;

    public Checkout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        fluentWait = new FluentWait(driver).withTimeout(Duration.ofSeconds(20));
        random=new Random();
        action=new Actions(driver);
    }
    @FindBy(id = "SHIPPING_STANDARD_GROUND")    WebElement standardShippingRadio;
    @FindBy(css = " div.CheckoutSteps_summary__pAh7L")
    WebElement shippingAddress;
    @FindBy(xpath = "//label[@for='SHIPPING_EXPEDITED']")
    WebElement expressShippingRadio;
    @FindBy(xpath = "//button[text()='Continue to payment']")
    public WebElement continueToPayment;
    @FindBy(css = "h3.CheckoutSteps_summaryHeading__qBnBv") WebElement billingAddress;
    @FindBy(id = "useShippingAsBilling") WebElement billingAddressCheckbox;
    @FindBy(css = "div.Pricing_priceItem__P62SZ:nth-of-type(1)>span.shrink:nth-of-type(2)") WebElement subTotal;
    @FindBy(css = "div.Pricing_priceItem__P62SZ:nth-of-type(2)>span.shrink:nth-of-type(2)") WebElement shippingCharges;
    @FindBy(xpath = "//button[text()='Continue to card details']") WebElement continueToCardDetails;

    @FindBy(id = "addressLine1") WebElement billingAddressLine1;
    By dropdownList = By.xpath("//div[@class='pca pcalist']/div[@class='pcaitem']");
    By priceContainer = By.cssSelector("div.Pricing_priceItem__P62SZ");
    @FindBy(id = "addressLine1-error") WebElement addressLine1Error;
    @FindBy(id = "city-error") WebElement cityError;
    @FindBy(xpath = "//div[@class='NativeSelect_container__kM_xP']//following-sibling::div[@class='InlineError_message__79aHw']") WebElement provinceError;
    @FindBy(id = "postalCode-error") WebElement postalError;
    @FindBy(id = "addressLine2") WebElement addressLine2;
    @FindBy(id = "postalCode") WebElement postalCode;
    @FindBy(id = "addressLine2-error") WebElement addressLine2Error;
    @FindBy(id = "pas_ccnum") WebElement creditCardNumber;
    @FindBy(id = "pas_expiry") WebElement expiryDate;
    @FindBy(id = "pas_cccvc") WebElement securityCode;
    @FindBy(id="pas_ccname") WebElement cardholderName;
    @FindBy(id = "pas_ccnum-error") WebElement creditCardError;
    @FindBy(id = "pas_expiry-error") WebElement expiryDateError;
    @FindBy(id="pas_cccvc-error") WebElement cvcError;
    @FindBy(id = "pas_ccname-error") WebElement cardholderError;
    @FindBy(xpath = "//button[text()='Review order']") WebElement reviewOrder;
    @FindBy(xpath = "//h3[text()='Credit card details']//following-sibling::p") WebElement creditCardDetails;
    @FindBy(xpath = "//div[@class='ResponsiveWrapper_mediumAbove__UvI2y']//button[text()='Place order']") WebElement placeOrderButton;
    @FindBy(css = "h1.CheckoutConfirmation_heading__pp5Ak") WebElement orderSuccess;
    @FindBy(id = "firstName") WebElement firstName;
    @FindBy(id = "lastName") WebElement lastName;
    @FindBy(id = "saveAddress") WebElement saveAddressCheckbox;
    @FindBy(xpath = "//button[text()='Continue to delivery']") WebElement continueToDeliveryButton;
    @FindBy(css="button.CheckoutSteps_editButton__68Z3m") WebElement editAddressButton;
    @FindBy(id = "firstName-error") WebElement firstNameError;
    @FindBy(id = "lastName-error") WebElement lastNameError;//*[@id="__next"]/div/div/div/div/div[2]/div[1]/div/div[1]/div[2]/form/div[10]/div/div/button
    @FindBy(css = "div.CheckoutSteps_errorShipping__qH6GL") WebElement beError;
    By inputRadioAddress=By.name("addressId");
    @FindBy(xpath = "//button[text()='Add a new address']") WebElement addANewAddress;
    @FindBy(xpath = "//button[text()='Cancel']") WebElement cancelButton;
    @FindBy(xpath = "//button[text()='Back to saved cards']") WebElement backToSavedCards;
    By savedCards=By.name("cardId");
    @FindBy(xpath = "//button[text()='Add a new card']") WebElement addANewCardButton;
   // @FindBy(xpath = "//button[text()='Back to saved cards']") WebElement backToSavedCards;
    @FindBy(id = "saveCard") WebElement saveCardCheckbox;
    @FindBy(id = "SHIPPING_EXPEDITED") WebElement expressDeliveryOption;
    @FindBy(id = "country") WebElement country;
    @FindBy(xpath = "//button[text()='Edit payment']") WebElement editPaymentButton;
    @FindBy(css = ".PCORedemption_p3__xTd_z") WebElement pointsPCO;
    @FindBy(css = ".PCORedemption_container__lIIYB") WebElement noPointPCO;
    @FindBy(css = "button[role='button'] > .PCORedemption_arrows__lkYJh") WebElement dropDownPCO;
    @FindBy(css = "ul#downshift-0-menu > li:nth-of-type(5)") WebElement PCOPoints;
    @FindBy(css = "ul#downshift-0-menu > li:nth-of-type(2)") WebElement deducePoints;
    @FindBy(css = ".StepperContainer_stepper__NUCZW label") WebElement saveCard;
    @FindBy(css= ".CheckoutConfirmation_heading__pp5Ak") WebElement thankYou;
    @FindBy(css = ".CheckoutConfirmation_fauxButton__wVH70") WebElement continueShopping;
    @FindBy(css= ".StepperContainer_stepper__NUCZW div:nth-of-type(4) .Button_primary__PgyFQ") WebElement placeOrder;
    @FindBy(xpath= "//button[@id='productsLabelledbyId']") public WebElement ProductCountOnCheckOut;
    @FindBy(id = "voucherId") WebElement promoCodeInputBox;
    @FindBy(id ="voucherLabelledbyId") WebElement promoCodeButton;
    @FindBy(css = "div.Voucher_alertMessage__LKjyU") WebElement promoCodeSuccessMessage;
    @FindBy(css = "div.Voucher_alertAction__iXo9O button") WebElement promoCodeRemoveButton;
    @FindBy(css = "div.Pricing_savings__U_gg0 span.cell:nth-of-type(2)") WebElement savingsAmount;
    By pricingItems=By.cssSelector("div.Pricing_priceItem__P62SZ");


    public void continueToDelivery(){
        continueToDeliveryButton.click();
    }
    public void billingAddressCheckbox() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(addANewCardButton));
        addANewCardButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(continueToCardDetails));
        continueToCardDetails.click();
        Thread.sleep(20000);
        driver.switchTo().frame("globalPaymentFrame");
        creditCardNumber.sendKeys("4111111111111111");
        expiryDate.sendKeys("0829");
        securityCode.sendKeys("400");
        cardholderName.sendKeys("John Smith");
        reviewOrder.click();
    }
    public void cardDetails() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(addANewCardButton));
        addANewCardButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(continueToCardDetails));
        continueToCardDetails.click();
        Thread.sleep(20000);
        driver.switchTo().frame("globalPaymentFrame");
        creditCardNumber.sendKeys("4111111111111111");
        expiryDate.sendKeys("0829");
        securityCode.sendKeys("400");
        cardholderName.sendKeys("John Smith");
        reviewOrder.click();
    }
    public void duplicateCard() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(addANewCardButton));
        addANewCardButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(continueToCardDetails));
        continueToCardDetails.click();
        Thread.sleep(20000);
        driver.switchTo().frame("globalPaymentFrame");
        creditCardNumber.sendKeys("4111111111111111");
        expiryDate.sendKeys("08");
        expiryDate.sendKeys("2");
        expiryDate.sendKeys("9");
        securityCode.sendKeys("400");
        cardholderName.sendKeys("John Smith");
        wait.until(ExpectedConditions.elementToBeClickable(reviewOrder));
        reviewOrder.click();
        wait.until(ExpectedConditions.elementToBeClickable(placeOrder));
        placeOrder.click();
    }
    public void orderPlace(){
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        placeOrderButton.click();
    }
    public void shopping(){
        wait.until(ExpectedConditions.elementToBeClickable(continueShopping));
        continueShopping.click();
    }
    public boolean selectPCO(){
        wait.until(ExpectedConditions.visibilityOf(pointsPCO));
        return pointsPCO.isDisplayed();
    }
    public void selectPCOPoints() throws InterruptedException {
        dropDownPCO.click();
        wait.until(ExpectedConditions.elementToBeClickable(deducePoints));
        deducePoints.click();
        wait.until(ExpectedConditions.elementToBeClickable(reviewOrder));
        reviewOrder.click();
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        placeOrderButton.click();
    }
    public boolean thankYouOrder(){
        wait.until(ExpectedConditions.visibilityOf(thankYou));
        return thankYou.isDisplayed();
    }
    public boolean noPCO(){
        wait.until(ExpectedConditions.visibilityOf(noPointPCO));
        return noPointPCO.isDisplayed();
    }
    @FindBy(id = "productsLabelledbyId") WebElement itemsInBagButtonCheckout;
    By productOnCheckoutImage=By.cssSelector("div.Product_productImageWrapper__U063S img");
    By savingsContainer=By.cssSelector("div.Pricing_savings__U_gg0");
    @FindBy(id = "voucherId") WebElement promoCodeBox;
    @FindBy(css = ".Voucher_applyPromoWrapper__Jt72X button") WebElement applyPromoCodeButton;
    @FindBy(id = "voucherLabelledbyId") WebElement promoCodeArrow;



    public void selectDefaultDeliveryMode() {
        wait.until(ExpectedConditions.visibilityOf(standardShippingRadio));
        continueToPayment.click();
    }
    public boolean validateBillingAddress() {
        wait.until(ExpectedConditions.visibilityOf(continueToCardDetails));
        return billingAddress.isDisplayed();
    }
    public boolean validateSameAsBillingAddress() {
        wait.until(ExpectedConditions.visibilityOf(continueToCardDetails));
        return billingAddressCheckbox.isSelected();
    }
    public boolean validateShippingAndBillingAddress() {
        String shippingAddress = driver.findElements(By.cssSelector("div.CheckoutSteps_summary__pAh7L"))
                .get(0).findElement(By.cssSelector("div.CheckoutSteps_summary__pAh7L :nth-child(2)")).getText() + " " +
                driver.findElements(By.cssSelector("div.CheckoutSteps_summary__pAh7L"))
                        .get(0).findElement(By.cssSelector("div.CheckoutSteps_summary__pAh7L :nth-child(3)")).getText();
        Log.info("Shipping Address: " + shippingAddress);
        String billingAddress = driver.findElement(By.cssSelector("div.CheckoutSteps_billingSummary__RpPyK :nth-child(1)")).getText() + " "
                + driver.findElement(By.cssSelector("div.CheckoutSteps_billingSummary__RpPyK :nth-child(2)")).getText();
        Log.info("Billing Address :" + billingAddress);
        return shippingAddress.equals(billingAddress);
    }
    public boolean shippingChargesApplicable() {
        float subtotalAmount = Float.parseFloat(subTotal.getText().replace("$", ""));
        Log.info("Subtotal: " + subtotalAmount);
        if (subtotalAmount < 50.0) {
            return true;
        } else if (subtotalAmount >= 50.0) {
            return false;
        } else {
            Log.info("Error with code");
            return false;
        }
    }
    public boolean validateShippingPrice() {
        wait.until(ExpectedConditions.visibilityOf(continueToCardDetails));
        List<WebElement> prices = driver.findElements(priceContainer);
        //prices.get(1).findElement(By.cssSelector("div.Pricing_priceItem__P62SZ>span.small-8")).getText();
        if (shippingChargesApplicable() && prices.get(1).findElement(By.cssSelector("div.Pricing_priceItem__P62SZ>span.small-8")).getText().contains("Shipping")) {
            Log.info("Price: " + prices.get(1).findElement(By.cssSelector("span.shrink")).getText());
            return prices.get(1).findElement(By.cssSelector("span.shrink")).getText().equals("$3.99");
        } else if (!shippingChargesApplicable() && prices.get(1).findElement(By.cssSelector("div.Pricing_priceItem__P62SZ>span.small-8")).getText().contains("Shipping")) {
            Log.info("Price: " + prices.get(1).findElement(By.cssSelector("span.shrink")).getText());
            return prices.get(1).findElement(By.cssSelector("span.shrink")).getText().equals("FREE");
        } else {
            Log.info("Error with the price");
            return false;
        }
    }
    public boolean validateTaxes() {
        wait.until(ExpectedConditions.visibilityOf(continueToCardDetails));
        List<WebElement> prices = driver.findElements(priceContainer);
        for (int i = 2; i < prices.size(); i++) {
            Log.info("TAX: " + prices.get(i).findElement(By.cssSelector("span.shrink:nth-of-type(1)")).getText());
            Log.info("TAX-Amount: " + prices.get(i).findElement(By.cssSelector("span.shrink:nth-of-type(2)")).getText());
            if (!(prices.get(i).findElement(By.cssSelector("span.shrink:nth-of-type(1)")).getText().contains("Tax") &&
                    Float.parseFloat(prices.get(i).findElement(By.cssSelector("span.shrink:nth-of-type(2)")).getText().replace("$", "")) > 0.0)) {
                return false;
            }
        }
        return true;
    }
    public boolean validateBillingFormDisplayed() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",billingAddressCheckbox);
        wait.until(ExpectedConditions.visibilityOf(billingAddressLine1));
        return billingAddressLine1.isDisplayed();
    }
    public boolean emptySubmitBillingAddress() {
        wait.until(ExpectedConditions.visibilityOf(continueToCardDetails));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",billingAddressCheckbox);
        fluentWait.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.attributeToBe(billingAddressCheckbox,"aria-checked","false"));
        action.moveToElement(continueToCardDetails).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(addressLine1Error));
        return cityError.isDisplayed() && provinceError.isDisplayed() && postalError.isDisplayed();
    }
    public boolean validateInvalidEntry(){
        wait.until(ExpectedConditions.visibilityOf(continueToCardDetails));
        wait.until(ExpectedConditions.attributeToBe(billingAddressCheckbox,"aria-checked","false"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        billingAddressLine1.sendKeys("#%^^&%*&%*(^)((^E1234$$$$");
        addressLine2.sendKeys("#%^^&%*&%*(^)((^E1234$$$$##%$%^$^^^99#");
        postalCode.sendKeys("12345");
        wait.until(ExpectedConditions.visibilityOf(postalError));
        return
        addressLine2Error.isDisplayed()&&addressLine2Error.getText().contains("35 characters")&&postalError.isDisplayed()&&postalError.getText().contains("correct format");
    }
    public boolean invalidCharacterEntry(){
        wait.until(ExpectedConditions.visibilityOf(continueToCardDetails));
        billingAddressLine1.clear();
        billingAddressLine1.sendKeys("####");
        addressLine2.clear();
        addressLine2.sendKeys("#####");
        wait.until(ExpectedConditions.textToBePresentInElement(addressLine1Error,"includes"));
        wait.until(ExpectedConditions.textToBePresentInElement(addressLine2Error,"includes"));
        Log.info("Address Line1 Error Text: "+addressLine1Error.getText());
        Log.info("Address Line2 Error Text: "+addressLine2Error.getText());
        return addressLine1Error.isDisplayed()&&addressLine1Error.getText().contains("your address only includes letters, numbers, spaces, commas")&&
                addressLine2Error.isDisplayed()&&addressLine2Error.getText().contains(" your address line 2 only includes letters, numbers, spaces, commas");
    }
    public void enterBillingAddressDetails()  {
        wait.until(ExpectedConditions.visibilityOf(continueToCardDetails));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",billingAddressCheckbox);
        wait.until(ExpectedConditions.visibilityOf(billingAddressLine1));
        billingAddressLine1.sendKeys("85-1454 Pendrell St ");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[title='85-1454 Pendrell St']")));
        action.moveToElement(driver.findElement(By.cssSelector("div[title='85-1454 Pendrell St']"))).click().build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(continueToCardDetails));
        continueToCardDetails.click();
    }
    public boolean validateCardFormVisible() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(59,TimeUnit.SECONDS);
        driver.switchTo().frame("globalPaymentFrame");
        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOf(creditCardNumber));
        return creditCardNumber.isDisplayed();
    }
    public boolean emptySubmitCardForm() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(continueToCardDetails));
        continueToCardDetails.click();
       Thread.sleep(15000);
        driver.switchTo().frame("globalPaymentFrame");
        reviewOrder.click();
        return creditCardError.isDisplayed()&&expiryDateError.isDisplayed()
                &&cvcError.isDisplayed()&&cardholderError.isDisplayed();
    }
    public boolean invalidCreditCardFormDetails() throws InterruptedException {
       Thread.sleep(5000);
       // driver.switchTo().frame("globalPaymentFrame");
        creditCardNumber.sendKeys("12345678910");
        expiryDate.sendKeys("0822");
        securityCode.sendKeys("10");
        cardholderName.sendKeys("#$^@#");
        reviewOrder.click();
        return creditCardError.getText().contains("at least 12 digits")&&
                expiryDateError.getText().contains("The Expiry Date is not valid")&&
                cvcError.getText().contains("too short");
    }
    public void submitCardDetails() throws IOException, InterruptedException {
        //driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
        Thread.sleep(20000);
        driver.switchTo().frame("globalPaymentFrame");
        creditCardNumber.sendKeys("4263970000005262");
        expiryDate.sendKeys("08");
        Thread.sleep(900);
        expiryDate.sendKeys("2");
        Thread.sleep(900);
        expiryDate.sendKeys("9");
        Thread.sleep(1000);
        securityCode.sendKeys("400");
        Thread.sleep(500);
        cardholderName.sendKeys("Test Account");
        Thread.sleep(1000);
        reviewOrder.click();
    }
    public boolean validateCardDetailsSubmitted(){
        wait.until(ExpectedConditions.visibilityOf(creditCardDetails));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return creditCardDetails.isDisplayed() && creditCardDetails.getText().contains("ending in");
    }
    public void directToPayment() throws IOException, InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(continueToCardDetails));
        continueToCardDetails.click();
        //driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
        submitCardDetails();
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOf(placeOrderButton));
        placeOrderButton.click();
    }
    public boolean validateOrderSuccess(){
        wait.until(ExpectedConditions.visibilityOf(orderSuccess));
        return orderSuccess.isDisplayed();
    }

    public boolean validateSaveShippingAddress(){
        wait.until(ExpectedConditions.visibilityOf(firstName));
        if(!saveAddressCheckbox.isSelected()){
            return true;
        }
        return false;
    }

    public void clickAddANewAddress(){
        wait.until(ExpectedConditions.visibilityOf(addANewAddress));
        addANewAddress.click();
    }

    public void fillShippingAddressAuth() throws IOException, InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(firstName));
        ArrayList<String> userData=DataDriven.getTestData("Checkout","Auth Shipping Details");
        firstName.sendKeys(userData.get(1));
        lastName.sendKeys(userData.get(2));
        billingAddressLine1.sendKeys("17 ");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dropdownList));
        int dropdownOption=random.nextInt(driver.findElements(dropdownList).size());
        action.moveToElement(driver.findElements(dropdownList).get(dropdownOption)).click().build().perform();
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveAddressCheckbox);
        wait.until(ExpectedConditions.elementToBeClickable(continueToDeliveryButton));
        wait.until(ExpectedConditions.attributeToBe(saveAddressCheckbox, "aria-checked", "true"));
        continueToDeliveryButton.click();
    }

    public void proceedToPayment(){
        wait.until(ExpectedConditions.elementToBeClickable(continueToCardDetails));
        continueToCardDetails.click();
    }

    public boolean validateEditAddressButton(){
        wait.until(ExpectedConditions.elementToBeClickable(continueToDeliveryButton));
        continueToDeliveryButton.click();
        wait.until(ExpectedConditions.visibilityOf(standardShippingRadio));
        editAddressButton.click();
        wait.until(ExpectedConditions.visibilityOf(addANewAddress));
        addANewAddress.click();
        wait.until(ExpectedConditions.visibilityOf(firstName));
        return firstName.isDisplayed() && lastName.isDisplayed();
    }

    public boolean emptySubmissionShippingDetails(){
        wait.until(ExpectedConditions.visibilityOf(continueToDeliveryButton));
        addANewAddress.click();
        wait.until(ExpectedConditions.visibilityOf(cancelButton));
        continueToDeliveryButton.click();
        wait.until(ExpectedConditions.visibilityOf(postalError));
        return //firstNameError.isDisplayed()&&lastNameError.isDisplayed()&&
                addressLine1Error.isDisplayed()&&postalError.isDisplayed()&&beError.isDisplayed();
    }

    public boolean invalidShippingDetailsEntry(){
        wait.until(ExpectedConditions.visibilityOf(continueToDeliveryButton));
        firstName.sendKeys("%7UJH^");
        lastName.sendKeys("^&U&6555");
        postalCode.sendKeys("12467");
        return //firstNameError.isDisplayed()&&lastNameError.isDisplayed()&&
         postalError.isDisplayed()&&beError.isDisplayed();
    }

    public boolean validateSavedAddressSelection(){
        wait.until(ExpectedConditions.visibilityOf(continueToDeliveryButton));
        return driver.findElements(inputRadioAddress).get(0).isSelected();
    }

    public boolean validateNewAddressCanBeFilled(){
        wait.until(ExpectedConditions.visibilityOf(continueToDeliveryButton));
        addANewAddress.click();
        wait.until(ExpectedConditions.visibilityOf(firstName));
        return firstName.isDisplayed();
    }

    public void selectDefaultAddress(){
        wait.until(ExpectedConditions.visibilityOf(continueToDeliveryButton));
        addANewAddress.click();
        wait.until(ExpectedConditions.visibilityOf(firstName));
        cancelButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(inputRadioAddress));
        continueToDeliveryButton.click();
    }

    public boolean validateShippingAddressDetailsSubmitted(){
        wait.until(ExpectedConditions.visibilityOf(continueToPayment));
        return standardShippingRadio.isDisplayed();
    }

    public boolean validateSavedCards(){
        wait.until(ExpectedConditions.elementToBeClickable(reviewOrder));
        reviewOrder.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(savedCards));
        return driver.findElements(savedCards).size()>=1&&driver.findElements(savedCards).get(0).isSelected();
    }

    public boolean validateAddANewCard(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(savedCards));
        addANewCardButton.click();
        return billingAddressCheckbox.isDisplayed() && billingAddressCheckbox.isSelected();
    }



    public boolean validateCancelPaymentSectionAfterBillingDetails(){
        driver.switchTo().parentFrame();
        wait.until(ExpectedConditions.visibilityOf(continueToCardDetails));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(savedCards));
        return driver.findElements(savedCards).size()>=1
                &&driver.findElements(savedCards).get(0).isSelected()
                &&addANewCardButton.isDisplayed();
    }

    public boolean validateCancelPaymentSectionAfterPaymentDetails() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(addANewCardButton));
        addANewCardButton.click();
        enterBillingAddressDetails();
        Thread.sleep(1000);
        driver.switchTo().frame("globalPaymentFrame");
        driver.switchTo().parentFrame();
        backToSavedCards.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(savedCards));
        return driver.findElements(savedCards).size()>=1
                &&driver.findElements(savedCards).get(0).isSelected()
                &&addANewCardButton.isDisplayed();
    }

    public void selectDefaultPayment(){
        wait.until(ExpectedConditions.elementToBeClickable(reviewOrder));
        reviewOrder.click();
    }

    public boolean validateExpressDeliverySelected(){
        List<WebElement> prices = driver.findElements(priceContainer);
        wait.until(ExpectedConditions.visibilityOf(continueToPayment));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",expressDeliveryOption);
        continueToPayment.click();
        wait.until(ExpectedConditions.visibilityOf(reviewOrder));
        return expressDeliveryOption.isSelected()&&prices.get(1).findElement(By.cssSelector("span.shrink")).getText().equals("$17.00");
    }

    public void loginNoDetailsCheckout() throws IOException, InterruptedException {
        fillShippingAddressAuth();
        selectDefaultDeliveryMode();
        wait.until(ExpectedConditions.visibilityOf(continueToCardDetails));
        continueToCardDetails.click();
        wait.until(ExpectedConditions.visibilityOf(saveCardCheckbox));
        submitCardDetails();
        wait.until(ExpectedConditions.visibilityOf(placeOrderButton));
        placeOrderButton.click();
        wait.until(ExpectedConditions.visibilityOf(orderSuccess));
    }

    public void loginSavedInformationCheckout(){
        wait.until(ExpectedConditions.visibilityOf(continueToDeliveryButton));
        continueToDeliveryButton.click();
        wait.until(ExpectedConditions.visibilityOf(continueToPayment));
        continueToPayment.click();
        wait.until(ExpectedConditions.visibilityOf(reviewOrder));
        reviewOrder.click();
        wait.until(ExpectedConditions.visibilityOf(placeOrderButton));
        placeOrderButton.click();
    }

    public boolean headerOnlyLogo(){
        wait.until(ExpectedConditions.visibilityOf(continueToDeliveryButton));
        return driver.findElements(By.cssSelector("div.medium-4")).size()==1;
    }

    public String authenticateBillingAddress() throws InterruptedException {
       wait.until(ExpectedConditions.elementToBeClickable(editPaymentButton));
        editPaymentButton.click();
        wait.until(ExpectedConditions.visibilityOf(continueToCardDetails));
        String address=driver.findElement(By.cssSelector("div.CheckoutSteps_billingSummary__RpPyK")).getText();
        continueToCardDetails.click();
        wait.until(ExpectedConditions.visibilityOf(saveCardCheckbox));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",saveCardCheckbox);
       driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
       // Thread.sleep(5000);
        driver.switchTo().frame("CheckoutSteps_globalPaymentFrame__xqTKv");
        creditCardNumber.sendKeys("4222000006285344t");
        expiryDate.sendKeys("0727");
        securityCode.sendKeys("400");
        cardholderName.sendKeys("Test Account");
        reviewOrder.click();
        driver.switchTo().parentFrame();
        return address;
    }
    public String validateAddressBeforeAndAfterContinueToDelivery() {
        wait.until(ExpectedConditions.visibilityOf(continueToPayment));
        return shippingAddress.getText();
    }
    public boolean checkAndValidateEditAddress() {
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys("dfsdfsd");
        wait.until(ExpectedConditions.visibilityOf(lastName));
        lastName.sendKeys("wdfdfd");
        billingAddressLine1.sendKeys("17 ");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dropdownList));
        int dropdownOption = random.nextInt(driver.findElements(dropdownList).size());
        action.moveToElement(driver.findElements(dropdownList).get(dropdownOption)).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(continueToDeliveryButton));
        continueToDeliveryButton.click();
        return true;

    }
    public boolean validateAddressButtonClickableAfterContinueToDelivery() {
        wait.until(ExpectedConditions.visibilityOf(editAddressButton));
        editAddressButton.click();
        wait.until(ExpectedConditions.visibilityOf(firstName));
        return firstName.isDisplayed() && lastName.isDisplayed();
    }
    public boolean validateExpressButtonEnabled() {
        wait.until(ExpectedConditions.visibilityOf(expressShippingRadio));
        expressShippingRadio.click();
        return expressShippingRadio.isDisplayed();
    }

    public boolean validateExpressShipping(){
        wait.until(ExpectedConditions.visibilityOf(shippingCharges));
        return shippingCharges.getText().equals("$17.00");
    }
    public boolean validatePriceAfterCardContinueTODelivery() {
        wait.until(ExpectedConditions.visibilityOf(shippingCharges));
        List<WebElement> prices = driver.findElements(priceContainer);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.Pricing_priceItem__P62SZ>span.small-8"))));
        prices.get(1).findElement(By.cssSelector("div.Pricing_priceItem__P62SZ>span.small-8")).getText();
        if (shippingChargesApplicable() && prices.get(1).findElement(By.cssSelector("div.Pricing_priceItem__P62SZ>span.small-8")).getText().contains("Shipping")) {
            Log.info("Price: " + prices.get(1).findElement(By.cssSelector("span.shrink")).getText());
            return prices.get(1).findElement(By.cssSelector("span.shrink")).getText().equals("$3.99");
        } else if (!shippingChargesApplicable() && prices.get(1).findElement(By.cssSelector("div.Pricing_priceItem__P62SZ>span.small-8")).getText().contains("Shipping")) {
            Log.info("Price: " + prices.get(1).findElement(By.cssSelector("span.shrink")).getText());
            return prices.get(1).findElement(By.cssSelector("span.shrink")).getText().equals("FREE");
        } else {
            Log.info("Error with the price");
            return false;
        }
    }
    public String returnShippingAddressSelectedOrAdded(){
        driver.findElement(By.xpath("//div[@class='CheckoutSteps_summary__pAh7L']"));
        return driver.findElement(By.xpath("//div[@class='CheckoutSteps_summary__pAh7L']")).getText();
    }

    public List<String> validateItemsOnCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(itemsInBagButtonCheckout));
        itemsInBagButtonCheckout.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productOnCheckoutImage));
        List<String> imgSrc=new ArrayList<>();
        for (WebElement prodctImage:driver.findElements(productOnCheckoutImage)){
            imgSrc.add(prodctImage.getAttribute("src"));
        }
        return imgSrc;
    }
    public boolean validateAmount(){
        By salePrice=By.cssSelector("span.PriceSale_container__qlwOe span.PriceSale_priceSale__QbrNY");
        By regularPrice=By.cssSelector("li.Product_container__sRh_g span.PriceSale_container__qlwOe span.PriceSale_priceRegular__1Hlp5");
        By price=By.cssSelector("li.Product_container__sRh_g span.PriceRegular_container__IKh_v");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("li.Product_container__sRh_g")));
        for(WebElement product:driver.findElements(By.cssSelector("li.Product_container__sRh_g"))){
            try {
                Log.info("Sale Price: "+Float.parseFloat(product.findElement(salePrice).getText().replaceAll("[^\\d.]","")));
                Log.info("Regular Price: "+Float.parseFloat(product.findElement(regularPrice).getText().replaceAll("[^\\d.]","")));
                return product.findElement(salePrice).isDisplayed()&&Float.parseFloat(product.findElement(salePrice).getText().replaceAll("[^\\d.]",""))>0.0
                        &&product.findElement(regularPrice).isDisplayed()&&Float.parseFloat(product.findElement(regularPrice).getText().replaceAll("[^\\d.]",""))>0.0;
            }
            catch (NoSuchElementException nsee){
                Log.info("Sale Price: "+Float.parseFloat(product.findElement(price).getText().replaceAll("[^\\d.]","")));
                return product.findElement(price).isDisplayed()&&Float.parseFloat(product.findElement(price).getText().replaceAll("[^\\d.]",""))>0.0;
            }
        }
        return false;
    }

    public boolean checkSalePrice(){
        itemsInBagButtonCheckout.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.Product_productDesc__xMerp")));
        return driver.findElements(By.cssSelector("span.PriceSale_priceSale__QbrNY")).size()>=1;
    }

    public HashMap<String,String> getOrderMap(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.Pricing_priceItem__P62SZ span.shrink")));
        HashMap<String,String> cartPrices=new HashMap<>();
        List<WebElement> prices=driver.findElements(By.cssSelector("div.Pricing_priceItem__P62SZ span.cell:nth-of-type(1)"));
        for (int i=0;i<prices.size();i++){
            if(prices.get(i).getText().contains("Shipping")){
            if (!checkSalePrice()){
                cartPrices.put(prices.get(i).getText().replace(prices.get(i).findElement(By.cssSelector("span.Pricing_shipping__Qybox")).getText(),""),
                        driver.findElements(By.cssSelector("div.Pricing_priceItem__P62SZ span.cell:nth-of-type(2)")).get(i).getText());
                continue;
            }}
            Log.info("i= "+i);
            cartPrices.put(prices.get(i).getText(),driver.findElements(By.cssSelector("div.Pricing_priceItem__P62SZ span.cell:nth-of-type(2)")).get(i).getText());
        }
        Log.info("Order Prices: "+cartPrices);
        return cartPrices;
    }
    public boolean validatePromoCodeDiscount() throws IOException {
        ArrayList<String> promoCode=DataDriven.getTestData("PromoCode","Promocode");
        ArrayList<String> discount= DataDriven.getTestData("PromoCode","Discount");
        int randomCode=random.nextInt();
        if(randomCode==0){
            randomCode=1;
        }
        wait.until(ExpectedConditions.visibilityOf(promoCodeArrow));
        promoCodeArrow.click();
        wait.until(ExpectedConditions.visibilityOf(promoCodeBox));
        promoCodeBox.sendKeys(promoCode.get(randomCode));
        By amount=By.cssSelector("span:nth-of-type(2)");
        float percentageDiscount=Float.parseFloat(subTotal.getText().replace("$",""))*Float.parseFloat(discount.get(randomCode));
        Log.info("Amount after discount: "+percentageDiscount);
        wait.until(ExpectedConditions.visibilityOfElementLocated(savingsContainer));
        float savingsAmount=Float.parseFloat(driver.findElement(savingsContainer).findElement(amount).getText().replace("$",""));
        Log.info("Amount on subtotal: "+savingsAmount);
        return savingsAmount==percentageDiscount&&savingsAmount<0.0&&driver.findElement(savingsContainer).findElement(By.cssSelector("span:nth-of-type(2)")).getText().equals("Savings");
    }
    public boolean validateTotal(){
        final DecimalFormat df = new DecimalFormat("0.00");
        wait.until(ExpectedConditions.visibilityOf(continueToCardDetails));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("h3.Pricing_total__Pgjlw span.cell:nth-of-type(2)"))));
        WebElement totalAmount=driver.findElement(By.cssSelector("h3.Pricing_total__Pgjlw span.cell:nth-of-type(2)"));
        float sum=0;
        HashMap<String,String> price=getOrderMap();
        for(Map.Entry<String,String> entry:price.entrySet()){
            if(entry.getValue().equalsIgnoreCase("FREE")){
                sum+=0.0;
                continue;
            }
            sum+=(Float.parseFloat(entry.getValue().replace("$","")));
        }
        Log.info("Sum: "+sum);
        Log.info("Total amount: "+totalAmount.getText());
        return Float.parseFloat(totalAmount.getText().replace("$",""))==sum;
    }
    public ArrayList<String> returnTax(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.Pricing_priceItem__P62SZ  span.shrink:nth-of-type(1)")));
        ArrayList<String> taxes=new ArrayList<>();
        List<WebElement> prices=driver.findElements(By.cssSelector("div.Pricing_priceItem__P62SZ  span.shrink:nth-of-type(1)"));
        for (int i=0;i<prices.size();i++){
            if (prices.get(i).getText().contains("Tax")){
                Log.info("Element:"+prices.get(i).getText());
                taxes.add(driver.findElements(By.cssSelector("div.Pricing_priceItem__P62SZ  span.shrink:nth-of-type(2)")).get(i).getText());
            }
        }
        return taxes;
    }

    public void editAddressWithNewAddress() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(firstName));
        billingAddressLine1.clear();
        billingAddressLine1.sendKeys("31 ");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[title='31-12069 Westside Rd']")));
        action.moveToElement(driver.findElement(By.cssSelector("div[title='31-12069 Westside Rd']"))).click().build().perform();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(continueToDeliveryButton));
    }

    public String returnProvince(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("province"))));
        return driver.findElement(By.id("province")).getText();
    }

    public void proceedToDelivery() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(continueToDeliveryButton));
        Thread.sleep(1000);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",continueToDeliveryButton);
    }

    public void clickEditAddress(){
        wait.until(ExpectedConditions.elementToBeClickable(editAddressButton));
        editAddressButton.click();
    }

    public boolean orderConfirmationId(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.CheckoutConfirmation_content__hF9ng p")));
        String orderNumber=driver.findElement(By.cssSelector("div.CheckoutConfirmation_content__hF9ng p")).getText();
        return orderNumber.equals(orderNumber.replaceAll("[^\\d.]",""));
    }

    public boolean verifyCreatePcId(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.PCOTile_link__kHdGW")));
        driver.findElement(By.cssSelector("button.PCOTile_link__kHdGW")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        return driver.getCurrentUrl().equals("https://accounts-lower.pcid.ca/create-account");
    }
    public boolean verifyContinueShopping(){
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.CheckoutConfirmation_content__hF9ng p")));
        driver.findElement(By.xpath("//a[text()='Continue shopping']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.HeaderMenu_menu__uBzg3")));
        return driver.findElement(By.cssSelector("ul.HeaderMenu_menu__uBzg3")).isDisplayed();
    }
    public String validateSippingPrice(){
        List<WebElement> prices = driver.findElements(priceContainer);
        return prices.get(1).findElement(By.cssSelector("span.shrink")).getText();
    }
    public int productsAvailableCountOnCheckOut(){
       int Count = Integer.parseInt(ProductCountOnCheckOut.getText().replaceAll("[^\\d.]",""));
        System.out.println(Count);
        return Count;
    }

    public boolean validatePromoCodeOnCheckout(){
        wait.until(ExpectedConditions.visibilityOf(promoCodeButton));
        promoCodeButton.click();
        wait.until(ExpectedConditions.visibilityOf(promoCodeInputBox));
        promoCodeInputBox.sendKeys("SASHA25");
        wait.until(ExpectedConditions.visibilityOf(promoCodeSuccessMessage));
        return promoCodeSuccessMessage.getText().contains("applied");
    }

    public boolean validatePromoCodeDiscountOnC(){
        wait.until(ExpectedConditions.visibilityOf(promoCodeSuccessMessage));
        wait.until(ExpectedConditions.visibilityOf(savingsAmount));
        float discountPrice=Float.parseFloat(savingsAmount.getText().replace("$",""));
        return discountPrice<0.0;
    }

    public boolean validateRemovePromoCode(){
        wait.until(ExpectedConditions.visibilityOf(promoCodeSuccessMessage));
        int pricingItemSize=driver.findElements(pricingItems).size();
        promoCodeRemoveButton.click();
        wait.until(ExpectedConditions.invisibilityOf(promoCodeSuccessMessage));
        return driver.findElements(pricingItems).size()==pricingItemSize-1;
    }

}





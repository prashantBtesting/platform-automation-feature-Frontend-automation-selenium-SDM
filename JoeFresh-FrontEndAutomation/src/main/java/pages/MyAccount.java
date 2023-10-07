package pages;

import io.cucumber.java.bs.I;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.DataDriven;
import util.Log;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MyAccount {
    WebDriver driver;
    WebDriverWait wait;
    FluentWait fluentWait;
    Actions actions;
    Random random;

    public MyAccount(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        fluentWait=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(1));
        actions=new Actions(driver);
        random=new Random();
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#headerXL a[aria-label='Joe Fresh Home']") WebElement homeButton;
    @FindBy(css = "button.MyAccountDesktop_button__dRh5V") WebElement myAccountButton;
    @FindBy(xpath = "//div[@class='MyAccountDesktop_menu__CLIkV MyAccountDesktop_visible__x1vLe']/a[text()='Shipping Addresses']")
    WebElement shippingAddress;
    By savedAddressCards= By.cssSelector("div.SavedAddress_container__Ft89N");
    @FindBy(css = "div.MyAccountDesktop_menu__CLIkV") WebElement accountDropdown;
    @FindBy(css = "h1.AccountShippingAddress_heading__Rbo62") WebElement shippingHeading;
    By addressTiles=By.cssSelector("div.SavedAddress_container__Ft89N");
    By editButtons=By.xpath("//div[@class='SavedAddress_buttonContainer__H3Yyy']/button[text()='Edit']");
    By removeButtons=By.xpath("//div[@class='SavedAddress_buttonContainer__H3Yyy']/button[text()='Remove']");
    @FindBy(xpath = "//button[text()='Add a new address']") WebElement addANewAddressButton;
    @FindBy(id = "firstName") WebElement firstName;
    @FindBy(id = "lastName") WebElement lastName;
    @FindBy(id = "addressLine1") WebElement addressLine1;
    @FindBy(id = "addressLine2") WebElement addressLine2;
    @FindBy(id = "city") WebElement city;
    @FindBy(id = "province") WebElement provinceDropdown;
    @FindBy(id = "postalCode") WebElement postalCode;
    @FindBy(xpath = "//button[text()='Save address']") WebElement saveAddressButton;
    @FindBy(xpath = "//button[text()='Cancel']") WebElement cancelButton;
    @FindBy(id = "firstName-error") WebElement firstNameError;
    @FindBy(id="lastName-error") WebElement lastNameError;
    @FindBy(id = "addressLine1-error") WebElement addressLine1Error;
    @FindBy(id = "addressLine2-error") WebElement addressLine2Error;
    @FindBy(id = "city-error") WebElement cityError;
    @FindBy(xpath = "//div[@class='NativeSelect_container__kM_xP']//following-sibling::div[@class='InlineError_message__79aHw']")
    WebElement provinceDropdownError;
    @FindBy(id = "postalCode-error") WebElement postalCodeError;
    @FindBy(css = "div.FormShippingAddress_errorShipping__N55P3") WebElement topErrorMessage;
    @FindBy(css = "div.AccountShippingAddress_error__0MAxX p") WebElement addressSavedSuccess;
    @FindBy(xpath = "//button[@class='InlineError_closeButton__6dA9L Button_primary__PgyFQ Button_icon__GDOIB']") WebElement closeSuccessButton;
    By dropdownList = By.xpath("//div[@class='pca pcalist']/div[@class='pcaitem']");
    @FindBy(css = "button.ModalRemoveAddress_removeBtnWrapper__M3oCB") WebElement removeAddressButton;
    @FindBy(xpath = "//button[text()='No, cancel']") WebElement noCancelButton;
    @FindBy(xpath = "//div[@class='MyAccountDesktop_menu__CLIkV MyAccountDesktop_visible__x1vLe']//a[text()='Payment Methods']") WebElement paymentInfoDropdown;
    @FindBy(css = "h1.AccountPaymentInfo_heading__1NE_A") WebElement paymentInfoHeading;
    By savedCardDetails=By.cssSelector("div.SavedCard_cardDetailsContainer__L_iF9");
    @FindBy(xpath = "//button[text()='Add a new card']") WebElement addANewCardButton;
    By removeCardButton=By.xpath("//div[@class='SavedCard_expiredContainer__wIJYF']/button[text()='Remove']");
    @FindBy(css = "button.AccountPaymentInfo_button__wNevv") WebElement continueToCardButton;
    @FindBy(id = "pas_ccnum") WebElement creditCardNumberInput;
    @FindBy(id = "pas_ccnum-error") WebElement cardNumberError;
    @FindBy(id = "pas_expiry") WebElement expiryDate;
    @FindBy(id = "pas_expiry") WebElement expiryDateError;
    @FindBy(id = "pas_cccvc") WebElement cvccode;
    @FindBy(id = "pas_cccvc-error") WebElement cvcError;
    @FindBy(id = "pas_ccname") WebElement cardHolderName;
    @FindBy(css = "button[value='Pay Now']") WebElement saveCardButton;
    @FindBy(css = "div.AccountPaymentInfo_alert__NfK4M") WebElement cardAddedSuccessMessage;
    @FindBy(css = "h1.ModalRemoveCard_heading__nw1Pc") WebElement modalHeading;
    @FindBy(css = "button.ModalRemoveCard_removeBtnWrapper__nqhK_") WebElement yesRemoveCardButton;
    @FindBy(css = "button.ModalRemoveCard_button__XykXI") WebElement noCancelCardButton;
    @FindBy(xpath = "//div[@class='OrderDetails_orderDetails__EDesr']") WebElement orderDetailHeading;
    By orderPageProductLink=By.cssSelector("div.Product_productImageWrapper__5DwrQ a");
    By orderListContainer=By.cssSelector("div.OrderList_container__KbHaG");
    @FindBy(xpath = "//div[@class='OrderInfo_container__pLrfv']//a[text()='Return and Exchange Policy']") WebElement returnAndExchangesDetailsPage;
    @FindBy(xpath ="//div[@class='OrderInfo_container__pLrfv']//a[text()='FAQ page']") WebElement faqDetailsPage;
    @FindBy(css = "div.MyAccountDesktop_menu__CLIkV a[href='/ca/my-account/account-settings']") WebElement accountsSettings;
    @FindBy(css = "h1.AccountSettings_heading__PqX35") WebElement accountSettingsHeading;
    @FindBy(css = "a.AccountSettings_manageProfileLink__8Vax_") WebElement manageYourPcAccount;
    @FindBy(css = "button.PCORedemption_button__v5h_F") WebElement pcOptimumDropdown;
    By pcOptimumDropdownList=By.cssSelector("li.PCORedemption_menuItem__OrGra");
   // @FindBy(xpath = "//h1[text()='Shipping Address']") WebElement shippingHeading;
    @FindBy(xpath = "//div[@class='StepperContainer_stepper__NUCZW']//p[text()='No saved addresses']") WebElement noSavedAddress;
    @FindBy(css = "h1.AccountPaymentInfo_heading__1NE_A") WebElement paymentHeading;
    @FindBy(xpath = "//div[@class='StepperContainer_stepper__NUCZW']//p") WebElement noSavedCards;
    @FindBy(xpath = "//button[text()='Continue to card details']") WebElement continueToCardDetails;
    @FindBy(xpath = "//button[text()='Sign Out']") WebElement signOutButton;
    @FindBy(xpath = "//div[@class='Header_topMenuContainerDesktop__FtC7r']//button[text()='Sign in']") WebElement signInButton;
    @FindBy(xpath = "//button[text()='Cancel order']") WebElement cancelOrder;
    @FindBy(xpath = "//button[@class='ModalCancelOrder_removeBtnWrapper__mbFAu Button_primary__PgyFQ'][text()='Yes, cancel order']") WebElement yesCancelOrder;



    public void navigateToMyAccount(){
        wait.until(ExpectedConditions.elementToBeClickable(homeButton));
        homeButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(myAccountButton));
        myAccountButton.click();
        wait.until(ExpectedConditions.visibilityOf(accountDropdown));
    }
    public void navigateToShipping(){
        navigateToMyAccount();
        wait.until(ExpectedConditions.visibilityOf(shippingAddress));
        actions.moveToElement(shippingAddress);
        shippingAddress.click();
        wait.until(ExpectedConditions.visibilityOf(shippingHeading));
    }
    public void signOut(){
        navigateToMyAccount();
        actions.moveToElement(signOutButton);
        signOutButton.click();
        wait.until(ExpectedConditions.visibilityOf(signInButton));
    }
    public boolean validateAllAddressVisibleWithEditAndRemove(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addressTiles));
        for (int i=0;i<driver.findElements(addressTiles).size();i++){
            if(driver.findElements(editButtons).get(i).getAttribute("aria-labelledby").contains(driver.findElements(addressTiles).get(i).getAttribute("id"))
            &&driver.findElements(removeButtons).get(i).getAttribute("aria-labelledby").contains(driver.findElements(addressTiles).get(i).getAttribute("id"))){
                return true;
            }
        }
        return false;
    }

    public boolean validateAddNewAddressAccountsPage(){
        wait.until(ExpectedConditions.elementToBeClickable(addANewAddressButton));
       addANewAddressButton.click();
        wait.until(ExpectedConditions.visibilityOf(saveAddressButton));
        return saveAddressButton.isDisplayed()&&cancelButton.isDisplayed()&&firstName.isDisplayed();
    }

    public boolean validateAddressAddedFromAddressComplete() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys("Test");
        lastName.sendKeys("Account");
        wait.until(ExpectedConditions.visibilityOf(addressLine1));
        addressLine1.sendKeys("81 ");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dropdownList));
        int dropdownOption=random.nextInt(driver.findElements(dropdownList).size());
        actions.moveToElement(driver.findElements(dropdownList).get(dropdownOption)).click().build().perform();
        Thread.sleep(3000);
        Log.info("Address Line 1 "+addressLine1.getAttribute("value"));
        Log.info("City :"+city.getAttribute("value"));
        Log.info("Postal: "+postalCode.getAttribute("value"));
        return postalCode.getAttribute("value").length()>=6;
    }

    public void validateAddressNotFromAddressComplete() throws IOException, InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(addressLine1));
        firstName.sendKeys("Test");
        lastName.sendKeys("Account");
        addressLine1.sendKeys(DataDriven.getTestData("Account","Address Not Listed").get(1));
        addressLine2.sendKeys("Sector Test1 "+ random.nextInt(100));
        city.sendKeys("Victoria");
        Select provinceList=new Select(provinceDropdown);
        provinceList.selectByValue("BC");
        postalCode.sendKeys("V8P1A1");
        Thread.sleep(2000);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",saveAddressButton);
        }
    public void addNewAddress() throws IOException, InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(addANewAddressButton));
        addANewAddressButton.click();
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys("Test");
        lastName.sendKeys("Account");
        addressLine1.sendKeys(random.nextInt(100)+" ");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dropdownList));
        int dropdownOption=random.nextInt(driver.findElements(dropdownList).size());
        String address=driver.findElements(dropdownList).get(dropdownOption).getText();
        Log.info("Address: "+address);
        actions.moveToElement(driver.findElements(dropdownList).get(dropdownOption)).click().build().perform();
        Thread.sleep(1000);
        try {
            saveAddressButton.click();
            wait.until(ExpectedConditions.visibilityOf(addressSavedSuccess));
        }
        catch (TimeoutException se){
            saveAddressButton.click();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    }
    public boolean validateAddressSaved(){
        wait.until(ExpectedConditions.visibilityOf(addressSavedSuccess));
        return addressSavedSuccess.isDisplayed()&&addressSavedSuccess.getText().equals("New shipping address saved successfully.");
    }
    public boolean validateCloseButtonNotification(){
        wait.until(ExpectedConditions.visibilityOf(addressSavedSuccess));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",closeSuccessButton);
        return driver.findElements(By.cssSelector("div.AccountShippingAddress_error__0MAxX p")).size()<1;
    }

    public void fillInvalidShippingDetails(){
        firstName.sendKeys("######");
        lastName.sendKeys("$%%^");
        addressLine1.sendKeys("$$%$^^%%");
        addressLine2.sendKeys("%%^&*");
        postalCode.sendKeys("$&%^&&(");
        saveAddressButton.click();
    }
    public boolean validateErrorMessages(){
        return
                //firstNameError.isDisplayed()&&lastNameError.isDisplayed()
                addressLine1.isDisplayed()&&addressLine2Error.isDisplayed()
                &&postalCodeError.isDisplayed()&&topErrorMessage.isDisplayed();
    }

    public boolean editAddressForm(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(editButtons));
         List<WebElement> editButtonsList=driver.findElements(editButtons);
         int element=random.nextInt(editButtonsList.size());
         driver.findElements(editButtons).get(element).click();
         wait.until(ExpectedConditions.visibilityOf(firstName));
         return firstName.isDisplayed()&&saveAddressButton.isDisplayed()&&cancelButton.isDisplayed();
    }

    public boolean editAndAddNewAddress() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(cancelButton));
        cancelButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(editButtons));
        List<WebElement> editButtonsList=driver.findElements(editButtons);
        int element=random.nextInt(editButtonsList.size());
        String id=editButtonsList.get(element).getAttribute("id");
        String address=driver.findElement(By.id(id.replace("editButton","addressContainer"))).getText();
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElements(editButtons).get(element));
        wait.until(ExpectedConditions.visibilityOf(firstName));
        addressLine1.clear();
        firstName.clear();
        firstName.sendKeys("Test");
        lastName.clear();
        lastName.sendKeys("Account");
        addressLine1.sendKeys("17 ");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dropdownList));
        int dropdownOption=random.nextInt(driver.findElements(dropdownList).size());
        String newAddress=driver.findElements(dropdownList).get(dropdownOption).getText();
        actions.moveToElement(driver.findElements(dropdownList).get(dropdownOption)).click().perform();
        Thread.sleep(3000);
        saveAddressButton.click();
        wait.until(ExpectedConditions.visibilityOf(addressSavedSuccess));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.address_summary__4ys5O")));
        return driver.findElement(By.cssSelector("div.AccountShippingAddress_error__0MAxX p")).isDisplayed();
       // return driver.findElements(By.cssSelector("div.address_summary__4ys5O")).get(element).getText().contains(address)&&(!address.contains(newAddress));
    }

    public boolean removeAccountModal(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(removeButtons));
        List<WebElement> removeAddress=driver.findElements(removeButtons);
        int element=random.nextInt(removeAddress.size());
        String id=removeAddress.get(element).getAttribute("id");
        String address=driver.findElement(By.id(id.replace("removeButton","addressContainer"))).getText();
        removeAddress.get(element).click();
        wait.until(ExpectedConditions.visibilityOf(removeAddressButton));
        return removeAddressButton.isDisplayed();
    }

    public boolean validateAddressRemoveCancel(){
        List<WebElement> removeAddress=driver.findElements(removeButtons);
        int element=random.nextInt(removeAddress.size());
        String id=removeAddress.get(element).getAttribute("id");
        String address=driver.findElement(By.id(id.replace("removeButton","addressContainer"))).getText();
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",removeAddress.get(element));
        wait.until(ExpectedConditions.visibilityOf(removeAddressButton));
        noCancelButton.click();
        return driver.findElement(By.id(id.replace("removeButton","addressContainer"))).isDisplayed();
    }

    public boolean validateAddressRemoved(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(removeButtons));
        List<WebElement> removeAddress=driver.findElements(removeButtons);
        //int element=random.nextInt(removeAddress.size());
        String id=removeAddress.get(0).getAttribute("id");
        String address=driver.findElement(By.id(id.replace("removeButton","addressContainer"))).getText();
        removeAddress.get(0).click();
        wait.until(ExpectedConditions.visibilityOf(removeAddressButton));
        removeAddressButton.click();
        wait.until(ExpectedConditions.visibilityOf(addressSavedSuccess));
        return addressSavedSuccess.isDisplayed()&&addressSavedSuccess.getText().equals("Shipping address removed successfully.")
                &&driver.findElements(By.id(id.replace("removeButton","addressContainer"))).size()<1;
    }

    public void navigateToPaymentInfo(){
        navigateToMyAccount();
        wait.until(ExpectedConditions.visibilityOf(paymentInfoDropdown));
        paymentInfoDropdown.click();
        wait.until(ExpectedConditions.visibilityOf(paymentInfoHeading));
    }

    public boolean validateSavedCards(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(savedCardDetails));
        return driver.findElements(savedCardDetails).size()>=1&&driver.findElements(removeCardButton).size()>=1&&addANewCardButton.isDisplayed();
    }

    public void clickAddANewCard(){
        wait.until(ExpectedConditions.visibilityOf(addANewCardButton));
        addANewCardButton.click();
    }
    public boolean validateBillingAddressDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(addressLine1));
        return addressLine1.isDisplayed();
    }

    public void fillBillingDetails() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(addressLine1));
        addressLine1.sendKeys("17 ");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dropdownList));
        int dropdownOption=random.nextInt(driver.findElements(dropdownList).size());
        String address=driver.findElements(dropdownList).get(dropdownOption).getText();
        actions.moveToElement(driver.findElements(dropdownList).get(dropdownOption)).click().build().perform();
        Thread.sleep(2000);
        continueToCardDetails.click();
    }

    public boolean validateCreditCardDetails() throws InterruptedException {
        Thread.sleep(8000);
        driver.switchTo().frame("globalPaymentFrame");
        Thread.sleep(3000);
        return creditCardNumberInput.isDisplayed();
    }

    public void fillInvalidCardDetails() throws InterruptedException {
        Thread.sleep(11000);
        driver.switchTo().frame("globalPaymentFrame");
        creditCardNumberInput.sendKeys("111111111111");
        expiryDate.sendKeys("0822");
        cvccode.sendKeys("40");
        cardHolderName.sendKeys("Test");
    }

    public boolean validateCardErrorMessages(){
        //driver.switchTo().frame("globalPaymentFrame");
        wait.until(ExpectedConditions.visibilityOf(cardNumberError));
        return cardNumberError.isDisplayed()&&expiryDateError.isDisplayed()&& cvcError.isDisplayed();
    }

    public void fillValidDetails() throws IOException, InterruptedException {
        Thread.sleep(10000);
        driver.switchTo().frame("globalPaymentFrame");
        wait.until(ExpectedConditions.visibilityOf(creditCardNumberInput));
       ArrayList<String> cardData=DataDriven.getTestData("Checkout","Card Details");
       creditCardNumberInput.sendKeys(cardData.get(1));
       expiryDate.sendKeys("12");
       expiryDate.sendKeys("2");
       expiryDate.sendKeys("9");
       cvccode.sendKeys("400");
       cardHolderName.sendKeys("Test Account");
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",saveCardButton);
    }
    public boolean validateCardSaved(){
        wait.until(ExpectedConditions.visibilityOf(cardAddedSuccessMessage));
        return cardAddedSuccessMessage.isDisplayed()&&cardAddedSuccessMessage.getText().equals("New card saved successfully.");
    }

    public boolean removeCardModal(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(removeCardButton));
        int randomCard=random.nextInt(driver.findElements(removeCardButton).size());
        driver.findElements(removeCardButton).get(randomCard).click();
        return modalHeading.isDisplayed()&& yesRemoveCardButton.isDisplayed()&&noCancelCardButton.isDisplayed();
    }

    public boolean validateCardRemove() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(removeCardButton));
       // int randomCard=random.nextInt(driver.findElements(removeCardButton).size());
        String id=driver.findElements(By.xpath("//div[@class='SavedCard_expiredContainer__wIJYF']")).get(0).getAttribute("id");
        Log.info("ID: "+id);
        String addressId=id.replace("removeCard","cardDetailsContainer");
        String removedAddressId=driver.findElement(By.id(addressId)).getAttribute("id");
        driver.findElements(removeCardButton).get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(yesRemoveCardButton));
        yesRemoveCardButton.click();
        wait.until(ExpectedConditions.visibilityOf(cardAddedSuccessMessage));
        return cardAddedSuccessMessage.isDisplayed()&&cardAddedSuccessMessage.getText().equals("Card removed successfully.")&&driver.findElements(By.id(removedAddressId)).size()<1;
    }

    public void navigateToOrderHistory(){
        wait.until(ExpectedConditions.elementToBeClickable(homeButton));
        homeButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(myAccountButton));
        myAccountButton.click();
        wait.until(ExpectedConditions.visibilityOf(accountDropdown));
        driver.findElement(By.xpath("//a[text()='My Orders']")).click();
    }

    public boolean navigateToOrderDetails(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(orderListContainer));
        int randomOrder= random.nextInt(driver.findElements(orderListContainer).size());
        WebElement order=driver.findElements(orderListContainer).get(randomOrder);
        Log.info("Order Details: "+order.getText());
        order.findElement(By.xpath("//descendant::a[@class='OrderList_link__8ka5f']")).click();
        wait.until(ExpectedConditions.visibilityOf(orderDetailHeading));
        return orderDetailHeading.isDisplayed();
    }

    public boolean navigateToPdpFromOrderDetails(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(orderPageProductLink));
        String imUrl=driver.findElements(orderPageProductLink)
                .get(random.nextInt(driver.findElements(orderPageProductLink).size()))
                .findElement(By.cssSelector(" img")).getAttribute("alt");
        driver.findElements(orderPageProductLink)
                .get(random.nextInt(driver.findElements(orderPageProductLink).size())).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[data-testid='zoomImg0']")));
        return driver.findElement(By.cssSelector("img[data-testid='zoomImg0']")).isDisplayed();
    }

    public boolean validateReturnsPage(){
        wait.until(ExpectedConditions.elementToBeClickable(returnAndExchangesDetailsPage));
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@class='OrderInfo_container__pLrfv']//h3[1]")), "Returns & Exchanges"));
        actions.moveToElement(returnAndExchangesDetailsPage).click().build().perform();
        wait.until(ExpectedConditions.urlContains("returns"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        return driver.findElement(By.xpath("//h1")).getText().contains("Return");
    }

    public boolean validateFaqPage(){
        wait.until(ExpectedConditions.visibilityOf(orderDetailHeading));
        faqDetailsPage.click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//h1")), "Frequently Asked Questions"));
        return driver.findElement(By.xpath("//h1")).getText().contains("Frequently Asked Questions");
    }

    public void navigateToAccountsSettings(){
        navigateToMyAccount();
        wait.until(ExpectedConditions.visibilityOf(accountsSettings));
        accountsSettings.click();
        wait.until(ExpectedConditions.visibilityOf(accountSettingsHeading));
    }

    public boolean validateManagePcAccount(){
        wait.until(ExpectedConditions.elementToBeClickable(manageYourPcAccount));
        manageYourPcAccount.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        wait.until(ExpectedConditions.urlContains("https://accounts.pcid.ca/login"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        return driver.findElement(By.id("email")).isDisplayed();
    }

    public boolean noShippingAddress(){
        wait.until(ExpectedConditions.visibilityOf(shippingHeading));
        wait.until(ExpectedConditions.visibilityOf(noSavedAddress));
        return shippingHeading.isDisplayed()&&addANewAddressButton.isDisplayed()&&noSavedAddress.getText().contains("No saved addresses");
    }
        public boolean noSavedCards(){
        wait.until(ExpectedConditions.visibilityOf(paymentHeading));
        wait.until(ExpectedConditions.visibilityOf(noSavedCards));
        return paymentHeading.isDisplayed()&&addANewCardButton.isDisplayed()&&noSavedCards.getText().contains("No saved cards");
    }
    public boolean savedShippingAddressOnMyAccount(String address){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addressTiles));
        return address.contains(driver.findElements(addressTiles).get(0).getText());
    }

    public void cancelOrder(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(orderListContainer));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(orderListContainer));
        WebElement order=driver.findElements(orderListContainer).get(0);
        Log.info("Order Details: "+order.getText());
        order.findElement(By.xpath("//descendant::a[@class='OrderList_link__8ka5f']")).click();
        wait.until(ExpectedConditions.visibilityOf(orderDetailHeading));
        wait.until(ExpectedConditions.visibilityOf(cancelOrder));
        cancelOrder.click();
        wait.until(ExpectedConditions.visibilityOf(yesCancelOrder));
        yesCancelOrder.click();
    }
}


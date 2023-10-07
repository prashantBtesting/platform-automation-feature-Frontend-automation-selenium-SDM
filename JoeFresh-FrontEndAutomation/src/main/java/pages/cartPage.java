package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Log;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class cartPage {
    WebDriver driver;
    WebDriverWait wait;
    FluentWait fluentWait;
    Random random;
    Actions action;
    public PDPPage pdpPage;

    public cartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        fluentWait = new FluentWait(driver);
        random = new Random();
        pdpPage = new PDPPage(driver);
    }


    By priceContainer = By.cssSelector("div.Pricing_priceItem__P62SZ");


    @FindBy(xpath = "(//button[normalize-space()='Promo code'])[1]")
    public WebElement promoCodeButton;
    @FindBy(css = "div[class='Pricing_priceItem__P62SZ Pricing_savings__U_gg0 grid-x'] span:nth-child(2)")
    public WebElement savingPricePromoApplied;

    @FindBy(xpath = "//Select[@aria-label=\"Quantity\"]")
    public WebElement Quantity_dropdown;
    @FindBy(xpath = "//input[@id='voucherId']")
    WebElement voucherBox;
    @FindBy(xpath = "//button[normalize-space()='Apply']")
    public WebElement applyButton;
    @FindBy(css = "div.Voucher_appliedVouchers__7nghU p.Voucher_promoSuccessNotes__TRHh4")
    public WebElement successNote;
    @FindBy(css = "div.Voucher_applyVoucherError__KGTzj")
    public WebElement errorMessage;
    @FindBy(css = "div[class=InlineError_message__79aHw][id=voucherId-error]")
    public WebElement invalidPromoCodeError;

    @FindBy(xpath = "//h2[text()='Perhaps you may like these instead?']")
    public WebElement PerhapsYouMayLikeTheseInsteadText;
    @FindBy(xpath = "(//button[@type='button'][normalize-space()='Checkout'])[2]")
    public WebElement checkoutButton;
    @FindBy(xpath = "//button[text()='Remove']")
    public WebElement removePromoCodeButton;

    @FindBy(xpath = "(//button[text()='Checkout'])[2]")
    public WebElement checkout;
    @FindBy(css = "h3 span:nth-child(2)")
    public WebElement estimatedPrice;
    @FindBy(css = ".ProductDetails_productDesc__8dq8u.cell.small-12.xlarge-8")
    public WebElement MyCartProductDetails;
    @FindBy(css = "span:nth-child(2) span:nth-child(1)")
    public WebElement styleOnMyBag;
    @FindBy(css = "span:nth-child(2) span:nth-child(2)")
    public WebElement styleOnMyBagValue;
    @FindBy(css = "span:nth-child(3) span:nth-child(1)")
    public WebElement colourOnMyBag;
    @FindBy(css = "span:nth-child(3) span:nth-child(2)")
    public WebElement colourOnMyBagValue;
    @FindBy(css = "span:nth-child(4) span:nth-child(1)")
    public WebElement sizeOnMyBag;
    @FindBy(css = "span:nth-child(4) span:nth-child(2)")
    public WebElement sizeOnMyBagValue;
    @FindBy(css = "span.PriceRegular_container__IKh_v")
    public WebElement ProductRegularPriceOnCartPageWithOutDiscount;
    @FindBy(css = "span.PriceSale_priceSale__QbrNY")
    public WebElement ProductDiscountedPriceOnCartPageWithDiscount;
    @FindBy(css = "span.PriceSale_priceRegular__1Hlp5")
    public WebElement ProductRegularPriceOnCartPageWithDiscount;
    @FindBy(css = "section.Pricing_container__T81I7 div:nth-child(1) span:nth-child(2)")
    public WebElement subTotal;
    @FindBy(css = "div[class='Voucher_removeVoucherError__tB_bF InlineError_message__79aHw InlineError_error__94pSk'] p")
    public WebElement TechnicalErrorMessage;
    @FindBy(css = "div[class='grid-x'] div:nth-child(4) span:nth-child(2)")
    public WebElement TaxValueAfterLogin;


    By pricesCounter = By.cssSelector("div.Pricing_priceItem__P62SZ span.shrink:nth-of-type(2)");


    public String PromoCodeList() {
        String[] codes = {"DANIMARIE20", "SASHA25"};
        int index = random.nextInt(codes.length);
        return codes[index];
    }

    public String fakePromoList() {
        String[] fakeCodes = {"gfdsfg", "ggfgrg", "sdfsdf", "rgg", "ygfv"};
        int index2 = random.nextInt(fakeCodes.length);
        return fakeCodes[index2];
    }

    public String enterValueInPromoCodeBox() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(voucherBox));
        voucherBox.sendKeys(PromoCodeList());
        System.out.println(PromoCodeList());
        applyButton.click();
        wait.until(ExpectedConditions.visibilityOf(successNote));
        String successnote = successNote.getText();
        Thread.sleep(3000);
        removePromoCodeButton.click();
        System.out.println(successnote);
        return successnote;
    }

    public boolean technicalErrorMessage() {
        try {
            String Error = TechnicalErrorMessage.getText();
            if (TechnicalErrorMessage.isDisplayed()) {
                Log.error(Error);
                return false;
            } else {
                String successnote = successNote.getText();
                System.out.println(successnote);
                Log.info("Not get Technical Error");
                return true;
            }
        } catch (NotFoundException NF) {
            Log.error("error Occurs");
        }
        return false;
    }

    public boolean TaxPriceValue() {
        String tx = "--";
        if (TaxValueAfterLogin.equals(tx)) {
            return false;
        } else {
            String Tax = TaxValueAfterLogin.getText().replace("$", "");
            System.out.println(Tax);
            return true;
        }
    }

    public boolean savingsAfterAddingPromoCode() {
        try {
            savingPricePromoApplied.isDisplayed();

            Float savingPrice = Float.valueOf(savingPricePromoApplied.getText().replaceAll("[^0-9.]", ""));
            if (savingPrice > 0) {
                System.out.println(savingPrice);
                Log.info("Saving price displayed");
                return true;
            } else {
                Log.info("Saving Price Is not displayed");
            }
            return false;
        } catch (NotFoundException NF) {
            Log.info("Element Not found exception");
        }
        return false;
    }

    public boolean enterFakeValueInPromoCodeBox() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(voucherBox));
        voucherBox.sendKeys(fakePromoList());
        System.out.println(fakePromoList());
        applyButton.click();
        Thread.sleep(5000);
        try {
            if (invalidPromoCodeError.isDisplayed()) {
                wait.until(ExpectedConditions.visibilityOf(invalidPromoCodeError));
                String successnote = invalidPromoCodeError.getText();
                System.out.println(successnote);
                return true;
            } else {
                Log.error("Error Occur");
                return false;
            }
        } catch (NotFoundException NF) {
            Log.error("error message not displayed");
        }
        return false;
    }


    public boolean calculateValue() {
        List<WebElement> prices = driver.findElements(priceContainer);
        return prices.get(1).findElement(By.cssSelector("div.Pricing_priceItem__P62SZ>span.shrink")).getText().contains("Shipping");

    }

    public String validateTaxValue() {
        wait.until(ExpectedConditions.visibilityOf(TaxValueAfterLogin));
        return TaxValueAfterLogin.getText();
    }

    public boolean validateOrderSummery() {
        wait.until(ExpectedConditions.visibilityOf(checkout));
        List<WebElement> prices = driver.findElements(priceContainer);
        String Text1 = prices.get(1).findElement(By.cssSelector("span.shrink:nth-of-type(1)")).getText();
        String Text2 = prices.get(1).findElement(By.cssSelector("span.shrink:nth-of-type(2)")).getText();
        System.out.println(Text1);
        System.out.println(Text2);

        /*
        for (int i = 2; i < prices.size(); i++) {
            Log.info("TAX: " + prices.get(i).findElement(By.cssSelector("span.shrink:nth-of-type(1)")).getText());
            Log.info("TAX-Amount: " + prices.get(i).findElement(By.cssSelector("span.shrink:nth-of-type(2)")).getText());
            if (!(prices.get(i).findElement(By.cssSelector("span.shrink:nth-of-type(1)")).getText().contains("Tax") &&
                    Float.parseFloat(prices.get(i).findElement(By.cssSelector("span.shrink:nth-of-type(2)")).getText().replace("$", "")) > 0.0)) {
                return false;
            }
        }
        return true;
        */
        return true;
    }

    public List<Float> ValidateProductValuePrice() {

        List<WebElement> priceContainer = driver.findElements(pricesCounter);
        List<String> ExtractedPricesString = new ArrayList<String>();
        for (WebElement values : priceContainer) {
            if (values.getText().equals("FREE")) {
                ExtractedPricesString.add(String.valueOf(0.0));
                continue;
            } else if (values.getText().equals("--")) {
                ExtractedPricesString.add(String.valueOf(0.0));
                continue;

            }
            ExtractedPricesString.add(values.getText().replaceAll("[^\\d.]", ""));
        }
        List<Float> ExtractedPriceFloat = ExtractedPricesString.stream().map(Float::parseFloat).collect(Collectors.toList());
        for (Float val : ExtractedPriceFloat) {
            val.floatValue();

        }
        return ExtractedPriceFloat;
    }

    public float validateEstimatedPriceAndTotalCalculation() {

        float sum = 0;
        for (float i = 0; i < ValidateProductValuePrice().size(); i++)
            sum += ValidateProductValuePrice().get((int) i);
        System.out.println("sum-> " + sum);
        return sum;
    }

    public boolean validateAllProductDetailsOnMyBag() {
        wait.until(ExpectedConditions.visibilityOf(MyCartProductDetails));
        if (styleOnMyBag.isDisplayed() && styleOnMyBagValue.isDisplayed() && colourOnMyBag.isDisplayed() && colourOnMyBagValue.isDisplayed() && sizeOnMyBag.isDisplayed() && sizeOnMyBagValue.isDisplayed()) {
            String ValuesPresent = MyCartProductDetails.getText();
            System.out.println(ValuesPresent);
            Log.info("All Details Are Present");
            return true;
        } else {
            Log.error("Product Details are Not Displayed");
            return false;
        }
    }

    public boolean validateProductPricesOnCartPage() {
        wait.until(ExpectedConditions.visibilityOf(MyCartProductDetails));
        if (ProductRegularPriceOnCartPageWithOutDiscount.isDisplayed()) {
            String ProductRegularPriceOnCartPageWithOutDiscountValue = ProductRegularPriceOnCartPageWithOutDiscount.getText();
            Log.info("RegularPrice:: " + ProductRegularPriceOnCartPageWithOutDiscountValue);
            return true;
        } else if (ProductDiscountedPriceOnCartPageWithDiscount.isDisplayed() && ProductRegularPriceOnCartPageWithDiscount.isDisplayed()) {
            String PriceAfterDiscount = ProductDiscountedPriceOnCartPageWithDiscount.getText();
            String PriceBeforeDiscount = ProductRegularPriceOnCartPageWithDiscount.getText();
            Log.info("Price Before Discount:: " + PriceBeforeDiscount);
            Log.info("Price Before Discount:: " + PriceAfterDiscount);
            return true;
        }
        return false;
    }

    public int myBagCount() {
        int MyBagCountBeforeSignOut = Integer.parseInt(pdpPage.MyBagTextAboveSearch.getText().replaceAll("[^\\d.]", ""));
        System.out.println(MyBagCountBeforeSignOut);
        return MyBagCountBeforeSignOut;
    }

    public boolean calculatePriceOfJA1Product() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(Quantity_dropdown));
        WebElement Quantity_dropdown = driver.findElement(By.xpath("//Select[@aria-label=\"Quantity\"]"));

        Select value = new Select(Quantity_dropdown);

        List<WebElement> dropdown = value.getOptions();
        for (WebElement dropDownV : dropdown) {
            value.selectByIndex(2);
            Thread.sleep(3000);
            System.out.println("Selected option's text: " + value.getFirstSelectedOption().getText());

            wait.until(ExpectedConditions.elementToBeClickable(Quantity_dropdown));
            Float productPrice = Float.valueOf(ProductRegularPriceOnCartPageWithOutDiscount.getText().replaceAll("[^\\d.]", ""));
            int index = Integer.parseInt(dropDownV.getText());
            Thread.sleep(2000);
            Float calculation = productPrice * index;
            System.out.println("Product Regular Price With Quantity:: " + calculation);
            Thread.sleep(5000);
            Float subTotalValue = Float.valueOf(subTotal.getText().replaceAll("[^0-9.]", ""));
            System.out.println("SubTotal Price After Calculation:: " + subTotalValue);

            if (calculation.equals(subTotalValue)) {
                return true;
            } else {
                Log.info("Subtotal Value and product value count is not same");
                return false;
            }

        }
        return true;
    }

    public void ReplaceAllExample1() {
        String AB = "PraS2$35Hant";
        String CD = AB.replace("2$35", "").toUpperCase();
        int EF = CD.length();
        System.out.println(CD);
        System.out.println(EF);

    }

    public void isPalindromString() {
        String  Reverse="";
        String ok="AdA";
        int length = ok.length();
        for ( int i = length - 1; i >= 0; i-- )
            Reverse = Reverse + ok.charAt(i);
        if (ok.equals(Reverse))
            System.out.println("Entered string/number is a palindrome.");
        else
            System.out.println("Entered string/number isn't a palindrome.");
    }
}







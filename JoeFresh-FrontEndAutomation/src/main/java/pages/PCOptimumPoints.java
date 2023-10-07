package pages;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.DataDriven;
import util.Log;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

public class PCOptimumPoints {
    WebDriver driver;
    WebDriverWait wait;
    Random random;

    public PCOptimumPoints(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        random=new Random();
    }

    @FindBy(css = "div.Pricing_priceItem__P62SZ:nth-of-type(1) span.cell:nth-of-type(2)")
    WebElement subTotal;
    By styleCode = By.xpath("//div[@class='ProductDetails_productDesc__8dq8u cell small-12 xlarge-8']//span[text()='Style']/following-sibling::span");
    By cartItem=By.cssSelector("div.ProductDetails_productDesc__8dq8u");
    @FindBy(css = "span.PCOCard_red___DKi_")
    WebElement pcoPoints;
    By productAmount = By.cssSelector("div.ProductDetails_price__yHkc0 span.PriceSale_priceSale__QbrNY");
    By productLinks=By.cssSelector("div.Product_productImageWrapper__yyPu9 a");
    By productTiles = By.cssSelector("div.Product_container__54y22");
    By quantity=By.cssSelector("select[aria-label='Quantity']");
    By productQuantity=By.cssSelector("div.Product_quantity__OvRgC");

    public int ot1() throws IOException {
        int sum = 0;
        for (int i=0;i<driver.findElements(productLinks).size();i++) {
            String productLink = driver.findElements(productLinks).get(i).getAttribute("href");
            Log.info(productLink);
            String[] slicing=productLink.replace("https://jf-frontshop-service-platform-sit2.loblaw.digital/ca/Categories/","").replace("/"," ").split(" ");
            Log.info("Sliced: "+slicing[3]);
            ArrayList<String> promotionCodes = DataDriven.getTestData("PCO", "OT1");
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTiles));
            Log.info(slicing[slicing.length-1]);
            if (promotionCodes.contains(slicing[slicing.length-1])) {
                sum += 3000 * returnQty(driver.findElements(productQuantity).get(i));
            } else sum += 0;
            if (Float.parseFloat(subTotal.getText().replaceAll("[^\\d.]",""))>=50.0){
                sum+=10000;
            }
        }
        Log.info("Sum OT1: " + sum);
        return sum;
    }

    public int returnQty(WebElement product) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItem));
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(quantity));
        Select qtyDropdwon = new Select(product.findElement(quantity));
        WebElement option = qtyDropdwon.getFirstSelectedOption();
        Log.info("Selected option" + option.getText());
        return Integer.parseInt(option.getText());
    }

    public int ot6() {
        if (Float.parseFloat(subTotal.getText()) > 50.00) {
            return 10000;
        } else {
            return 0;
        }
    }

    public int ot4a() throws IOException {
        int sum=0;
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTiles));

        ArrayList<Float> cartAmount = new ArrayList<>();
        for (int i = 0; i < driver.findElements(productTiles).size(); i++) {

            try {
                cartAmount.add(Float.parseFloat(driver.findElements(By.cssSelector("span.PriceSale_priceSale__QbrNY")).get(i).getText().replaceAll("[^\\d.]", "")));
            } catch (NoSuchElementException ex) {
                cartAmount.add(Float.parseFloat(driver.findElements(By.cssSelector("span.PriceRegular_container__IKh_v")).get(i).getText().replaceAll("[^\\d.]", "")));
            }
        }
        Log.info("Product Cart Amount :" + cartAmount);
        for (float i : cartAmount) {
            if (i >= 49.97) {
                sum=10000;
            }
        }
        if (Float.parseFloat(subTotal.getText().replaceAll("[^\\d.]",""))>=50.0){
            sum+=10000;
        }

        return 0;
    }

    public int ot4b() throws IOException {
        int totalQty = 0;
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTiles));
        ArrayList<String> styleCodeOt3 = DataDriven.getTestData("PCO", "OT3");
        ArrayList<Float> amount = new ArrayList<>();
        ArrayList<Integer> qty = new ArrayList<>();
        for (int i = 0; i < driver.findElements(productTiles).size(); i++) {
            if (styleCodeOt3.contains(driver.findElements(styleCode).get(i).getText())) {
                qty.add(returnQty(driver.findElements(productTiles).get(i)));
                try {
                    if (Float.parseFloat(driver.findElements(By.cssSelector("span.PriceSale_priceSale__QbrNY")).get(i).getText().replaceAll("[^\\d.]", "")) >= 10.00) {
                        amount.add(Float.parseFloat(driver.findElements(By.cssSelector("span.PriceSale_priceSale__QbrNY")).get(i).getText().replaceAll("[^\\d.]", "")));
                    }
                } catch (NoSuchElementException e) {
                    if (Float.parseFloat(driver.findElements(By.cssSelector("span.PriceRegular_container__IKh_v")).get(i).getText().replaceAll("[^\\d.]", "")) >= 10.00) {
                        amount.add(Float.parseFloat(driver.findElements(By.cssSelector("span.PriceRegular_container__IKh_v")).get(i).getText().replaceAll("[^\\d.]", "")));
                    }
                }
            }

        }
        for (int i = 0; i < qty.size(); i++) {
            totalQty += qty.get(i);
        }
        if (totalQty < 100) {
            return totalQty * 1000;
        }
        return 99 * totalQty;
    }

    public boolean validatePcOptimumPoints() throws IOException {
        int sum = 0;
        sum += ot1();
        sum += ot6();
        sum += ot4a();
        sum += ot4b();
        return sum == Integer.parseInt(pcoPoints.getText().replaceAll("\\d+", ""));
    }

    public boolean validateOt1() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(pcoPoints));
        Log.info(pcoPoints.getText());
        return Integer.parseInt(pcoPoints.getText().replaceAll("[^0-9]", "")) == ot1();
    }

    public boolean validateOt6() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(pcoPoints));
        return Integer.parseInt(pcoPoints.getText().replaceAll("\\d+", "")) == ot6();
    }

    public boolean validateOt4A() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(pcoPoints));
        return Integer.parseInt(pcoPoints.getText().replaceAll("\\d+", "")) == ot4a();
    }

    public boolean validateOt4B() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(pcoPoints));
        return Integer.parseInt(pcoPoints.getText().replaceAll("\\d+", "")) == ot4b();
    }

    public void addMoreQuantity(WebElement element){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(quantity));
        Select selectQuantity=new Select(element.findElement(quantity));
        int valueToBeSelected=random.nextInt(9);
        if (valueToBeSelected==0){
            valueToBeSelected=1;
        }
        Log.info("Quantity to be updated: "+valueToBeSelected);
        selectQuantity.selectByValue(String.valueOf(valueToBeSelected));
        wait.until(ExpectedConditions.textToBePresentInElement(element.findElement(quantity),String.valueOf(valueToBeSelected)));
    }

    public void addQuantityToNine(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(quantity));
        for (int i=0;i<driver.findElements(quantity).size();i++){
            
        }

    }






}

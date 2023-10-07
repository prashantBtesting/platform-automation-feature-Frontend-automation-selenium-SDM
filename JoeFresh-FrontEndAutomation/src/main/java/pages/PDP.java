package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Log;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class PDP {
    WebDriver driver;
    WebDriverWait wait;
    Random random;
    public PDP(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        random=new Random();
    }

    @FindBy (xpath = "//img[@data-testid='zoomImg0']")
    WebElement productImage;

    @FindBy (xpath = "//ol[@class='Breadcrumbs_list__K1ZN9']")
    WebElement breadCrumbs;
    @FindBy(xpath = "//button[text()='Add to bag']") WebElement addToCartButton;
    By enabledSizeSwatches= By.cssSelector("input[name='addToBagPdp'][aria-disabled='false']");
    @FindBy(css="h1.ModalAddToBag_heading___YF19") WebElement successHeading;
    @FindBy(css = "#headerXL a.MyBagLink_container__xcIvf") WebElement myBagHeader;
    @FindBy(css = "button.Button_secondary__Sgalt") WebElement viewCart;
    @FindBy(css = "div.ProductPrice_large__haiZ8 span.ProductPrice_salePrice__uPZ5p") WebElement salePrice;
    @FindBy(css = "div.ProductPrice_large__haiZ8 span.ProductPrice_regularPrice__P7kc1") WebElement regularPrice;
    @FindBy(css = "div.ProductPrice_large__haiZ8 span.ProductPrice_price__XUX4C") WebElement productPrice;
    By colourSwatches=By.cssSelector("div.SwatchList_large__2t7zC input");
    By availableSizes=By.cssSelector("div.SizeList_large__aVkjL input[aria-disabled='false']");
    By allSizes=By.cssSelector("div.SizeList_large__aVkjL input[aria-disabled='true']");
    @FindBy(xpath = "//button[text()='Continue shopping']") WebElement continueShoppingButton;


    public boolean isImageVisible(){
        wait.until(ExpectedConditions.visibilityOf(productImage));
        Log.info("Image Displayed: "+productImage.isDisplayed());
        return productImage.isDisplayed();
    }

    public boolean isBreadCrumpsDisplayed(){
            wait.until(ExpectedConditions.visibilityOf(breadCrumbs));
            Log.info("BreadCrumbs Displayed: " + breadCrumbs.isDisplayed());
            return breadCrumbs.isDisplayed();

    }
    public void itemAddToCart(){
        wait.until(ExpectedConditions.visibilityOf(productImage));
        Log.info("Product: "+driver.findElement(By.cssSelector("h1.ProductDetails_heading__OZWMB")).getText());
        List<WebElement> availableSizes=driver.findElements(enabledSizeSwatches);
        Log.info("Available sizes: "+availableSizes);
        if(driver.findElements(allSizes).size()==1){
            addToCartButton.click();
            wait.until(ExpectedConditions.visibilityOf(successHeading));
            viewCart.click();
        }
        else {
           // wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(enabledSizeSwatches));
            int sizeSelected = random.nextInt(availableSizes.size());
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", availableSizes.get(sizeSelected));
            addToCartButton.click();
            wait.until(ExpectedConditions.visibilityOf(successHeading));
            viewCart.click();
        }
    }

    public boolean priceDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(productImage));
        try{
        if(!(salePrice.isDisplayed()&&Float.parseFloat(salePrice.getText().replace("$",""))>0.0)){
            return false;
        }
        else if(!(regularPrice.isDisplayed()&&Float.parseFloat(regularPrice.getText().replace("$",""))>0.0)){
            return false;
        }
        }
        catch (NoSuchElementException exception){
            if(!(productPrice.isDisplayed()&&Float.parseFloat(productPrice.getText().replace("$",""))>0.0)){
                return false;
            }
        }
        return true;
    }
    public String returnPrice(){
        wait.until(ExpectedConditions.visibilityOf(productImage));
        try {
           return salePrice.getText();
        }
        catch (NoSuchElementException ex){
            return productPrice.getText();
        }
    }
    public void addAllVariants(){
        wait.until(ExpectedConditions.visibilityOf(productImage));
        for (WebElement colour:driver.findElements(colourSwatches)){
            colour.click();
            for (WebElement size:driver.findElements(availableSizes)){
                ((JavascriptExecutor)driver).executeScript("arguments[0].click();",size);
                addToCartButton.click();
                wait.until(ExpectedConditions.visibilityOf(successHeading));
                continueShoppingButton.click();
                wait.until(ExpectedConditions.invisibilityOf(continueShoppingButton));
            }

        }
    }

}
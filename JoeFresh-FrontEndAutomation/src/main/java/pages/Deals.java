package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class Deals {
    WebDriver driver;
    WebDriverWait wait;
    Random random;

    public Deals(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        random=new Random();
    }

    @FindBy(css = "span.ProductPrice_regularPrice__P7kc1")
    WebElement regularPrice;
    @FindBy(css = "span.ProductPrice_salePrice__uPZ5p") WebElement promotionalPrice;
    @FindBy(css = "span.Badge_small___RdFM") WebElement badge;

    public boolean clearanceDeal(int percent){
        wait.until(ExpectedConditions.visibilityOf(badge));
        float regularPriceValue=Float.parseFloat(regularPrice.getText().replace("$",""));
        float promotionalPriceValue=Float.parseFloat(promotionalPrice.getText().replace("$",""));
        int clearanceValue=Math.round((promotionalPriceValue/regularPriceValue)*100);
        return promotionalPriceValue==clearanceValue;
    }

    public boolean dollarOff(int amount){
        wait.until(ExpectedConditions.visibilityOf(regularPrice));
        float regularPriceValue=Float.parseFloat(regularPrice.getText().replace("$",""));
        float promotionalPriceValue=Float.parseFloat(promotionalPrice.getText().replace("$",""));
        return promotionalPriceValue==regularPriceValue-amount;
    }

    public boolean percentOff(int percent){
        wait.until(ExpectedConditions.visibilityOf(badge));
        float regularPriceValue=Float.parseFloat(regularPrice.getText().replace("$",""));
        float promotionalPriceValue=Float.parseFloat(promotionalPrice.getText().replace("$",""));
        return promotionalPriceValue==regularPriceValue-(0.01*percent*regularPriceValue);
    }





}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Log;

import java.time.Duration;

public class NoSearchPage {
    WebDriver driver;
    WebDriverWait wait;

    public NoSearchPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//h1[@class='NoSearchResults_heading__cIFyz']")
    WebElement noSearchResult;

    @FindBy(xpath = "//div[@class='category-navigation__links css-en3jfr e1tg9ykc2']")
    WebElement categoryNavigation;


    By sliderItems= By.xpath("//li[@class='RecommendationSlider_sliderItem__j_8sl']");


    @FindBy(xpath = "//ul[@class='RecommendationSlider_sliderList__EhfAn']")
    WebElement sliderList;

    public boolean noSearchResultTextVisible()  {
        try {
            wait.until(ExpectedConditions.visibilityOf(noSearchResult));
            return noSearchResult.isDisplayed();
        }
        catch (TimeoutException te){
            Log.info("No Search Page is not working");
            return false;
        }
    }

    public boolean productNavigationVisible(){

        return categoryNavigation.isDisplayed();
    }

    public boolean recommendedProductVisible(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sliderItems));
        if(sliderList.isDisplayed()){

            return driver.findElements(sliderItems).size()>0;
        }
        return false;
    }
}

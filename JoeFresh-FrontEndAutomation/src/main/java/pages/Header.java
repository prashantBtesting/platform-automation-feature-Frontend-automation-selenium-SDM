package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//div[@class='Header_topMenuContainerDesktop__FtC7r']//descendant::button")
    WebElement headerSignInButton;
    @FindBy(css = "#headerXL a.Header_logo__iu8zZ") WebElement homeLogo;
     @FindBy(css = "#headerXL a.MyBagLink_container__xcIvf") WebElement myBagButton;
    @FindBy(css = "#headerXL a.Header_findStoreLink___sr5B") WebElement findAStore;
    @FindBy(xpath = "//h2[text()=\"What's Trending\"]") WebElement whatsTrending;
    @FindBy(id = "email") WebElement pcIdEmail;
    @FindBy(css = "h1.EmptyBag_heading__F_2ow") WebElement emptyBagHeading;
    @FindBy(css = "div.grid-x h1") WebElement myBagHeading;
    @FindBy(css = "button.lds__location-search__search-toggle-button") WebElement locationSearchButton;
    @FindBy (css = "input[name='search']") WebElement searchInput;



    public Header(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickFindAStore(){
        findAStore.click();
    }

    public boolean validateFindAStoreVisible(){
        wait.until(ExpectedConditions.visibilityOf(locationSearchButton));
        return locationSearchButton.isDisplayed();
    }

    public void clickLogin(){
        headerSignInButton.click();
    }

    public boolean validatePcLoginPage(){
        wait.until(ExpectedConditions.visibilityOf(pcIdEmail));
        return pcIdEmail.isDisplayed();
    }

    public void clickMyBag(){
        wait.until(ExpectedConditions.elementToBeClickable(myBagButton));
        try {
            myBagButton.click();
        }
        catch (ElementClickInterceptedException e){
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();",myBagButton);
        }

    }
    public boolean validateMyBag(){
        try {
            wait.until(ExpectedConditions.visibilityOf(emptyBagHeading));
            return emptyBagHeading.isDisplayed();
        }
        catch (TimeoutException te){
            return myBagHeading.isDisplayed();
        }
    }

    public void clickHome(){
        clickFindAStore();
        validateFindAStoreVisible();
        homeLogo.click();
    }
    public boolean validateHomePage(){
        wait.until(ExpectedConditions.visibilityOf(whatsTrending));
        return whatsTrending.isDisplayed();
    }

    public boolean searchVisible(){
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        return searchInput.isDisplayed();
    }

}

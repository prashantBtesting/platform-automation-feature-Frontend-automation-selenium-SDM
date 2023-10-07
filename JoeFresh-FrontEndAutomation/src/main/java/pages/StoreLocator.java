package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class StoreLocator {
    WebDriver driver;
    WebDriverWait wait;
    Random random;

    public StoreLocator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        random = new Random();
    }

    @FindBy(css = "a.Header_findStoreLink___sr5B")
    WebElement storeLocatorButton;

    @FindBy(css = "button.lds__location-search__search-toggle-button")
    WebElement buttonEnterLocation;
    @FindBy(id = "lds-store-locator-location-search-input")
    WebElement locationInputBox;
    @FindBy(css = "div.lds__location-search__search-list-container__suggestion-container")
    WebElement locationSuggestion;
    @FindBy(css = "ol.lds__store-locator-result-list__list")
    WebElement storeSuggestionList;

    @FindBy(xpath = "//div[@class='lds__location-search__search-list-container__suggestion-container']/ul[1]")
    WebElement suggestedAddressList;
    @FindBy(xpath = "//div[@class='lds__location-search__search-list-container__suggestion-container']/ul[2]")
    WebElement recentAddressList;
    By direction=By.xpath("//descendant::div[@class='lds__store-locator-base-list-item__actions']/a");
    By details=By.xpath("//descendant::div[@class='lds__store-locator-base-list-item__actions']/button");
    @FindBy(xpath = "//h1[@class='lds__store-locator-details-store-name-pane__heading']") WebElement storeHeading;
    @FindBy(xpath = "//span[@class='lds__store-locator-details-address-pane__postal']") WebElement pinCode;
    @FindBy(linkText = "Get Directions") WebElement getDirectionsLink;
    @FindBy(linkText = "Call Store") WebElement callLink;

    By resultAddress = By.xpath("//li[@class='lds__location-search__search-list-container__suggestion-item']//descendant::button");
    By resultStores=By.xpath("//li[@class='lds__store-locator-result-list__item']");


    public void visitStoreLocator() {
        wait.until(ExpectedConditions.visibilityOf(storeLocatorButton));
        storeLocatorButton.click();
    }

    public void clickToEnterAddress() {
        wait.until(ExpectedConditions.visibilityOf(buttonEnterLocation));
        buttonEnterLocation.click();
    }

    public void typeAddress() {
        locationInputBox.sendKeys("88 ");
    }

    public boolean suggestionVisible() {
        wait.until(ExpectedConditions.visibilityOf(locationSuggestion));
        return locationSuggestion.isDisplayed();
    }

    public void selectLocation() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(resultAddress));
        List<WebElement> suggestedAddresses = suggestedAddressList.findElements(resultAddress);
        int locationNumber = random.nextInt(suggestedAddresses.size());
        suggestedAddresses.get(locationNumber).click();
    }

    public boolean storeListDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(storeSuggestionList));
        return storeSuggestionList.isDisplayed();
    }

    public void selectDirection(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultStores));
        List<WebElement> storeSuggestion=driver.findElements(resultStores);
        int storeSelected= random.nextInt(storeSuggestion.size());
        storeSuggestion.get(storeSelected).findElement(direction).click();
    }

    public boolean googleMapsRedirected() throws InterruptedException {
        Thread.sleep(2000);
        return driver.getCurrentUrl().contains("www.google.com/maps");
    }

    public void selectDetails(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultStores));
        List<WebElement> storeSuggestion=driver.findElements(resultStores);
        int storeSelected= random.nextInt(storeSuggestion.size());
        storeSuggestion.get(storeSelected).findElement(details).click();
    }

    public boolean detailsVisible(){
        wait.until(ExpectedConditions.visibilityOf(storeHeading));
        return storeHeading.isDisplayed()&&pinCode.isDisplayed()&&getDirectionsLink.isDisplayed();
    }



}



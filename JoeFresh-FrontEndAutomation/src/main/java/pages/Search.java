package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.DataDriven;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Search {

    WebDriver driver;
    String productName;
    Random random;
    WebDriverWait wait;
    public Search(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        random=new Random();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    @FindBy(xpath = "//input[@name='search']")
    WebElement searchBox;

    @FindBy(xpath = "//div[@class='SearchBarDesktop_suggestions__iFEuq']")
    WebElement dropdown;

    By dropdownMenu=By.xpath("//div[@class='SearchBarDesktop_suggestions__iFEuq']");
    By dropdownProducts=By.xpath("//a[@class='SearchBarDesktop_link__2xwcN']");


    public void setSearchBox(String testCase) throws IOException {
        List<String> searchKeys=DataDriven.getTestData("SearchData",testCase);
        int productNumber=random.nextInt(searchKeys.size());
        if(productNumber==0){
            productNumber=1;
        }
        searchBox.sendKeys(searchKeys.get(productNumber));
        productName=searchKeys.get(productNumber);
    }

    public String getProduct(){
        return productName;
    }



    public boolean dropDownVisiblity(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver.findElements(dropdownMenu).size()>0;
    }


    public void searchProduct(){
        searchBox.sendKeys(Keys.ENTER);
    }

    public void clickElementOnDropdown(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dropdownProducts));
        List<WebElement> dropdownP=driver.findElements(dropdownProducts);
        Random random=new Random();
        dropdownP.get(random.nextInt(dropdownP.size())).click();
    }

    public void setSearchBoxMultiple(String searchTerm){
        searchBox.sendKeys(searchTerm);
        productName=searchTerm;
    }



}

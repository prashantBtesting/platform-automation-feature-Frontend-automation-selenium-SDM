package util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageObjectManager;
import resources.Base;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Common extends Base{
    PageObjectManager pom;
   public WebDriver driver;
    public Properties properties;

    public Common(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        pom=new PageObjectManager(driver);
    }



    public boolean clickOn(WebElement element) {

        WebDriverWait webWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webWait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        return true;
    }

    public void elementCLick(String xpath){
        //System.out.println("driver="+driver);
        driver.findElement(By.xpath(xpath)).click();

    }
    public boolean addExplicitWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        return true;
    }
    public String isTextVisible(String xpath, String ExpectedText) {

        List<WebElement> l = driver.findElements(By.xpath(xpath));

        if (l.size() > 0) {
            System.out.println("Text: " + ExpectedText + " is present. ");
        } else {
            System.out.println("Text: " + ExpectedText + " is not present. ");
        }
        return ExpectedText;
    }
    public String getTitle() {
        String cd = driver.getTitle();
        return cd;
    }
    public void Back(){
        driver.navigate().back();
    }
    public void implicitlyWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    }
    public void enter(WebElement element){
        element.sendKeys(Keys.ENTER);
    }
    public boolean elementdisplayed(WebElement element){
        element.isDisplayed();
        return true;
    }
    public String getPrice(){
        List<WebElement> Productvalues = driver.findElements(By.cssSelector("div.ProductDetails_price__yHkc0"));

        for (WebElement productprice:Productvalues){
            String text = productprice.getText();
            System.out.println(text);
        } return getPrice();

    }
    public void addImplicitWait(WebElement productBadge){
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    public boolean isElementVisibleCss(String cssLocator){
       try {
           return driver.findElement(By.cssSelector(cssLocator)).isDisplayed();
       }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
       }
    }
public boolean isDisplayedAndIsVisible(WebElement element) {
    WebElement webelement = element;
    if (webelement.isDisplayed() && webelement.isEnabled()) {
        element.click();
    }return true;
}
public String getVisibleText() throws IOException {
    return driver.findElement(By.xpath(loadProperties("xpathToGetTextProduct1"))).getText();
}

public void BrokenLinksAndImgValidation() throws IOException {
        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        linkList.addAll(driver.findElements(By.tagName("img")));
    System.out.println("Size of full links and Images:: "+ linkList.size());

    List<WebElement> activeLinks =  new ArrayList<WebElement>();

    for (int i=0; i<linkList.size(); i++){
        try {
            if(linkList.get(i).getAttribute("href")!=null){
                activeLinks.add(linkList.get(i));
            }
        }catch (Exception SE){

            if(linkList.get(i).getAttribute("href")!=null){
                activeLinks.add(linkList.get(i));
            }
        }
    }
    System.out.println("Size of active link and images:: "+ activeLinks.size());

    for (int j=0;j<activeLinks.size(); j++){
        HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
        connection.connect();
        String response = connection.getResponseMessage();
        connection.disconnect();
        try {
            System.out.println(activeLinks.get(j).getAttribute("href")+ "   --->>>" + response);
        }catch (Exception SE){
            System.out.println(activeLinks.get(j).getAttribute("href")+ "   --->>>" + response);
        }


    }
}



public void brokenImages(){
    List<WebElement> images = driver.findElements(By.tagName("img"));
    System.out.println("Total number of Images on the Page are " + images.size());


    //checking the links fetched.
    for(int index=0;index<images.size();index++)
    {
        WebElement image= images.get(index);
        String imageURL= image.getAttribute("src");
        System.out.println("URL of Image " + (index+1) + " is: " + imageURL);
        verifyLinks(imageURL);

        //Validate image display using JavaScript executor
        try {
            boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);", image);
            if (imageDisplayed) {
                System.out.println("DISPLAY - OK");
            }else {
                System.out.println("DISPLAY - BROKEN");
            }
        }
        catch (Exception e) {
            System.out.println("Error Occured");
        }
    }


    driver.quit();
}

    public static void verifyLinks(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);

            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400)
            {
                System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage() + "is a broken link");
            }

            //Fetching and Printing the response code obtained
            else{
                System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage());
            }
        }catch (Exception e) {
        }
}


public void BrokenImagesOnPages() throws IOException {
       List<WebElement> imges =driver.findElements(By.tagName("img"));
    System.out.println(imges.size());

    for (WebElement image: imges){
        String imgSrc = image.getAttribute("src");
try {
    URL url = new URL(imgSrc);
    URLConnection urlConnection = url.openConnection();
    HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
    httpURLConnection.setConnectTimeout(5000);
    httpURLConnection.connect();

    if (httpURLConnection.getResponseCode() == 200)
        System.out.println(imgSrc + " >> " + httpURLConnection.getResponseCode() + " >> " + httpURLConnection.getResponseMessage());
    else
        System.err.println(imgSrc + " >> " + httpURLConnection.getResponseCode() + " >> " + httpURLConnection.getResponseMessage());
    httpURLConnection.disconnect();
}catch (Exception e){
    System.err.println(imgSrc);
}

    }
}

}

package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.DataDriven;
import util.Log;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class SearchResult {
    WebDriver driver;
    WebDriverWait wait;
    Random random;
    public SearchResult(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        random=new Random();
    }
    @FindBy(xpath = "//h1[@class='Search_heading__8zGwn']")
    WebElement searcResultHeading;

    @FindBy(xpath = "//div[@class='ProductTile_productTile__LOg79 cell medium-4 small-6']")
    WebElement productTie;

    @FindBy(xpath = "//button[@id='labelledby-Department-desktop']")
    WebElement departmentTitle;

    @FindBy(xpath = "//button[@id='labelledby-Colour-desktop']")
    WebElement colourTitle;

    @FindBy(xpath = "//button[@id='labelledby-Size-desktop']")
    WebElement sizeTitle;

    @FindBy(xpath = "//button[@id='labelledby-Price-desktop']")
    WebElement priceTitle;

    @FindBy(xpath = "//span[@class='SortDesktop_currentValue__vI6Td']")
            WebElement selectedSortCriteria;

    @FindBy(xpath = "//button[@class='ProductTileLoadMore_button__veTzk Button_primary__PgyFQ']")
            WebElement loadMoreButton;

    @FindBy (xpath = "//p[@class='ProductShowing_showing__ZT_y3']")
            WebElement resultCount;

    @FindBy (xpath = "//button[@role='button']")
            WebElement sortButton;
    By promotionalPricePlp=By.cssSelector("span.ProductPrice_salePrice__uPZ5p");
    By regularPricePlp=By.cssSelector("span.ProductPrice_regularPrice__P7kc1");
    By productPricePlp=By.cssSelector("span.ProductPrice_price__XUX4C") ;
    By selectedCheckBox=By.cssSelector("li.ListBox_isSelected__TAtfT");

    By breadCrumbs=By.xpath("//ol[@class='Breadcrumbs_list__K1ZN9']");

    By productTile=By.xpath("//div[@class='ProductTile_productTile__LOg79 cell medium-4 small-6']");
    By filterChips=By.xpath("//button[@class='FilterPill_pill__dbrbz']");

    By checkedFilters=By.xpath("//div[@class='cell large-3 medium-12']//li[@role='option'][@aria-selected='true']");

    By sortCriteria=By.xpath("//button[@role='menuitem']");
    By colourSwatch = By.xpath("//input[@type='radio']");
    By filterHeadings=By.cssSelector("div.ResponsiveWrapper_largeAbove__L08sy button.Accordion_headingButton__yxb9e");
    @FindBy(css = "button.SortDesktop_button__8xBg6") WebElement sortItem;
    By sortButtons=By.xpath("//button[@role='menuitem']");
    By inputFilter = By.xpath("//li[@role='option'][@class='ListBox_listItem__QMuX2']");

    public String getSearchTitle(){
        return searcResultHeading.getText();
    }

    public void checkRandomFilter(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTile));
        int filterChecked= random.nextInt(driver.findElements(inputFilter).size());
        String id=driver.findElements(inputFilter).get(filterChecked).getAttribute("id");
        Log.info("Filter Checked: "+driver.findElements(inputFilter).get(filterChecked).getText());
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",driver.findElement(By.id(id)));
        wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.id(id)),"aria-selected","true"));
    }

    public void checkFilter() throws InterruptedException, IOException {
        ArrayList<String> filters=DataDriven.getTestData("SearchData","Filters");
        Log.info("Filters: "+filters);
        for (int i=1;i<filters.size();i++) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@role='option'][@value='" + filters.get(i) + "']")));
            driver.findElement(By.xpath("//li[@role='option'][@value='" + filters.get(i) + "']")).click();
            Thread.sleep(1000);
            Log.info("//li[@role='option'][@value='" + filters.get(i) + "']" + " clicked.");
        }

    }

    public int getProductQuantity() throws InterruptedException, IOException {
        Thread.sleep(5000);
        List<WebElement> checkedFiltersList=getCheckedFilters();
        Log.info("Array of web elements from getProductQuantity: "+checkedFiltersList);
        int qty=0;
        Log.info("Number of applied filters: "+checkedFiltersList.size());
      for (int i=0;i<checkedFiltersList.size()-1;i++){
          if(checkedFiltersList.size()<=1){
              qty=checkedFiltersList.size();
          }
          else if(findParent(checkedFiltersList.get(i)).getAttribute("aria-label").equals(findParent(checkedFiltersList.get(i+1)).getAttribute("aria-label"))){
              qty=convertStringToIntProductQuantity(checkedFiltersList.get(i).getText())+convertStringToIntProductQuantity(checkedFiltersList.get(i+1).getText());
          }
          else if(!(findParent(checkedFiltersList.get(i)).getAttribute("aria-label").equals(findParent(checkedFiltersList.get(i+1)).getAttribute("aria-label")))){
              qty=convertStringToIntProductQuantity(checkedFiltersList.get(i+1).getText());
          }
      }
        Log.info("Quantity of available product: "+qty);
        return qty;
    }

    public List<WebElement> getCheckedFilters() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        Log.info("From method getCheckedFilters: Checked Filters: "+driver.findElements(checkedFilters).size());
        return driver.findElements(checkedFilters);
    }

    public int getNumberOfProductsDisplayed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> productTiles=driver.findElements(productTile);
        Log.info("ProductTiles size :"+productTiles.size());
        return productTiles.size();

    }

    public boolean productTileVisiblity(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver.findElements(productTile).size()>0;

    }

    public List<WebElement> getFilterChips() throws InterruptedException {
        Thread.sleep(2000);
        Log.info("Filter Chips: "+driver.findElements(filterChips).size());
        return driver.findElements(filterChips);
    }

    public int getChipsCount() throws InterruptedException {
        return getFilterChips().size();
    }



    public void removeFilterChip() throws InterruptedException {
        List<WebElement> filterChipsList=getFilterChips();
        int chipToBeRemoved=random.nextInt(filterChipsList.size());
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",filterChipsList.get(chipToBeRemoved));
    }

    public boolean checkedItemsAndChips() throws InterruptedException, IOException {
        List<String> filterChipsList=new ArrayList<String>();
        List<WebElement> filterChips=getFilterChips();
        List<String> checkedFiltersList=new ArrayList<String>();
        List<WebElement> checkedFilters=getCheckedFilters();
        for (int i=0;i<filterChips.size();i++){
            Log.info(filterChips.get(i).getText());
            filterChipsList.add(filterChips.get(i).getText().replace(". Press enter to remove filter.","").replace("\n",""));
            Log.info(filterChipsList.get(i));
        }
        Log.info("Number Of Filters available: "+getFilterChips().size());
        Log.info("List of Filter Chips "+filterChipsList);
        for (int i=0;i<checkedFilters.size();i++){
            Log.info(checkedFilters.get(i).getText());
            String filterText=checkedFilters.get(i).getText();
            checkedFiltersList.add(filterText.replace(filterText.substring(filterText.indexOf("(")),"").trim());
            Log.info(checkedFiltersList.get(i));
        }
        Log.info("Number Of Filters available: "+checkedFiltersList.size());
        Log.info("List of Checked Filters "+checkedFiltersList);
        if (checkedFiltersList.size() == filterChipsList.size()){
            return new HashSet<>(filterChipsList).equals(new HashSet<>(checkedFiltersList));
        }
        return false;
    }

    public int convertStringToIntProductQuantity(String stringLiteral){
        return Integer.parseInt(stringLiteral.substring(stringLiteral.indexOf('(')+1,stringLiteral.indexOf(')')));
    }

    public WebElement findParent(WebElement element){
        JavascriptExecutor executor=(JavascriptExecutor) driver;
        return (WebElement) executor.executeScript("return arguments[0].parentNode;",element);
    }

    public String sortCriteria(){
        return selectedSortCriteria.getText();
    }

    public List<String> extractText(List<WebElement> webElements){
        List<String> webElementsText = new ArrayList<String>();
        for (int i=0;i<webElements.size();i++){
            webElementsText.add(i,returnParentText(webElements.get(i)).replaceAll("[^A-Za-z]+", ""));
            Log.info("Extracted Text :"+webElementsText);
        }
        return webElementsText;
    }

    public String returnParentText(WebElement webElement){
        JavascriptExecutor executor=(JavascriptExecutor) driver;
        return (String) executor.executeScript("return arguments[0].firstChild.textContent", webElement);
    }

    public void removeFilter() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        List<WebElement> checkedFilters=driver.findElements(selectedCheckBox);
        int randomElement=random.nextInt(checkedFilters.size());
        Log.info("Element Removed: "+checkedFilters.get(randomElement).getText());

        String idItemToBeRemoved=checkedFilters.get(randomElement).getAttribute("id");

        Log.info("ID: "+idItemToBeRemoved);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",driver.findElement(By.id(idItemToBeRemoved)));
        // driver.findElement(By.id(idItemToBeRemoved)).click();
        wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.id(idItemToBeRemoved)),"aria-selected","false"));
        Log.info("Checked Filters: "+driver.findElements(selectedCheckBox).size());
        //Thread.sleep(1000);
       // return driver.findElements(selectedCheckBox).size()==2;
        //driver.findElement(By.xpath("//li[@role='option'][@value='"+value+"']")).click();
    }
    public void loadAllProducts() throws InterruptedException {
        String resultDisplayed=resultCount.getText().replace("Showing ","");
        Log.info(resultDisplayed);
        Log.info("Product Count: "+resultDisplayed.substring(0,resultDisplayed.indexOf(" ")));
        if(Integer.parseInt(resultDisplayed.substring(0,resultDisplayed.indexOf(" ")))<30){
            Log.info("The product count is less than 30");
        }
        else if(Integer.parseInt(resultDisplayed.substring(0,resultDisplayed.indexOf(" ")))==30){
            String totalResult=resultDisplayed.replace("30 of ","");
            if(Integer.parseInt(totalResult.substring(0,totalResult.indexOf(" ")))==30){
                Log.info("Product is equal to 30");
            }
            else if(Integer.parseInt(totalResult.substring(0,totalResult.indexOf(" ")))>30){
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loadMoreButton);
                Thread.sleep(3000);
                try {
                    while (loadMoreButton.isDisplayed()) {
                        loadMoreButton.click();
                    }
                }
                catch(org.openqa.selenium.StaleElementReferenceException sere){
                    while (loadMoreButton.isDisplayed()) {
                        loadMoreButton.click();
                    }
                    }
            }

            else {
                Log.error("There is some error");
            }
        }
        else{
            Log.error("Error with the code");
            }
        }

        public boolean validateSortCriteria(){
        List<String> sortItems= Arrays.asList("Relevance","Price: Low to High","Price: High to Low","Recommended");
        List<WebElement> sortItemElements=driver.findElements(sortCriteria);
        List<String> sortItemElementText=new ArrayList<String>();
        for (WebElement sortItemElement:sortItemElements){
            sortItemElementText.add(sortItemElement.getText());
        }
        return sortItems.equals(sortItemElementText);
    }

    public void clickSort(){
        wait.until(ExpectedConditions.elementToBeClickable(sortButton));
        sortButton.click();
    }

    public boolean isBreadCrumpsDisplayed(){
        try{
        driver.findElement(breadCrumbs);

        return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
    }
    }

    public boolean colourChecked(String colourText){
        List<WebElement> productTiles=driver.findElements(productTile);
        for (WebElement product:productTiles){
            List<WebElement> colours=product.findElements(colourSwatch);
            for (WebElement color:colours){
               if(!(color.findElement(By.xpath("//following-sibling::label/span[@class='sr-only']")).getText().equals("Color "+colourText))){
                   return false;
               }
            }
        }
        return true;
    }

    public boolean validateFilterHeadings() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(filterHeadings));
        List<String> accordionText = new ArrayList<>();
        List<String> expectedAccordion = Arrays.asList("Department", "Type", "Colour", "Size", "Price");
        for (WebElement accordion : driver.findElements(filterHeadings)) {
            accordionText.add(accordion.getText());
        }
        return accordionText.equals(expectedAccordion);
    }

    public boolean sortDisplayed(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTile));
        Log.info("Default Sorting: "+sortItem.getText());
        return sortItem.isDisplayed() && sortItem.getText().equals("Sort by: Relevance");
    }
    public boolean sortItemsDropdown(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTile));
        sortItem.click();
        wait.until(ExpectedConditions.visibilityOf(sortItem));
        List<String> sortItems= Arrays.asList("Relevance","Price: Low to High","Price: High to Low","Popular");
        List<WebElement> sortItemElements=driver.findElements(sortButtons);
        List<String> sortItemElementText=new ArrayList<String>();
        for (WebElement sortItemElement:sortItemElements){
            sortItemElementText.add(sortItemElement.getText());
        }
        return sortItems.equals(sortItemElementText);
    }



    public boolean priceDisplayed()  {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTile));
        for (WebElement product : driver.findElements(productTile)) {
            try {
                Log.info("Promotional Price: " + product.findElement(promotionalPricePlp).getText());
                Log.info("Regular Price: " + product.findElement(regularPricePlp).getText());
                if (!(product.findElement(promotionalPricePlp).isDisplayed() && Float.parseFloat(product.findElement(promotionalPricePlp).getText().replace("$", "")) > 0.0)) {
                    return false;
                } else {
                   // DataDriven.writeData(1,1,product.findElement(promotionalPricePlp).getText());
                    if (!(product.findElement(regularPricePlp).isDisplayed() && Float.parseFloat(product.findElement(regularPricePlp).getText().replace("$", "")) > 0.0)) {
                        return false;
                    }
                }
            } catch (NoSuchElementException nsee) {
                try{
                if (!(product.findElement(productPricePlp).isDisplayed() && Float.parseFloat(product.findElement(productPricePlp).getText().replace("$", "")) > 0.0)) {
                    Log.info("Actual Price: " + product.findElement(productPricePlp).getText());
                    return false;
                }
                else {
                    Log.info("Promotional Price: " + product.findElement(productPricePlp).getText());
                    //DataDriven.writeData(1,1,product.findElement(productPricePlp).getText());
                }
                }
                catch (NoSuchElementException exception){
                    Log.info("Error with the code");
                    return false;
                }
            }
        }
        return true;
    }



}




package pages;

import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.Base;
import resources.DataDriven;
import util.Log;

import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class PLP {
    WebDriver driver;
    Random random;
    WebDriverWait wait;


    public PLP(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        random = new Random();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//div[@class='ResponsiveWrapper_largeAbove__L08sy']/h1")
    WebElement productHeading;

    @FindBy(xpath = "//div[@class='Modal_content__R7I_E Modal_center__tAVFu Modal_fadeIn__6FMV3']//h1[@class='ModalAddToBag_heading___YF19']")
    WebElement dialogHeading;

    @FindBy(xpath = "//div[@aria-labelledby='labelledby-Category-desktop']//a[@class='CategoryAccordion_navItem__75gMU CategoryAccordion_active__521iU']")
    WebElement selectedCategory;

    @FindBy(xpath = "//button[@data-testid='load-more-button']")
    WebElement loadMoreButton;
    @FindBy(css = "p.ProductShowing_showing__ZT_y3")
    WebElement resultTopHeading;
    @FindBy(css = "p.ProductTileLoadMore_showing__OIHA6")
    WebElement resultBottomHeading;

    @FindBy(xpath = "//button[@class='BackToTop_backToTop__6dcjJ Button_primary__PgyFQ Button_iconBorder__oosu6']")
    WebElement backToTopButton;

    @FindBy(css = "ol.Breadcrumbs_list__K1ZN9")
    WebElement breadCrumb;

    @FindBy(css = "#controls-Category-desktop ul.CategoryAccordion_container__eNF22")
    WebElement categoryMenu;
    @FindBy(id = "labelledby-Color-desktop") WebElement colourButton;
    @FindBy(id = "labelledby-Category-desktop")
    WebElement categoryButton;
    @FindBy(css = "button.SortDesktop_button__8xBg6") WebElement sortItem;
    @FindBy(css = "span.SortDesktop_currentValue__vI6Td") WebElement selectedSortItem;
    @FindBy (xpath = "//img[@data-testid='zoomImg0']")
    WebElement productPdpImage;
    @FindBy(xpath = "//div[@class='cell large-3 medium-12']") WebElement filterWrapper;
    By colourSwatch = By.xpath("//input[@type='radio']");
    By productTile = By.xpath("//div[@class='ProductTile_productTile__LOg79 cell medium-4 small-6']");
    By productTileCss=By.cssSelector("div.grid-x div.ProductTile_productTile__LOg79") ;
    By productImage = By.xpath("//descendant::div[@data-testid='product-image']//img");
    //By addToCartButton=By.xpath("//button[@aria-label='Add to bag']");
    By addToCartButton =By.xpath("//button[text()='Add to bag']");
            //By.cssSelector(".ResponsiveWrapper_xlargeOnly__EF88U button[data-testid='atb-desktop']");
    By sizeButton = By.xpath("//input[@name='addToBagDesktop'][@aria-disabled='false']");
    By sizeBox = By.xpath("//div[@class='SizeList_overlay__aKa3m SizeList_sizeList__jdG_V']");
    By selectedAddToCartButton = By.xpath("//button[@data-testid='atb-selected-desktop']");
    By colourLabel = By.id("labelledby-Colour-desktop");
    By disabledSizeButton = By.xpath("//input[@name='addToBagDesktop'][@aria-disabled='true']");
    By productName = By.xpath("//p[@class='ProductTile_name__eAKRK']");
    By breadCrumbItems = By.cssSelector("li.Breadcrumbs_listItem__bGiOT");
    By categoryList = By.cssSelector("a.CategoryAccordion_navItem__75gMU");
    By accordionHeadings = By.xpath("//div[@class='ResponsiveWrapper_largeAbove__L08sy']//button[@class='Accordion_headingButton__yxb9e']");
    By inputFilter = By.xpath("//li[@role='option'][@class='ListBox_listItem__QMuX2']");
    By showMoreFilters = By.id("showmore-Size");
    By sortButtons=By.xpath("//button[@role='menuitem']");
    By checkedFilters=By.xpath("//li[@role='option'][@aria-selected='true']");
    By unselectedSortItem=By.xpath("//button[@class='SortDesktop_menuItem__Y6vxB']");
    By collectionProducts=By.xpath("//div[@class='ProductTile_productTile__LOg79 cell large-3 medium-4 small-6']");
    By collectionProductImage=By.xpath("//descendant::img");
    By collectionColourSwatch=By.xpath("//descendant::input[@type='radio']");
    By collectionProductHeading=By.xpath("//descendant::p[@class='ProductTile_name__eAKRK']");
    By salePrice=By.cssSelector("div.ProductPrice_small__iGJNZ span.ProductPrice_salePrice__uPZ5p");
    By regularPrice=By.cssSelector("div.ProductPrice_small__iGJNZ span.ProductPrice_regularPrice__P7kc1");
    By selectedCheckBox=By.cssSelector("li.ListBox_isSelected__TAtfT");

    @FindBy(xpath = "//button[text()='Price: Low to High']") WebElement lowToHighButton;
    @FindBy(xpath = "//button[text()='Continue shopping']") WebElement continueShopping;
    @FindBy(xpath = "//button[text()='Price: High to Low']") WebElement highToLowButton;
    By badgePlp=By.cssSelector("span.Badge_small___RdFM");
    By badgePdp=By.cssSelector("span.Badge_large__dASni");
    By onlyPrice=By.cssSelector("div.ProductPrice_small__iGJNZ span.ProductPrice_price__XUX4C");
    By bundledSalePrice=By.cssSelector("span.ProductPrice_bundlePrice___5Dpq");
    By eachItemPrice=By.cssSelector("span.ProductPrice_eachPrice__0hB2Z");
    @FindBy(css = "h1.ProductDetails_heading__OZWMB") WebElement productHeadingPdp;


    public boolean validateColourChange()  {
        wait.until(ExpectedConditions.visibilityOf(productHeading));
        List<WebElement> productTiles=driver.findElements(productTile);
        int productNumber=randomNumberChoose(productTiles);
        WebElement product=productTiles.get(productNumber);
        Log.info(product.getText());
        List<WebElement> coloursNotChecked=product.findElements(By.cssSelector("div[role='radiogroup'] input[data-testid='swatch-item-6']:not(:checked)"));
        Log.info("Available Colors: "+coloursNotChecked.size());
        if(coloursNotChecked.size()>1){
            int colourChosen=randomNumberChoose(coloursNotChecked);
            Log.info(coloursNotChecked.get(colourChosen).getAttribute("id"));
            WebElement checkedColour=product.findElement(By.cssSelector("div[role='radiogroup'] input[data-testid='swatch-item-6']:checked"));
            String checkedColourText=driver.findElement(By.cssSelector("label[for='"+checkedColour.getAttribute("id")+"'] span.sr-only")).getText();
            Log.info("Default Colour:"+checkedColourText);
            String colourToBeSelectedLabel=driver.findElement(By.cssSelector("label[for='"+coloursNotChecked.get(colourChosen).getAttribute("id")+"'] span.sr-only")).getText();
            Log.info("Colour To Be Selected "+colourToBeSelectedLabel);
            try {
                coloursNotChecked.get(colourChosen).click();
            }
            catch (ElementClickInterceptedException e){
                Actions actions=new Actions(driver);
                actions.moveToElement(coloursNotChecked.get(colourChosen));
                actions.click().build().perform();
            }
            wait.until(ExpectedConditions.elementToBeSelected(coloursNotChecked.get(colourChosen)));
            WebElement currentSelected=product.findElement(By.cssSelector(" div.ProductTile_content__a5cd2 input[data-testid='swatch-item-6']:checked"));
            String currentColour=driver.findElement(By.cssSelector("label[for='"+currentSelected.getAttribute("id")+"'] span.sr-only")).getText();
            Log.info("Current Colour "+currentColour);
            return currentSelected.isSelected()&&getProductTiles().get(productNumber).findElement(productImage)
                    .getAttribute("src").contains(currentColour.replace("Color ",""));

        }
        else if(coloursNotChecked.size()==1){
            WebElement checkedColour=product.findElement(By.cssSelector("div[role='radiogroup'] input[data-testid='swatch-item-6']:checked"));
            String checkedColourText=driver.findElement(By.cssSelector("label[for='"+checkedColour.getAttribute("id")+"'] span.sr-only")).getText();
            Log.info("Colour before switching "+checkedColourText);
            String colourToBeSelected=driver.findElement(By.cssSelector("label[for='"+coloursNotChecked.get(0).getAttribute("id")+"'] span.sr-only")).getText();
            Log.info("Colour To Be Selected: "+colourToBeSelected);
            try {
                coloursNotChecked.get(0).click();
            }
            catch (ElementClickInterceptedException e){
                Actions actions=new Actions(driver);
                actions.moveToElement(coloursNotChecked.get(0));
                actions.click().build().perform();
            }
            wait.until(ExpectedConditions.elementToBeSelected(coloursNotChecked.get(0)));
            WebElement currentSelected=product.findElement(By.cssSelector(" div.ProductTile_content__a5cd2 input[data-testid='swatch-item-6']:checked"));
            String currentColour=driver.findElement(By.cssSelector("label[for='"+currentSelected.getAttribute("id")+"'] span.sr-only")).getText();
            Log.info("Current Colour "+currentColour);
            String colourContent=currentSelected.getAttribute("value");
            Log.info("After Trimming "+colourContent);
            Log.info(currentSelected.findElement(By.xpath("//input[@id='"+currentSelected.getAttribute("id")+"']/ancestor::div[@class='ProductTile_content__a5cd2']/preceding-sibling::div[@data-testid='product-image']/a"))
                    .getAttribute("href"));
            return coloursNotChecked.get(0).isSelected()&&currentSelected.findElement(By.xpath("//input[@id='"+currentSelected.getAttribute("id")+"']/ancestor::div[@class='ProductTile_content__a5cd2']/preceding-sibling::div[@data-testid='product-image']/a"))
                    .getAttribute("href").contains(colourContent);
        }
        else{
            return true;
        }
    }
    public int randomNumberChoose(List<WebElement> webElementList){
        return random.nextInt(webElementList.size());
    }
    public void selectSizeSelector() {
        wait.until(ExpectedConditions.visibilityOf(productHeading));
        Actions action = new Actions(driver);
        int productIndex = random.nextInt(getProductTiles().size());
        action.moveToElement(getProductTiles().get(productIndex).findElement(productImage)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        getProductTiles().get(productIndex).findElement(addToCartButton).click();
    }

    public List<WebElement> getProductTiles()  {
        //wait.until(ExpectedConditions.visibilityOf(productHeading));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTileCss));
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productHeading);
        Log.info("Size of the productTiles: " + driver.findElements(productTileCss).size());
        return driver.findElements(productTileCss);
    }

    public boolean sizeBoxVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sizeBox));
        return driver.findElement(sizeBox).isDisplayed();
    }

    public void addTheItemToCart() {
        //wait.until(ExpectedConditions.visibilityOf(productHeading));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTileCss));
        Actions action = new Actions(driver);
        int productIndex = random.nextInt(getProductTiles().size());
        WebElement element= getProductTiles().get(productIndex);
        action.moveToElement(element).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        action.moveToElement(driver.findElement(By.xpath("//button[text()='Add to bag']"))).click().build().perform();
       // wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sizeButton));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        List<WebElement> sizeChart = element.findElements(sizeButton);
        int sizeSelected = random.nextInt(sizeChart.size());
        String id=sizeChart.get(sizeSelected).getAttribute("id");
        Log.info("ID: "+id);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.id(id)));
        //driver.findElement(By.id(id)).click();
        wait.until(ExpectedConditions.elementToBeClickable(element.findElement(By.xpath("//button[text()='Add to bag']"))));
        //action.moveToElement(element.findElement(By.xpath("//button[text()='Add to bag']")));
        driver.findElement(By.xpath("//button[text()='Add to bag']")).click();
    }

    public void selectOutOfStockSizes(){
        wait.until(ExpectedConditions.visibilityOf(productHeading));
        Actions action = new Actions(driver);
        int productIndex = random.nextInt(getProductTiles().size());
        WebElement element= getProductTiles().get(productIndex);
        action.moveToElement(element).build().perform();
        wait.until(ExpectedConditions.visibilityOf(element.findElement(addToCartButton)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        action.moveToElement(element.findElement(addToCartButton)).click().build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public boolean itemAddedToCart() {
        wait.until(ExpectedConditions.visibilityOf(dialogHeading));
        Log.info("Text on dialog box: " + dialogHeading.getText());
        return dialogHeading.getText().equals("Item added to bag!");
    }

    public void navigateToMyCart(){
        wait.until(ExpectedConditions.visibilityOf(dialogHeading));
        driver.findElement(By.xpath("//button[text()='View bag']")).click();
    }

    public void pageLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTile));
        Log.info("Page has been loaded");
    }

    public boolean categorySelected() {
        wait.until(ExpectedConditions.visibilityOf(selectedCategory));
        Log.info("Selected Category : " + selectedCategory.getText());
        Log.info("Heading : " + productHeading.getText());
        return selectedCategory.getText().equals(productHeading.getText());
    }

    public void scrollBelow() {
        int productSize=getProductTiles().size();
        Actions actions=new Actions(driver);
        actions.moveToElement(getProductTiles().get(productSize-1));
    }

    public void loadMoreButton() throws InterruptedException {
        try {
            while (loadMoreButton.isDisplayed()){
                loadMoreButton.click();
                Thread.sleep(1000);
            }
        } catch (NoSuchElementException | org.openqa.selenium.StaleElementReferenceException exception) {
            Log.info("all items loaded");
        }
    }

    public void clickLoadMore() {
        //wait.until(ExpectedConditions.visibilityOf(loadMoreButton));
        if(getProductTiles().size()<=30){
            Log.info("All product loaded");
        }
        else {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loadMoreButton);
            }
            catch (NoSuchElementException nsee){
                Log.info("all products loaded");
            }
        }
    }

    public void outOfStockSize() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(productHeading));
        ArrayList<String> data = DataDriven.getTestData("PLP", "Out Of Stock-Size");
        ArrayList<String> sizeData = DataDriven.getTestData("PLP", "Sizes");
        for (WebElement product : getProductTiles()) {
            if (product.findElement(productName).getText().equals(data.get(3))) {
                Actions actions = new Actions(driver);
                actions.moveToElement(product).build().perform();
                wait.until(ExpectedConditions.visibilityOf(product.findElement(addToCartButton)));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
                actions.moveToElement(product.findElement(addToCartButton)).click().build().perform();
                wait.until(ExpectedConditions.visibilityOfElementLocated(sizeBox));
                for (int i = 1; i < sizeData.size(); i++) {
                    driver.findElement(By.xpath("//input[@name='addToBagDesktop']/following-sibling::label[text()='" + sizeData.get(i) + "']")).getAttribute("aria-disabled").equals("true");
                }

            }
        }

    }

    public boolean topSearchResultDisplayed() {
        return resultTopHeading.getText().contains("Showing");
    }

    public boolean bottomSearchResultDisplayed() {
        return resultBottomHeading.getText().contains("Showing");
    }

    public void productLoaded()  {
        wait.until(ExpectedConditions.visibilityOf(productHeading));
        String resultDisplayed = resultTopHeading.getText().replace("Showing ", "");
        Log.info(resultDisplayed);
        Log.info("Product Count: " + resultDisplayed.substring(0, resultDisplayed.indexOf(" ")));
        String productDisplayed = resultDisplayed.substring(0, resultDisplayed.indexOf(" "));
        Log.info("Products Displayed: " + productDisplayed);
        if (Integer.parseInt(productDisplayed) == 30) {
            String totalProductsDisplayed = resultDisplayed.replace("30 of ", "");
            Log.info("Trimmed List: " + totalProductsDisplayed);
            String totalProducts = totalProductsDisplayed.replaceAll("\\D+", "");
            Log.info("Total Products: " + totalProducts);
            if (Integer.parseInt(totalProducts) > 30) {
                try {
                    do {
                        Log.info("Product Displayed :" + getProductTiles().size());
                        loadMoreButton.click();
                        Log.info("Load More Button Clicked");
                    } while (loadMoreButton.isDisplayed());
                } catch (NoSuchElementException | org.openqa.selenium.StaleElementReferenceException exception) {
                    Log.info("all items loaded");
                }
            }
        } else {
            Log.info("Products are less than 30");
        }

    }

    public boolean allProductsLoaded() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(resultTopHeading));
        String[] words=resultTopHeading.getText().split(" ");
        Log.info(words[1]);
        Log.info("Product Count: " + words[1]);
        int resultNumber=Integer.parseInt(words[1]);
        String totalProducts = words[3];
        int totalProductNumber=Integer.parseInt(words[3]);
        Log.info("Total Products: "+totalProducts);
        if(totalProductNumber>30 && resultNumber<30 ){
            return false;
        }
        else {
            loadMoreButton();
            return getProductTiles().size() == Integer.parseInt(totalProducts);
        }
    }

    public boolean backToTopVisible() throws InterruptedException {
        loadMoreButton();
        wait.until(ExpectedConditions.visibilityOf(backToTopButton));
        return backToTopButton.isDisplayed();
    }

    public boolean breadCrumbsVisible() {

        return breadCrumb.isDisplayed();
    }

    public boolean breadCrumbContent() {
        Log.info("Item 1: "+driver.findElements(breadCrumbItems).get(0).getAttribute("title"));
        Log.info("Item 2: "+driver.findElements(breadCrumbItems).get(2).getAttribute("title"));
        return driver.findElements(breadCrumbItems).get(0).getAttribute("title").equals("Home") &&
                driver.findElements(breadCrumbItems).get(2).getAttribute("title").equals(selectedCategory.getText());
    }
    public boolean breadCrumbsHomeClickable() throws IOException {
        Base base=new Base();
        Log.info("1st item: "+ driver.findElements(breadCrumbItems).get(0).getText());
        driver.findElements(breadCrumbItems).get(0).findElement(By.xpath(" a")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.category-navigation")));
        return driver.getCurrentUrl().equals(base.loadProperties("url"));
    }
    public boolean breadCrumbCategoryClickable(){
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(breadCrumbItems));
        String category=driver.findElements(breadCrumbItems).get(1).getText();
        driver.findElements(breadCrumbItems).get(1).click();
        Log.info("Category: "+category);
        return category.equals(productHeading.getText());
    }

    public boolean linkHref() {
        List<WebElement> listCategories = driver.findElements(categoryList);
        List<Boolean> attributeValue = new ArrayList<Boolean>();
        for (int i = 0; i < listCategories.size(); i++) {
            Log.info("Href Link: " + listCategories.get(i).getAttribute("href"));
            Log.info("Aria-Label: " + listCategories.get(i).getAttribute("aria-label"));
            Log.info("After Modification: " + listCategories.get(i).getAttribute("aria-label")
                    .replace("Go to ", "").replaceAll("[^a-zA-Z]+", "-"));
            if (listCategories.get(i).getAttribute("aria-label").contains("Clearance")){
                break;
            }
            attributeValue.add(i, listCategories.get(i).getAttribute("href")
                    .contains(listCategories.get(i).getAttribute("aria-label")
                            .replace("Go to ", "").replaceAll("[^a-zA-Z]+", "-")));
        }
        for (boolean b : attributeValue) {
            Log.info(String.valueOf(b));
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public boolean categoryDisplayed() {
        return categoryButton.isDisplayed();
    }

    public void collapseCategory() {
        wait.until(ExpectedConditions.visibilityOf(categoryButton));
        if (categoryButton.getAttribute("aria-expanded").equals("true")) {
            categoryButton.click();
        } else {
            Log.error("The category is already collapsed");
        }
    }

    public boolean validateCategoryCollapse() {
        return categoryButton.getAttribute("aria-expanded").equals("false");
    }

    public boolean validateFilters() {
        List<String> accordionText = new ArrayList<>();
        List<String> expectedAccordion = Arrays.asList("Category", "Type", "Colour", "Size", "Price");
        for (WebElement accordion : driver.findElements(accordionHeadings)) {
            accordionText.add(accordion.getText());
        }
        return accordionText.equals(expectedAccordion);
    }

    public boolean validateFiltersUnchechecked() {
        try {
            for (WebElement showMore : driver.findElements(showMoreFilters)) {
                showMore.click();
            }
        } catch (NoSuchElementException e) {
            Log.info("All fiters loaded");
        }
        for (WebElement input : driver.findElements(inputFilter)) {
            Log.info("Filter: " + input.getText());
            Log.info("Attribute Value: " + input.getAttribute("aria-selected"));
            if (input.getAttribute("aria-selected").equals("true")) {
                return false;
            }

        }
        return true;
    }

    public boolean numbersDisplayedInFilter() {
        try {
            for (WebElement filter : driver.findElements(inputFilter)) {
                Log.info("Filter Number: " + filter.getText().replaceAll("\\D+", ""));
                Integer.parseInt(filter.getText().replaceAll("\\D+", ""));
            }
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    public boolean validateFilterChecked(){
        wait.until(ExpectedConditions.visibilityOf(productHeading));
        int filterNumber=random.nextInt(driver.findElements(inputFilter).size());
        String id=driver.findElements(inputFilter).get(filterNumber).getAttribute("id");
        Log.info("ID: "+id);
        driver.findElement(By.id(id)).click();
        Log.info("aria-selected: "+driver.findElement(By.id(id)).getAttribute("aria-selected"));
        wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.id(id)),"aria-selected","true"));
        //wait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.id(id))));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return driver.findElement(By.id(id)).getAttribute("aria-selected").equals("true");

    }

    public boolean validateFilterAndProductCount() throws InterruptedException {
        String filterName= driver.findElement(By.xpath("//li[@role='option'][@aria-selected='true']")).getText();
        String filterNumber=filterName.substring(filterName.indexOf("("),filterName.length()-1).replaceAll("\\D+","");
        Log.info("Filter: "+filterName+" Number: "+filterNumber);
        loadMoreButton();
        return Integer.parseInt(filterNumber)==getProductTiles().size();
    }

    public boolean validateCollapse(){
        wait.until(ExpectedConditions.visibilityOf(productHeading));
        List<WebElement> filterHeadings=driver.findElements(accordionHeadings);
        int filterHeading=random.nextInt(filterHeadings.size());
        filterHeadings.get(filterHeading).click();
        return filterHeadings.get(filterHeading).getAttribute("aria-expanded").equals("false");
    }

    public void collapseAllFilters(){
        wait.until(ExpectedConditions.visibilityOf(productHeading));
        List<WebElement> filterHeaders=driver.findElements(accordionHeadings);
        for (WebElement header:filterHeaders){
            try {
                if (header.getAttribute("aria-expanded").equals("true")){
                    header.click();
                }
            }
            catch (ElementClickInterceptedException ex){
                ((JavascriptExecutor)driver).executeScript("arguments[0].click()",header);
            }
        }
    }

    public boolean expandAccordion(){
        int randomFilter=random.nextInt(driver.findElements(accordionHeadings).size());
        try {
            driver.findElements(accordionHeadings).get(randomFilter).click();
        }catch (ElementClickInterceptedException ex){
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();",driver.findElements(accordionHeadings).get(randomFilter));
        }
       // wait.until(ExpectedConditions.attributeToBe(driver.findElements(accordionHeadings)))
        return driver.findElements(accordionHeadings).get(randomFilter).getAttribute("aria-expanded").equals("true");
    }

    public boolean sortDisplayed(){
        Log.info("Default Sorting: "+sortItem.getText());
        return sortItem.isDisplayed() && sortItem.getText().equals("Sort by: Featured");
    }

    public boolean sortItemsDropdown(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sortButtons));
        List<String> sortItems= Arrays.asList("Newest","Price: Low to High","Price: High to Low","Popular","Featured");
        List<WebElement> sortItemElements=driver.findElements(sortButtons);
        List<String> sortItemElementText=new ArrayList<String>();
        for (WebElement sortItemElement:sortItemElements){
            sortItemElementText.add(sortItemElement.getText());
        }
        return sortItems.equals(sortItemElementText);
    }

    public void clickSortButton(){
        wait.until(ExpectedConditions.visibilityOf(sortItem));
        sortItem.click();
    }

    public void checkFilter()  {
        wait.until(ExpectedConditions.visibilityOf(productHeading));
        int filterChecked= random.nextInt(driver.findElements(inputFilter).size());
        String id=driver.findElements(inputFilter).get(filterChecked).getAttribute("id");
        Log.info("Filter Checked: "+driver.findElements(inputFilter).get(filterChecked).getText());
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",driver.findElement(By.id(id)));
        wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.id(id)),"aria-selected","true"));
    }

    public List<WebElement> getCheckedFilters() throws InterruptedException {
        Thread.sleep(1000);
        Log.info("Elements array size: "+driver.findElements(checkedFilters).size());
        for (WebElement e:driver.findElements(checkedFilters)){
            Log.info("Checked Filter: "+e.getText());
        }
        return driver.findElements(checkedFilters);
    }

    public boolean validateFilterAfterReload() throws InterruptedException {
        Thread.sleep(2000);
        checkFilter();
        List<String> beforeReload=getElementText(getCheckedFilters());
        Log.info("Web: "+beforeReload);
        driver.navigate().refresh();
        Log.info("Page has been reloaded");
        Thread.sleep(1000);
        List<String> afterReload=getElementText(getCheckedFilters());
        Log.info("Before Reload: ");
        Log.info("Web: "+beforeReload);
        Log.info("After Reload: ");
        Log.info("Web: "+afterReload);
        return beforeReload.equals(afterReload);
    }

    public void logWebelementText(List<WebElement> webElementList){
        for (WebElement webElement:webElementList){
            Log.info("Webelement Referred: "+webElement.getText());
        }
    }
    public List<String> getElementText(List<WebElement> webElements){
        List<String> textElements=new ArrayList<>();
        for (WebElement webElement:webElements){
            textElements.add(webElement.getText());
        }
        return textElements;
    }

    public boolean validateFilterAfterLoadMore() throws InterruptedException {
        checkFilter();
        List<String> beforeLoading=getElementText(getCheckedFilters());
        Log.info("Web: "+beforeLoading);
        loadMoreButton();
        List<String> afterProductLoad=getElementText(getCheckedFilters());
        Log.info("Before Reload: ");
        Log.info("Web: "+beforeLoading);
        Log.info("After Reload: ");
        Log.info("Web: "+afterProductLoad);
        return beforeLoading.equals(afterProductLoad);
    }

    public boolean validateSortAfterLoad() throws InterruptedException {
        clickSortButton();
        int randomSortItem=random.nextInt(driver.findElements(unselectedSortItem).size());
        Log.info("Item To Be Selected: "+driver.findElements(unselectedSortItem).get(randomSortItem).getText());
        driver.findElements(unselectedSortItem).get(randomSortItem).click();
        Thread.sleep(1000);
        String beforeLoadSort=selectedSortItem.getText();
        Log.info("Sort Value before Load: "+beforeLoadSort);
        clickLoadMore();
        clickLoadMore();
        String afterLoadSort=selectedSortItem.getText();
        Log.info("Sort Value after Load: "+afterLoadSort);
        return beforeLoadSort.equals(afterLoadSort);
    }
    public boolean validateFilterAfterPdp() throws InterruptedException {
        checkFilter();
        List<String> beforeVisitingPdp=getElementText(getCheckedFilters());
        Log.info("Checked filters before PDP: "+beforeVisitingPdp);
        int randomProductSelected=random.nextInt(getProductTiles().size());
        Log.info("Name of the product: "+getProductTiles().get(randomProductSelected).findElement(productName).getText());
        getProductTiles().get(randomProductSelected).click();
        wait.until(ExpectedConditions.visibilityOf(productPdpImage));
        Log.info("Image Displayed: "+productPdpImage.isDisplayed());
        driver.navigate().back();
        Thread.sleep(1000);
        List<String> afterVisitingPdp=getElementText(getCheckedFilters());
        Log.info("Checked filters after PDP: "+afterVisitingPdp);
        return beforeVisitingPdp.equals(afterVisitingPdp)&&getProductTiles().get(randomProductSelected).isDisplayed();

    }

    public boolean isImageVisible(){
        wait.until(ExpectedConditions.visibilityOf(productPdpImage));
        Log.info("Image Displayed: "+productPdpImage.isDisplayed());
        return productPdpImage.isDisplayed();
    }

    public List<WebElement> getCollectionProducts(){
        Log.info("Total Products: "+driver.findElements(collectionProducts).size());
        return driver.findElements(collectionProducts);
    }

    public boolean filterSortNotDisplayed(){
        try {
            if (filterWrapper.isDisplayed()&&sortItem.isDisplayed()){
                return false;
            }
        }catch (NoSuchElementException e){
            return true;
        }
        return false;
    }

    public boolean productInfoDisplayed(){
        wait.until(ExpectedConditions.visibilityOfAllElements(getCollectionProducts()));
        Actions actions=new Actions(driver);
        if(getCollectionProducts().size()==0){
            Log.info("Products on collection: "+getCollectionProducts().size());
            return false;
        }
        try {
            for (int i=0;i<getCollectionProducts().size();i++) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",getCollectionProducts().get(i));
                driver.findElements(productImage).get(i).isDisplayed();
                driver.findElements(collectionProductHeading).get(i).isDisplayed();
                Log.info("Product: "+driver.findElements(collectionProductHeading).get(i).getText());
                //element.findElement(collectionColourSwatch).isDisplayed();
                actions.moveToElement(getCollectionProducts().get(i)).build().perform();
                wait.until(ExpectedConditions.visibilityOf(getCollectionProducts().get(i).findElement(addToCartButton)));
                getCollectionProducts().get(i).findElement(addToCartButton).isDisplayed();
            }
        }
        catch (NoSuchElementException e){
            Log.error(e.getMessage());
            return false;
        }
        return true;
    }

    public void visitPdp(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTile));
        int randomNumber=random.nextInt(getProductTiles().size());
        getProductTiles().get(randomNumber).click();
    }

    public boolean verifyPriceLowToHigh()  {
        clickLoadMore();
        clickLoadMore();
        //By priceLowToHigh=By.xpath("//button[@class='SortDesktop_menuItem__Y6vxB'][text()='Price: Low to High']");
        try {
            sortItem.click();
        }
        catch (ElementClickInterceptedException eci){
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",sortItem);
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();",sortItem);
        }
        wait.until(ExpectedConditions.elementToBeClickable(lowToHighButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",lowToHighButton);
        List<Float> price= new ArrayList<>();
        for (WebElement product:getProductTiles()){
            Log.info(product.getText());
            try {
                price.add(Float.parseFloat(product.findElement(salePrice).getText().replaceAll("[^\\d.]","")));
            }
            catch (NoSuchElementException e){
                {
                    try {

                        price.add(Float.parseFloat(product.findElement(By.cssSelector("span.ProductPrice_price__XUX4C")).getText().replaceAll("[^\\d.]", "")));
                    }
                    catch (NoSuchElementException nse){
                        price.add(Float.parseFloat(product.findElement(By.cssSelector("span.ProductPrice_eachPrice__0hB2Z")).getText().replaceAll("[^\\d.]", "")));
                    }
                }
            }
        }
        Log.info("Active Price: "+price);
        for (int i=0;i<price.size()-1;i++){
            if(price.get(i)>price.get(i+1)){
                return  false;
            }
        }
        return true;
    }

    public boolean verifyPriceHighToLow()  {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTileCss));
        clickLoadMore();
        clickLoadMore();
        try {
            sortItem.click();
        }
        catch (ElementClickInterceptedException eci){
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",sortItem);
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();",sortItem);
        }
        wait.until(ExpectedConditions.elementToBeClickable(highToLowButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",highToLowButton);
        List<Float> price= new ArrayList<>();
        for (WebElement product:getProductTiles()){
            try {
                price.add(Float.parseFloat(product.findElement(salePrice).getText().replaceAll("[^\\d.]","")));
            }
            catch (NoSuchElementException e){
                try {
                    price.add(Float.parseFloat(product.findElement(regularPrice).getText().replaceAll("[^\\d.]", "")));
                }
                catch (NoSuchElementException ex) {
                    try {
                     price.add(Float.parseFloat(product.findElement(By.cssSelector("div.ProductPrice_small__iGJNZ span.ProductPrice_price__XUX4C")).getText().replaceAll("[^\\d.]", "")));
                    }
                    catch (NoSuchElementException nse){
                        price.add(Float.parseFloat(product.findElement(By.cssSelector("span.ProductPrice_eachPrice__0hB2Z")).getText().replaceAll("[^\\d.]", "")));
                    }
                }
            }

        }
        Log.info("Price: "+price);
        for (int i=0;i<price.size()-1;i++){
            if(price.get(i)<price.get(i+1)){
                return  false;
            }
        }
        return true;
    }


    public boolean salePriceAndBadgeDisplayed()  {
        driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='Sale & Offers']")).click();
        driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_twoColumn__wiv9Y']//descendant::a[text()='Women']")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTile));
        List<WebElement> productTilesOnSalesAndOffers=getProductTiles();
        clickLoadMore();
        clickLoadMore();
        for(int i=0;i<getProductTiles().size();i++){
            try{
                if(!(productTilesOnSalesAndOffers.get(i).findElement(By.cssSelector("div.ProductPrice_small__iGJNZ span.ProductPrice_salePrice__uPZ5p")).isDisplayed()&&
                        productTilesOnSalesAndOffers.get(i).findElement(By.cssSelector("div.ProductPrice_small__iGJNZ span.ProductPrice_regularPrice__P7kc1")).isDisplayed()&&productTilesOnSalesAndOffers.get(i).findElement(By.cssSelector("div.ProductTile_textContainer__pTHu4 span.Badge_small___RdFM")).isDisplayed())){
                    return false;
                }}
            catch (NoSuchElementException nsee){
                return false;
            }

        }
        return true;
    }

    public boolean fourofour(){
        driver.navigate().to(driver.getCurrentUrl()+"51254");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.NotFound_heading__l1ydW")));
        return driver.findElement(By.cssSelector("h1.NotFound_heading__l1ydW")).isDisplayed();
    }

    public boolean removeFilter() throws InterruptedException {
        checkFilter();
        checkFilter();
        checkFilter();
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
       return driver.findElements(selectedCheckBox).size()==2;
    }

    public boolean multipleCheckFilters()  {
        checkFilter();
        checkFilter();
        checkFilter();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver.findElements(selectedCheckBox).size()==3;
    }

    public boolean outOfStockNotPresent() throws IOException, InterruptedException {
        List<String> outOfStockItems=DataDriven.getTestData("PLP","Out of Stock Item");
        loadMoreButton();
        for (WebElement product:getProductTiles()){
            if(product.findElement(productName).getText().equals(outOfStockItems.get(1))){
                return false;
            }
        }
        return true;
    }
    public String returnPrice() {
        try {
            return driver.findElement(salePrice).getText();
        } catch (NoSuchElementException ex) {
            return driver.findElement(By.cssSelector("div.ProductPrice_small__iGJNZ span.ProductPrice_price__XUX4C")).getText();
        }
    }

    public String modalReturnPrice(){
        try {
            return driver.findElement(By.cssSelector("div.ProductPrice_modal__lHPlr span.ProductPrice_salePrice__uPZ5p")).getText();
        } catch (NoSuchElementException ex) {
            return driver.findElement(By.cssSelector("div.ProductPrice_modal__lHPlr span.ProductPrice_price__XUX4C")).getText();
        }
    }

    public void addAllVariants(){
        Actions action=new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTileCss));
        for (WebElement colour: driver.findElements(colourSwatch)){
            action.moveToElement(driver.findElement(productImage)).build().perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            action.moveToElement(driver.findElement(By.xpath("//button[text()='Add to bag']"))).click().build().perform();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            for(WebElement size:driver.findElements(sizeButton)){
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();",size);
            }
        }
    }

    public boolean outOfStockItems() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTileCss));
        loadMoreButton();
        Actions action = new Actions(driver);
        for (WebElement productTile:getProductTiles()){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",productTile);
            action.moveToElement(productTile).build().perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
            productTile.findElement(addToCartButton).click();
            if(driver.findElements(By.xpath("//input[@name='addToBagDesktop'][@aria-disabled='false']")).size()<1){
                return false;
            }
        }
        return true;
    }

    public boolean plpSizesSameAsPdp(){
        Actions action=new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTileCss));
        int productIndex = random.nextInt(getProductTiles().size());
        WebElement element= getProductTiles().get(productIndex);
        action.moveToElement(element).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        action.moveToElement(driver.findElement(By.xpath("//button[text()='Add to bag']"))).click().build().perform();
        // wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sizeButton));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        List<WebElement> sizeChart = element.findElements(By.xpath("//input[@name='addToBagDesktop']"));
        int sizeOnPlp=sizeChart.size();
        Log.info("Plp size: "+sizeOnPlp);
        action.moveToElement(driver.findElements(productName).get(productIndex)).click().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[data-testid='zoomImg0']")));
        int sizeOnPdp=driver.findElements(By.cssSelector("input[name='addToBagPdp']")).size();
        Log.info("PDP size: "+sizeOnPdp);
        return sizeOnPlp==sizeOnPdp;
    }

    public void clickViewBagButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View bag']")));
        driver.findElement(By.xpath("//button[text()='View bag']")).click();
    }

    public void addAllAvailableSizesFromPlp(WebElement element)  {
        Actions action=new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTileCss));
        action.moveToElement(element).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        action.moveToElement(driver.findElement(By.xpath("//button[text()='Add to bag']"))).click().build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        int availableSizes = element.findElements(sizeButton).size();
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",element.findElements(sizeButton).get(0));
        wait.until(ExpectedConditions.elementToBeClickable(element.findElement(By.xpath("//button[text()='Add to bag']"))));
        try {
            driver.findElement(By.xpath("//button[text()='Add to bag']")).click();
            wait.until(ExpectedConditions.visibilityOf(continueShopping));
        }
        catch (TimeoutException nsee){
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.ModalError_content__AZACs h1"),"No more stock"));
            driver.findElement(By.xpath("//button[text()='Close']")).click();
        }
        continueShopping.click();
       for (int i=1;i<availableSizes;i++){
            action.moveToElement(element).build().perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            action.moveToElement(driver.findElement(By.xpath("//button[text()='Add to bag']"))).click().build().perform();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
           ((JavascriptExecutor)driver).executeScript("arguments[0].click();",element.findElements(sizeButton).get(i));
           wait.until(ExpectedConditions.elementToBeClickable(element.findElement(By.xpath("//button[text()='Add to bag']"))));
           driver.findElement(By.xpath("//button[text()='Add to bag']")).click();
           try {
               wait.until(ExpectedConditions.visibilityOf(continueShopping));
               continueShopping.click();
           }
           catch (TimeoutException nsee){
               wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.ModalError_content__AZACs h1"),"No more stock"));
               driver.findElement(By.xpath("//button[text()='Close']")).click();
           }
        }
    }

    public ArrayList<String> productTitle(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTileCss));
        ArrayList<String> productNames=new ArrayList<>();
        for (WebElement element:driver.findElements(By.cssSelector("div.ProductTile_image__sBbV_ a"))){
            productNames.add(element.getAttribute("href"));
        }
        Log.info("Product Names: "+productNames);
        return productNames;
    }

    public boolean validateAllProductsCanBeAddedToCart(String header,String menuItem) throws InterruptedException, IOException {
        Base base=new Base();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='headerXL']//button[text()='"+header+"']")));
        driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='New']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_twoColumn__wiv9Y']//descendant::a[text()='"+menuItem+"']")).click();
        loadMoreButton();
        ArrayList<String> productName=productTitle();
        Log.info("Product names: "+productName);
        try {
            for (int i=0;i<productName.size();i++){
                base.initializeDriver();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='headerXL']//button[text()='"+header+"']")));
                driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='New']")).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_twoColumn__wiv9Y']//descendant::a[text()='"+menuItem+"']")).click();
                //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTileCss));
                loadMoreButton();
                Log.info("Product: "+driver.findElement(By.xpath("//div[@class='ProductTile_image__sBbV_']//a[@href='"+productName.get(i)+"']//ancestor::div[@class='ProductTile_productTile__LOg79 cell medium-4 small-6']//p[@class='ProductTile_name__eAKRK']")));
                addAllAvailableSizesFromPlp(driver.findElement(By.xpath("//div[@class='ProductTile_image__sBbV_']//a[@href='"+productName.get(i)+"']//ancestor::div[@class='ProductTile_productTile__LOg79 cell medium-4 small-6']")));
                driver.quit();
            }
        }
        catch (NoSuchElementException nsee){
            return false;
        }
        return true;
    }

    public boolean validateAllProductsCanBeAddedToCartCommonCategory(String header,String type,String menuItem) throws InterruptedException, IOException {
        Base base=new Base();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='headerXL']//button[text()='"+header+"']")));
        driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='Toddlers']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//h3[text()='"+type+"']//following-sibling::ul//li[@class='MenuList_menuItem__a6CgE']//a[text()='"+menuItem+"']")).click();
        loadMoreButton();
        ArrayList<String> productName=productTitle();
        Log.info("Product names: "+productName);
        try {
            for (int i=0;i<productName.size();i++){
                base.initializeDriver();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='headerXL']//button[text()='"+header+"']")));
                driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='Toddlers']")).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.findElement(By.xpath("//h3[text()='"+type+"']//following-sibling::ul//li[@class='MenuList_menuItem__a6CgE']//a[text()='"+menuItem+"']")).click();
                loadMoreButton();
                Log.info("Product: "+driver.findElement(By.xpath("//div[@class='ProductTile_image__sBbV_']//a[@href='"+productName.get(i)+"']//ancestor::div[@class='ProductTile_productTile__LOg79 cell medium-4 small-6']//p[@class='ProductTile_name__eAKRK']")));
                addAllAvailableSizesFromPlp(driver.findElement(By.xpath("//div[@class='ProductTile_image__sBbV_']//a[@href='"+productName.get(i)+"']//ancestor::div[@class='ProductTile_productTile__LOg79 cell medium-4 small-6']")));
                driver.quit();
            }
        }
        catch (NoSuchElementException nsee){
            return false;
        }
        return true;
    }

    public boolean validateAllProductsCanBeAddedToCartDisneyAndMarvel(String menuItem) throws InterruptedException, IOException {
        Base base=new Base();
        driver.findElement(By.cssSelector("div#headerXL li.HeaderMenuDropdown_menuItem__9Qqgx button img")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//li[@class='MenuList_menuItem__a6CgE']//descendant::a[text()='"+menuItem+"']")).click();
        wait.until(ExpectedConditions.urlContains(menuItem.replace(" Shop","").toLowerCase()+"-collection"));
        loadMoreButton();
        ArrayList<String> productName=productTitle();
        Log.info("Product names: "+productName);
        try {
            for (int i=0;i<productName.size();i++){
                base.initializeDriver();
                driver.findElement(By.cssSelector("div#headerXL li.HeaderMenuDropdown_menuItem__9Qqgx button img")).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.findElement(By.xpath("//li[@class='MenuList_menuItem__a6CgE']//descendant::a[text()='"+menuItem+"']")).click();
                wait.until(ExpectedConditions.urlContains(menuItem.replace(" Shop","").toLowerCase()+"-collection"));
                loadMoreButton();
                Log.info("Product: "+driver.findElement(By.xpath("//div[@class='ProductTile_image__sBbV_']//a[@href='"+productName.get(i)+"']//ancestor::div[@class='ProductTile_productTile__LOg79 cell medium-4 small-6']//p[@class='ProductTile_name__eAKRK']")));
                addAllAvailableSizesFromPlp(driver.findElement(By.xpath("//div[@class='ProductTile_image__sBbV_']//a[@href='"+productName.get(i)+"']//ancestor::div[@class='ProductTile_productTile__LOg79 cell medium-4 small-6']")));
                driver.quit();
            }
        }
        catch (NoSuchElementException nsee){
            return false;
        }
        return true;
    }

    public boolean redirectColourSwatchToPdp(){
        return true;
    }

    public boolean validatePdpProductInfoEqualsPlp(WebElement element){
        Map<String,String>  plpInfo=new HashMap<String,String>();
        Map<String,String>  pdpInfo=new HashMap<String,String>();
        plpInfo.put("badge",element.findElement(badgePlp).getText());
        plpInfo.put("productName",element.findElement(productName).getText());
        try {
            plpInfo.put("salePrice",element.findElement(salePrice).getText());
            plpInfo.put("regularPrice",element.findElement(regularPrice).getText());
        }
        catch (NoSuchElementException nsee){
            plpInfo.put("salePrice","");
            plpInfo.put("regularPrice","");
        }
        try {
            plpInfo.put("bundlePrice",element.findElement(bundledSalePrice).getText());
            plpInfo.put("eachItemPrice",element.findElement(eachItemPrice).getText());
        }
        catch (NoSuchElementException nsee){
            plpInfo.put("bundlePrice","");
            plpInfo.put("eachItemPrice","");
        }
        try {
            plpInfo.put("onlyPrice",driver.findElement(onlyPrice).getText());
        }
        catch (NoSuchElementException nsee){
            plpInfo.put("onlyPrice","");
        }
        element.click();
        wait.until(ExpectedConditions.visibilityOf(productPdpImage));
        Log.info("PDP Badge: "+driver.findElement(badgePdp).getText());
        pdpInfo.put("badge",driver.findElement(badgePdp).getText());
        pdpInfo.put("productName",productHeadingPdp.getText());
        try {
            pdpInfo.put("salePricepdp",driver.findElement(salePrice).getText());
            pdpInfo.put("regularPricepdp",driver.findElement(regularPrice).getText());
        }
        catch (NoSuchElementException nsee){
            pdpInfo.put("salePricepdp","");
            pdpInfo.put("regularPrice","");
        }
        try {
            pdpInfo.put("bundlePrice",driver.findElement(bundledSalePrice).getText());
            pdpInfo.put("eachItemPrice",driver.findElement(eachItemPrice).getText());
        }
        catch (NoSuchElementException nsee){
            pdpInfo.put("bundlePrice","");
            pdpInfo.put("eachItemPrice","");
        }
        try {
            pdpInfo.put("onlyPrice",driver.findElement(onlyPrice).getText());
        }
        catch (NoSuchElementException nsee){
            pdpInfo.put("onlyPrice","");
        }
        Log.info("PLP :"+plpInfo);
        Log.info("PDP :"+pdpInfo);
        return plpInfo.equals(pdpInfo);
    }



    /*public boolean validateProductInformationOnPlpAndPdp(WebElement element){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTileCss));
        String badgeOnPlp=element.findElement(badgePlp).getText().trim();
        String productNamePlp=element.findElement(productName).getText();
        if(!salePriceAndRegularPriceEqual(element)){
            if (!bundledPriceAndEachPriceEqual())
        }
        wait.until(ExpectedConditions.visibilityOf(productPdpImage));
        String badgeOnPdp=driver.findElement(badgePdp).getText();


    }

    public boolean salePriceAndRegularPriceEqual(WebElement element){
        try {
            String salePriceOnPlp=element.findElement(salePrice).getText();
            String regularPriceOnPlp=element.findElement(regularPrice).getText();
            Log.info("Sale Price PLP: "+salePriceOnPlp);
            Log.info("Regular Price PLP: "+regularPriceOnPlp);
            element.click();
            wait.until(ExpectedConditions.visibilityOf(productPdpImage));
            String salePriceOnPdp=element.findElement(salePrice).getText();
            String regularPriceOnPdp=element.findElement(regularPrice).getText();
            Log.info("Sale Price PDP: "+salePriceOnPdp);
            Log.info("Regular Price PDP: "+regularPriceOnPdp);
            return salePriceOnPlp.equals(salePriceOnPdp)&&regularPriceOnPlp.equals(regularPriceOnPdp);
        }
        catch (NoSuchElementException nsee) {
            nsee.printStackTrace();
            return false;
        }
    }

    public boolean onlyPriceEqual(WebElement element){
        try {
            String onlyPriceOnPlp=element.findElement(onlyPrice).getText();
            Log.info("Only Price PLP: "+onlyPriceOnPlp);
            element.click();
            wait.until(ExpectedConditions.visibilityOf(productPdpImage));
            String onlyPriceOnPdp=element.findElement(onlyPrice).getText();
            return onlyPriceOnPlp.equals(onlyPriceOnPdp);
        }
        catch (NoSuchElementException nsee){
            nsee.printStackTrace();
            return  false;
        }
    }

    public boolean bundledPriceAndEachPriceEqual(WebElement element){
        try {
            String bundledSalePriceOnPlp=element.findElement(bundledSalePrice).getText();
            String eachItemPriceOnPlp=element.findElement(eachItemPrice).getText();
            Log.info("Sale Price PLP: "+bundledSalePriceOnPlp);
            Log.info("Regular Price PLP: "+eachItemPriceOnPlp);
            element.click();
            wait.until(ExpectedConditions.visibilityOf(productPdpImage));
            String bundledSalePriceOnPdp=element.findElement(bundledSalePrice).getText();
            String eachItemPriceOnPdp=element.findElement(eachItemPrice).getText();
            Log.info("Sale Price PDP: "+bundledSalePriceOnPdp);
            Log.info("Regular Price PDP: "+eachItemPriceOnPdp);
            return bundledSalePriceOnPlp.equals(bundledSalePriceOnPdp)&&eachItemPriceOnPlp.equals(eachItemPriceOnPdp);
        }
        catch (NoSuchElementException nsee) {
            nsee.printStackTrace();
            return false;
        }
    }*/



}

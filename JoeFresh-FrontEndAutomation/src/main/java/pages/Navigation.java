package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.DataDriven;
import util.Log;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Navigation {
    WebDriver driver;
    Random random;

    WebDriverWait wait;
    public Navigation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        random = new Random();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//div[@class='ResponsiveWrapper_largeAbove__L08sy']/h1")
    WebElement heading;

    By menuItem = By.xpath("//ul[@class='HeaderMenuListDesktop_menu__reUgZ']//li[@class='MenuList_menuItem__a6CgE']/a");
    By header = By.xpath("//div[@id='headerXL']//div[@class='ResponsiveWrapper_xlargeOnly__EF88U']/ul[@class='HeaderMenu_menu__uBzg3']//li[@class='HeaderMenuDropdown_menuItem__9Qqgx']/button");


    //ul[@class='HeaderMenuListDesktop_menu__reUgZ']//li[@class='MenuList_menuItem__a6CgE']/a//ancestor::div[@class='HeaderMenuListDesktop_twoColumn__wiv9Y']//child::h3

    @FindBy(xpath = "//div[@class='ResponsiveWrapper_largeAbove__L08sy']/h1")
    WebElement productHeading;

    public void navigateToCategory() throws IOException, InterruptedException {
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(header));
        List<WebElement> headerItems = driver.findElements(header);
        int headerSelected = random.nextInt(headerItems.size() - 3);
        Log.info("Header Selected: " + headerItems.get(headerSelected).getText());
        headerItems.get(headerSelected).click();
        Thread.sleep(1000);
        int menuSelected = selectRandomInteger(getMenuItems());
        if (getCollections().contains(getMenuItems().get(menuSelected).getText())) {
            menuSelected = selectRandomInteger(getMenuItems());
        }
        Log.info("Menu Item Selected: " + getMenuItems().get(menuSelected).getText());
        Log.info("Number of menu items: " + getMenuItems().size());
        getMenuItems().get(menuSelected).click();
    }


    public List<WebElement> getMenuItems() {
        return driver.findElements(menuItem);
    }

    public int selectRandomInteger(List list) {
        return random.nextInt(list.size());
    }

    public void selectMentionedHeader(String testCase) throws IOException, InterruptedException {
        String menuItemSelected = DataDriven.getTestData("PLP", testCase).get(2);
        List<WebElement> headerItems = driver.findElements(header);
        Log.info("Header: " + DataDriven.getTestData("PLP", testCase).get(1));
        for (WebElement headerItem : headerItems) {
            if (headerItem.getText().equals(DataDriven.getTestData("PLP", testCase).get(1))) {
                Log.info(headerItem.getText());
                headerItem.click();
                break;
            }
        }
        List<WebElement> menuItems = driver.findElements(menuItem);
        for (WebElement menu : menuItems) {
            if (menu.getText().equals(menuItemSelected)) {
                Log.info("Menu Item: " + DataDriven.getTestData("PLP", testCase).get(2));
                Log.info(menu.getText());
                menu.click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                break;
            }
        }

    }

    public ArrayList<String> getCollections() throws IOException {
        return DataDriven.getTestData("PLP", "Collections");
    }

    public void navigateToCollection() throws IOException {
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItem));
        List<String> headerItems = DataDriven.getTestData("PLP", "Collection Header");
        List<String> collectionPage = DataDriven.getTestData("PLP", "Collections");
        Log.info("Header Items: "+headerItems);
        Log.info("Collection Items:"+collectionPage);
        int headerSelected = ThreadLocalRandom.current().nextInt(1,headerItems.size());
        int collectionSelected = ThreadLocalRandom.current().nextInt(1,collectionPage.size());
        Log.info("Header to be selected: "+headerItems.get(headerSelected));
        Log.info("Collections to be selected: "+collectionPage.get(collectionSelected));
         for (WebElement header : driver.findElements(header)) {
            if (header.getText().equals(headerItems.get(headerSelected))) {
                header.click();
                Log.info("Header Selected: " + headerItems.get(headerSelected));
      break;
            }
        }
        for (WebElement menuItem : getMenuItems()) {
            if (menuItem.getText().equals(collectionPage.get(collectionSelected))) {
                menuItem.click();
                Log.info("Menu Item Selected: " + collectionPage.get(collectionSelected));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                break;
            }
        }

    }

    public boolean navigateNew() throws  IOException {
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItem));
        List<String> menuItems=DataDriven.getTestData("Navigation","New");
        List<String> menuItemsHeading=DataDriven.getTestData("Navigation","New Heading");
        Log.info("List menuItes"+menuItems);
        for (int i=1;i<menuItems.size();i++){
            driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='New']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_twoColumn__wiv9Y']//descendant::a[text()='"+menuItems.get(i)+"']")).click();
            wait.until(ExpectedConditions.textToBePresentInElement(heading,menuItemsHeading.get(i)));
            Log.info(heading.getText());
            Log.info(menuItemsHeading.get(i));
            if(!(heading.getText().equals(menuItemsHeading.get(i)))){
                  Log.info("Heading: "+heading.getText());
                Log.info("Menu Item: "+menuItemsHeading.get(i));
                return false;
            }
        }return true;
    }

    public boolean navigateWomen() throws IOException {
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItem));
        List<String> menuItems=DataDriven.getTestData("Navigation","Women");
        List<String> menuItemsHeading=DataDriven.getTestData("Navigation","Women Heading");
         Log.info("List menuItems"+menuItems);
        for (int i=1;i<menuItems.size();i++){
            driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='Women']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            if(menuItems.get(i).equals("All Promotions")||menuItems.get(i).equals("JF Classics")){
                driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_oneColumn__EI3h_']//descendant::a[text()='"+menuItems.get(i)+"']")).click();
                wait.until(ExpectedConditions.textToBePresentInElement(heading,menuItemsHeading.get(i)));
            }
            else {
                driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_threeColumn__Xf3nU']//descendant::a[text()='" + menuItems.get(i) + "']")).click();
                wait.until(ExpectedConditions.textToBePresentInElement(heading, menuItemsHeading.get(i)));
            }
            Log.info(heading.getText());
            Log.info(menuItemsHeading.get(i));
            if(!(heading.getText().equals(menuItemsHeading.get(i)))){
                Log.info("Heading: "+heading.getText());
                Log.info("Menu Item: "+menuItemsHeading.get(i));
                return false;
            }
        }return true;
    }

    public boolean navigateWomenPlus() throws InterruptedException, IOException {
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItem));
        List<String> menuItems=DataDriven.getTestData("Navigation","Women+");
        List<String> menuItemsHeading=DataDriven.getTestData("Navigation","Women+ Heading");
        Log.info("List menuItems"+menuItems);
        for (int i=1;i<menuItems.size();i++){
            driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='Women+']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_twoColumn__wiv9Y']//descendant::a[text()='"+menuItems.get(i)+"']")).click();
            wait.until(ExpectedConditions.textToBePresentInElement(heading,menuItemsHeading.get(i)));
            Log.info(heading.getText());
            Log.info(menuItemsHeading.get(i));
            if(!(heading.getText().equals(menuItemsHeading.get(i)))){
                return false;
            }
        }return true;
    }

    public boolean navigateActive() throws IOException, InterruptedException {
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItem));
        List<String> menuItems=DataDriven.getTestData("Navigation","Active");
        List<String> menuItemsHeading=DataDriven.getTestData("Navigation","Active Heading");
        Log.info("List menuItems"+menuItems);
        for (int i=1;i<menuItems.size();i++){
            driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='Active']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_oneColumn__EI3h_']//descendant::a[text()='"+menuItems.get(i)+"']")).click();
            wait.until(ExpectedConditions.textToBePresentInElement(heading,menuItemsHeading.get(i)));
            Log.info(heading.getText());
            Log.info(menuItemsHeading.get(i));
            if(!(heading.getText().equals(menuItemsHeading.get(i)))){
                Log.info("Heading: "+heading.getText());
                Log.info("Menu Item: "+menuItemsHeading.get(i));
                return false;
            }
        }return true;
    }

    public boolean navigateMen() throws IOException, InterruptedException {
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItem));
        List<String> menuItems=DataDriven.getTestData("Navigation","Men");
        List<String> menuItemsHeading=DataDriven.getTestData("Navigation","Men Heading");
        Log.info("List menuItems"+menuItems);
        for (int i=1;i<menuItems.size();i++){
            driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='Men']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            if(menuItems.get(i).equals("All Promotions")||menuItems.get(i).equals("Rain Shop")){
                driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_oneColumn__EI3h_']//descendant::a[text()='"+menuItems.get(i)+"']")).click();
                wait.until(ExpectedConditions.textToBePresentInElement(heading,menuItemsHeading.get(i)));
            }
            else {
                driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_twoColumn__wiv9Y']//descendant::a[text()='" + menuItems.get(i) + "']")).click();
                wait.until(ExpectedConditions.textToBePresentInElement(heading, menuItemsHeading.get(i)));
            }
            Log.info(heading.getText());
            Log.info(menuItemsHeading.get(i));
            if(!(heading.getText().equals(menuItemsHeading.get(i)))){
                Log.info("Heading: "+heading.getText());
                Log.info("Menu Item: "+menuItemsHeading.get(i));
                return false;
            }
        }return true;
    }

    public boolean navigateGirls() throws InterruptedException, IOException {
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItem));
        List<String> menuItems=DataDriven.getTestData("Navigation","Girls");
        List<String> menuItemsHeading=DataDriven.getTestData("Navigation","Girls Heading");
        Log.info("List menuItems"+menuItems);
        for (int i=1;i<menuItems.size();i++){
            driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='Girls']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            if(menuItems.get(i).equals("All Promotions")||menuItems.get(i).equals("Rain Shop")||menuItems.get(i).equals("Mix & Match")){
                driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_oneColumn__EI3h_']//descendant::a[text()='"+menuItems.get(i)+"']")).click();
                wait.until(ExpectedConditions.textToBePresentInElement(heading,menuItemsHeading.get(i)));
            }else {
                driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_twoColumn__wiv9Y']//descendant::a[text()='" + menuItems.get(i) + "']")).click();
                wait.until(ExpectedConditions.textToBePresentInElement(heading, menuItemsHeading.get(i)));
            }
            Log.info(heading.getText());
            Log.info(menuItemsHeading.get(i));
            if(!(heading.getText().equals(menuItemsHeading.get(i)))){
                Log.info("Heading: "+heading.getText());
                Log.info("Menu Item: "+menuItemsHeading.get(i));
                return false;
            }
        }return true;
    }

    public boolean navigateBoys() throws IOException {
       // wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItem));
        List<String> menuItems=DataDriven.getTestData("Navigation","Boys");
        List<String> menuItemsHeading=DataDriven.getTestData("Navigation","Boys Heading");
        Log.info("List menuItems"+menuItems);
        for (int i=1;i<menuItems.size();i++){
            driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='Boys']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            if(menuItems.get(i).equals("All Promotions")||menuItems.get(i).equals("Rain Shop")||menuItems.get(i).equals("Mix & Match")){
                driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_oneColumn__EI3h_']//descendant::a[text()='"+menuItems.get(i)+"']")).click();
                wait.until(ExpectedConditions.textToBePresentInElement(heading,menuItemsHeading.get(i)));
            }
            else {
                driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_twoColumn__wiv9Y']//descendant::a[text()='" + menuItems.get(i) + "']")).click();
                wait.until(ExpectedConditions.textToBePresentInElement(heading, menuItemsHeading.get(i)));
            }
            Log.info(heading.getText());
            Log.info(menuItemsHeading.get(i));
            if(!(heading.getText().equals(menuItemsHeading.get(i)))){
                Log.info("Heading: "+heading.getText());
                Log.info("Menu Item: "+menuItemsHeading.get(i));
                return false;
            }
        }return true;
    }

    public boolean navigateToddlersGirls() throws IOException {
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItem));
        List<String> menuItems=DataDriven.getTestData("Navigation","Toddler Girls");
        List<String> menuItemsHeading=DataDriven.getTestData("Navigation","Toddler Girls Heading");
        Log.info("List menuItems"+menuItems);
        for (int i=1;i<menuItems.size();i++){
            driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='Toddlers']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_twoColumn__wiv9Y']/h3[text()='Toddler Girls']//following-sibling::ul//descendant::a[text()='"+menuItems.get(i)+"']")).click();
            wait.until(ExpectedConditions.textToBePresentInElement(heading,menuItemsHeading.get(i)));
            Log.info(heading.getText());
            Log.info(menuItemsHeading.get(i));
            if(!(heading.getText().equals(menuItemsHeading.get(i)))){
                Log.info("Heading: "+heading.getText());
                Log.info("Menu Item: "+menuItemsHeading.get(i));
                return false;
            }
        }return true;
    }

    public boolean navigateToddlersBoys() throws IOException {
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItem));
        List<String> menuItems=DataDriven.getTestData("Navigation","Toddler Boys");
        List<String> menuItemsHeading=DataDriven.getTestData("Navigation","Toddler Boys Heading");
        Log.info("List menuItems"+menuItems);
        for (int i=1;i<menuItems.size();i++){
            driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='Toddlers']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_twoColumn__wiv9Y']/h3[text()='Toddler Boys']//following-sibling::ul//descendant::a[text()='"+menuItems.get(i)+"']")).click();
            wait.until(ExpectedConditions.textToBePresentInElement(heading,menuItemsHeading.get(i)));
            Log.info(heading.getText());
            Log.info(menuItemsHeading.get(i));
            if(!(heading.getText().equals(menuItemsHeading.get(i)))){
                Log.info("Heading: "+heading.getText());
                Log.info("Menu Item: "+menuItemsHeading.get(i));
                return false;
            }
        }return true;
    }

    public boolean navigateToddlerCommon() throws IOException{
        List<String> menuItems=DataDriven.getTestData("Navigation","Toddler Common");
        List<String> menuItemsHeading=DataDriven.getTestData("Navigation","Toddler Common  Heading");
        Log.info("List menuItems"+menuItems);
        Log.info("List menuItem Headings: "+menuItemsHeading);
        for (int i=1;i<menuItems.size();i++){
            driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='Toddlers']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_oneColumn__EI3h_']//descendant::a[text()='"+menuItems.get(i)+"']")).click();
            wait.until(ExpectedConditions.textToBePresentInElement(heading,menuItemsHeading.get(i)));
            Log.info(heading.getText());
            Log.info(menuItemsHeading.get(i));
            if(!(heading.getText().equals(menuItemsHeading.get(i)))){
                Log.info("Heading: "+heading.getText());
                Log.info("Menu Item: "+menuItemsHeading.get(i));
                return false;
            }
        }return true;
    }
    public boolean navigateBabyGirls() throws IOException, InterruptedException {
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItem));
        List<String> menuItems=DataDriven.getTestData("Navigation","Baby Girl");
        List<String> menuItemsHeading=DataDriven.getTestData("Navigation","Baby Girl Heading");
        Log.info("List menuItems"+menuItems);
        for (int i=1;i<menuItems.size();i++){
            driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='Baby']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_twoColumn__wiv9Y']/h3[text()='Shop Baby Girls']//following-sibling::ul//descendant::a[text()='"+menuItems.get(i)+"']")).click();
            wait.until(ExpectedConditions.textToBePresentInElement(heading,menuItemsHeading.get(i)));
            Log.info(heading.getText());
            Log.info(menuItemsHeading.get(i));
            if(!(heading.getText().equals(menuItemsHeading.get(i)))){
                Log.info("Heading: "+heading.getText());
                Log.info("Menu Item: "+menuItemsHeading.get(i));
                return false;
            }
        }return true;
    }
    public boolean navigateBabyBoys() throws IOException, InterruptedException {
       // wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItem));
        List<String> menuItems=DataDriven.getTestData("Navigation","Baby Boy");
        List<String> menuItemsHeading=DataDriven.getTestData("Navigation","Baby Boy Heading");
        Log.info("List menuItems"+menuItems);
        for (int i=1;i<menuItems.size();i++){
            driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='Baby']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_twoColumn__wiv9Y']/h3[text()='Shop Baby Boys']//following-sibling::ul//descendant::a[text()='"+menuItems.get(i)+"']")).click();
            wait.until(ExpectedConditions.textToBePresentInElement(heading,menuItemsHeading.get(i)));
            Log.info(heading.getText());
            Log.info(menuItemsHeading.get(i));
            if(!(heading.getText().equals(menuItemsHeading.get(i)))){
                Log.info("Heading: "+heading.getText());
                Log.info("Menu Item: "+menuItemsHeading.get(i));
                return false;
            }
        }return true;
    }
    public boolean navigateBabyCommon() throws IOException {
       // wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItem));
        List<String> menuItems=DataDriven.getTestData("Navigation","Baby Common");
        List<String> menuItemsHeading=DataDriven.getTestData("Navigation","Baby Common Heading");
        Log.info("List menuItems"+menuItems);
        for (int i=1;i<menuItems.size();i++){
            driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='Baby']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_oneColumn__EI3h_']//descendant::a[text()='"+menuItems.get(i)+"']")).click();
            wait.until(ExpectedConditions.textToBePresentInElement(heading,menuItemsHeading.get(i)));
            Log.info(heading.getText());
            Log.info(menuItemsHeading.get(i));
            if(!(heading.getText().equals(menuItemsHeading.get(i)))){
                Log.info("Heading: "+heading.getText());
                Log.info("Menu Item: "+menuItemsHeading.get(i));
                return false;
            }
        }return true;
    }
    public void navigatingSanity()  {
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItem));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='Women']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".HeaderMenuListDesktop_threeColumn__Xf3nU > ul[role='menu'] > li:nth-of-type(3) > a[role='menuitem']"))));
        driver.findElement(By.cssSelector(".HeaderMenuListDesktop_threeColumn__Xf3nU > ul[role='menu'] > li:nth-of-type(3) > a[role='menuitem']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public boolean navigatingCollectionRainShop() throws IOException, InterruptedException {
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItem));
        List<String> headerItems=DataDriven.getTestData("Navigation","Children’s Rain");
        for (int i=1;i<headerItems.size();i++){
            driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='"+headerItems.get(i)+"']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_oneColumn__EI3h_']//descendant::a[text()=\"Children's Rain\"]")).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.promo-content p"))));
            if(!(driver.findElement(By.cssSelector("div.promo-content p")).getText().equals("splash proof!"))){
                return false;
            }
        }
        return true;
    }
    public boolean navigatingCollectionBackToSchool() throws IOException, InterruptedException {
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItem));
        List<String> headerItems=DataDriven.getTestData("Navigation","Back To School");
        for (int i=1;i<headerItems.size();i++){
            driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='"+headerItems.get(i)+"']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_oneColumn__EI3h_']//descendant::a[text()='Back to School Shop']")).click();
            Thread.sleep(1000);
            if(!(driver.findElement(By.xpath("//p[@id='74qJQQiSM2hmynQGEZCKSt']")).getText().equals("big things are back"))){
                return false;
            }
        }
        return true;
    }

    public boolean navigatingChildrenCharity() throws IOException {
     //   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItem));
        List<String> headerItems=DataDriven.getTestData("Navigation","PC Children's Charity");
        for (int i=1;i<headerItems.size();i++) {
            driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='" + headerItems.get(i) + "']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_oneColumn__EI3h_']//descendant::a[text()=\"PC Children's Charity\"]")).click();
            wait.until(ExpectedConditions.urlContains("m-pc-childrens-charity"));
            if(!(driver.getCurrentUrl().contains("PC-Childrens-Charity"))){
                return false;
            }

        }
           // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@id='74qJQQiSM2hmynQGEZCKSt']"))));
        return true;
    }

    public boolean navigateDisney()  {
        driver.findElement(By.cssSelector("div#headerXL li.HeaderMenuDropdown_menuItem__9Qqgx button img")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//li[@class='MenuList_menuItem__a6CgE']//descendant::a[text()='Disney Shop']")).click();
        wait.until(ExpectedConditions.urlContains("disney-collection"));
        return driver.getCurrentUrl().contains("disney-collection");
        //return driver.findElement(By.xpath("//div[@class='rich-text css-oebsk2 e1jhomqc0']//p")).getText().equals("dream big");
    }
    public boolean navigateMarvel() {
        driver.findElement(By.cssSelector("div#headerXL li.HeaderMenuDropdown_menuItem__9Qqgx button img")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//li[@class='MenuList_menuItem__a6CgE']//descendant::a[text()='Marvel Shop']")).click();
        /*wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='rich-text css-oebsk2 e1jhomqc0']//p"))));
        return driver.findElement(By.xpath("//div[@class='rich-text css-oebsk2 e1jhomqc0']//p")).getText().equals("big snooze");*/
        wait.until(ExpectedConditions.urlContains("marvel-collection"));
        return driver.getCurrentUrl().contains("marvel-collection");
    }

    public void navigateJoeFreshDev(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='Women']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".HeaderMenuListDesktop_threeColumn__Xf3nU > ul[role='menu'] > li:nth-of-type(2) > a[role='menuitem']"))));
        driver.findElement(By.cssSelector(".HeaderMenuListDesktop_threeColumn__Xf3nU > ul[role='menu'] > li:nth-of-type(2) > a[role='menuitem']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void navigateWomenPlusCategory(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='headerXL']//button[text()='Women+']")));
        driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='Women+']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_twoColumn__wiv9Y']//descendant::a[text()='Dresses & Skirts']")).click();
    }

    public void navigationMoreThan30products(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='headerXL']//button[text()='Women']")));
        driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='Women+']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//div[@class='HeaderMenuListDesktop_twoColumn__wiv9Y']//descendant::a[text()='Sweaters']")).click();
    }

    public void navigateNewAndAddProducts() throws IOException {
        List<String> menuItems=DataDriven.getTestData("Navigation","New");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='headerXL']//button[text()='Women']")));
       // driver.findElement(By.xpath("//div[@id='headerXL']//button[text()='New']")).click();

    }


}
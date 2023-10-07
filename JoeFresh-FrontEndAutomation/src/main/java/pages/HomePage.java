package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.Base;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class HomePage extends Base {
    WebDriver driver;
    String Element;
    public Properties properties;
    public PDPPage pdppage;
    Random random;

    WebDriverWait wait;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        pdppage= new PDPPage(driver);
        random = new Random();
    }

    @FindBy(xpath = "//button[normalize-space()='Sign in']")
    public WebElement signInBtn;
    @FindBy(xpath = "//button[normalize-space()='Continue shopping']")
    public WebElement continueShopping;
    @FindBy(xpath = "//a[normalize-space()='Home']")
    public WebElement Home;

    @FindBy(xpath = "//li[@title=\"Women's Dresses\"]")
    public WebElement WomenDresses;
    @FindBy(xpath = "//a[normalize-space()='Women']")
    public WebElement Women;
    @FindBy(xpath = "//a[normalize-space()='Women+']")
    public WebElement Women2;
    @FindBy(xpath = "//a[normalize-space()='Men']")
    public WebElement MenBreadcrumb;
    @FindBy(xpath = "//a[normalize-space()='Girls']")
    public WebElement Girls;
    @FindBy(xpath = "//a[normalize-space()='Boys']")
    public WebElement Boys;
    @FindBy(xpath = "//a[normalize-space()='Toddler Girl']")
    public WebElement Toddler_Girl;
    @FindBy(xpath = "//a[normalize-space()='Toddler Boy']")
    public WebElement Toddler_Boy;
    @FindBy(xpath = "//a[normalize-space()='Baby']")
    public WebElement Baby;
    @FindBy(xpath = "//button[text()='My Account']")
    public WebElement myAccount;
    @FindBy(xpath = "(//a[@class='MyBagLink_container__xcIvf'])[1]")
    public WebElement MyBag;
    @FindBy(xpath = "//p[normalize-space()='Button Vest Cardi']")
    public WebElement selectItem_NameOfProduct;
    @FindBy(xpath = "//button[text()='Sign Out']")
    public WebElement signOut;

    @FindBy(xpath = "(//input[@placeholder='Search'])[1]")
    public WebElement searchBox;
    @FindBy(xpath = "(//img)[18]")
    public WebElement recommendedOptions;

    @FindBy(xpath = " //*[@id=\"__next\"]/div/div/main/div[2]/div[6]/div/div/ul/li[1]/a/img")
    public WebElement TrendingOptions;

    @FindBy(xpath = "(//a[normalize-space()='SHOP NOW'])[1]")
    public WebElement ShopNow1;

    @FindBy(xpath = "//h1[normalize-space()='Page not found']")
    public WebElement PageNotFound;


    @FindBy(xpath = "//a[@aria-label=\"Shop Women's New Arrivals\"]")
    public WebElement ShopWomenNewArrival;

    @FindBy(xpath = "//a[@aria-label='Shop the Disney Marvel Collection.'][normalize-space()='SHOP']")
    public WebElement MarvalCollection;

    @FindBy(xpath = "(//a[@aria-label='Shop the Disney Collection.'][normalize-space()='SHOP'])[1]")
    public WebElement DisneyCollection;
    @FindBy(xpath = "(//div[@class='heading-component css-c490sy e15cu9s70'])[1]")
    public WebElement disneyHeading;
    @FindBy(xpath = "(//button[text()=\"Men\"])[1]")
    public WebElement Men;
    @FindBy(xpath = "//a[text()=\"All Promotions\"]")
    public WebElement AllPromotions;
    @FindBy(xpath = "//img[@alt=\"Toddler Girls' Chambray Romper - Medium Wash\"]")
    public WebElement J1BProduct;




  By NavigationList = By.cssSelector("ul.HeaderMenuListDesktop_menu__reUgZ li.MenuList_menuItem__a6CgE");
    By NavigationListOnHomepage = By.cssSelector("ul.HeaderMenu_menu__uBzg3 li.HeaderMenuDropdown_menuItem__9Qqgx");
    By breadCrumbLinks= By.xpath("//a[@class=\"Breadcrumbs_link__NrH_Q\"]");
    By productTile = By.xpath("//div[@class='ProductTile_productTile__LOg79 cell medium-4 small-6']");



    public void searchProduct1() throws IOException {
        searchBox.sendKeys(loadProperties("Product1"));
    }
    public void searchProduct2() throws IOException {
        searchBox.sendKeys(loadProperties("Product2"));
    }
    public void searchProduct3() throws IOException {
        searchBox.sendKeys(loadProperties("Product3"));
    }
    public void searchProduct4() throws IOException {
        searchBox.sendKeys(loadProperties("Product4"));
    }
    public void DealsProductJA1() throws IOException {
        searchBox.sendKeys(loadProperties("DealsProductJA1"));
    }
    public void DealsProductJ1B() throws IOException {
        searchBox.sendKeys(loadProperties("DealsProductJ1B"));
    }

    public void searchProduct5() throws IOException {
        searchBox.sendKeys(loadProperties("Product5"));
    }



    public void openProduct() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchProduct1();
        searchBox.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pdppage.productList));
        pdppage.TankDress.click();
    }



    public void signIN(){
        signInBtn.click();
    }
    public void women(){
        Women.click();
    }





}





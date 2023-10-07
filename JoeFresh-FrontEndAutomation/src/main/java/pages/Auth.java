package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.DataDriven;
import util.Log;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Auth {
    WebDriver driver;
    WebDriverWait wait;
    FluentWait fluentWait;
    Random random;
    Actions actions;

    public Auth(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
        fluentWait=new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1));
        random=new Random();
        actions=new Actions(driver);
    }
    @FindBy(xpath = "//button[text()='Sign in']") WebElement signInButton;
    @FindBy(id = "email") WebElement pcEmail;
    @FindBy(id="password") WebElement password;
    @FindBy(xpath = "//button[text()='Sign In']") WebElement pcSignIn;
    @FindBy(css = "button.MyAccountDesktop_button__dRh5V") WebElement myAccountButton;
    @FindBy(css = "a.link--external[href='/create-account']") WebElement createAccountLink;
    @FindBy(id = "newPassword") WebElement signUppassword;
    @FindBy(id = "confirmPassword") WebElement confirmPassword;
    @FindBy(id = "termsAndConditions") WebElement termsAndConditionsLink;
    @FindBy(xpath = "//button[@class='button button--block button--submit button--theme-base button--theme-dark submit-button']") WebElement signUpButton;
    @FindBy(css = "#headerXL a[aria-label='Joe Fresh Home']") WebElement homeButton;
    @FindBy(css = "button.EmptyBag_button__WYD2m") WebElement emptyBagSignInButton;
    @FindBy(css = "button.CheckoutSteps_signInButton__phFqQ") WebElement checkOutPageSignInButton;

    public void signInWithNoSavedDetails() throws IOException {
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOf(pcEmail));
        ArrayList<String> userData= DataDriven.getTestData("Account","New User");
        pcEmail.sendKeys(userData.get(1));
        password.sendKeys(userData.get(2));
        pcSignIn.click();
    }

    public boolean validateSignedIn(){
        wait.until(ExpectedConditions.visibilityOf(myAccountButton));
        return myAccountButton.isDisplayed();
    }

    public void signInWithSavedDetails() throws IOException {
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOf(pcEmail));
        ArrayList<String> userData= DataDriven.getTestData("Account","Account");
        pcEmail.sendKeys(userData.get(1));
        password.sendKeys(userData.get(2));
        pcSignIn.click();
    }

    public void sigInWithPCODetails() throws IOException{
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOf(pcEmail));
        ArrayList<String> userData= DataDriven.getTestData("Checkout","PCO Credentials");
        pcEmail.sendKeys(userData.get(1));
        password.sendKeys(userData.get(2));
        pcSignIn.click();
    }
    public void sigInWithTestDetails() throws IOException{
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOf(pcEmail));
        ArrayList<String> userData= DataDriven.getTestData("Checkout","Test Credentials");
        pcEmail.sendKeys(userData.get(1));
        password.sendKeys(userData.get(2));
        pcSignIn.click();
    }
    public void createNewAccount() throws InterruptedException {
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOf(pcEmail));
        createAccountLink.click();
        wait.until(ExpectedConditions.visibilityOf(confirmPassword));
        String email="test"+random.nextInt(100)+random.nextInt(300)+"@yopmail.com";
        Log.info("Email: "+email);
        pcEmail.sendKeys(email);
        signUppassword.sendKeys("Loblaw@Testing");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//button[text()='Show Password']")).click();
        confirmPassword.sendKeys("Loblaw@Testing");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//button[text()='Show Password']")).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",termsAndConditionsLink);
        signUpButton.click();
    }

    public boolean validateUserSignedUp(){
        wait.until(ExpectedConditions.visibilityOf(homeButton));
        return homeButton.isDisplayed();
    }

    public void navigateFromCartPage() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(emptyBagSignInButton));
        emptyBagSignInButton.click();
        wait.until(ExpectedConditions.visibilityOf(pcEmail));
        ArrayList<String> userData= DataDriven.getTestData("Account","Account");
        pcEmail.sendKeys(userData.get(1));
        password.sendKeys(userData.get(2));
        pcSignIn.click();
    }

    public void signInFromCheckOutPage() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(checkOutPageSignInButton));
        checkOutPageSignInButton.click();
        wait.until(ExpectedConditions.visibilityOf(password));
        ArrayList<String> userData= DataDriven.getTestData("Account","Account");
        pcEmail.sendKeys(userData.get(1));
        password.sendKeys(userData.get(2));
        pcSignIn.click();
    }

    public boolean validateUserSignedIn(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input[name='addressId']")));
        return driver.findElements(By.cssSelector("input[name='addressId']")).size()>=1;
    }

}

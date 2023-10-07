package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Log;


import java.time.Duration;

public class PcidPage {
    WebDriverWait wait;
     WebDriver driver;
     Actions action;
    public PcidPage(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(60));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }
    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailF;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement passF;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitSignInOrCheckout;
    @FindBy(xpath = "//button[text()='Sign in']")
    public WebElement signInButton;
    @FindBy(xpath = "(//button[normalize-space()='My Account'])[1]")
    public WebElement myAccount;
    @FindBy(xpath = " (//a[normalize-space()='PC Optimum'])[1]")
    public WebElement hoverToPCOptimum;
    @FindBy(css = "div.HasPCOAccount_pointsBalance__zUuE6")
    public WebElement pointsBalance;
    @FindBy(css = "div.HasPCOAccount_redeemableValue__Y0pbl")
    public WebElement redeemableValues;
    @FindBy(css = ".cell.xlarge-5.small-12")
    public WebElement emailInPCOptimumAccount;
    @FindBy(css = ".HasPCOAccount_link__OEyY8")
    public WebElement goToPCOptimumAccountLink;

    @FindBy(css = ".HasPCIAccount_link__6UIw8")
    public WebElement pcOptimumInsiders;

    @FindBy(css = ".PCOptimumOffers_noOffersAvailable__N5jkj")
    public WebElement noOffers;





    public void signInToPCOptimumAccount(String Email, String pass){
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOf(submitSignInOrCheckout));
        emailF.sendKeys(Email);
        passF.sendKeys(pass);
        submitSignInOrCheckout.click();
        wait.until(ExpectedConditions.visibilityOf(myAccount));
        myAccount.click();
        action.moveToElement(hoverToPCOptimum).click().build().perform();
    }

    public boolean CheckPCOptimumValuesDetails(){
        wait.until(ExpectedConditions.visibilityOf(redeemableValues));
      boolean pointBalance= pointsBalance.isDisplayed();
      boolean redeemableBalanceValues = redeemableValues.isDisplayed();
      boolean emailInPCOptimum =emailInPCOptimumAccount.isDisplayed();
      boolean goToPCOptimumAccount = goToPCOptimumAccountLink.isEnabled();


      if(pointBalance&&redeemableBalanceValues&&emailInPCOptimum&&goToPCOptimumAccount){
         String  Text2 = pointsBalance.getText();
         String  Text3 = redeemableValues.getText();
         String  Text1 = emailInPCOptimumAccount.getText();
          System.out.println(Text1 + Text2 + Text3);
      }else {
          Log.error("element not Displayed");
      }
        return true;
    }

    public void signInMethod(){
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOf(emailF));
        emailF.sendKeys("joefresh1@yopmail.com");
        passF.sendKeys("passwordisnew");
        submitSignInOrCheckout.click();
    }


    public void emailM(String value) {
        emailF.sendKeys(value);
    }
    public void passM(String value){
      passF.sendKeys(value);
    }
}

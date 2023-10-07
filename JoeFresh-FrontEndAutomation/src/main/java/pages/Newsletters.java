package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.Base;
import resources.DataDriven;
import util.Log;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Newsletters {
    WebDriver driver;
    WebDriverWait wait;
    public Newsletters(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @FindBy(id="newsletterPageName") WebElement firstName;
    @FindBy(id = "newsletterPageName-error") WebElement firstNameError;
     @FindBy(id = "newsletterPageEmail") WebElement email;
    @FindBy(id = "newsletterPageEmail-error") WebElement emailError;
    @FindBy(name = "termsAndConditions") WebElement checkbox;
    @FindBy(xpath = "//label[@data-testid='label-newsletterPageCheckbox']//following-sibling::div[@class='InlineError_message__79aHw']")
    WebElement checkBoxErrorMessage;
    @FindBy(css = "button.NewsletterFormLong_button__amyxu") WebElement submitButton;
    @FindBy(css = "h1.NewsletterThankYou_heading__62wZ_") WebElement successMessage;
    @FindBy(css = "label[for='newsletterPageCheckbox'] p a[href='https://www.joefresh.com/ca/terms']") WebElement termsLink;
    @FindBy(css = "label[for='newsletterPageCheckbox'] p a[href='https://www.loblaw.ca/en/privacy-policy']") WebElement privacyLink;
    @FindBy(xpath = "//h1") WebElement heading;

    public void visitNewsletters() throws IOException {
        Base base=new Base();
        String url=base.loadProperties("url");
        driver.get(url+"/newsletter/signup");

    }


    public void typeFirstName() throws IOException {
        firstName.sendKeys(getData().get(1));
    }

    public List<String> getData() throws IOException {
        return DataDriven.getTestData("Newsletters","Newsletter Page");
    }

    public void typeEmail() throws IOException {
        email.sendKeys(getData().get(2));
    }
    public void clickCheckBox(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",checkbox);
    }

    public void clickSubmit()  {
        //wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
    }

    public boolean validateFirstNameError(){
        return firstNameError.isDisplayed();
    }

    public boolean validateEmailErrorIsDisplayed(){
        return emailError.isDisplayed();
    }

    public boolean validateCheckBoxErrorDisplayed(){
        return checkBoxErrorMessage.isDisplayed();
    }

    public boolean validateSucessMessage(){
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.isDisplayed();
    }

    public boolean validateTermsLink()  {
        wait.until(ExpectedConditions.elementToBeClickable(termsLink));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",termsLink);
        wait.until(ExpectedConditions.urlContains("ca/terms"));
        wait.until(ExpectedConditions.visibilityOf(heading));
        return heading.getText().equals("Terms and conditions for use of the application");
    }

    public boolean validatePrivacyLink()  {
        wait.until(ExpectedConditions.elementToBeClickable(privacyLink));
        privacyLink.click();
        wait.until(ExpectedConditions.urlContains("privacy-policy"));
        Log.info("Get Current URL "+driver.getCurrentUrl());
        return driver.getCurrentUrl().equals("https://www.loblaw.ca/en/privacy-policy");
    }
}

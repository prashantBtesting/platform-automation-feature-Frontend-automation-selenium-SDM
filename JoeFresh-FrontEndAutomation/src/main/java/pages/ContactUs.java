package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.Base;

import java.io.IOException;
import java.time.Duration;

public class ContactUs {
    WebDriver driver;
    WebDriverWait wait;

    public ContactUs(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(id = "firstName") WebElement firstName;
    @FindBy(id = "lastName") WebElement lastName;
    @FindBy(id="email") WebElement email;
    //@FindBy(id = "reasonForInquiry") WebElement reasonDropdown;
    @FindBy(id = "message") WebElement message;
    @FindBy(xpath = "//h1") WebElement aboutHeading;
    @FindBy(css="div.InlineError_message__79aHw") WebElement dropdownError;

    @FindBy(css = "button.ContactUsForm_submit__Aw6cV") WebElement submitButton;
    @FindBy(css = "div.category-navigation__links a[href='/ca/shipping']") WebElement shippingCta;
    @FindBy(css ="div.category-navigation__links a[href='/ca/returns']" ) WebElement returnsCta;
    @FindBy(css = "div.category-navigation__links a[href='/ca/faq']") WebElement faqButton;
    @FindBy(css = "div.category-navigation__links a[href='https://www.joefresh.com/ca/my-account/orders']") WebElement orderStatus;
    @FindBy(id="firstName-error") WebElement firstNameError;
    @FindBy(id="lastName-error") WebElement lastNameError;
    @FindBy(id="email-error") WebElement emailError;
    @FindBy(id = "message-error") WebElement messageError;
    @FindBy(css = "div.ContactUsForm_formAlert__lzBZb") WebElement successMessage;
    @FindBy(css = "div.ContactUsForm_formAlert__lzBZb p") WebElement successMessageContent;



    public void enterFirstName(){
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys("Test");
    }

    public void enterLastName(){
        wait.until(ExpectedConditions.visibilityOf(lastName));
        lastName.sendKeys("Account");
    }

    public void enterEmail(){
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys("test@yopmail.com");
    }

    public void dropDown(){
        wait.until(ExpectedConditions.visibilityOf(firstName));
        Select reasonDropdown=new Select(driver.findElement(By.id("reasonForInquiry")));
        reasonDropdown.selectByValue("Online Product Availability");
    }

    public void enterMessage(){
        wait.until(ExpectedConditions.visibilityOf(message));
        message.sendKeys("This message is for testing purpose");
    }

    public void clickSubmit(){
        submitButton.click();
    }

    public void navigateContactUs() throws IOException {
        Base base=new Base();
        driver.navigate().to(base.loadProperties("url")+"/contact-us");
        wait.until(ExpectedConditions.visibilityOf(aboutHeading));
    }

    public boolean visiblityOfFirstNameError(){
        wait.until(ExpectedConditions.visibilityOf(firstNameError));
        return firstNameError.isDisplayed();
    }
    public boolean visiblityOfLastNameError(){
        wait.until(ExpectedConditions.visibilityOf(lastNameError));
        return lastNameError.isDisplayed();
    }
    public boolean visiblityOfEmailError(){
        wait.until(ExpectedConditions.visibilityOf(emailError));
        return emailError.isDisplayed();
    }

    public boolean visiblityOfDropdownError(){
        wait.until(ExpectedConditions.visibilityOf(dropdownError));
        return dropdownError.isDisplayed();
    }
    public boolean visiblityOfMessageError(){
        wait.until(ExpectedConditions.visibilityOf(messageError));
        return messageError.isDisplayed();
    }

    public boolean validateShippingRedirected(){
        wait.until(ExpectedConditions.textToBePresentInElement(aboutHeading,"Shipping & Handling"));
        return aboutHeading.getText().contains("Shipping");
    }
    public boolean validateReturnRedirected(){
        wait.until(ExpectedConditions.textToBePresentInElement(aboutHeading,"Return & Exchange Policy"));
        return aboutHeading.getText().contains("Return");
    }
    public boolean validateOrderStatus(){
        wait.until(ExpectedConditions.urlContains("https://accounts.pcid.ca/login"));
        return driver.getCurrentUrl().equals("https://accounts.pcid.ca/login");
    }
    public boolean validateFaq(){
        wait.until(ExpectedConditions.textToBePresentInElement(aboutHeading,"Frequently Asked Questions"));
        return aboutHeading.getText().contains("Frequently Asked Questions");
    }
    public boolean validateSuccessMessage(){
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.isDisplayed()&&successMessageContent.getText().contains("Your message has been sent");
    }
}

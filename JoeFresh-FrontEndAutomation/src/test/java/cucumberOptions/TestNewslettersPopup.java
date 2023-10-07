package cucumberOptions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.Base;
import resources.DataDriven;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class TestNewslettersPopup {
    WebDriver driver;
    WebDriverWait wait;


    By modalPopupEmail = By.id("newsletterModalEmail");
    By modelCheckbox = By.id("newsletterModalCheckbox");
    By submitButton = By.cssSelector("div.ModalNewsletter_modal__tlbL_ button.NewsletterFormShort_button__mbl_D");
    By sucessHeading = By.cssSelector("h1.ModalNewsletter_successHeading__OpyNa");
    By emailError = By.id("newsletterModalEmail-error");
    By checkBoxError = By.cssSelector("div.InlineError_message__79aHw");

    @BeforeMethod
    public void beforeRunningTestCase() throws IOException {
        Base base = new Base();
        driver = base.initializeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    @Test
    public void validateSuccessfulSubmission() throws IOException {
        ArrayList<String> data = DataDriven.getTestData("Newsletters", "Popup Success");
        driver.findElement(modalPopupEmail).sendKeys(data.get(1));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(modelCheckbox));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(submitButton));
        actions.click().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(sucessHeading));
        Assert.assertTrue(driver.findElement(sucessHeading).isDisplayed());
    }

    @Test
    public void validateEmailError() {
        wait.until(ExpectedConditions.elementToBeClickable(modelCheckbox));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(modelCheckbox));
        driver.findElement(submitButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailError));
        Assert.assertTrue(driver.findElement(emailError).isDisplayed());
    }

    @Test
    public void validateCheckBoxError() throws IOException {
        ArrayList<String> data = DataDriven.getTestData("Newsletters", "Popup Success");
        driver.findElement(modalPopupEmail).sendKeys(data.get(1));
        driver.findElement(submitButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxError));
        Assert.assertTrue(driver.findElement(checkBoxError).isDisplayed());
    }

    @Test
    public void validateAllEmailErrorMessage() {
        driver.findElement(submitButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailError));
        Assert.assertTrue(driver.findElement(emailError).isDisplayed());
        Assert.assertTrue(driver.findElement(checkBoxError).isDisplayed());
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

}



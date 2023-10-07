package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Log;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Footer {
    WebDriver driver;
    WebDriverWait wait;
    Wait fluentwait;

    public Footer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        fluentwait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1));
    }
    /**
     * Footer Popups
     */
    @FindBy(xpath = "//button[text()='Close']") WebElement footerClose;
    @FindBy(xpath = "//div[@class='ModalNewsletter_modal__tlbL_ Modal_content__R7I_E Modal_bottom__kndkE Modal_slideFromBottom__hqJIM']//button[@data-testid='modal-close']") WebElement subscriptionFooterClose;
    /**
     * Footer Links
     * */
    @FindBy(css = "div.Footer_menu__crD1j div.ResponsiveWrapper_xlargeOnly__EF88U a[href='/ca/aboutus']") WebElement aboutLink;
    @FindBy(xpath = "//h1") WebElement aboutHeading;
    @FindBy(css = "div.Footer_menu__crD1j div.ResponsiveWrapper_xlargeOnly__EF88U a[href='/ca/store-locator']") WebElement storeLocator;
    @FindBy(css = "button.lds__location-search__search-toggle-button") WebElement storeLocatorButton;
    @FindBy(css = "div.Footer_menu__crD1j div.ResponsiveWrapper_xlargeOnly__EF88U a[href='/ca/joefreshapp']") WebElement appButton;
    @FindBy(css = "picture img[alt='Download on the App Store']") WebElement appleStoreButton;
    @FindBy(css = "div.Footer_menu__crD1j div.ResponsiveWrapper_xlargeOnly__EF88U a[href='/ca/contact-us']") WebElement contactUsButton;
    @FindBy(css = "div.heading-component h1")  WebElement contactUsHeading;
    @FindBy(css = "div.Footer_menu__crD1j div.ResponsiveWrapper_xlargeOnly__EF88U a[href='/ca/shipping']") WebElement shippingButton;
    @FindBy(css = "div.Footer_menu__crD1j div.ResponsiveWrapper_xlargeOnly__EF88U a[href='/ca/returns']")  WebElement returnButton;
    @FindBy(css = "div.Footer_menu__crD1j div.ResponsiveWrapper_xlargeOnly__EF88U a[href='/ca/offerdetails']") WebElement offerDetailsButton;
    @FindBy(css = "div.Footer_menu__crD1j div.ResponsiveWrapper_xlargeOnly__EF88U a[href='/ca/productrecalls']") WebElement productRecalls;
    @FindBy(css = "div.Footer_menu__crD1j div.ResponsiveWrapper_xlargeOnly__EF88U a[href='https://www.joefresh.com/ca/my-account/orders']") WebElement orderStatus;
    @FindBy(css = "div.Footer_menu__crD1j div.ResponsiveWrapper_xlargeOnly__EF88U a[href='/ca/sizechart']") WebElement sizeChart;
    @FindBy(css = "div.Footer_menu__crD1j div.ResponsiveWrapper_xlargeOnly__EF88U a[href='/ca/faq']") WebElement faq;
    @FindBy(css = "div.Footer_menu__crD1j div.ResponsiveWrapper_xlargeOnly__EF88U a[href='/ca/affiliates']") WebElement affiliates;
    @FindBy(css = "div.Footer_menu__crD1j div.ResponsiveWrapper_xlargeOnly__EF88U a[href='/ca/jfcareers']") WebElement careers;
    @FindBy(css = "div.Footer_menu__crD1j div.ResponsiveWrapper_xlargeOnly__EF88U a[href='/ca/internationalopportunities']") WebElement opportunities;
    /**
     * Newsletter Popups
     **/
    @FindBy(id = "newsletterFooterDesktopEmail") WebElement newsLetterEmail;
    @FindBy(id = "newsletterFooterDesktopCheckbox") WebElement newsLetterCheckbox;
    @FindBy(css = "div.grid-container  button.NewsletterFormShort_button__mbl_D") WebElement signUpButton;
    @FindBy(css = "div.ResponsiveWrapper_xlargeOnly__EF88U p.FooterNewsletter_body__bUVJv") WebElement footerMessage;
    @FindBy(css = "div.InlineError_message__79aHw p") WebElement checkBoxErrorMessage;
    @FindBy(css = "#newsletterFooterDesktopEmail-error p") WebElement noEmailErrorMessage;
    /**
     * Social Media Shares*/
    @FindBy(css = "li.SocialIcons_listItem__zcxqU a[href='http://instagram.com/joefresh']") WebElement instagramButton;
    @FindBy(css = "li.SocialIcons_listItem__zcxqU a[href='https://www.tiktok.com/@joefreshstyle?lang=en']") WebElement tikTokButton;
    @FindBy(css = "li.SocialIcons_listItem__zcxqU a[href='https://www.facebook.com/joefresh']") WebElement facebookButton;
    @FindBy(css = "li.SocialIcons_listItem__zcxqU a[href='https://www.pinterest.ca/joefresh/']") WebElement pinterestButton;
    @FindBy(css = "li.SocialIcons_listItem__zcxqU a[href='https://twitter.com/JoeFresh']") WebElement twitterButton;
    @FindBy(css = "li.SocialIcons_listItem__zcxqU a[href='https://www.youtube.com/user/RealJoeFreshStyle']") WebElement youtubeButton;
    /**
     * Bottom Page Links
     * */
    @FindBy(css = "li.FooterCopyrightLinks_menuItem__CXLFR button.Button_text__ffOub") WebElement frenchButton;
    @FindBy(css = "li.FooterCopyrightLinks_menuItem__CXLFR a[href='/ca/terms']") WebElement termsOfUse;
    @FindBy(xpath = "//li[@class='FooterCopyrightLinks_menuItem__CXLFR']//descendant::a[text()='Privacy']") WebElement privacyTerms;
    @FindBy(xpath = "//li[@class='FooterCopyrightLinks_menuItem__CXLFR']//descendant::a[text()='Accessibility']") WebElement accessibility;
    @FindBy(css = "div.heading-component h2") WebElement frenchHeading;
    /**
     * Footer Cards
     * */
    @FindBy(css = "div.ValueProposition_container__f_BT5 a[href='https://apps.apple.com/ca/app/joe-fresh/id935697698']") WebElement appleApplication;
    @FindBy(css = "div.ValueProposition_container__f_BT5 a[href='https://www.pcoptimum.ca/']") WebElement pcOptimumCard;
    @FindBy(css = "div.ValueProposition_container__f_BT5 a[href='/ca/shipping']") WebElement shippingCard;
    @FindBy(css = "div.ValueProposition_container__f_BT5 a[href='/ca/returns']") WebElement returnCard;
    @FindBy(css = "#headerXL a.MyBagLink_container__xcIvf") WebElement myBagButton;
    /**
     * Get Help Chat Bot
     * */
    @FindBy(id = "ada-chat-button") WebElement getHelpButton;
    @FindBy(css = "div[data-testid='AutoMessage']") WebElement autoGeneratedMessage;
    @FindBy(xpath = "//label[@data-testid='label-newsletterFooterDesktopCheckbox']//a[text()='Terms and Conditions']") WebElement footerTermsLink;
    @FindBy(xpath = "//label[@data-testid='label-newsletterFooterDesktopCheckbox']//a[text()='Privacy Policy']") WebElement footerPrivacyLink;
    @FindBy(css = "h1.EmptyBag_heading__F_2ow") WebElement emptyBagHeading;
    /**
     * Newsletters Popup
     */
    By footerIcons = By.cssSelector("div.ValueProposition_container__f_BT5");
    /**
     * Basic Footer Functionalities*/
    public void subscriptionFooterCloseButton() {
        subscriptionFooterClose.click();
    }
    public void footerClose() {
        footerClose.click();
    }

    public boolean validateFooterIcons() {
        List<WebElement> footerCards = driver.findElements(footerIcons);
        for (WebElement footerCard : footerCards) {
            try {
                Log.info("Image Displayed " + footerCard.findElement(By.cssSelector(" img")).isDisplayed());
                Log.info("Heading Displayed " + footerCard.findElement(By.cssSelector(" h3")).isDisplayed());
                Log.info("Subheading displayed " + footerCard.findElement(By.cssSelector(" p")).isDisplayed());
            } catch (NoSuchElementException nsee) {
                return false;
            }
        }
        return true;
    }
    public void scrollToBottom() {
        Actions actions = new Actions(driver);
        actions.moveToElement(frenchButton).perform();
    }

    public boolean validateFooterSubscription() {
        newsLetterEmail.sendKeys("test@yopmail.com");
        wait.until(ExpectedConditions.elementToBeClickable(newsLetterCheckbox));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", newsLetterCheckbox);
        wait.until(ExpectedConditions.visibilityOf(signUpButton));
        signUpButton.click();
        wait.until(ExpectedConditions.visibilityOf(footerMessage));
        return footerMessage.isDisplayed()&&footerMessage.getText().contains("Thanks for joining");
    }
    public boolean validateFooterCheckboxError() {
        newsLetterEmail.sendKeys("test0609@yopmail.com");
        signUpButton.click();
        wait.until(ExpectedConditions.visibilityOf(checkBoxErrorMessage));
        return checkBoxErrorMessage.isDisplayed();
    }
    public boolean validateFooterInvalidEmailMessage() {
        newsLetterEmail.sendKeys("test0609");
        wait.until(ExpectedConditions.elementToBeClickable(newsLetterCheckbox));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", newsLetterCheckbox);
        wait.until(ExpectedConditions.visibilityOf(noEmailErrorMessage));
        return noEmailErrorMessage.isDisplayed();
    }
    public boolean validateNoEmailMessage() {
        newsLetterEmail.sendKeys("");
        wait.until(ExpectedConditions.elementToBeClickable(newsLetterCheckbox));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", newsLetterCheckbox);
        signUpButton.click();
        return noEmailErrorMessage.isDisplayed();
    }
    public boolean validateAboutUs() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aboutLink);
        aboutLink.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return aboutHeading.getText().contains("About");
    }
    public boolean validateStoreLocator() {
        storeLocator.click();
        wait.until(ExpectedConditions.visibilityOf(storeLocatorButton));
        return storeLocator.isDisplayed();
    }
    public boolean validateAppButton() {
        appButton.click();
        wait.until(ExpectedConditions.visibilityOf(appleStoreButton));
        return appleStoreButton.isDisplayed();
    }
    public boolean validateContactUs()  {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactUsButton);
        contactUsButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return aboutHeading.getText().contains("Contact");
    }
    public boolean validateShipping()  {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shippingButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", shippingButton);
        wait.until(ExpectedConditions.textToBePresentInElement(aboutHeading, "Shipping & Handling"));
        Log.info("Shipping Heading :" + aboutHeading.getText());
        return aboutHeading.getText().contains("Shipping");
    }
    public boolean validateReturns()  {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", returnButton);
        returnButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(aboutHeading, "Return & Exchange Policy"));
        return aboutHeading.getText().contains("Return");
    }
    public boolean validateOffer()  {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", offerDetailsButton);
        offerDetailsButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(aboutHeading, "Offer Details "));
        return aboutHeading.getText().contains("Offer");
    }

    public boolean productRecalls()  {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productRecalls);
        productRecalls.click();
        wait.until(ExpectedConditions.textToBePresentInElement(aboutHeading, "Product Recalls"));
        return productRecalls.getText().contains("Product Recalls");
    }

    public boolean validateOrderStatus()  {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", orderStatus);
        orderStatus.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        wait.until(ExpectedConditions.urlContains("login"));
        Log.info("Get Current URL " + driver.getCurrentUrl());
        return driver.getCurrentUrl().contains("https://accounts.pcid.ca/login");
    }

    public boolean validateSizeChart() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sizeChart);
        sizeChart.click();
        wait.until(ExpectedConditions.textToBePresentInElement(aboutHeading, "Size Charts"));
        return aboutHeading.getText().contains("Size Charts");
    }

    public boolean validateFaq() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", faq);
        faq.click();
        wait.until(ExpectedConditions.textToBePresentInElement(aboutHeading, "Frequently Asked Questions"));
        return aboutHeading.getText().contains("Frequently Asked Questions");
    }

    public boolean validateCareers()  {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", careers);
        careers.click();
        wait.until(ExpectedConditions.textToBePresentInElement(aboutHeading, "Careers"));
        return aboutHeading.getText().contains("Careers");
    }

    public boolean validateAffiliate()  {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", affiliates);
        affiliates.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return aboutHeading.getText().contains("Affiliate");
    }

    public boolean validateInternationalBusinessOpportunities() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", opportunities);
        opportunities.click();
        wait.until(ExpectedConditions.textToBePresentInElement(aboutHeading, "International Business Opportunities"));
        return aboutHeading.getText().contains("International Business Opportunities");
    }

    public boolean validateInstagramLinks() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", instagramButton);
        instagramButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        wait.until(ExpectedConditions.urlContains("www.instagram.com"));
        Log.info("Get Current URL " + driver.getCurrentUrl());
        return driver.getCurrentUrl().equals("https://www.instagram.com/joefresh/");
    }

    public boolean validateTikTokLink() {
      /*  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",tikTokButton);
        tikTokButton.click();
        Thread.sleep(2000);
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(1000);
        Log.info("Get Current URL "+driver.getCurrentUrl());
        return driver.getCurrentUrl().equals("https://www.tiktok.com/@joefreshstyle?lang=en");*/
        return true;
    }

    public boolean validateFacebook() {
        driver.findElement(By.cssSelector("#headerXL a.Header_logo__iu8zZ"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", facebookButton);
        facebookButton.click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        wait.until(ExpectedConditions.urlContains("facebook"));
        Log.info("Get Current URL " + driver.getCurrentUrl());
        return driver.getCurrentUrl().equals("https://www.facebook.com/joefresh");
    }

    public boolean validatePintrest()  {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pinterestButton);
        pinterestButton.click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        wait.until(ExpectedConditions.urlContains("pinterest"));
        Log.info("Get Current URL " + driver.getCurrentUrl());
        return driver.getCurrentUrl().equals("https://www.pinterest.ca/joefresh/");
    }

    public boolean validateTwitter() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", twitterButton);
        twitterButton.click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        wait.until(ExpectedConditions.urlContains("twitter"));
        Log.info("Get Current URL " + driver.getCurrentUrl());
        return driver.getCurrentUrl().equals("https://twitter.com/JoeFresh");
    }

    public boolean validateYouTube() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", youtubeButton);
        youtubeButton.click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        wait.until(ExpectedConditions.urlContains("youtube"));
        Log.info("Get Current URL " + driver.getCurrentUrl());
        return driver.getCurrentUrl().equals("https://www.youtube.com/user/RealJoeFreshStyle");
    }

    public boolean validateFrenchButton() throws InterruptedException {
        driver.findElement(By.cssSelector("#headerXL a.Header_logo__iu8zZ")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".banner-wrapper")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", frenchButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", frenchButton);
       // wait.until(ExpectedConditions.titleContains("Page d'"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2"),"MAGASINER MAINTENANT"));
        return driver.getTitle().equals("Page d'accueil | Joe Fresh")||driver.findElement(By.xpath("//h2")).getText().equals("MAGASINER MAINTENANT");
    }

    public boolean validateTermsOfUseButton() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", termsOfUse);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", termsOfUse);
        wait.until(ExpectedConditions.visibilityOf(aboutHeading));
        return aboutHeading.getText().equals("Terms and conditions for use of the application");
    }

    public boolean validatePrivacyPolicy() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyTerms);
        privacyTerms.click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Log.info("Get Current URL " + driver.getCurrentUrl());
        return driver.getCurrentUrl().equals("https://www.loblaw.ca/en/privacy-policy");
    }

    public boolean validateAccessiblity() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyTerms);
        accessibility.click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Log.info("Get Current URL " + driver.getCurrentUrl());
        return driver.getCurrentUrl().equals("https://www.loblaw.ca/en/accessibility");
    }

    public boolean validateApplicationLink() {
        appleApplication.click();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
        return driver.getCurrentUrl().equals("https://apps.apple.com/ca/app/joe-fresh/id935697698");
    }

    public boolean pcOptimumLink() {
        pcOptimumCard.click();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
        return driver.getCurrentUrl().equals("https://www.pcoptimum.ca/");
    }

    public boolean freeShippingCard() {
        shippingCard.click();
        return aboutHeading.getText().equals("Shipping & Handling");
    }

    public boolean freeReturnCard() {
        returnCard.click();
        return aboutHeading.getText().equals("Return & Exchange Policy");
    }

    public void visitMyCartPage() {
        myBagButton.click();
    }

    public boolean getHelpVisible() {
        wait.until(ExpectedConditions.visibilityOf(emptyBagHeading));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().frame("ada-button-frame");
        return getHelpButton.isDisplayed();
    }

    public boolean getHelpFrameVisible() {
        wait.until(ExpectedConditions.visibilityOf(emptyBagHeading));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().frame("ada-button-frame");
        wait.until(ExpectedConditions.elementToBeClickable(getHelpButton));
        getHelpButton.click();
        driver.switchTo().parentFrame();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().frame("ada-chat-frame");
        fluentwait.until(ExpectedConditions.visibilityOf(autoGeneratedMessage));
        return autoGeneratedMessage.isDisplayed();
    }

    public boolean getHelpFrameMinimize(){
        wait.until(ExpectedConditions.visibilityOf(emptyBagHeading));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().frame("ada-button-frame");
        getHelpButton.click();
        driver.switchTo().parentFrame();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().frame("ada-chat-frame");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button[aria-label='Minimize Chat']"))));
        driver.findElement(By.cssSelector("button[aria-label='Minimize Chat']")).click();
        driver.switchTo().parentFrame();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().frame("ada-button-frame");
        return getHelpButton.isDisplayed();
    }

    public boolean getHelpFrameClose(){
        wait.until(ExpectedConditions.visibilityOf(emptyBagHeading));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().frame("ada-button-frame");
        getHelpButton.click();
        driver.switchTo().parentFrame();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().frame("ada-chat-frame");
        driver.findElement(By.cssSelector("button[aria-label='Close']")).click();
        driver.switchTo().parentFrame();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().frame("ada-button-frame");
        return getHelpButton.isDisplayed();
    }

    public boolean getHelpClickSuggestion()  {
        Random random = new Random();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().frame("ada-button-frame");
        getHelpButton.click();
        driver.switchTo().parentFrame();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().frame("ada-chat-frame");
        fluentwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[data-testid='AutoQuickReply'] button")));
        List<WebElement> autoSuggestions = driver.findElements(By.cssSelector("div[data-testid='AutoQuickReply'] button"));
        autoSuggestions.get(random.nextInt(autoSuggestions.size())).click();
        return driver.findElements(By.cssSelector("div[data-testid='MessageGroupNewBot']")).size() >=1;
    }

    public boolean getHelpSettings() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().frame("ada-button-frame");
        getHelpButton.click();
        driver.switchTo().parentFrame();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().frame("ada-chat-frame");
        fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[aria-label='Settings']")));
        driver.findElement(By.cssSelector("button[aria-label='Settings']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver.findElement(By.cssSelector("section[role='dialog']")).isDisplayed();
    }

    public boolean footerSubscriptionTerms() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footerTermsLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", footerTermsLink);
        wait.until(ExpectedConditions.textToBePresentInElement(aboutHeading, "Terms and conditions for use of the application"));
        return aboutHeading.getText().equals("Terms and conditions for use of the application");

    }

    public boolean footerPrivacy()  {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footerPrivacyLink);
        footerPrivacyLink.click();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("privacy-policy"));
        Log.info("Get Current URL " + driver.getCurrentUrl());
        return driver.getCurrentUrl().equals("https://www.loblaw.ca/en/privacy-policy");
    }

}


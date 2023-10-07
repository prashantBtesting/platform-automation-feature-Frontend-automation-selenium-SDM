package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShippingAndHandling {
    WebDriver driver;
    WebDriverWait wait;
    public ShippingAndHandling(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(25));
    }
    @FindBy(xpath = "//h1") WebElement heading;
    @FindBy(css = "button#labelledById5HIGuzyXzdiVlKORjNhsFj0") WebElement whereDoWeShip;
    @FindBy(css = "div#controlsId5HIGuzyXzdiVlKORjNhsFj0 p") WebElement whereDoWeShipResponse;
    @FindBy(css = "button#labelledById61Z0gIsDmxdKdzvSLpRiRQ1") WebElement howLongDoesItTakeMyOrderToBeProcessed;
    @FindBy(css = "div#controlsId61Z0gIsDmxdKdzvSLpRiRQ1 p") WebElement howLongDoesItTakeMyOrderToBeProcessedResponse;
    @FindBy(css = "button#labelledById5HkkaaXmouafSg8cwjZuhD0") WebElement whatShippingOptionsAreAvailable;




}

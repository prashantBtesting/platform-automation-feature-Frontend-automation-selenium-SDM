package util;

import io.cucumber.datatable.DataTable;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageObjectManager;
import resources.Base;
import resources.ColumnDataDriven;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class BasicOperations extends Base {

    public WebDriver driver;
    public Base base;

    PageObjectManager pom;
    ColumnDataDriven ddt;


    public BasicOperations(WebDriver driver){
        this.driver=driver;
        pom=new PageObjectManager(driver);
    }

    public void waitForElementToBeClicked(WebElement webElement){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }


    public void closeFooterNotification() throws InterruptedException {
        pom.getFooter().subscriptionFooterCloseButton();
        Thread.sleep(2000);
        pom.getFooter().footerClose();

    }

    public List<Map<String,String>> readDataExcel(String sheetName) throws IOException, InvalidFormatException {
        ddt=new ColumnDataDriven();
        return ddt.getData(sheetName);
    }

    public List<List<String>> handleDataTable(DataTable dt){
        return dt.cells();
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

}

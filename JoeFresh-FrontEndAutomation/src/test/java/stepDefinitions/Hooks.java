package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.       FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;


public class Hooks {
    TestContextSetup testContextSetup;
    public Hooks(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
    }

    @Before
    public void beforeScenario() throws InterruptedException {
       testContextSetup.basic.closeFooterNotification();
      //   testContextSetup.base.setCookie();
      //  testContextSetup.base.driver.navigate().refresh();
    }
    @Before ("@browserstack")
    public void startBrowserStackLocal() throws Exception {
        BrowserStackConnector.startBrowserStackLocal("prashantbabar_nGO8JI", "Dxe8CsKog9CxfhwynFrp");
    }

    @After
    public void afterScenario() throws IOException {
       testContextSetup.base.initializeDriver().quit();
    }
    @After("@browserstack")
    public void stopBrowserStackLocal() throws Exception {
        BrowserStackConnector.stopBrowserStackLocal();
    }



    @AfterStep
    public void takeScreenshot(Scenario scenario) throws IOException {
        WebDriver driver=testContextSetup.base.driver;
        if (scenario.isFailed()) {
           File sourcePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           byte[] fileContent= FileUtils.readFileToByteArray(sourcePath);
           scenario.attach(fileContent,"image/png","image");
        }
    }



}

package cucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/java/resources/features",
        tags = "@CartTEST",
        glue = "stepDefinitions",
        monochrome = true,
        plugin = {"html:target/cucumber.html","json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        )
public class TestRunnerJoeFreshSerialized extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel=false)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }

}

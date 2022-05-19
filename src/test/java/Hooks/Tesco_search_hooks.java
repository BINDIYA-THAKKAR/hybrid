package Hooks;

import driverfactory.Driver_Factory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.Tesco_Search;
import utils.Config_Reader;

import java.io.IOException;
import java.util.Properties;

public class Tesco_search_hooks {
    private Config_Reader reader;
    private Driver_Factory factory;
    private WebDriver driver;
    Properties prop;

    @Before(order = 0)
    public void getProperties() throws IOException {
        reader = new Config_Reader();
        prop = reader.ed_prop();
    }

    @Before(order = 1)
    public void lunchBrowser() {
        String browserName = prop.getProperty("browser");
        factory = new Driver_Factory();
        driver = factory.init_Browser(browserName);
    }

    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario Name) {
        if(Name.isFailed()){
            String screenShot = Name.getName().replaceAll(" ","_");
            byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            Name.attach(sourcePath,"image/png" ,screenShot);
        }
    }


}

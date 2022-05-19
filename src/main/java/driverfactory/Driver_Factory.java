package driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver_Factory {
    public WebDriver driver;

    public static ThreadLocal<WebDriver> tsLocal = new ThreadLocal<>();

    public WebDriver init_Browser(String browser) {
        System.out.println("The browser name is " + browser);

        if(browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            tsLocal.set(new ChromeDriver());
        }else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            tsLocal.set(new FirefoxDriver());
        }else if(browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            tsLocal.set(new EdgeDriver());
        }else {
            System.out.println("Please Provide the Correct Browser value " +browser);

        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tsLocal.get();
    }

}


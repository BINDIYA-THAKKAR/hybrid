package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Tesco_Search {
    private WebDriver driver;

    //Created Constructor
    public Tesco_Search(WebDriver driver){
        this.driver = driver;
    }

    private By cookies= By.className("beans-cookies-notification__form");

    private By SearchBar=By.xpath("//div[@class=\"search-logo-container\"]/div[2]/form/div/input");

    private By Searchbutton=By.xpath("//div[@class=\"search-logo-container\"]/div[2]/form/button[2]/span");

    private By Titletext=By.cssSelector("h1[class=\'heading query\']");

    public void setCookies(){
        driver.findElement(cookies).click();

    }
    public void setSearchBar(String Productname) {
        driver.findElement(SearchBar).sendKeys(Productname);

    }
    public void setSearchbutton(){
        driver.findElement(SearchBar).sendKeys(Keys.ENTER);
    }
    public String URL(){
        return driver.getCurrentUrl();
    }
    public String Title(){
        return driver.findElement(Titletext).getText();
    }

}


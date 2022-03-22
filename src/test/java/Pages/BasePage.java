package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;
    static {
        System.setProperty("webdriver.chrome.driver","/Users/mabreu/chromedriver/chromedriver.exe");
        ChromeOptions chromeOptions=new ChromeOptions();
        driver =new ChromeDriver(chromeOptions);
        wait=new WebDriverWait(driver,10);
    }
    public BasePage (WebDriver driver){
        BasePage.driver=driver;
        wait= new WebDriverWait(driver,10);
    }

    public static void navigateTo(String url){
        driver.get(url);
    }


    private WebElement Find (String locator){
     return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public static void closeBrowser(){
        driver.quit();
    }


    public void clickElement(String locator) {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator))).click();

    }

        public void write(String locator, String textToWrite){
            Find(locator).clear();
            Find(locator).sendKeys(textToWrite);
    }

    public List<WebElement> allItem(String locator){
        List<WebElement> webElementList = new ArrayList<>();
        webElementList.addAll(driver.findElements(By.className(locator)));

        return webElementList;

    }

    public WebElement text(WebElement webElement, String locator){
       WebElement s = webElement.findElement(By.className(locator));
       return s;


    }

}

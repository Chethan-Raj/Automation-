import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWait<W extends SearchContext> {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //WebDriverWait expwait = new WebDriverWait(driver, Duration.ofSeconds(8));
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id = 'start']//button")).click();
        //Wait<WebDriver> fwait = new org.openqa.selenium.support.ui.FluentWait<WebDriver>(driver);
        Wait <WebDriver> fwait = new org.openqa.selenium.support.ui.FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        WebElement f1 = fwait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver driver) {
                WebElement HW = driver.findElement(By.xpath("//div[@id = 'finish']//h4"));
                if(HW.isDisplayed()){
                    return HW;
                }
                else {
                    return null ;
                }
            }
        });
        System.out.println(driver.findElement(By.xpath("//div[@id = 'finish']//h4")).getText());
    }
}

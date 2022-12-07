
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class E2E_Scope {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        WebDriverWait expwait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Integer links = driver.findElements(By.tagName("a")).size();
        System.out.println(links);
        //Links from the footer section
        WebElement footerdriver = driver.findElement(By.xpath("//table[@class = 'gf-t']"));
        Integer footerlinks = footerdriver.findElements(By.tagName("a")).size();
        System.out.println(footerlinks);
        WebElement columndriver = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        Integer columnlinks = columndriver.findElements(By.tagName("a")).size();
        System.out.println(columnlinks);

        // open each link
        for (int i = 1;i< columnlinks;i++){
            String rightclick = Keys.chord(Keys.CONTROL,Keys.ENTER);
            //Keyboard events need to be sent from sendkeys
            columndriver.findElements(By.tagName("a")).get(i).sendKeys(rightclick);
            //driver.switchTo().defaultContent();
            Thread.sleep(5000);
        }
        Set<String> win =  driver.getWindowHandles();
        for (String one : win) {
            driver.switchTo().window(one);
            System.out.println(driver.getTitle());
        }
    }

    //Bring optimization: Links opened irrespective of the link names and used concept of loops to improve code and readability
}

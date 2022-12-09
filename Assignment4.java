import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Assignment4 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait exwait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.xpath("//a[@href = '/windows/new']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> tab = windows.iterator();
        String parent = tab.next();
        String child = tab.next();
        driver.switchTo().window(child);
        exwait.until(ExpectedConditions.urlToBe("https://the-internet.herokuapp.com/windows/new"));
        String chText = driver.findElement(By.xpath("//div[@class = 'example']//h3")).getText();
        driver.switchTo().window(parent);
        exwait.until(ExpectedConditions.urlToBe("https://the-internet.herokuapp.com/windows"));
        String patext = driver.findElement(By.xpath("//div[@class = 'example']//h3")).getText();
        System.out.println(chText);
        System.out.println(patext);
    }
}

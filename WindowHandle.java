import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


public class WindowHandle {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait expwait = new WebDriverWait(driver, Duration.ofSeconds(8));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
        Set<String> wind = driver.getWindowHandles();
        Iterator<String> it = wind.iterator();
        String parent = it.next();
        String child = it.next();
        driver.switchTo().window(child);
        expwait.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/documents-request"));
        //String a = driver.findElement(By.xpath("//a[@href = 'mailto:mentor@rahulshettyacademy.com']")).getText();
        String a = driver.findElement(By.xpath("//p[contains(@class , 'im-para red')]")).getText();
        //System.out.println(a);
        String[] abc = a.split("at");
        //System.out.println(abc[1].trim());
        String[] spl1 = abc[1].split("with");
        String email = spl1[0].trim();
        //System.out.println(email);
        driver.switchTo().window(parent);
        expwait.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/loginpagePractise/"));
        driver.findElement(By.xpath("//input [@id = 'username']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("learning");
        driver.findElement(By.xpath("//input[@id = 'signInBtn']")).click();
    }
}

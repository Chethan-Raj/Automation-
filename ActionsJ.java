import net.bytebuddy.implementation.bytecode.ShiftLeft;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsJ {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait expwait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        Actions m = new Actions(driver);
        //build and perform are used to invoke and perform action
        m.moveToElement(driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("Hello").doubleClick().build().perform();
        m.moveToElement(driver.findElement(By.xpath("//a[@id = 'nav-link-accountList']"))).build().perform();

    }
}

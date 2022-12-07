import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Assignment8 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebDriverWait waitx = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.findElement(By.xpath("//input[@id = 'autocomplete']")).sendKeys("Ind");
        waitx.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id = 'ui-id-1']")));
        Actions mouse = new Actions(driver);
        List<WebElement> suggestions = driver.findElements(By.xpath("//div[@class = 'ui-menu-item-wrapper']"));
        for (int i = 0; i < suggestions.size(); i++) {
            String name = driver.findElements(By.xpath("//li[@class = 'ui-menu-item']")).get(i).getText();
            System.out.println(name);
            if (name.equalsIgnoreCase("India")){
                System.out.println(name);
                mouse.moveToElement(driver.findElements(By.xpath("//li[@class = 'ui-menu-item']")).get(i)).build().perform();
                mouse.click(driver.findElements(By.xpath("//li[@class = 'ui-menu-item']")).get(i)).build().perform();
            }
        }
    }
}


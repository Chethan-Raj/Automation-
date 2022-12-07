import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Screenshot {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        /*File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("C://Users//905953//OneDrive - Cognizant//Documents//Automation_screenshots//screenshot.png"));*/
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        screenshot(driver);
        WebDriverWait waitx = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.findElement(By.xpath("//input[@id = 'autocomplete']")).sendKeys("Ind");
        screenshot(driver);
        waitx.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id = 'ui-id-1']")));
        Actions mouse = new Actions(driver);
        List<WebElement> suggestions = driver.findElements(By.xpath("//div[@class = 'ui-menu-item-wrapper']"));
        for (int i = 0; i < suggestions.size(); i++) {
            String name = driver.findElements(By.xpath("//li[@class = 'ui-menu-item']")).get(i).getText();
            System.out.println(name);
            if (name.equalsIgnoreCase("India")){
                System.out.println(name);
                mouse.moveToElement(driver.findElements(By.xpath("//li[@class = 'ui-menu-item']")).get(i)).build().perform();
                screenshot(driver);
                mouse.click(driver.findElements(By.xpath("//li[@class = 'ui-menu-item']")).get(i)).build().perform();
                screenshot(driver);
            }
        }
    }

    public static void screenshot(WebDriver driver) {
        try{
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src,new File("C://Users//905953//OneDrive - Cognizant//Documents//Automation_screenshots//screenshot"+ Math.random()+".png"));
            System.out.println("screenshot save");
        } catch (Exception e) {
            System.out.println("the is an issue with the script");
            throw new RuntimeException(e);
        }
    }
}

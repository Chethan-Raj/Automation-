import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestions {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.xpath("//input[@id= 'autosuggest']")).sendKeys("abc");
        Thread.sleep(3000);
        List<WebElement> options = driver.findElements(By.xpath("//li[@class = 'ui-menu-item']//a"));
        for (WebElement option : options) {

            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            } else if (option.getText().equalsIgnoreCase("Austria")) {
                option.click();
                break;
            } else {
                System.out.println("Country Not Found, search for a valid country!!");
            }
        }
    }
}


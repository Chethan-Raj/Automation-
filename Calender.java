import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Calender {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait expwait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://www.path2usa.com/travel-companion/");
        driver.manage().window().maximize();
//        driver.switchTo().frame(driver.findElement(By.xpath("//section[@date-id = '17639fa']")));
        WebElement element = driver.findElement(By.xpath("//input[@id ='form-field-travel_comp_date']"));
//        WebElement srl= driver.findElement(By.xpath("//select[contains(@name,'travel_comp_language')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
//        element.click();
        expwait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@id ='form-field-travel_comp_date']")));
        element.click();
        //expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'flatpickr-calendar animate arrowTop open')]")));
        List<WebElement> day =driver.findElements(By.className("flatpickr-day "));
        int i = 0;
        for(WebElement date : day){
            System.out.println(date.getText());
            String dates = date.getText();

            if(dates.equalsIgnoreCase("30")){
                driver.findElements(By.xpath("//span[@class = 'flatpickr-day ']")).get(i).click();
                break;
            }
            i++;
        }
    }
}

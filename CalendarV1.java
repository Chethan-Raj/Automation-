import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CalendarV1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.makemytrip.com/");
        driver.findElement(By.xpath("//label[@for = 'departure']")).click();
        WebDriverWait waitx = new WebDriverWait(driver, Duration.ofSeconds(3));
        waitx.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'datePickerContainer']")));
        //driver.findElement(By.xpath("//label[@for = 'departure']")).click();
        List<WebElement> calendar = driver.findElements(By.xpath("//div[@class = 'dateInnerCell']//p[1]"));

        for(int i = 0;i<calendar.size();i++){
            String day = calendar.get(i).getText();
            // driver.findElements(By.xpath("//div[(@class ,'DayPicker-Day DayPicker-Day--selected')]")).get(i).click();
            //System.out.println(day);
            if (day.equalsIgnoreCase(String.valueOf(22)) ){
                driver.findElements(By.xpath("//div[@class = 'dateInnerCell']//p[1]")).get(i).click();
                break;
            }
        }
        waitx.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-cy = 'returnArea']")));
        driver.findElement(By.xpath("//div[@data-cy = 'returnArea']")).click();
        driver.findElement(By.xpath("//span[contains(@aria-label, 'Next Month')]")).click();
        //boolean june = driver.findElement(By.xpath("//div[contains(text(),'June')]")).getText().contains("June");
        waitx.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@aria-label, 'Next Month')]")));
        while (!driver.findElement(By.xpath("//div[@class = 'DayPicker-Caption']")).getText().contains("June"))
        {
            driver.findElement(By.xpath("//span[contains(@aria-label, 'Next Month')]")).click();
        }
        List<WebElement> calendar1 = driver.findElements(By.xpath("//div[@class = 'dateInnerCell']//p[1]"));

        for(int i = 0;i<calendar1.size();i++){
            String day1 = calendar1.get(i).getText();
            // driver.findElements(By.xpath("//div[(@class ,'DayPicker-Day DayPicker-Day--selected')]")).get(i).click();
            //System.out.println(day1);
            if (day1.equalsIgnoreCase(String.valueOf(2)) ){
                driver.findElements(By.xpath("//div[@class = 'dateInnerCell']//p[1]")).get(i).click();
                break;
            }
        }
        //waitx.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id = 'range_error']")));
        String text = driver.findElement(By.xpath("//p[@id = 'range_error']")).getText();
        System.out.println(text);
        driver.findElement(By.xpath("//a[contains(text(), 'Search')]")).click();

//        waitx.until(ExpectedConditions.urlToBe("https://www.makemytrip.com/flight/search?itinerary=DEL-BLR-22/12/2022_BLR-DEL-02/06/2023&tripType=R&paxType=A-1_C-0_I-0&intl=false&cabinClass=E&ccde=IN&lang=eng"));
//        System.out.println(driver.getTitle());
    }
}

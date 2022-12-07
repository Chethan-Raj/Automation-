import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class FiltersGreenKart {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//*[@id = 'search-field']")).sendKeys("to");
        //driver.findElement(By.xpath("//*[@id = 'search-field']")).sendKeys("to");
        List<WebElement> filtered = driver.findElements(By.xpath("//tbody//tr//td[1]"));
        List<String> filterednames =  filtered.stream().map(s-> s.getText()).filter(s -> s.contains("to")).collect(Collectors.toList());
        filterednames.forEach(System.out::println);
    }
}

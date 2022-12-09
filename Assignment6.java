import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Locale;

public class Assignment6 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//input[@value ='option2']")).click();
        String option = driver.findElement(By.xpath("//label[@for ='benz']")).getText();
        WebElement dselect = driver.findElement(By.xpath("//select[@id = 'dropdown-class-example']"));
        Select dropdown = new Select(dselect);
        dropdown.selectByValue(option.toLowerCase(Locale.ROOT));
        driver.findElement(By.xpath("//input[@id = 'name']")).sendKeys(option);
        driver.findElement(By.xpath("//input[@id = 'alertbtn']")).click();
        String name = driver.switchTo().alert().getText();
        if(name.contains(option)){
            System.out.println("Alert message success");
        }
        else {
            System.out.println("issue with code. re check");
        }
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//input[@id = 'name']")).sendKeys(option);
        driver.findElement(By.xpath("//input[@id = 'confirmbtn']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();





    }
}

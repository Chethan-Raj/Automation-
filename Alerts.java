import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Alerts are JavaScript messages and cannot be spied using inspect option

public class Alerts {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //Alert with only one clickable option
        driver.findElement(By.xpath("//input[@id = 'name']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@id = 'alertbtn']")).click();
        String alert = driver.switchTo().alert().getText();
        System.out.println(alert);
        //to click on OK we need to append "accept()"
        driver.switchTo().alert().accept();

        //Alert with more than one clickable option
        driver.findElement(By.xpath("//input[@id = 'name']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@id ='confirmbtn']")).click();
        String confirm = driver.switchTo().alert().getText();
        System.out.printf(confirm);
        //"Accept()"  is used for positive note, ie, ok,done etc
        //"Dismiss()" is used for negative note ie, cancel,no etc
        driver.switchTo().alert().dismiss();
    }
}

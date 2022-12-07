import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
        //Since the value passed is true, executes further without any interruption

        driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
        Thread.sleep(2000);
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
        //Since the value passed is false, executes further without any interruption

        Integer num_ckb = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
        Assert.assertEquals(num_ckb,3);
    }
}

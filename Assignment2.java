import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.xpath("//div[@class= 'form-group']//input[@name = 'name']")).sendKeys("Test123");
        driver.findElement(By.xpath("//div[@class= 'form-group']//input[@name = 'email']")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//input[@id = 'exampleInputPassword1']")).sendKeys("test123");
        driver.findElement(By.xpath("//input[@id = 'exampleCheck1']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'exampleCheck1']")).isSelected());
        driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']")).click();
        driver.findElement(By.xpath("//select[@id = 'exampleFormControlSelect1']//option[1]")).click();
        String a = driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']//option[1]")).getText();
        Assert.assertEquals(a,"Male");
        driver.findElement(By.xpath("//input[@id = 'inlineRadio2']")).click();
        System.out.println(driver.findElement(By.xpath("//input[@id = 'inlineRadio2']")).isSelected());
        System.out.println(driver.findElement(By.xpath("//label[@for = 'inlineRadio2']")).getText());
        driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("22/12/1999");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class ='alert alert-success alert-dismissible']")).getText());
    }
}

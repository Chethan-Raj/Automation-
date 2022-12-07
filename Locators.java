import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Locators
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("Chethan");
        driver.findElement(By.name("inputPassword")).sendKeys("1rahulshettyacademy");
        driver.findElement(By.className("submit")).click();
        //System.out.println(driver.findElement(By.className("error")).getText());

        //Standard CSS selector
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        //System.out.println(driver.findElement(By.className("forgot-pwd-container")).getText());

        //Link text
        driver.findElement(By.linkText("Forgot your password?")).click();

        //CSS locator generic
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Test");

        //Xpath
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
        //sleep
        Thread.sleep(1000);

        //Xpath by Index
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("Test@gmail.com");
        //driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("Test");

        //CSS locator by Index
        driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("959000000");
        //driver.findElement(By.xpath("//button[@class ='reset-pwd-btn']")).click();

        //Xpath by parent-child "//parent/child [index number required only if similar elements are present]
        driver.findElement(By.xpath("//div/button[2]")).click();

        //System.out.println(driver.findElement(By.xpath("//p[@class ='infoMsg']")).getText());
        //System.out.println(driver.findElement(By.xpath("//form/p")).getText());

        //CSS Parent-child locator
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        driver.findElement(By.cssSelector("button[class = 'go-to-login-btn']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id= 'inputUsername']")).sendKeys("Chethan");
        driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("rahulshettyacademy");

        driver.findElement(By.xpath("//input[@value= 'rmbrUsername']")).click();
        driver.findElement(By.xpath("//input[@value = 'agreeTerms']")).click();
        //Xpath if the part of value changes dynmically
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        //Thread.sleep(6000);
        //driver.findElement(By.xpath("//button[@class='logout-btn']")).click();

        //driver.close();
    }


}


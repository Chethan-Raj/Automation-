import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Locators_2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        String username = "Chethan";
        Locators_2 aa = new Locators_2();
        String pwd = aa.getpwd(driver);
        driver.findElement(By.xpath("//input[@id= 'inputUsername']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys(pwd);
        driver.findElement(By.xpath("//input[@value= 'rmbrUsername']")).click();
        driver.findElement(By.xpath("//input[@value = 'agreeTerms']")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        Thread.sleep(1000);
        //Xpath Parent to child relation
        //String str = driver.findElement(By.xpath("//div[@class = 'login-container']//p")).getText();
        String str = driver.findElement(By.tagName("p")).getText();
        System.out.println(str);
        //Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'login-container']//p")).getText(),"this is a sample textt");
        Assert.assertEquals(str,"You are successfully logged in.");
        String a =  driver.findElement(By.xpath("//div[@class = 'login-container']//h2")).getText();
        System.out.println(a);
        Assert.assertEquals(a,"Hello "+username+",");
        //driver.findElement(By.xpath("//button[@class = 'logout-btn']")).click();
        //find element by name Xpath
        driver.findElement(By.xpath("//button[text() = 'Log Out']")).click();
        driver.close();

    } ;
    public String  getpwd(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.xpath("//div[@class = 'forgot-pwd-container']//a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class= 'reset-pwd-btn']")).click();
        String txt = driver.findElement(By.xpath("//p[@class ='infoMsg']")).getText();
        //txt = Please use temporary password 'rahulshettyacademy' to Login.
        String[] pwdarray = txt.split("'");
        //0 - Please use temporary password '
        //1 - rahulshettyacademy' to Login.
        //get the index 0 of index 1 of txt
        String pwd = pwdarray[1].split("'")[0];
        driver.findElement(By.xpath("//button[@class= 'go-to-login-btn']")).click();
        return pwd;


    }
}



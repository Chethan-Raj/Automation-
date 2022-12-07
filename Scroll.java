import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

//window scroll and table scroll
public class Scroll {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //Console: CSS Script: document.querySelector(".tableFixHead").scrollTop = 4000
//        Normal Scroll CSS Script: window.scroll(0,600)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,600)");
        Thread.sleep(2000);
        js.executeScript("document.querySelector(\".tableFixHead\").scrollTop = 4000");
        List<WebElement> amt = driver.findElements(By.xpath("//div[@class = 'tableFixHead']//td[4]"));
        int j = 0;
        for (int i = 0; i<amt.size();i++){
            String values = driver.findElements(By.xpath("//div[@class = 'tableFixHead']//td[4]")).get(i).getText();
            System.out.println(values);
            j = j + Integer.parseInt(values);
        }
        System.out.println(j);
        String text = driver.findElement(By.xpath("//div[@class = 'totalAmount']")).getText();
        String val1 = text.split(": ")[1];
        System.out.println(val1.trim());
        Assert.assertEquals(val1,String.valueOf(j));
    }
}
//scroll by id
//return document.getElementById(\"hiddentext\").value;";
//String text=(String) js.executeScript(val);


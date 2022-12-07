import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//Dynamic UI
//UI Elements enabled or Disabled

public class DynamicUI {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.xpath("//span[@id = 'ctl00_mainContent_ddl_originStation1_CTXTaction']")).click();
        driver.findElement(By.xpath("//a[@value ='BLR']")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("(//a[@value ='MAA'])[2]")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value= 'HBX']")).click();
        //Thread.sleep(2000);
        String s= driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value= 'HBX']")).getText();
        System.out.println(s);
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath("//td[contains(@class,'ui-datepicker-today')]//a[@class= 'ui-state-default ui-state-highlight']")).getText());
        driver.findElement(By.xpath("//td[contains(@class,'ui-datepicker-today')]//a[@class= 'ui-state-default ui-state-highlight']")).click();

        //UI Elements enabled or Disabled
        //System.out.println(driver.findElement(By.xpath("//input[@id = 'ctl00_mainContent_rbtnl_Trip_1']")).isSelected());
        driver.findElement(By.xpath("//input[@id = 'ctl00_mainContent_rbtnl_Trip_1']")).click();
        //System.out.println(driver.findElement(By.xpath("//input[@id = 'ctl00_mainContent_rbtnl_Trip_1']")).isSelected());
        Thread.sleep(2000);


        //"is Displayed" is inconsitent and need to do work around
        //Using Get attribute method we can get the status enabled or Disabled
        if (driver.findElement(By.xpath("//div[@id= 'Div1']")).getAttribute("Style").contains("0.5"))
        {
            System.out.println("Enabled");
            Assert.assertTrue(true);
        }
        else
        {
            System.out.println("Disabled");
            //if "false" is passed for assert true, the testcase shall fail as assert true, requires to pass only true value
            Assert.assertTrue(false);
        }

    }
}

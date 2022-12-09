import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class E2E {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //Auto Suggestion Dropdown
        driver.findElement(By.xpath("//input[@id= 'autosuggest']")).sendKeys("Ind");
        Thread.sleep(3000);
        List<WebElement> options = driver.findElements(By.xpath("//li[@class = 'ui-menu-item']//a"));
        for (WebElement option : options) {

            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            } else if (option.getText().equalsIgnoreCase("Austria")) {
                option.click();
                break;
            }
        }

        //Dynamic Dropdown
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

        //UI Validation (round way/ single way)
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

        //Passenger Count
        driver.findElement(By.xpath("//div[@id = 'divpaxinfo']")).click();
        Thread.sleep(2000);
        String x = driver.findElement(By.xpath("//span[@id='spanAudlt']")).getText();
        Integer num = Integer.parseInt(x);
        for (int i = 0;num<3;i++)
        {
            driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
            num++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        String a = driver.findElement(By.xpath("//div[@id = 'divpaxinfo']")).getText();
        System.out.println(a);

        //Static Dropdown
        WebElement StaticDropdown = driver.findElement(By.xpath("//select[@id = 'ctl00_mainContent_DropDownListCurrency']"));
        Select dropdown = new Select(StaticDropdown);
        dropdown.selectByVisibleText("USD");
        Assert.assertEquals("USD",dropdown.getFirstSelectedOption().getText());

        //Click on search
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();

    }
}

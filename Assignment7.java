import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Assignment7 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        //driver.get("file:///C:/Users/905953/OneDrive%20-%20Cognizant/Desktop/Testtable.html");
        List< WebElement> row = driver.findElements(By.xpath("//table[@class= 'table-display']//tbody//tr"));
        int i = 0;
        for(WebElement rows : row){
            driver.findElement(By.xpath("//table[@class= 'table-display']//tbody//tr"));
            i++;
        }
        System.out.println("Number of rows: "+ i);

        List<WebElement> column = driver.findElements(By.xpath("//table[@class= 'table-display']//tbody//tr[1]//th"));
        int j = 0;
        for (WebElement columns: column) {
            driver.findElements(By.xpath("//table[@class= 'table-display']//tbody//tr[1]//th"));
            j++;
        }
        
        System.out.println("Number of columns: " +j);

        List <WebElement> row2 = driver.findElements(By.xpath("//table[@class= 'table-display']//tbody//tr[3]//td"));
        int x = 0;
        for (WebElement row22: row2) {
            System.out.println(driver.findElements(By.xpath("//table[@class= 'table-display']//tbody//tr[3]//td")).get(x).getText());
            x++;
        }

    }

}

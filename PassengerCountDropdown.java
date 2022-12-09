import org.mozilla.javascript.ast.WhileLoop;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PassengerCountDropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.xpath("//div[@id = 'divpaxinfo']")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
        String x = driver.findElement(By.xpath("//span[@id='spanAudlt']")).getText();
        Integer num = Integer.parseInt(x);
        //System.out.println(num);
        /*while(num<3)
        {
            driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
            num++;
        }*/

        for (int i = 0;num<3;i++){
            driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
            num++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        String a = driver.findElement(By.xpath("//div[@id = 'divpaxinfo']")).getText();
        System.out.println(a);
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Assignment3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        WebDriverWait expwait = new WebDriverWait(driver,Duration.ofSeconds(8));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.xpath("//input[@id ='username']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//input[@id ='password']")).sendKeys("learning");

        driver.findElement(By.xpath("//span[text() =' User']")).click();
        driver.findElement(By.xpath("//span[text() =' User']")).isSelected();
        //pop up message
        expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button [@id = 'okayBtn']")));
        driver.findElement(By.xpath("//button [@id = 'okayBtn']")).click();

        //Static Dropdown
        WebElement doptions = driver.findElement(By.xpath("//select[@class = 'form-control']"));
        Select dropdown = new Select(doptions);
        dropdown.selectByVisibleText("Consultant");

        //terms and conditions
        driver.findElement(By.xpath("//input[@id = 'terms']")).click();

        //Submit
        driver.findElement(By.xpath("//input[@id = 'signInBtn']")).click();

        //explicit wait for new page
        expwait.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/angularpractice/shop"));

        //click on add to cart
        List <WebElement> addtocart = driver.findElements(By.xpath("//button[@class = 'btn btn-info']"));

        for (WebElement add: addtocart){
            //int ind = addtocart.indexOf(add);
            //System.out.println(ind);
            if(addtocart.indexOf(add)<4){
                driver.findElements(By.xpath("//button[@class = 'btn btn-info']")).get(addtocart.indexOf(add)).click();
            }
        }
        driver.findElement(By.xpath("//li[contains(@class, 'nav-item active')]")).click();

        //wait for next page
        expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class ,'btn btn-success')]")));

        //cart page
        driver.findElement(By.xpath("//button[contains(@class ,'btn btn-success')]")).click();

        //wait for final page
        expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type = 'submit']")));


        String place = "Ind";
        driver.findElement(By.xpath("//input[@id = 'country']")).sendKeys(place);
        expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'suggestions']")));


        ArrayList<String> select = new ArrayList<String>();
        List<WebElement> counties = driver.findElements(By.xpath("//div[@class = 'suggestions']"));
        for (WebElement country : counties){
            String spl = country.getText().split("\n")[0];
            String loop = country.getText();

            if(spl.matches("India")){
                driver.findElement(By.xpath("//a[text() = 'India']")).click();
            }
        }
        Thread.sleep(5000);
        driver.findElement(By.xpath("//label[@for = 'checkbox2']")).click();
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();

    }
}

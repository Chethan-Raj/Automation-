import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Waits {
    public static void main(String[] args) throws InterruptedException {
        //Implicit and Explicit are part of selenium web driver
        /*Implicit wait:wait n number of seconds before throwing any exceptions and Applies globally
            if a page loads before the specified time, execution Continues,
            and it does not wait for the entire time specified once the object is found
        */

        //Explicit wait: specific to only defined elements

        //Thread.sleep: is a function of java class, irrespective of element found /not found it waits for the specific amount of time

        //Fluent Sleep:


        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //Explicit wait should be initialized
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));

        String[] list = {"Tomato", "Cucumber", "Carrot", "Potato"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        //additems(driver,list);-->  Declaration with static

        //declaration without static
        // main class [variable name] = "new" main class();
        Waits meth = new Waits();
        meth.additems(driver,list);

        driver.findElement(By.xpath("//img[@alt = 'Cart']")).click();
        driver.findElement(By.xpath("//div[@class = 'cart-preview active']//button[text()='PROCEED TO CHECKOUT']")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class = 'promoCode']")));
        driver.findElement(By.xpath("//input[@class = 'promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[@class ='promoBtn']")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class ='promoInfo']")));

        System.out.println(driver.findElement(By.xpath("//span[@class ='promoInfo']")).getText());

    }
    public void additems(WebDriver driver,String[] list) throws InterruptedException    {
        //can pass the array from main method to be initiated with driver
        List<WebElement> names = driver.findElements(By.xpath("//h4[@class = 'product-name']"));
        ArrayList<String> na = new ArrayList<String>();
        int j = 0;
        for (WebElement name : names) {
            String product = name.getText().split(" ")[0];
            na.add(product);
            //System.out.printf(na+"\n");
            int position = na.indexOf(product);
            List<String> items = Arrays.asList(list);
            //Thread.sleep(1000);

            if (items.contains(product)) {

                driver.findElements(By.xpath("//div[@class = 'product-action']//button")).get(position).click();
                j++;
                if (j == 2)
                    break;
            }
        }

    }
}

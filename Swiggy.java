import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Swiggy {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        WebDriverWait waitx = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.swiggy.com/");
        driver.findElement(By.xpath("//input[@id = 'location']")).sendKeys("Mysore");
        waitx.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class = '_3lmRa']")));
        List<WebElement> loc = driver.findElements(By.xpath("//button[@class = '_3lmRa']"));
        List<String> location = loc.stream().map(s -> s.getText()).collect(Collectors.toList());
        System.out.println(location);
        if (location.contains("Mysore Palace, Sayyaji Rao Road, Agrahara, Chamrajpura, Mysuru, Karnataka, India")) {
            driver.findElement(By.xpath("//button[@class = '_3lmRa']")).click();
        }
        waitx.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'BZR3j']")));
        driver.findElement(By.xpath("//div[contains(text(),'Polar Bear Ice Cream Sundaes')]")).click();
        waitx.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class = 'M_o7R _27PKo']")));
        List<WebElement> menu = driver.findElements(By.xpath("//h3[@class = 'styles_itemNameText__3ZmZZ']"));

        int noplates = 0;
        String total = "";
        for (int i = 0;i<menu.size();i++){
            String r = menu.get(i).getText();
                if (r.contains("Choco Blocka Sundae Tub (480 ml)")) {
                    driver.findElements(By.xpath("//div[@class = '_3L1X9 F8dpS']")).get(i).click();
                    //waitx.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = '_2zAXs _18lJJ']")));
                    noplates = Integer.parseInt(driver.findElement(By.xpath("//div[@class = '_2zAXs _18lJJ']")).getText());
                    System.out.println(noplates);
                    waitx.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = '_161V3']//span")));
                    String x = driver.findElement(By.xpath("//div[@class = '_161V3']//span")).getText();
                    total = x.split("₹")[1].trim();
                    driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
                    break;
                }
            }
            waitx.until(ExpectedConditions.urlToBe("https://www.swiggy.com/checkout"));
            String ckout = driver.findElement(By.xpath("//span[@class = '_2W2U4']")).getText();
            Assert.assertEquals(total,ckout);
        }
    }


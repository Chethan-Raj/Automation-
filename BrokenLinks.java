import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        // WILL GET ALL THE URLS AND VERIFY AND GET THE STATUS WITHOUT OPENING IN THE LINK
        //STEP-1 get all the URL's
        //String url = driver.findElement(By.xpath("//li//a[contains(text() , 'Broken Link')]")).getAttribute("href");
        List<WebElement> links = driver.findElements(By.xpath("//div[@id = 'gf-BIG']//li//a"));
        SoftAssert sassert = new SoftAssert();
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            //System.out.println(url);
            //HttpsURLconnection
            HttpURLConnection status = (HttpURLConnection) new URL(url).openConnection();
            status.setRequestMethod("HEAD");
            int respocode = status.getResponseCode();
            System.out.println(link.getText() + " " + respocode);
            //Hard Assert: Assert.assertFalse(respocode > 400, ("Name of the broken link text: " + link.getText() + " Responce Code: " + respocode));

            //soft assert catches the validation but does not soft the execution
            sassert.assertFalse(respocode > 400, ("Name of the broken link text: " + link.getText() + " Responce Code: " + respocode));
        }
//        written outside loop: this helps in catching all the validation
        sassert.assertAll();
    }
}

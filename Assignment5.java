import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        System.out.println(driver.findElements(By.tagName("frame")).size());
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name = 'frame-top']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name = 'frame-middle']")));
        String Middlename = driver.findElement(By.xpath("//div[@id = 'content']")).getText();
        System.out.println(Middlename);
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropFrams {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class= 'demo-frame']")));
        driver.findElement(By.xpath("//div[@id = 'draggable']")).click();
        Actions Act = new Actions(driver);
        WebElement source = driver.findElement(By.xpath("//div[@id = 'draggable']"));
        WebElement target = driver.findElement(By.xpath("//div[@id = 'droppable']"));
        Act.dragAndDrop(source,target).build().perform();
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.xpath("//h1[@class = 'entry-title']")).getText());

    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

public class WebTableSorting {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //click on column header
        List<WebElement> bydefault = driver.findElements(By.xpath("//tbody//tr//td[1]"));
        List<String> def = bydefault.stream().map(s -> s.getText()).collect(Collectors.toList());
        driver.findElement(By.xpath("//span[contains(text(),'Veg/fruit name')]")).click();
        List<WebElement> ascorder = driver.findElements(By.xpath("//tbody//tr//td[1]"));
        List<String> ordered = ascorder.stream().map(s -> s.getText()).collect(Collectors.toList());
        SoftAssert compare = new SoftAssert();
        compare.assertEquals(def, ordered);
        //compare.assertAll();

        //verify the price of rice
        //scan the name column
        List<String> price;
        do {
            List<WebElement> def1 = driver.findElements(By.xpath("//tbody//tr//td[1]"));
            price = def1.stream().filter(s -> s.getText().contains("Rice"))
                    .map(s -> getprice(s)).collect(Collectors.toList());
            price.forEach(System.out::println);

            if (price.size() < 1) {
                driver.findElement(By.xpath("//*[@aria-label= 'Next']")).click();
            }
        }
        while (price.size() < 1);
    }

    public static String getprice(WebElement s){

        String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return  price;
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class RandomTests {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://www.flipkart.com/");
        Thread.sleep(2000);
        /*driver.getWindowHandle();
        Thread.sleep(2000);*/
        driver.findElement(By.xpath("//div[@class= '_2QfC02']//button[@class= '_2KpZ6l _2doB4z']")).click();
        driver.findElement(By.xpath("//input[@class = '_3704LK']")).sendKeys("iphone");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//li[@class= 'Y5N33s'])[1]")).click();
        Thread.sleep(5000);
        //System.out.println(Arrays.toString(driver.findElements(By.xpath("//div[@class= '_30jeq3 _1_WHN1']")).toArray()));

        List <WebElement> price = driver.findElements(By.xpath("//div[@class= '_30jeq3 _1_WHN1']"));
        System.out.println(price.size());
        ArrayList<String> sorted = new ArrayList<String>();
        ArrayList<Integer> x1 = new ArrayList<Integer>();
        for(int i = 0;i<price.size();i++){
            String aa = price.get(i).getText().split("₹")[1];
            int x = Integer.parseInt(aa.replace(",",""));
            x1.add(x);
            //sorted.add(aa);
        }
        Collections.sort(x1);

        for(Integer a: x1){
            //DecimalFormat finalCellFormater = new DecimalFormat("##,##,##0");
            //finalCellFormater.format(a);

            Locale indian = new Locale("en", "IN");
            NumberFormat a1 = NumberFormat.getCurrencyInstance(indian);
            System.out.println(a1.format(a));
        }
        /*
        ArrayList<String> sorted = new ArrayList<String>();
        for (WebElement prc: price){
            String txt = prc.getText();
            sorted.add(txt);
        }
        Collections.sort(sorted);
        //Collections.sort(sorted,Collections.reverseOrder());
        System.out.println(sorted);*/

    }

}

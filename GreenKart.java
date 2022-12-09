import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreenKart {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Declaring an array for list of vegetables to click on add to cart
        String[] list = {"Tomato","Cucumber","Carrot","Potato"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        //need to use "list" as we are returning "elements"
        List<WebElement> names = driver.findElements(By.xpath("//h4[@class = 'product-name']"));

        ArrayList<String> na = new ArrayList<String>();
        int j = 0;
        for (WebElement name : names) {
            String product = name.getText().split(" ")[0];
            //".trim()" can be used to trim of the white spaces in the values
            na.add(product);
            //System.out.printf(na+"\n");
            int position = na.indexOf(product);

            //System.out.println(position);
            //need to convert the list from array to arraylist inorder for easy search
            //Convert array to array list
            List<String> items = Arrays.asList(list);
            Thread.sleep(4000);


            if(items.contains(product)){

                driver.findElements(By.xpath("//div[@class = 'product-action']//button")).get(position).click();
                j++;
                //this breaks the execution after particular instance, so the remaining elements are not looped unnecessarily
                if(j == 2)
                    break;
            }
        }
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//Chechboxes and Assertions code is written in this file

public class CheckBox {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


        //"Assert.assertFalse"--> requires to pass false condition, if the condition is false, will execute further
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id = 'ctl00_mainContent_chk_friendsandfamily']")).isSelected());

        //"is selected" is used to verify if the checkbox/radio button is selected or not, it's of form Boolean
        //System.out.println(driver.findElement(By.xpath("//input[@id = 'ctl00_mainContent_chk_friendsandfamily']")).isSelected());
        driver.findElement(By.xpath("//input[@id = 'ctl00_mainContent_chk_friendsandfamily']")).click();
        Boolean verify = driver.findElement(By.xpath("//input[@id = 'ctl00_mainContent_chk_friendsandfamily']")).isSelected();
        System.out.println(verify);

        //"Assert.asserttrue"-->requires to pass the true condition, if the condition is true, will execute further
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'ctl00_mainContent_chk_friendsandfamily']")).isSelected());


        //Verify number of checkboxes present in the page, we are using "elements" as we have more than one checkbox present in the webpage
        //"size()" gives us the number of count of the same object
        System.out.println(driver.findElements(By.xpath("//input[@type= 'checkbox']")).size());


        //ASSERTIONS
        Integer a = driver.findElements(By.xpath("//input[@type= 'checkbox']")).size();
        Assert.assertEquals(a,6);

        driver.findElement(By.xpath("//div[@id = 'divpaxinfo']")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
        driver.findElement(By.xpath("//span[@id = 'hrefIncChd']")).click();
        String x = driver.findElement(By.xpath("//span[@id='spanAudlt']")).getText();
        Integer num = Integer.parseInt(x);
        for (int i = 0;num<3;i++){
            driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
            num++;
        }
        String a1 = driver.findElement(By.xpath("//span[@id = 'spanAudlt']")).getText();
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(a1);
        //Assert.assertEquals(a1,"4");
    }
}

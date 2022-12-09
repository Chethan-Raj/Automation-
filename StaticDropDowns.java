import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StaticDropDowns {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //Dropdown with select tag = Static dropdown
        //need to initialize a new "Web Element" and assign the path of the dropdown
        WebElement StaticDropdown = driver.findElement(By.xpath("//select[@id = 'ctl00_mainContent_DropDownListCurrency']"));
        //initialize select function
        Select dropdown = new Select(StaticDropdown);
        dropdown.selectByIndex(3);
        //to get the text of the dropdown value= "getFirstselectedOption()" which returns WebElement
        //gettext is used to extract the text value from the element
        Assert.assertEquals("USD", dropdown.getFirstSelectedOption().getText());
        //selectbyvalue: select the dropdown wrt value attribute (in html)
        dropdown.selectByValue("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        //selectbyvisibletext: selects the option based on the text visible in the UI
        dropdown.selectByVisibleText("INR");
        Assert.assertEquals("INR",dropdown.getFirstSelectedOption().getText());

    }
}

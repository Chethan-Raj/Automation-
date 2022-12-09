import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class browserCapabilities {
    public static void main(String[] args) {
        //Plugins , addons etc
        ChromeOptions options = new ChromeOptions();
        //options.addExtensions("file path");

        //run chrome sessions with proxy
        Proxy pro = new Proxy();
        //pro.setHttpProxy("ipaddress:1111") --> gives a lot of options needs to select the valid one depending on project
        options.setCapability("proxy", pro);

        //Block pop ups , like website wants to access the location, camera etc
        ChromeOptions option = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

        //set file download path
        ChromeOptions option2 = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "/directory/path");
        options.setExperimentalOption("prefs", prefs);


        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);


    }

}

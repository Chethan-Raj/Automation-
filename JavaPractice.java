import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JavaPractice {

    @Test
    public void commonEleinArr(){
        //Common elements in an array
        int[] arr1 = {231,45,23,557,812,34,67};
        int[] arr2 = {123,345,23,7,32,344,637};
        System.out.println("The common elements are: ");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]){
                    System.out.println(arr1[i]);
                    System.out.println("RD" + 10 + 20);
                    System.out.println(10 + 20 +"RD" );
                }
            }
        }
    }

    @Test
    public void DistEleinArr(){
        int[] arr1 = {231,45,23,557,812,34,67};
        int[] arr2 = {123,345,23,7,32,344,637};
        System.out.println("distinct elements are: ");

        for (int i = 0; i < arr1.length; i++) {
            int find = 0;
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]){
                    find =1;
                    break;
                }
            }
            if (find==0){
                System.out.println(arr1[i]);
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            int find = 0;
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]){
                    find =1;
                    break;
                }
            }
            if (find==0){
                System.out.println(arr2[i]);
            }
        }
    }

    @Test
    public void EquiTri(){
        int n = 7;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n-i-j; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <=i; k++) {
                System.out.print("* ");
            }
        }
        System.out.println();
    }

    @Test //File Upload
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement upload = driver.findElement(By.xpath("//input[@id = 'file-upload']"));
        upload.sendKeys("C://Users//905953//IdeaProjects//Automation//src//main//java//Assignment1.java");
    }

    @Test
    public void Q16(){
        String test = "aaddeeffdddd";
        int[] count = new int[255];
        int len = test.length();
        for (int i = 0; i < len; i++) {
            count[test.charAt(i)]++;
        }
        char[] chr = new char[test.length()];
        for (int i = 0; i < test.length(); i++) {
            chr[i] = test.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {
                {
                    if(test.charAt(i)==chr[j])
                    find++;
                }
                if (find ==1){
                    System.out.println(test.charAt(i));
                }
            }
        }

    }


    @Test
    public void Q15(){
        String[] pan1 = {"CHEPN2014C","CHAND8014C"};
        String[] gstin = {"29CHEPN2014C1Z5","29ADSC2014C1Z5"};
        List<String> pan = Arrays.asList(pan1);
        List<String> gst = Arrays.asList(gstin);
        for (int i = 0; i < gst.size(); i++) {
            String gst2= gst.get(i);

            for (int j = 0; j < pan.size(); j++) {
                String pan2 = pan.get(j);

                if (gst2.contains(pan2)){
                    System.out.println(gst2+ " "+ pan2 +  " " +true) ;
                }
                else{
                    System.out.println(gst2+ " "+ pan2 + " "+ false);
                }
            }
        }
    }

    @Test
    public void test(){
        String test = "aaassddewsddx";
        int count = 0;
        for (int i = 0; i < test.toCharArray().length-1; i++) { //char length = 12 , i = 0, i = 3,i = 5
            if (test.toCharArray()[i] == test.toCharArray()[i+1]){ //a==a true;s==s
                count++; //count = 1;c = 2
                while (test.toCharArray()[i] == test.toCharArray()[i+1]) { //a==a true;l2:a==a true;l3 a!= s;l4
                    i++; //i = 1;l2 i= 2;l3 = 4
                    if (i + 1 == test.toCharArray().length) { //2!=12
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}

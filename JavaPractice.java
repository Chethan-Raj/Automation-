import org.testng.annotations.Test;

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
}

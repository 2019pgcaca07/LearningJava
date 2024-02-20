package ArrayEasy;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMinElement {
    public static void main(String []args){
        //Given array
        int[] arr = {3,5,4,1,9};
        Scanner input = new Scanner(System.in);

        System.out.println("Type 1 for  function using linear search " +
                "Type 2 for function using sorting");
        int choice = input.nextInt();
        switch(choice){
            case 1:
                function1(arr);
                break;
            case 2:
                function2(arr);
                break;
            default:

                System.out.println("WRONG CHOICE");
        }
    }
    //this gunction taking o(n) as using linear search
    private static void function1(int[] arr){
           int min = Integer.MAX_VALUE;
           int max = Integer.MIN_VALUE;
        for (int j : arr) {
            if (min > j) {
                min = j;
            }
            if (max < j) {
                max = j;
            }
        }
           System.out.println("min is "+min +" max is "+ max);
    }
    private static void function2(int[] arr){
         //using java inbuilt sort method to solve this in o(nlogn)
        Arrays.sort(arr);
        System.out.println("min is "+arr[0]+" and max is "+arr[arr.length-1]);
    }
}

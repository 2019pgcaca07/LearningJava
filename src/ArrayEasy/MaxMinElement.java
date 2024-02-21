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
            case 3:
                function3(arr);
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
    private static void function3(int[] arr){
        Pair minMax = helper(arr,0,arr.length-1);
        System.out.println("min is "+ minMax.min +" max is "+minMax.max);
    }
    static class Pair{
        int min;
        int max;
    }
    private static Pair helper(int[] arr,int low,int high){

        Pair minMax = new Pair();
        //1.base case->if there is only one element
        if(low == high){
            minMax.min = arr[low];
            minMax.max =arr[low];
            return minMax;
        }
        //1.base case->if there are only two element
        if(low+1 == high){
            minMax.min = (arr[low]<arr[high]) ? arr[low] : arr[high];
            minMax.max = (arr[low] > arr[high]) ? arr[low] : arr[high];
           return minMax;
        }
        //2.hypothesis ,divide the array into two halves
        int mid = (low+high)/2;
        Pair minMaxLeft = new Pair();//to save min amnd max of left have
        Pair minMaxRight = new Pair();//to save min amnd max of right have
        minMaxLeft = helper(arr,low,mid);//suppose it will give min max of left half
        minMaxRight = helper(arr, mid + 1, high);//suppose it will give min max of right half
        //3.small calculation
        //comparing min of left and right and assign it to final min
        minMax.min = minMaxLeft.min< minMaxRight.min? minMaxLeft.min : minMaxRight.min;
        //comparing max of left and right and assign it to final maxs
        minMax.max = minMaxLeft.max> minMaxRight.max? minMaxLeft.max:minMaxRight.max;
        return minMax;


    }
}

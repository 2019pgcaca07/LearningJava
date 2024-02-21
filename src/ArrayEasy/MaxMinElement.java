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
            case 4:
                Pair maxMin = function4(arr);
                System.out.println("max is "+ maxMin.max + " min is "+maxMin.min);
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
    //function by dividing and search in left and right halve then compare
    private static Pair helper(int[] arr,int low,int high){
       //o(n) and for recursive call o(log n) stack space
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
    //function by comparing pairs ,if n is odd then suppose 1st element is max and min and then
    //start with the next index i and comapre with next of i that is i+1 and then compare it with max and min
    //and update accoprdingly .similarly if nis even 1st find 1st two of element which is max and min then start
    //with index 2 and again by comparing the pairs then comapre it with max and min and update accordingly.
    private static Pair function4(int[] arr){
        int n = arr.length;
        Pair maxMin = new Pair();
        int i;
        if(n%2!=0){
            maxMin.min = arr[0];
            maxMin.max = arr[0];
            i=1;
        }else{
            if(arr[0]>arr[1]){
                maxMin.max = arr[0];
                maxMin.min = arr[1];
                i=2;
            }else{
                maxMin.max = arr[1];
                maxMin.min = arr[0];
                i=2;
            }
        }
        while (i<n-1){
            if(arr[i]<arr[i+1]){
                if(arr[i]< maxMin.min){
                    maxMin.min = arr[i];
                }
                if(arr[i+1]> maxMin.max){
                    maxMin.max = arr[i+1];
                }
            }else{
                if(arr[i]>maxMin.max){
                    maxMin.max =arr[i];
                }
                if(arr[i+1]<maxMin.min){
                    maxMin.min =arr[i+1];
                }
            }
            i+=2;
        }
        return maxMin;
    }
}

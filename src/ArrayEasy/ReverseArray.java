package ArrayEasy;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5,6};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the choice 1 to solve by loop enter 2 for using recursion and 2 for using stack");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                 usingLoop(arr);
                break;
            case 2:
                int low =0;
                int high = arr.length-1;
               usingRecursion(arr,low,high);
               printArray(arr);
                break;
            case 3:
                usingStack(arr);
            default:
                System.out.println("WRONG CHOICE");
        }

    }
    //1.FUNCTION using loop
    private static int[] usingLoop(int[] arr){
        int startIndex =0;
        int lastIndex = arr.length-1;
        while(startIndex<lastIndex){
            int temp = arr[startIndex];
            arr[startIndex] = arr[lastIndex];
            arr[lastIndex] = temp;
            startIndex++;
            lastIndex--;
        }
      printArray(arr);
        return arr;
    }
    //2.Function using recursion
    private static int[] usingRecursion(int[] arr,int low,int high){
       //base case when there is only one element,it also cover the case when n is odd so for one element
        //it will just return without swapping
        if(low==high){
            return arr;
        }
        //when n is even above test case does't meet this one meet
        if(low>high){
            return arr;
        }
        //hypothesis step: suppose it will reverse the array from low+1 to high -1
        //then we have to swap 1st and last element and the whol;e array is reversed
        usingRecursion(arr,low+1,high-1);
        //small calculation
        int temp = arr[low];
        arr[low]=arr[high];
        arr[high] =temp;
        return arr;

    }
    private static int[] usingStack(int[] arr){
   return arr;

    }
    //print array function
    private static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}

package Recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={3,4,1,7,5,8,2};
        bubbleSort(arr,arr.length-1,0);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr,int i,int j)
    {
        if(i==0)
            return;
        if(j<i)
        {
            if(arr[j]>arr[j+1])
            {
                int temp=arr[j+1];
                arr[j+1]=arr[j];
                arr[j]=temp;
            }
            bubbleSort(arr,i,j+1);
        }
        else
        {
            bubbleSort(arr,i-1,0);
        }
    }
}

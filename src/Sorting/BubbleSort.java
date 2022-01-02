package Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={10,8,20,5};
//        bubbleSort(arr);
        bubbleSortEnhanced(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr)
    {
        int n=arr.length;
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                    swap(arr,j,j+1);
            }
        }
    }

    static void bubbleSortEnhanced(int[] arr)
    {
        int n=arr.length;
        for(int i=0;i<n-1;i++)
        {
            boolean sort=false;
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    swap(arr,j,j+1);
                    sort=true;
                }
            }
            if(!sort)
                break;
        }
    }

    static void swap(int[] arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

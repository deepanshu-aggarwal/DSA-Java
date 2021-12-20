package Recursion;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
//        int[] arr={1,2,3,4,5};
//        int[] ans=mergeSort(arr);
        mergeSortEfficient(arr,0,arr.length);
//        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(arr));
    }

    static int[] mergeSort(int[] arr)
    {
        if(arr.length==1)
            return arr;
        int mid=arr.length/2;
        int[] left=mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right=mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }

    static int[] merge(int[] first,int[] second)
    {
        int[] mix=new int[first.length+second.length];
        int k=0,i=0,j=0;
        while(i<first.length && j<second.length)
        {
            if(first[i]<second[j])
            {
                mix[k]=first[i];
                i++;
            }
            else
            {
                mix[k]=second[j];
                j++;
            }
            k++;
        }

        while(i<first.length)
        {
            mix[k]=first[i];
            i++;
            k++;
        }

        while(j<second.length)
        {
            mix[k]=second[j];
            j++;
            k++;
        }

        return mix;
    }

    static void mergeSortEfficient(int[] arr,int s,int e)
    {
        if(s==e-1)
            return;
        int m=s+(e-s)/2;
        mergeSortEfficient(arr,s,m);
        mergeSortEfficient(arr,m,e);

        merge(arr,s,m,e);
    }

    static void merge(int[] arr,int s,int m,int e)
    {
        int[] mix=new int[e-s];
        int i=s,j=m,k=0;
        while(i<m && j<e)
        {
            if(arr[i]<arr[j])
            {
                mix[k]=arr[i];
                i++;
            }
            else
            {
                mix[k]=arr[j];
                j++;
            }
            k++;
        }

        while(i<m)
        {
            mix[k]=arr[i];
            i++;
            k++;
        }

        while(j<e)
        {
            mix[k]=arr[j];
            j++;
            k++;
        }

        for(int x=s;x<e;x++)
        {
            arr[x]=mix[x-s];
        }
    }
}

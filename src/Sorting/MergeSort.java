package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    private static void merge(int[] arr, int l, int h, int mid){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = l, right = mid+1;

        while(left<=mid && right<=h){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            } else{
                temp.add(arr[right]);
                right++;
            }
        }

        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }

        while(right<=h){
            temp.add(arr[right]);
            right++;
        }

        for(int i=l; i<=h; i++){
            arr[i] = temp.get(i-l);
        }
    }

    private static void mergeSort(int[] arr, int l, int h){
        if(l >= h)    return;
        int mid = l+(h-l)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, h);
        merge(arr, l, h, mid);
    }

    public static void main(String[] args) {
        int[] arr = {10, 8, 20, 5, 2, 3, 54, 45, 9, 7};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}

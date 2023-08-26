package Sorting;

import java.util.Arrays;

public class QuickSort {

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[low], i = low, j = high;

        // note that i and j pointers should not cross each other
        // else it means that there is no small element than pivot after i and no greater before j
        // else i & j had encountered and swapped them
        while(i<j){
            // stop when element at i is greater than pivot
            // also, i should not cross the high, as high is border
            while(arr[i] <= pivot && i <= high)  i++;

            // stop when element at j is smaller than pivot
            // also, j should not cross the low, as low is border
            while(arr[j] > pivot && j >= low)  j--;

            // at last swap both
            if(i<j) swap(arr, i, j);
        }

        // as j will be at right border of small elements
        // thus it is the correct position of pivot, swap low & j
        swap(arr, low, j);
        return j;
    }

    private static void quickSort(int[] arr, int low, int high){
        // base condition -> if only one element is present, or low has passed high
        if(low >= high)   return;

        // firstly, set the pivot element at its correct place
        // then return it's new index
        int pivot = partition(arr, low, high);

        // similarly call the function for left & right sub-arrays
        // also, all elements in left part will be less than pivot
        quickSort(arr, low, pivot-1);

        // and, all in right part will be greater than pivot
        quickSort(arr, pivot+1, high);
    }

    public static void main(String[] args) {
        int[] arr = {10, 8, 20, 5, 2, 3, 54, 45, 9, 7};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}

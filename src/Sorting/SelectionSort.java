package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {10, 8, 20, 5};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            // as behind i every element is sorted, so currently we have to deal with ith position
            int minIdx = i;
            for(int j=i+1; j<n; j++){
                if(arr[minIdx] > arr[j]){
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

package Recursion;

import java.util.ArrayList;

public class SubsetSumProblem {
    public static void main(String[] args) {
        int[] arr={10,20,15};
        int sum=25;
        System.out.println(findSum(arr,arr.length,sum));
    }

    static int findSum(int[] arr, int n,int sum)
    {
        if(n==0)
            return sum==0?1:0;
        return findSum(arr,n-1,sum)+findSum(arr,n-1,sum-arr[n-1]);
    }
}

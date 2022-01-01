package Searching;

import java.util.Arrays;

public class RepeatingElement {

    // Constraints
    // All elements from 0 to max[arr] are present in array
    // 0 <= max[arr] <=n-2

    public static void main(String[] args) {
        int[] arr={0,3,0,2,4,1};
//        System.out.println(repeatingNaive(arr));
//        System.out.println(repeatingEfficient(arr));
        System.out.println(floydAlgo(arr));
    }

    static int repeatingNaive(int[] arr)
    {
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]==arr[i+1])
                return arr[i];
        }
        return -1;
    }

    static int repeatingEfficient(int[] arr)
    {
        boolean[] b=new boolean[arr.length-1];    // Constraint is given that numbers lie from 0 to size-2 because there is at least one element repeating
        for(int j : arr) {
            if(b[j])
                return j;
            b[j] = true;
        }
        return -1;
    }

    static int floydAlgo(int[] arr)    // 1 is added to handle the edge cases when 0 in the array forms an unnecessary loop
    {
        int slow=arr[0]+1;
        int fast=arr[0]+1;
        do{
            slow=arr[slow]+1;
            fast=arr[arr[fast]+1]+1;
        }while(slow!=fast);

        slow=arr[0]+1;
        while(slow!=fast)
        {
            slow=arr[slow]+1;
            fast=arr[fast]+1;
        }
        return slow-1;
    }
}

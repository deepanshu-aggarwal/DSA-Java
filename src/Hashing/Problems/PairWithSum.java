package Hashing.Problems;

import java.util.HashSet;

public class PairWithSum {
    public static void main(String[] args) {
        int[] arr={11,10,6};
        int sum=10;
//        System.out.println(isPair(arr,sum));
        System.out.println(isPairHash(arr,sum));
    }

    static boolean isPair(int[] arr,int sum)
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]+arr[j]==sum)
                    return true;
            }
        }
        return false;
    }

    static boolean isPairHash(int[] arr,int sum)
    {
        HashSet<Integer> h=new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            if(h.contains(sum-arr[i]))
                return true;
            h.add(arr[i]);
        }
        return false;
    }
}

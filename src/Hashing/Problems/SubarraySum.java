package Hashing.Problems;

import java.util.HashSet;

public class SubarraySum {
    public static void main(String[] args) {
        int k=0;
        int[] arr={-3,-2,2,1,3};
        System.out.println(isSumK(arr,k));
//        System.out.println(isSum0Hash(arr,k));
    }

    static boolean isSumK(int[] arr,int k)
    {
        for(int i=0;i<arr.length;i++)
        {
            int sum=0;
            for(int j=i;j<arr.length;j++)
            {
                sum+=arr[j];
                if(sum==k)
                    return true;
            }
        }
        return false;
    }

    static boolean isSum0Hash(int[] arr,int k)
    {
        int sum=0;
        HashSet<Integer> h=new HashSet<>();
        for(int x:arr)
        {
            sum+=x;
            if(h.contains(sum-k))
                return true;
            if(sum==k)
                return true;
            h.add(sum);
        }
        return false;
    }
}

package Hashing.Problems;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubArraySum {
    public static void main(String[] args) {
        int k=4;
        int[] arr={8,3,1,-2,-6,6,2,2};
//        System.out.println(longestSubarraySum(arr,k));
        System.out.println(longestSubarraySumHash(arr,k));
    }

    static int longestSubarraySum(int[] arr,int k)
    {
        int size=0;
        for(int i=0;i<arr.length;i++)
        {
            int sum=0;
            for(int j=i;j<arr.length;j++)
            {
                sum+=arr[j];
                if(sum==k)
                {
                    size=Math.max(size,j-i+1);
                }
            }
        }
        return size;
    }

    static int longestSubarraySumHash(int[] arr,int k)
    {
        int ans=0;
        int sum=0;
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(sum==k)
                ans=i+1;
            if(!h.containsKey(sum))
                h.put(sum,i);
            if(h.containsKey(sum-k))
                ans=Math.max(ans,i-h.get(sum-k));
        }
        return ans;
    }
}

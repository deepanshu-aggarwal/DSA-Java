package Hashing.Problems;

import java.util.*;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr={3,-1,1,1,2,7};
//        System.out.println(lConscSubsequence(arr));
        System.out.println(lConscSubsequenceHash(arr));
    }

    static int lConscSubsequence(int[] arr)
    {
        int curr=1,ans=1;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]+1==arr[i+1])
                curr++;
            else
            {
                ans=Math.max(ans,curr);
                curr=0;
            }
        }
        if(curr==arr.length)
            return curr;
        return ans;
    }

    static int lConscSubsequenceHash(int[] arr)
    {
        int ans=1;
        HashSet<Integer> h=new HashSet<>();
        for(int i=0;i<arr.length;i++)
            h.add(arr[i]);
        for(int i=0;i<arr.length;i++)
        {
            int count=1;
            if(h.contains(arr[i]-1))
                continue;
            while(h.contains(arr[i]+count))
            {
                count++;
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
}

package Hashing.Problems;

import java.util.HashMap;

public class LongestSubZeroAndOne {
    public static void main(String[] args) {
        int[] arr={1,1,0,0,1,1,1,1};
//        System.out.println(longSubarray(arr));
        System.out.println(longSubarrayHash(arr));

    }

    static int longSubarray(int[] arr)
    {
        int ans=0;
        for(int i=0;i<arr.length;i++)
        {
            int sum=0;
            for(int j=i;j<arr.length;j++)
            {
                sum+=(int)arr[j];
                if(2*sum-j+i-1==0)
                    ans=Math.max(ans,2*sum);
            }
        }
        return ans;
    }

    static int longSubarrayHash(int[] arr)
    {
        HashMap<Integer,Integer> h=new HashMap<>();
        int ans=0;
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
                arr[i]=-1;
        }
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(sum==0)
                ans=i+1;
            if(h.containsKey(sum))
            {
                ans=Math.max(ans,i-h.get(sum));
            }
            if(!h.containsKey(sum))
                h.put(sum,i);
        }
        return ans;
    }
}

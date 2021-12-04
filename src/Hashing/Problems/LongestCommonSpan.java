package Hashing.Problems;

import java.util.HashMap;

public class LongestCommonSpan {
    public static void main(String[] args) {
        int[] a={1,1,0,0,0,0};
        int[] b={1,0,1,0,1,1};
//        System.out.println(longestCSpan(a,b));
        System.out.println(longestCSpanHash(a,b));
    }

    static int longestCSpan(int[] a,int[] b)
    {
        int ans=0;
        for(int i=0;i<a.length;i++)
        {
            int sum1=0,sum2=0;
            for(int j=i;j<a.length;j++)
            {
                sum1+=a[j];
                sum2+=b[j];
                if(sum1==sum2)
                    ans=Math.max(ans,j-i+1);
            }
        }

        return ans;
    }

    static int longestCSpanHash(int[] a,int[] b)
    {
        int ans=0;
        int[] temp=new int[a.length];
        for(int i=0;i<a.length;i++)
            temp[i]=a[i]-b[i];
        HashMap<Integer,Integer> h=new HashMap<>();
        int sum=0;
        for(int i=0;i<a.length;i++)
        {
            sum+=temp[i];
            if(sum==0)
                ans=i+1;
            if(h.containsKey(sum))
                ans=Math.max(ans,i-h.get(sum));
            if(!h.containsKey(sum))
                h.put(sum,i);
        }
        return ans;
    }
}

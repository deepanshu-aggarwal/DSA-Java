package Hashing.Problems;

import java.util.HashSet;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        int[] a={10,20,10,30,60,40,30};
        int[] b={10,20,30,10};
//        int ans=intersectionArrays(a,b);
        int ans=intersectionArraysHash(a,b);
        System.out.println(ans);
    }

    // Naive Approach
    static int intersectionArrays(int[] a,int[] b)
    {
        int ans=0;
        for(int i=0;i<a.length;i++)
        {
            boolean flag=false;
            for(int j=0;j<i;j++)
            {
                if(a[i]==a[j])
                {
                    flag=true;
                    break;
                }
            }
            if(flag)
                continue;
            for(int j=0;j<b.length;j++)
            {
                if(a[i]==b[j])
                {
                    ans++;
                    break;
                }
//                boolean flag1=false;
//                for(int k=0;k<j;k++)
//                {
//                    if(b[j]==b[k])
//                    {
//                        flag1=true;
//                        break;
//                    }
//                }
//                if(flag1)
//                    continue;
//                if(a[i]==b[j])
//                    ans++;
            }
        }
        return ans;
    }

    static int intersectionArraysHash(int[] a,int[] b)
    {
        int ans=0;
        HashSet<Integer> h=new HashSet<>();
        for(int x:a)
            h.add(x);
        for(int x:b)
        {
            if(h.contains(x))
            {
                ans++;
                h.remove(x);
            }
        }
        return ans;
    }
}

package Hashing.Problems;

import java.util.HashSet;

public class UnionOfArrays {
    public static void main(String[] args) {
        int[] a={20,40,60,80,20,40};
        int[] b={10,30,50,70,20};
//        int ans=unionArrays(a,b);
        int ans=unionArraysHash(a,b);
        System.out.println(ans);
    }

    static int unionArrays(int[] a,int[] b)
    {
        int ans=0;
        int[] c=new int[a.length+b.length];
        for(int i=0;i<a.length;i++) {
            c[i]=a[i];
        }
        for(int i=a.length;i<c.length;i++) {
            c[i]=b[i-a.length];
        }

        for(int i=0;i<c.length;i++)
        {
            boolean flag=false;
            for(int j=0;j<i;j++)
            {
                if(c[i]==c[j])
                {
                    flag=true;
                    break;
                }
            }
            if(!flag)
                ans++;
        }
        return ans;
    }

    static int unionArraysHash(int[] a,int[] b)
    {
        HashSet<Integer> c=new HashSet<>();
        for(int x:a) {
            c.add(x);
        }
        for(int x:b) {
            c.add(x);
        }

        return c.size();
    }
}

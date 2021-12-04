package Hashing.Problems;

import java.util.HashMap;
import java.util.HashSet;

public class DistinctWindows {
    public static void main(String[] args) {
        int[] arr={10,10,5,3,5,5};
        int k=3;
//        countDistinctWindows(arr,k);
        countDistinctWindowsHash(arr,k);
    }

    static void countDistinctWindows(int[] arr,int k)
    {
        for(int x=0;x<=arr.length-k;x++)
        {
            int count=0;
            for(int i=x;i<x+k;i++)
            {
                boolean flag=false;
                for(int j=0;j<i;j++)
                {
                    if(arr[i]==arr[j])
                    {
                        flag=true;
                        break;
                    }
                }
                if(!flag)
                    count++;
            }
            System.out.print(count+" ");
        }
    }

    static void countDistinctWindowsHash(int[] arr,int k)
    {
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<k;i++)
        {
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
        }
        System.out.print(h.size()+" ");
        for(int i=k;i<arr.length;i++)
        {
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
            h.put(arr[i-k],h.get(arr[i-k])-1);
            if(h.get(arr[i-k])==0)
                h.remove(arr[i-k]);
            System.out.print(h.size()+" ");
        }
//        System.out.println(h);
    }
}

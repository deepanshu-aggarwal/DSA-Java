package Hashing.Problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MoreThan_n_k_Occurrences {
    public static void main(String[] args) {
        int[] arr={10,20,10,20,20,30,10,10,10};
        int k=2;
//        countMoreThan_n_k(arr,k);
//        countMoreThan_n_kHash(arr,k);
        countForSmallK(arr,k);
    }

    static void countMoreThan_n_k(int[] arr,int k)
    {
        Arrays.sort(arr);
        int count=1;
        boolean flag=true;
        for(int i=0;i+1<arr.length;i++)
        {
            if(arr[i]==arr[i+1])
            {
                count++;
            }
            else
                count=1;
            if(count>arr.length/k){
                System.out.println(arr[i]+" ");
                count=Integer.MIN_VALUE;
            }
        }
    }

    static void countMoreThan_n_kHash(int[] arr,int k)
    {
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int x:arr)
            h.put(x,h.getOrDefault(x,0)+1);
        for(Map.Entry<Integer,Integer> e:h.entrySet())
            if(e.getValue()>arr.length/k)
                System.out.println(e.getKey()+" ");
    }

    static void countForSmallK(int[] arr,int k)
    {
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int x:arr)
        {
            if(h.containsKey(x))
                h.put(x,h.get(x)+1);
            else if(h.size()<k-1)
                h.put(x,1);
            else
                for(Map.Entry<Integer,Integer> e:h.entrySet())
                {
                    h.put(e.getKey(),e.getValue()-1);
                    if(e.getValue()==0)
                        h.remove(e.getKey());
                }
        }
        for(Map.Entry<Integer,Integer> e:h.entrySet())
        {
            int x=e.getKey();
            int count=0;
            for(int i:arr)
            {
                if(i==x)
                    count++;
                if(count>arr.length/k)
                {
                    System.out.println(x+" ");
                    count=0;
                    break;
                }
            }
        }
    }
}

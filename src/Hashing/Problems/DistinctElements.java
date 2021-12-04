package Hashing.Problems;

import java.util.HashMap;
import java.util.HashSet;

public class DistinctElements {
    public static void main(String[] args) {
        int[] arr={10,20,10,20,30,20,40,30,50,60,70,80,90};
        int ans=countDistHash(arr);
        System.out.println(ans);
    }

    // Naive Solution
    static int countDist(int[] arr)
    {
        int ans=0;
        for(int i=0;i<arr.length;i++)
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
                ans++;
        }
        return ans;
    }

    // Optimized Solution
    static int countDistHash(int[] arr)
    {
        HashSet<Integer> s=new HashSet<>();
        for(int i=0;i<arr.length;i++)
            s.add(arr[i]);
        return s.size();
    }
}

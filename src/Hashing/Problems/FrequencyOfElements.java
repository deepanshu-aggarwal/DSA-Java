package Hashing.Problems;

import java.util.HashMap;
import java.util.Map;

public class FrequencyOfElements {
    public static void main(String[] args) {
        int[] arr={10,20,30,10,40,30,10,30,50,20,10,40};
//        countFrequency(arr);
        countFrequencyHash(arr);
    }

    // Naive Approach
    static void countFrequency(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                continue;
            int freq = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    freq++;
            }
            System.out.println(arr[i] + " : " + freq);
        }
    }

    //Optimized Solution
    static void countFrequencyHash(int[] arr)
    {
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> e:h.entrySet())
        {
            System.out.println(e.getKey()+" : "+e.getValue());
        }
    }

}

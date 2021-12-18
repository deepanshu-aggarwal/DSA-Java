package Recursion;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr={2,5,7,4,2,4};
        int target=1;
//        System.out.println(find(arr,target,0));
//        System.out.println(findIndex(arr,target,0));
//        ArrayList<Integer> list=findAllIndex(arr,target,0,new ArrayList<>());
        ArrayList<Integer> list=findAllIndex(arr,target,0);
        System.out.println(list);
    }

    static boolean find(int[] arr,int x,int i)
    {
        if(i==arr.length)
            return false;
        return arr[i]==x || find(arr,x,i+1);
    }

    static int findIndex(int[] arr,int x,int i)
    {
        if(i==arr.length)
            return -1;
        if(arr[i]==x)
            return i;
        return findIndex(arr,x,i+1);
    }

    static ArrayList<Integer> findAllIndex(int[] arr, int x, int i, ArrayList<Integer> list)
    {
        if(i==arr.length)
            return list;
        if(arr[i]==x)
            list.add(i);
        return findAllIndex(arr,x,i+1,list);
    }

    static ArrayList<Integer> findAllIndex(int[] arr,int x,int i)
    {
        ArrayList<Integer> list=new ArrayList<>();
        if(i==arr.length)
            return list;
        if(arr[i]==x)
            list.add(i);

        ArrayList<Integer> l=findAllIndex(arr,x,i+1);
        l.addAll(list);
        return l;
    }
}

package Searching;

public class SortedRotatedSearch {
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50,8,9};
        int x=8;
        System.out.println(searchSR(arr,x,0,arr.length-1));
    }

    static int searchSR(int[] arr,int x,int s,int e)
    {
        if(s>e)
            return -1;
        int mid=(s+e)/2;
        if(arr[mid]==x)
            return mid;
        else if(arr[mid]>arr[s])
        {
            if(arr[mid]>x && arr[s]<=x)
                return searchSR(arr,x,s,mid-1);
            else
                return searchSR(arr,x,mid+1,e);
        }
        else
        {
            if(arr[mid]<x && x<=arr[e])
                return searchSR(arr,x,mid+1,e);
            else
                return searchSR(arr,x,s,mid-1);
        }
    }
}

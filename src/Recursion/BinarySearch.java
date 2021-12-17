package Recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={2,4,6,8,10,12};
        int key=9;
        System.out.println(search(arr,0,arr.length-1,key));
    }

    static int search(int[] arr,int start,int end,int key)
    {
        if(start>end)
            return -1;
        int mid=(start+end)/2;
        if(arr[mid]==key)
            return mid;
        if(arr[mid]>key)
            return search(arr,start,mid-1,key);
        else
            return search(arr,mid+1,end,key);
    }
}

package Searching;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr={100,20,30,50,80,90};
        int peak=peak(arr,0,arr.length-1);
        if(peak==-1)
            System.out.println(arr[arr.length-1]);
        else
            System.out.println(peak);
    }

    static int peak(int[] arr,int s,int e)
    {
        if(s>e)
            return -1;
        int mid=(s+e)/2;
        if(mid+1<arr.length && arr[mid]>arr[mid+1])
            return mid;
        else if(mid-1>=0 && arr[mid]<arr[mid-1])
            return mid-1;
        if(arr[mid]>arr[s])
            return peak(arr,mid+1,e);
        else
            return peak(arr,s,mid-1);
    }
}

package Searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50,60,70,80,90};
        int x=100;
//        System.out.println(binarySearchIter(arr,x));
        System.out.println(binarySearchRec(arr,x,0,arr.length-1));
    }

    static int binarySearchIter(int[] arr,int x)
    {
        int s=0,e=arr.length;
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(arr[mid]==x)
                return mid;
            else if(arr[mid]>x)
                e=mid-1;
            else
                s=mid+1;
        }
        return -1;
    }

    static int binarySearchRec(int[] arr,int x,int s,int e)
    {
        if(s>e)
            return -1;
        int mid=(s+e)/2;
        if(arr[mid]==x)
            return mid;
        else if(arr[mid]>x)
            return binarySearchRec(arr,x,s,mid-1);
        else
            return binarySearchRec(arr,x,mid+1,e);
    }
}

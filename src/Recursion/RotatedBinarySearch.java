package Recursion;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr={5,6,7,8,9,0,1,2,3,4};
        int target=0;
        System.out.println(search(arr,target,0,arr.length-1));
    }

    static int search(int[] arr,int x,int s,int e)
    {
        if(s>e)
            return -1;
        int mid=s+(e-s)/2;
        if(arr[mid]==x)
            return mid;
        if(arr[s]<=arr[mid])
        {
            if(x>=arr[s] && x<arr[mid])
                return search(arr,x,s,mid-1);
            else
                return search(arr,x,mid+1,e);
        }
        else
        {
            if(x>arr[mid] && x<=arr[e])
                return search(arr,x,mid+1,e);
            else
                return search(arr,x,s,mid-1);
        }
    }
}

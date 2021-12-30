package Searching;

public class CountOccurrences {
    public static void main(String[] args) {
        int[] arr={1,10,10,10,20,20,40};
        int x=100;
        System.out.println(countOccurrences(arr,x));
    }

    static int countOccurrences(int[] arr,int x)
    {
        int first=-1,last=-1;
        int s=0,e=arr.length-1;
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(arr[mid]>x)
                e=mid-1;
            else if(arr[mid]<x)
                s=mid+1;
            else
            {
                if(mid!=0 && arr[mid-1]==arr[mid])
                    e=mid-1;
                else
                {
                    first=mid;
                    break;
                }
            }
        }
        s=0;e=arr.length-1;
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(arr[mid]>x)
                e=mid-1;
            else if(arr[mid]<x)
                s=mid+1;
            else
            {
                if(mid!=arr.length-1 && arr[mid+1]==arr[mid])
                    s=mid+1;
                else
                {
                    last=mid;
                    break;
                }
            }
        }
        if(last==-1)  // Since both first and last will be -1
            return 0;
        else
            return last-first+1;
    }
}

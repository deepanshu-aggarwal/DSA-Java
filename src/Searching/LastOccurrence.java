package Searching;

public class LastOccurrence {
    public static void main(String[] args) {
        int[] arr={1,10,10,10,20,20,40};
        int x=1;
//        System.out.println(lastOccurrenceNaive(arr,x));
//        System.out.println(lastOccBinaryRec(arr,x,0,arr.length-1));
        System.out.println(lastOccBinaryIter(arr,x));
    }

    static int lastOccurrenceNaive(int[] arr,int x)
    {
        for(int i=arr.length-1;i>=0;i--)
        {
            if(arr[i]==x)
            {
                return i;
            }
        }
        return -1;
    }

    static int lastOccBinaryRec(int[] arr, int x, int s, int e)
    {
        if(s>e)
            return -1;
        int mid=(s+e)/2;
        if(arr[mid]>x)
            return lastOccBinaryRec(arr,x,s,mid-1);
        else if(arr[mid]<x)
            return lastOccBinaryRec(arr,x,mid+1,e);
        else
        {
            if(mid!=arr.length-1 && arr[mid+1]==arr[mid])
                return lastOccBinaryRec(arr,x,mid+1,e);
            else
                return mid;
        }
    }

    static int lastOccBinaryIter(int[] arr, int x)
    {
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
                if(mid!=arr.length-1 && arr[mid+1]==arr[mid])
                    s=mid+1;
                else
                    return mid;
            }
        }
        return -1;
    }
}

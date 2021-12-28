package Searching;

public class FirstOccurrence {
    public static void main(String[] args) {
        int[] arr={1,10,10,10,20,20,40};
        int x=20;
//        System.out.println(firstOccurrenceNaive(arr,x));
//        System.out.println(firstOccBinaryRec(arr,x,0,arr.length-1));
        System.out.println(firstOccBinaryIter(arr,x));
    }

    static int firstOccurrenceNaive(int[] arr,int x)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==x)
            {
                return i;
            }
        }
        return -1;
    }

    static int firstOccBinaryRec(int[] arr,int x,int s,int e)
    {
        if(s>e)
            return -1;
        int mid=(s+e)/2;
        if(arr[mid]>x)
            return firstOccBinaryRec(arr,x,s,mid-1);
        else if(arr[mid]<x)
            return firstOccBinaryRec(arr,x,mid+1,e);
        else
        {
            if(mid!=0 && arr[mid-1]==arr[mid])
                return firstOccBinaryRec(arr,x,s,mid-1);
            else
                return mid;
        }
    }

    static int firstOccBinaryIter(int[] arr,int x)
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
                if(mid!=0 && arr[mid-1]==arr[mid])
                    e=mid-1;
                else
                    return mid;
            }
        }
        return -1;
    }
}

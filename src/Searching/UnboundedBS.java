package Searching;

public class UnboundedBS {
    public static void main(String[] args) {
        int[] arr={1,30,40,59,88,149,590,899,1035,1936};
        int x=30;
        System.out.println(unboundedBS(arr,x));
    }

    static int unboundedBS(int[] arr,int x)
    {
        int i=1;
        while(arr[i]<x)
            i*=2;
        if(arr[i]==x)
            return i;
        int s=i/2,e=i-1;
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

}

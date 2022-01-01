package Searching;

public class AllocateMinimumPages {
    public static void main(String[] args) {
        int[] arr={10,20,10,30};
        int k=5;
        System.out.println(minPages(arr,k));
    }

    static boolean allocate(int[] arr,int n,int mid,int k)
    {
        int nos=1,pages=0;
        for(int i=0;i<n;i++)
        {
            if(pages+arr[i]<=mid)
                pages+=arr[i];
            else
            {
                nos++;
                pages=arr[i];
            }
            if(nos>k)
                return false;
        }
        return true;
    }

    static int minPages(int[] arr,int k)
    {
        if(k>arr.length)
            return -1;
        int low=arr[0],high=arr[0],n=arr.length;
        for (int x : arr) {
            if (low < x)
                low = x;
            high += x;
        }

        int ans=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(allocate(arr,n,mid,k))
            {
                high=mid-1;
                ans=mid;
            }
            else
                low=mid+1;
        }
        return ans;
    }
}

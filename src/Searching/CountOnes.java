package Searching;

public class CountOnes {
    public static void main(String[] args) {
        int[] arr={0,0,0,0,0,0,0};
        System.out.println(countOnes(arr));
    }

    static int countOnes(int[] arr)
    {
        int s=0,e=arr.length-1;
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(arr[mid]==0)
                s=mid+1;
            else
            {
                if(mid!=0 && arr[mid-1]==arr[mid])
                    e=mid-1;
                else
                    return arr.length-mid;
            }
        }
        return 0;
    }
}

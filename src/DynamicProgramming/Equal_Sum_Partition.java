package DynamicProgramming;

public class Equal_Sum_Partition {
    public static void main(String[] args) {
        int[] arr={2,3,12,9};
        int n=arr.length;
        int sum=0;
        for(int i: arr)
            sum+=i;
        if(sum%2==0)
            System.out.println(recEqualPart(arr, sum/2, n));
        else
            System.out.println("false");
    }

    public static boolean recEqualPart(int[] arr, int sum, int n)
    {
        if(n==0)
            return false;
        if(sum==0)
            return true;

        if(sum >= arr[n-1])
        {
            return recEqualPart(arr, sum-arr[n-1], n-1) || recEqualPart(arr, sum, n-1);
        }
        else
            return recEqualPart(arr, sum, n-1);
    }
}

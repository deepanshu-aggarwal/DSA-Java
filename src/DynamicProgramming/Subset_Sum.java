package DynamicProgramming;

public class Subset_Sum {
    public static void main(String[] args) {
        int[] arr={1,6,11,5};
        int n=arr.length;
        int target=22;
        boolean[][] dp = new boolean[n+1][target+1];
        System.out.println(recSubSum(arr,target,n));
        System.out.println(dpSubSum(arr,target,n,dp));
        System.out.println(tabSubSum(arr,target,n));
    }

    public static boolean recSubSum(int[] arr, int target, int n)
    {
        if(n==0)
        {
            return target == 0;
        }

        if(target >= arr[n-1])
            return recSubSum(arr,target-arr[n-1],n-1) || recSubSum(arr,target,n-1);
        else
            return recSubSum(arr,target,n-1);
    }

    public static boolean dpSubSum(int[] arr, int target, int n, boolean[][] dp)
    {
        if(n==0)
        {
            return target == 0;
        }

        if(dp[n][target])
            return true;

        if(target >= arr[n-1])
        {
            dp[n][target] = recSubSum(arr,target-arr[n-1],n-1) || recSubSum(arr,target,n-1);
        }

        else
        {
            dp[n][target] = recSubSum(arr,target,n-1);
        }

        return dp[n][target];
    }

    public static boolean tabSubSum(int[] arr, int target, int n)
    {
        boolean[][] tab = new boolean[n+1][target+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<target+1;j++)
            {
                if(i==0)
                    tab[i][j]=false;
                if(j==0)
                    tab[i][j]=true;
            }
        }

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<target+1;j++)
            {
                if(arr[i-1]<=j)
                    tab[i][j] = tab[i-1][j-arr[i-1]] || tab[i-1][j];
                else
                    tab[i][j] = tab[i-1][j];
            }
        }

        return tab[n][target];
    }
}

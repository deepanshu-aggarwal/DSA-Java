package DynamicProgramming;

public class Count_Subset_Sum {
    public static void main(String[] args) {
        int[] arr={4,3,5,1};
        int n=arr.length;
        int target=9;

        System.out.println(recCountSubset(arr, target, n));

        int[][] dp = new int[n+1][target+1];
        System.out.println(dynCountSubset(arr, target, dp, n));

        System.out.println(tabCountSubset(arr, target, n));
    }

    public static int recCountSubset(int[] arr, int target, int n)
    {
        if(n==0)
        {
            if(target==0)
                return 1;
            return 0;
        }

        if(target >= arr[n-1])
        {
            return recCountSubset(arr, target-arr[n-1], n-1) + recCountSubset(arr, target, n-1);
        }
        else
            return recCountSubset(arr, target, n-1);
    }

    public static int dynCountSubset(int[] arr, int sum, int[][] dp, int n)
    {
        if(n==0)
        {
            if(sum==0)
                return 1;
            return 0;
        }

        if(dp[n][sum] != 0)
            return dp[n][sum];

        if(sum >= arr[n-1])
        {
            dp[n][sum] = dynCountSubset(arr, sum-arr[n-1], dp, n-1) + dynCountSubset(arr, sum, dp, n-1);
            return dp[n][sum];
        }
        else
        {
            dp[n][sum] = dynCountSubset(arr, sum, dp, n-1);
            return dp[n][sum];
        }
    }

    public static int tabCountSubset(int[] arr, int sum, int n)
    {
        int[][] tab = new int[n+1][sum+1];

        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                if(i==0)
                    tab[i][j] = 0;
                if(j==0)
                    tab[i][j] = 1;
            }
        }

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                if(j >= arr[i-1])
                    tab[i][j] = tab[i-1][j-arr[i-1]] + tab[i-1][j];
                else
                    tab[i][j] = tab[i-1][j];
            }
        }

        return tab[n][sum];
    }
}

package DynamicProgramming;

public class Subset_With_Given_Difference {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int diff = 1;
        int n = arr.length;
        int range = 0;
        for(int i : arr)
            range += i;
        int sum = (range + diff)/2;

        if((diff+range) % 2 == 0)
        {
            System.out.println(givenDifference(arr, sum, n));

            int[][] dp = new int[n + 1][sum + 1];
            System.out.println(dynGivenDiff(arr, sum, dp, n));

            System.out.println(tabGivenDiff(arr, sum, n));
        }
        else
            System.out.println("Not Valid Input!");
    }

    public static int givenDifference(int[] arr, int sum, int n)
    {
        if(n==0)
        {
            if(sum==0)
                return 1;
            return 0;
        }

        if(arr[n-1]<=sum)
            return givenDifference(arr, sum-arr[n-1], n-1) + givenDifference(arr, sum, n-1);
        else
            return givenDifference(arr, sum, n-1);
    }

    public static int dynGivenDiff(int[] arr, int sum, int[][] dp, int n)
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
            dp[n][sum] = dynGivenDiff(arr, sum-arr[n-1], dp, n-1) + dynGivenDiff(arr, sum, dp, n-1);
            return dp[n][sum];
        }
        else
        {
            dp[n][sum] = dynGivenDiff(arr, sum, dp, n-1);
            return dp[n][sum];
        }
    }

    public static int tabGivenDiff(int[] arr, int sum, int n)
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

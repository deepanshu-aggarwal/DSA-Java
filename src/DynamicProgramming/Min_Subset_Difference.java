package DynamicProgramming;

public class Min_Subset_Difference {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        int n=arr.length;
        int range=0;
        for(int i: arr)
            range+=i;

        System.out.println(minSubsetDiff(arr, 0, range, n));

        boolean[][] dp = new boolean[n+1][range/2+1];
        boolean x = dynSubsetDiff(arr, range/2, n, dp);
        int min=Integer.MAX_VALUE;
        for(int j=range/2;j>=0;j--)
        {
            if(dp[n][j])
            {
                min = range - 2 * j;
                break;
            }
        }
        System.out.println(min);

        System.out.println(tabSubsetDiff(arr, range/2, n));
    }

    public static int minSubsetDiff(int[] arr, int sum, int range, int n)
    {
        if(n==0)
        {
            return Math.abs((range-sum)-sum);
        }

        return Math.min(minSubsetDiff(arr, sum+arr[n-1], range, n-1), minSubsetDiff(arr, sum, range, n-1));
    }

    public static boolean dynSubsetDiff(int[] arr, int sum, int n, boolean[][] dp)
    {
        if(n==0)
        {
            return sum == 0;
        }

        if(dp[n][sum])
            return true;

        if(sum >= arr[n-1])
        {
            dp[n][sum] = dynSubsetDiff(arr,sum-arr[n-1],n-1, dp) || dynSubsetDiff(arr,sum,n-1, dp);
        }

        else
        {
            dp[n][sum] = dynSubsetDiff(arr,sum,n-1, dp);
        }

        return dp[n][sum];
    }

    public static int tabSubsetDiff(int[] arr, int sum, int n)
    {
        int range=0;
        for(int i: arr)
            range+=i;

        boolean[][] tab = new boolean[n+1][sum+1];

        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                if(i == 0)
                    tab[i][j] = false;
                if(j == 0)
                    tab[i][j] = true;
            }
        }

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                if(j >= arr[i-1])
                    tab[i][j] = tab[i-1][j-arr[i-1]] || tab[i-1][j];
                else
                    tab[i][j] = tab[i-1][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for(int j=sum;j>=0;j--)
        {
            if(tab[n][j])
            {
                min = range - 2 * j;
                break;
            }
        }

        return min;
    }
}

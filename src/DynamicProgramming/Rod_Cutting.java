package DynamicProgramming;

public class Rod_Cutting {
    public static void main(String[] args) {

        int[] price = {3, 5, 8, 9, 10, 17, 17, 20};
        int n = price.length;
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = i+1;

        System.out.println(recRodCutting(arr, price, n, n));

        int[][] dp = new int[n+1][n+1];
        System.out.println(dpRodCutting(arr, price, n, n, dp));

        System.out.println(tabRodCutting(arr, price, n, n));
    }

    public static int recRodCutting(int[] arr, int[] val, int len, int n)
    {
        if(n==0 || len==0)
            return 0;

        if(arr[n-1] <= len)
            return Math.max(val[n-1] + recRodCutting(arr, val, len-arr[n-1], n), recRodCutting(arr, val, len, n-1));
        else
            return recRodCutting(arr, val, len, n-1);
    }

    public static int dpRodCutting(int[] arr, int[] val, int len, int n, int[][] dp)
    {
        if(n==0 || len==0)
            return 0;

        if(dp[n][len] != 0)
            return dp[n][len];

        if(arr[n-1] <= len)
        {
            dp[n][len] = Math.max(val[n-1] + dpRodCutting(arr, val, len-arr[n-1], n, dp), dpRodCutting(arr, val, len, n-1, dp));
            return dp[n][len];
        }
        else
        {
            dp[n][len] = dpRodCutting(arr, val, len, n-1, dp);
            return dp[n][len];
        }
    }

    public static int tabRodCutting(int[] arr, int[] val, int len, int n)
    {
        int[][] tab = new int[n+1][len+1];

        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<len+1;j++)
            {
                if(i==0 || j==0)
                    tab[i][j] = 0;
            }
        }

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<len+1;j++)
            {
                if(arr[i-1] <= j)
                {
                    tab[i][j] = Math.max(val[i-1] + tab[i][j-arr[i-1]], tab[i-1][j]);
                }
                else
                {
                    tab[i][j] = tab[i-1][j];
                }
            }
        }

        return tab[n][len];
    }
}

package DynamicProgramming;

public class CoinChangeProblem {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(maxWays(arr, 5));
    }

    public static int maxWays(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<n+1;i++) {
            dp[i][0] = 1;
        }

        for(int i=1;i<n+1;i++) {
            for(int j=1;j<sum+1;j++) {
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i][j - arr[i-1]] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }

    public static int minCoins(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];
        for(int j = 1; j<sum+1; j++)
            dp[0][j] = Integer.MAX_VALUE - 1;
        for(int i = 0; i<n+1; i++)
            dp[i][0] = 0;

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<sum+1; j++) {
                if(arr[i-1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - arr[i-1]], dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if(dp[n][sum] <= sum) {
            return dp[n][sum];
        }
        else {
            return -1;
        }
    }
}

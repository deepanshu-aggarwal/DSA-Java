package DynamicProgramming;

public class BinomialCoefficient {
    public static void main(String[] args) {
        int n = 10;
        int r = 5;
        System.out.println(nCr(n,r));
    }

    public static int nCr(int n, int r) {
        int mod = 1000000007;
        if(n<r) return 0;
        int[][] dp = new int[n+1][n+1];
        for(int i = 0;i<n+1;i++) {
            for(int j=0;j<n+1;j++) {
                if(j==0 || j == i) {
                    dp[i][j] = 1;
                }
            }
        }

        for(int i=2; i<n+1; i++) {
            for(int j=1; j<i; j++) {
                dp[i][j] = (dp[i-1][j-1]%mod + dp[i-1][j]%mod)%mod;
            }
        }
        return dp[n][r];
    }
}

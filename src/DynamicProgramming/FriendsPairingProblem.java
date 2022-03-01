package DynamicProgramming;

public class FriendsPairingProblem {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(pairing(n));
    }

    public static long pairing(int n) {
        if( n==1 || n==2)    return n;
        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;
        int mod = 1000000007;
        for(int i=3;i<n+1;i++) {
            dp[i] = (dp[i-1]%mod + (i-1)*dp[i-2]%mod)%mod;
            // every person can be alone or can be paired with rest(i-1) person one at a time.
        }
        return dp[n];
    }
}

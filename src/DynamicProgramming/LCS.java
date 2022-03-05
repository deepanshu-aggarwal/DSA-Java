package DynamicProgramming;

public class LCS {
    public static void main(String[] args) {
        String s1 = "abcgrh";
        String s2 = "acdghra";

        System.out.println(lcsRec(s1, s2, s1.length(), s2.length()));

        int[][] dp = new int[s1.length()+1][s2.length()+1];
        System.out.println(lcsDP(s1, s2, s1.length(), s2.length(), dp));

        System.out.println(lcsTab(s1, s2, s1.length(), s2.length()));
    }

    public static int lcsRec(String s1, String s2, int n, int m) {
        if(n == 0 || m == 0) {
            return 0;
        }

        if(s1.charAt(n-1) == s2.charAt(m-1)) {
            return 1 + lcsRec(s1, s2, n-1, m-1);
        }
        else {
            return Math.max(lcsRec(s1, s2, n-1, m), lcsRec(s1, s2, n, m-1));
        }
    }

    public static int lcsDP(String s1, String s2, int n, int m, int[][] dp) {
        if(n == 0 || m == 0) {
            return 0;
        }

        if(dp[n][m] != 0)   return dp[n][m];

        if(s1.charAt(n-1) == s2.charAt(m-1)) {
            dp[n][m] = 1 + lcsDP(s1, s2, n-1, m-1, dp);
        }
        else {
            dp[n][m] = Math.max(lcsDP(s1, s2, n-1, m, dp), lcsDP(s1, s2, n, m-1, dp));
        }
        return dp[n][m];
    }

    public static int lcsTab(String s1, String s2, int n, int m) {

        int[][] tab = new int[n+1][m+1];
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<m+1; j++) {
                if(i == 0 || j == 0) {
                    tab[i][j] = 0;
                }
            }
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    tab[i][j] = 1 + tab[i-1][j-1];
                }
                else
                    tab[i][j] = Math.max(tab[i-1][j], tab[i][j-1]);
            }
        }
        return tab[n][m];
    }
}

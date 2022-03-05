package DynamicProgramming;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "acbcgrh";
        String s2 = "adghbac";

        System.out.println(lcsubstringRec(s1, s2, s1.length(), s2.length(), 0));

//        int[][] dp = new int[s1.length()+1][s2.length()+1];
//        System.out.println(lcsubstringDP(s1, s2, s1.length(), s2.length(), 0, dp));

        System.out.println(lcsubstringTab(s1, s2, s1.length(), s2.length()));
    }

    public static int lcsubstringRec(String s1, String s2, int n, int m, int count) {
        if(n == 0 || m == 0) {
            return count;
        }

        int size = count;
        if(s1.charAt(n-1) == s2.charAt(m-1)) {
            size = lcsubstringRec(s1, s2, n-1, m-1, count+1);
        }
        int d = Math.max(lcsubstringRec(s1, s2, n-1, m, 0), lcsubstringRec(s1, s2, n, m-1, 0));
        return Math.max(size, d);
    }

//    public static int lcsubstringDP(String s1, String s2, int n, int m, int count, int[][] dp) {
//        if(n == 0 || m == 0) {
//            return count;
//        }
//
//        if(dp[n][m] != 0)   return dp[n][m];
//
//        int size = count;
//        if(s1.charAt(n-1) == s2.charAt(m-1)) {
//            size = lcsubstringDP(s1, s2, n-1, m-1, count+1, dp);
//        }
//
//        int d = Math.max(lcsubstringDP(s1, s2, n-1, m, 0, dp), lcsubstringDP(s1, s2, n, m-1, 0, dp));
//        dp[n][m] = Math.max(size, d);
//        return dp[n][m];
//    }

    public static int lcsubstringTab(String s1, String s2, int n, int m) {

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
                    tab[i][j] = 0;
            }
        }

        int max = 0;
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(max < tab[i][j])
                    max = tab[i][j];
            }
        }
        return max;
    }
}

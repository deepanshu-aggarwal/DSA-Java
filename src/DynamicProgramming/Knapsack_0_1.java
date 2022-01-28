package DynamicProgramming;

public class Knapsack_0_1 {
    public static void main(String[] args) {
        int[] wt={1,3,4,5};
        int[] val={1,4,5,7};
        int w=6;
        int n=wt.length;
        int[][] dp=new int[n+1][w+1];
        System.out.println(recKnap(wt, val, w, n));
        System.out.println(dynamicKnap(wt, val, w, n, dp));
        System.out.println(tabKnap(wt, val, w, n));
    }

    public static int recKnap(int[] wt, int[] val, int w, int n)
    {
        if(n==0 || w==0)
            return 0;

        if(wt[n-1]<=w)
        {
            return Math.max(val[n-1] + recKnap(wt, val, w-wt[n-1], n-1), recKnap(wt, val, w, n-1));
        }
        else
            return recKnap(wt, val, w, n-1);
    }

    public static int dynamicKnap(int[] wt, int[] val, int w, int n, int[][] dp)
    {
        if(n==0 || w==0)
            return 0;
        if(dp[n][w]!=0)
            return dp[n][w];
        if(wt[n-1]<=w)
        {
            dp[n][w] = Math.max(val[n-1] + dynamicKnap(wt, val, w-wt[n-1], n-1, dp), dynamicKnap(wt, val, w, n-1, dp));
            return dp[n][w];
        }
        else
        {
            dp[n][w] = dynamicKnap(wt, val, w, n-1, dp);
            return dp[n][w];
        }
    }

    public static int tabKnap(int[] wt, int[] val, int w, int n) {
        int[][] tab = new int[n + 1][w + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (wt[i - 1] <= j)
                    tab[i][j] = Math.max(val[i - 1] + tab[i - 1][j - wt[i - 1]], tab[i - 1][j]);
                else
                    tab[i][j] = tab[i - 1][j];
            }
        }

        return tab[n][w];
    }
}

package DynamicProgramming;

public class GoldMineProblem {
    public static void main(String[] args) {

        int[][] arr = {{1, 3, 1, 5},
                        {2, 2, 4, 1},
                        {5, 0, 2, 3},
                        {0, 6, 1, 2}};
        int ans = 0;
        int n = arr.length;
        for(int i=0; i<n; i++) {
            ans = Math.max(findRec(i, 0, arr, 0), ans);
        }
        System.out.println(ans);
        System.out.println(findDP(arr));
    }

    static int findRec(int i, int j, int[][] arr, int sum) {
        int n = arr.length, m = arr[0].length;
        if (i >= n || i <= -1 || j >= m) {
            return sum;
        }
        sum += arr[i][j];
        return Math.max(findRec(i - 1, j + 1, arr, sum),
                Math.max(findRec(i, j + 1, arr, sum), findRec(i + 1, j + 1, arr, sum)));
    }

    static int findDP(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int[][] dp = new int[n][m];
        for(int j = m-1;j>=0;j--) {
            for(int i=0;i<n;i++) {
                if(j == m-1) {
                    dp[i][j] = 0;
                }
                else if(i == 0) {
                    if(i+1<n)
                        dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j+1]);
                    else
                        dp[i][j] = dp[i][j+1];
                }
                else if(i == n-1) {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i-1][j+1]);
                }
                else{
                    dp[i][j] = Math.max(dp[i][j+1], Math.max(dp[i+1][j+1], dp[i-1][j+1]));
                }
                dp[i][j] += arr[i][j];
            }
        }
        int max = 0;
        for(int i = 0;i<n;i++) {
            max = Math.max(dp[i][0], max);
        }
        return max;
    }
}

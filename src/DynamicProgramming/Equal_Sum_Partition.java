package DynamicProgramming;

public class Equal_Sum_Partition {
    public static void main(String[] args) {
        int[] arr={2,3,12,9};
        int n=arr.length;
        int sum=0;
        for(int i: arr)
            sum+=i;

        if(sum%2==0)
        {
            System.out.println(recEqualPart(arr, sum/2, n));

            boolean[][] dp = new boolean[n+1][sum/2+1];
            System.out.println(dynEqualPart(arr, sum/2, dp, n));

            System.out.println(tabEqualPart(arr, sum/2, n));
        }
        else
            System.out.println("false");
    }

    public static boolean recEqualPart(int[] arr, int sum, int n)
    {
        if(n==0)
            return sum==0;

        if(sum >= arr[n-1])
        {
            return recEqualPart(arr, sum-arr[n-1], n-1) || recEqualPart(arr, sum, n-1);
        }
        else
            return recEqualPart(arr, sum, n-1);
    }

    public static boolean dynEqualPart(int[] arr, int sum, boolean[][] dp, int n)
    {
        if(n==0)
        {
            return sum == 0;
        }

        if(dp[n][sum])
            return true;

        if(sum >= arr[n-1])
            return dynEqualPart(arr, sum-arr[n-1], dp, n-1) || dynEqualPart(arr, sum, dp, n-1);
        else
            return dynEqualPart(arr, sum, dp, n-1);
    }

    public static boolean tabEqualPart(int[] arr, int sum, int n)
    {
        boolean[][] tab = new boolean[n+1][sum+1];

        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                if(i==0)
                    tab[i][j] = false;

                if(j==0)
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

        return tab[n][sum];
    }
}

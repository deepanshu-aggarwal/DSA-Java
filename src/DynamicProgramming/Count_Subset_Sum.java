package DynamicProgramming;

public class Count_Subset_Sum {
    public static void main(String[] args) {
        int[] arr={4,3,5,1};
        int n=arr.length;
        int target=9;

        System.out.println(countSubset(arr, target, n));
    }

    public static int countSubset(int[] arr, int target, int n)
    {
        if(n==0)
        {
            if(target==0)
                return 1;
            return 0;
        }

        if(target >= arr[n-1])
        {
            return countSubset(arr, target-arr[n-1], n-1) + countSubset(arr, target, n-1);
        }
        else
            return countSubset(arr, target, n-1);
    }
}

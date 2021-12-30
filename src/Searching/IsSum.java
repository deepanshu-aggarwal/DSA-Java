package Searching;

public class IsSum {
    public static void main(String[] args) {
        int[] arr={2,3,5,8,10,11,17};
        int sum=10;
        System.out.println(pair(arr,sum));
    }

    static boolean pair(int[] arr,int sum)
    {
        int i=0,j=arr.length-1;
        while(i!=j)
        {
            int s=arr[i]+arr[j];
            if(s==sum)
                return true;
            if(s<sum)
                i++;
            else
                j--;
        }
        return false;
    }
}

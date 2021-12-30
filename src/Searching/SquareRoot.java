package Searching;

public class SquareRoot {
    public static void main(String[] args) {
        int n=220;
//        System.out.println(sqrtNaive(n));
        System.out.println(sqrt(n));
    }

    static int sqrtNaive(int n)
    {
        int i=1;
        while(i*i<=n)
            i++;
        return i-1;
    }

    static int sqrt(int n)
    {
        int s=1,e=n,ans=1;
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(mid*mid<n)
            {
                s=mid+1;
                ans=mid;
            }
            else if(mid*mid>n)
                e=mid-1;
            else
                return mid;
        }
        return ans;
    }
}

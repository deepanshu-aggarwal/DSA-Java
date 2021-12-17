package Recursion;

public class CountZeros {
    public static void main(String[] args) {
        int n=32004;
        System.out.println(countZeros(n));
    }

    static int countZeros(int n)
    {
        if(n==0)
            return 0;
        if(n%10==0)
            return 1+countZeros(n/10);
        else
            return countZeros(n/10);

    }
}

package Recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        int n=253;
        System.out.println(sod(n));
    }

    static int sod(int n)
    {
        if(n==0)
            return 0;
        return n%10+sod(n/10);
    }
}

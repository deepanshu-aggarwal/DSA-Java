package Recursion;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverse(12820));
    }

    static int reverse(int n)
    {
        if(n%10==n)
            return n;
        int x=(int)(Math.pow(10,(int)Math.log10(n))) * (n%10);
        return x + reverse(n/10);
    }
}

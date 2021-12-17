package Recursion;

public class IsPalindrome {
    public static void main(String[] args) {
//        String s="bab";
//        System.out.println(isPalindrome(s,0,s.length()-1));
        System.out.println(isPalindrome(1221));
    }

    static Boolean isPalindrome(String s,int start,int end)
    {
        if(start>=end)
            return true;
        return (s.charAt(start)==s.charAt(end)) && isPalindrome(s,start+1,end-1);
    }

    static int reverse(int n)
    {
        if(n%10==n)
            return n;
        int x=(int)(Math.pow(10,(int)Math.log10(n))) * (n%10);
        return x + reverse(n/10);
    }

    static Boolean isPalindrome(int n)
    {
        return n==reverse(n);
    }
}

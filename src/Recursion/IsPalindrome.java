package Recursion;

public class IsPalindrome {
    public static void main(String[] args) {
        String s="bab";
        System.out.println(isPalindrome(s,0,s.length()-1));
    }

    static Boolean isPalindrome(String s,int start,int end)
    {
        if(start>=end)
            return true;
        return (s.charAt(start)==s.charAt(end)) && isPalindrome(s,start+1,end-1);
    }
}

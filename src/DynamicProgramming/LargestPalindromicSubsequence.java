package DynamicProgramming;

public class LargestPalindromicSubsequence {
    public static void main(String[] args) {
        String s1 = "afbcgb";

        System.out.println(lpsRec(s1));
        System.out.println(lpsDP(s1));
        System.out.println(lpsTab(s1));
    }

    public static int lpsRec(String s1) {
        String s2 = new StringBuffer(s1).reverse().toString();
        return LCS.lcsRec(s1, s2, s1.length(), s2.length());
    }

    public static int lpsDP(String s1) {
        String s2 = new StringBuffer(s1).reverse().toString();
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        return LCS.lcsDP(s1, s2, s1.length(), s2.length(), dp);
    }

    public static int lpsTab(String s1) {
        String s2 = new StringBuffer(s1).reverse().toString();
        return LCS.lcsTab(s1, s2, s1.length(), s2.length());
    }
}

package DynamicProgramming;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String s1 = "aggtab";
        String s2 = "gxtxayb";
        int len = s1.length() + s2.length();

        int lcsRec = LCS.lcsRec(s1, s2, s1.length(), s2.length());
        int lcsDP = LCS.lcsRec(s1, s2, s1.length(), s2.length());
        int lcsTab = LCS.lcsRec(s1, s2, s1.length(), s2.length());

        System.out.println(len - lcsRec);
        System.out.println(len - lcsDP);
        System.out.println(len - lcsTab);
    }

    // The code is same as to find the Longest Common Subsequence,
    // the only extra step is to deduct lcs from the total length
    // of strings because it is common in both.
}

package DynamicProgramming;

public class LCS {
    public static void main(String[] args) {
        String s1 = "abcrh";
        String s2 = "acdghra";

        System.out.println(lcsRec(s1, s2, s1.length(), s2.length()));
    }

    public static int lcsRec(String s1, String s2, int n, int m) {
        if(n == 0 || m == 0) {
            return 0;
        }

        if(s1.charAt(n-1) == s2.charAt(m-1)) {
            return 1 + lcsRec(s1, s2, n-1, m-1);
        }
        else {
            return Math.max(lcsRec(s1, s2, n-1, m), lcsRec(s1, s2, n, m-1));
        }
    }
}

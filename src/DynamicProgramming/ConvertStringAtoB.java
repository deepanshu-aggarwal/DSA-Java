package DynamicProgramming;

public class ConvertStringAtoB {
    public static void main(String[] args) {
        String a = "heap";
        String b = "pea";

        // We convert string a to b by insertion and deletion of elements.
        // So a way possible is through Longest Common subsequence as it is common in both thus not require any action.
        // Elements other than lcs needs to be deleted from string a and some elements needs to be inserted to get desired b.
        // So no. of deletion = length(a) - length(lcs)
        // & no. of insertion = length(b) - length(lcs)
        // total no. of steps = insertion + deletion

        int lcs = LCS.lcsTab(a, b, a.length(), b.length());
        int insert = b.length() - lcs;
        int delete = a.length() - lcs;
        int steps = insert + delete;
        System.out.println(steps);
    }
}

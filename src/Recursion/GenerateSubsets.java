package Recursion;

public class GenerateSubsets {
    public static void main(String[] args) {
        String s="abc";
        String curr=" ";
        int i=0;
        subsets(s,curr,i);
    }

    static void subsets(String s,String curr,int i)
    {
        if(i==s.length())
        {
            System.out.println(curr);
            return;
        }
        subsets(s,curr+s.charAt(i),i+1);
        subsets(s,curr,i+1);
    }
}

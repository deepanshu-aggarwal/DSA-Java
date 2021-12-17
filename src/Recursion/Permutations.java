package Recursion;

import java.util.Arrays;

public class Permutations {
    public static void main(String[] args) {
        String s="ABCD";
        permute(s,0);
    }

    static String swap(String s,int i,int j)
    {
        char[] ch=s.toCharArray();
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
        return String.valueOf(ch);
    }

    static void permute(String s,int i)
    {
        if(i==s.length()-1)
        {
            System.out.println(s);
            return;
        }
        for(int j=i;j<s.length();j++)
        {
            s=swap(s,i,j);
            permute(s,i+1);
            s=swap(s,i,j);
        }
    }
}

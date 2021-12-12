package Stack;

import java.util.ArrayDeque;

public class BalancedParenthesis {
    public static void main(String[] args) {
        System.out.println(isBalanced("([]))"));
    }

    static Boolean matching(char a,char b)
    {
        if(a==')' && b=='(')
            return true;
        if(a==']' && b=='[')
            return true;
        if(a=='}' && b=='{')
            return true;
        return false;
    }

    static Boolean isBalanced(String str)
    {
        ArrayDeque<Character> s=new ArrayDeque<>();
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='{' || str.charAt(i)=='[' || str.charAt(i)=='(')
                s.push(str.charAt(i));
            else
            {
                if(s.isEmpty())
                    return false;
                if(!matching(str.charAt(i), s.peek()))
                    return false;
                s.pop();
            }
        }
        return s.isEmpty();
    }
}

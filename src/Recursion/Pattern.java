package Recursion;

public class Pattern {
    public static void main(String[] args) {
        int n=10;
//        pattern1(n);
//        pattern1(4,0);
        pattern2(4,0);
    }

    static void pattern1(int n)
    {
        if(n==0)
            return;
        for(int i=0;i<n;i++)
            System.out.print("* ");
        System.out.println();
        pattern1(n-1);
    }

    static void pattern1(int r,int c)
    {
        if(r==0)
            return;
        if(c<r)
        {
            System.out.print("* ");
            pattern1(r,c+1);
        }
        else
        {
            System.out.println();
            pattern1(r-1,0);
        }
    }

    static void pattern2(int r,int c)
    {
        if(r==0)
            return;
        if(c<r)
        {
            pattern2(r,c+1);
            System.out.print("* ");
        }
        else
        {
            pattern2(r-1,0);
            System.out.println();
        }
    }
}

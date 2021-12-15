package Recursion;

public class RopeCuttingProblem {
    public static void main(String[] args) {
        int n=23;
        int a=11;
        int b=9;
        int c=12;
        System.out.println(maxPieces(n,a,b,c));
    }

    static int max(int a,int b,int c)
    {
        return Math.max(a,Math.max(b,c));
    }

    private static int maxPieces(int n, int a, int b, int c) {
        if(n<0)
            return -1;
        if(n==0)
            return 0;
        int res=max(maxPieces(n-a,a,b,c),maxPieces(n-b,a,b,c),maxPieces(n-c,a,b,c));
        if(res==-1)
            return -1;
        return res+1;
    }
}

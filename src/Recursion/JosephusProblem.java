package Recursion;

public class JosephusProblem {
    public static void main(String[] args) {
        int n=2;
        int k=3;
        System.out.println(findSurvivor(n,k));
    }

    static int findSurvivor(int n,int k)
    {
        if(n==1)
            return 0;
        return (findSurvivor(n-1,k)+k)%n;
    }
}

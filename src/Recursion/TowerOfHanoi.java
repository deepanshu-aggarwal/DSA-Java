package Recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int n=4;
        towerOfHanoi(n,'a','b','c');
    }

    static void towerOfHanoi(int n,char a,char b,char c)
    {
        if(n==0)
            return;
        towerOfHanoi(n-1,a,c,b);
        System.out.println("Move disc from "+a+" to "+c);
        towerOfHanoi(n-1,b,a,c);
    }
}

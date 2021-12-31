package Searching;

public class MedianOfTwoArrays {
    public static void main(String[] args) {
        int[] a={10,20,30,40,50};
        int[] b={5,15,25,35,45,55,65,75,85};
        if(a.length>b.length)
        {
            int[] t=a;
            a=b;
            b=t;
        }
        System.out.println(findMedian(a,b));
    }

    static double findMedian(int[] a,int[] b)
    {
        int n1=a.length;
        int n2=b.length;

        int begin=0;
        int end=n1;

        while(begin<=end)
        {
            int i1=(begin+end)/2;
            int i2=(n1+n2+1)/2-i1;               // a.length should always be less than b.length for validation of this step

            int max1=(i1==0)?Integer.MIN_VALUE:a[i1-1];
            int min1=(i1==n1)?Integer.MAX_VALUE:a[i1];
            int max2=(i2==0)?Integer.MIN_VALUE:b[i2-1];
            int min2=(i2==n2)?Integer.MAX_VALUE:b[i2];

            if(max1<=min2 && max2<=min1)
            {
                if((n1+n2)%2==0)
                    return (double)(Math.max(max1,max2)+Math.min(min1,min2))/2;
                else
                    return (Math.max(max1,max2));
            }
            if(min1<max2)
                begin=i1+1;
            else
                end=i1-1;
        }
        return 0;
    }
}

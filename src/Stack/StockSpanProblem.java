package Stack;

import java.util.ArrayDeque;

public class StockSpanProblem {
    public static void main(String[] args) {
        int[] arr={18,12,13,14,11,11,16};
//        int[] ans=stockSpanNaive(arr);
        int[] ans=stockSpanStack(arr);
        for(int i:ans)
            System.out.print(i+" ");
    }

    static int[] stockSpanNaive(int[] arr)
    {
        int[] span=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            int count=1;
            for(int j=i-1;j>=0 && arr[j]<=arr[i];j--)
            {
                count++;
            }
            span[i]=count;
        }
        return span;
    }

    static int[] stockSpanStack(int[] arr)
    {
        int[] span=new int[arr.length];
        ArrayDeque<Integer> s=new ArrayDeque<>();
        s.push(0);
        span[0]=1;
        for(int i=1;i<arr.length;i++)
        {
            while(!s.isEmpty() && arr[s.peek()]<=arr[i])
                s.pop();
            span[i]=s.isEmpty()?i+1:i-s.peek();
            s.push(i);
        }
        return span;
    }
}

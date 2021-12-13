package Stack;

import java.util.ArrayDeque;

public class LargestRectangularArea {
    public static void main(String[] args) {
        int[] arr={6,2,5,4,1,5,6};
//        System.out.println(largestArea(arr));
        System.out.println(largestAreaStack(arr));
    }

    static int largestArea(int[] arr)
    {
        int max=0;
        for(int i=0;i<arr.length;i++)
        {
            int sum=arr[i];
            for(int j=i-1;j>=0;j--)
            {
                if(arr[j]<arr[i])
                    break;
                sum+=arr[i];
            }
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[j]<arr[i])
                    break;
                sum+=arr[i];
            }
            max=Math.max(max,sum);
        }
        return max;
    }

    static int largestAreaStack(int[] arr)
    {
        int max=0;
        int[] prev=new int[arr.length];
        int[] next=new int[arr.length];
        ArrayDeque<Integer> s=new ArrayDeque<>();
        for(int i=0;i<arr.length;i++)
        {
            while(!s.isEmpty() && arr[i]<=arr[s.peek()])
                s.pop();
            prev[i]=s.isEmpty()?-1:s.peek();
            s.push(i);
        }
        for(int i:prev)
            System.out.print(i+" ");
        System.out.println();
        s.clear();
        for(int i=arr.length-1;i>=0;i--)
        {
            while(!s.isEmpty() && arr[i]<=arr[s.peek()])
                s.pop();
            next[i]=s.isEmpty()?arr.length:s.peek();
            s.push(i);
        }
        for(int i:next)
            System.out.print(i+" ");
        System.out.println();
        for(int i=0;i<arr.length;i++)
        {
            int sum=arr[i]*(next[i]-prev[i]-1);
            max=Math.max(max,sum);
        }
        return max;
    }
}

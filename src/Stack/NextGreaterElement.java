package Stack;

import java.util.ArrayDeque;

public class NextGreaterElement {
    public static void main(String[] args) {
//        int[] arr={15,10,18,12,4,6,2,8};
        int[] arr={5,15,10,8,6,12,9,18};
//        int[] arr={15,12,8};
//        int[] arr={8,12,12};
        int[] temp=nextGreaterStack(arr);
        for(int i:temp)
            System.out.print(i+" ");
    }

    static int[] nextGreaterNaive(int[] arr)
    {
        int[] temp=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            int ans=-1;
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[j]>arr[i])
                {
                    ans=arr[j];
                    break;
                }
            }
            temp[i]=ans;
        }
        return temp;
    }

    static int[] nextGreaterStack(int[] arr)
    {
        int[] temp=new int[arr.length];
        ArrayDeque<Integer> s=new ArrayDeque<>();
        for(int i=arr.length-1;i>=0;i--)
        {
            while(!s.isEmpty() && s.peek()<=arr[i])
                s.pop();
            temp[i]=s.isEmpty()?-1:s.peek();
            s.push(arr[i]);
        }
        return temp;
    }
}

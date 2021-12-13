package Stack;

import java.util.ArrayDeque;

public class PreviousGreaterElement {
    public static void main(String[] args) {
//        int[] arr={15,10,18,12,4,6,2,8};
//        int[] arr={15,12,8};
        int[] arr={8,12,12};
        int[] temp=prevGreaterELement(arr);
        for(int i:temp)
            System.out.print(i+" ");
    }

    static int[] prevGreaterELement(int[] arr)
    {
        int[] temp=new int[arr.length];
        ArrayDeque<Integer> s=new ArrayDeque<>();
        for(int i=0;i<arr.length;i++)
        {
            while(!s.isEmpty() && s.peek()<=arr[i])
                s.pop();
            temp[i]=s.isEmpty()?-1:s.peek();
            s.push(arr[i]);
        }
        return temp;
    }
}

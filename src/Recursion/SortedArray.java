package Recursion;

public class SortedArray {
    public static void main(String[] args) {
        int[] arr={111,12,13,16,19};
        System.out.println(sortedArray(arr,arr.length-1));
    }

    static boolean sortedArray(int[] arr,int i)
    {
        if(i==0)
            return true;
        return arr[i]>arr[i-1] && sortedArray(arr,i-1);
    }
}

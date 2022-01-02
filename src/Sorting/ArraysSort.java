package Sorting;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArraysSort {
    public static void main(String[] args) {
        int[] a={23,6,20,33,18,5};

        // For sorting primitive data types
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));       // but cannot sort in descending order

        // For sorting non-primitive data types we use Collections class
        // Resolves the problem of reverse order
        Integer[] b={23,6,20,33,18,5};
        Arrays.sort(b, Collections.reverseOrder());
        System.out.println(Arrays.toString(b));

        // Sorting as even numbers first then odd
        Arrays.sort(b,new evenOdd());
        System.out.println(Arrays.toString(b));

    }

    static class evenOdd implements Comparator<Integer>
    {
        @Override
        public int compare(Integer a,Integer b)
        {
            return a%2-b%2;
        }
    }

}

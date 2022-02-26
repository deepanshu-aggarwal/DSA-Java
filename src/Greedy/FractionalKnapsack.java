package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        Item[] item = {
                new Item(10,60),
                new Item(40,40),
                new Item(20,100),
                new Item(30,120)
        };
        int W = 50;

        System.out.println(fractionalKnap(item, W, item.length));
    }

    public static double fractionalKnap(Item[] arr, int W, int n) {
        Arrays.sort(arr, new myCmp());
        double res = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i].wt <= W) {
                res += arr[i].val;
                W -= arr[i].wt;
            }
            else {
                res += arr[i].val * (double)(W) / (double)(arr[i].wt);
                break;
            }
        }
        return res;
    }
}

class myCmp implements Comparator<Item> {
    public int compare(Item a, Item b) {
        return b.val*a.wt - b.wt*a.val;
    }
}

class Item {
    int val;
    int wt;
    Item(int wt, int val) {
        this.wt = wt;
        this.val = val;
    }
}
package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelectionProblem {
    public static void main(String[] args) {

        Pair[] p = {
                        new Pair(3,8),
                        new Pair(2,4),
                        new Pair(1,3),
                        new Pair(10,11)
                   };

        System.out.println(maxActivity(p));

    }

    public static int maxActivity(Pair[] p) {
        Arrays.sort(p, new myComp());

        int ans = 1;
        int prev = 0;
        for(int curr = 1; curr < p.length; curr++) {
            if(p[curr].first >= p[prev].second) {
                ans++;
                curr = prev;
            }
        }
        return ans;
    }

}

class myComp implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        return p1.first - p2.first;
    }
}

class Pair {
    int first;
    int second;
    Pair(int a, int b) {
        first = a;
        second = b;
    }
}

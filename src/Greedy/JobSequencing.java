package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencing {
    public static void main(String[] args) {
        Job[] jobs = {
                        new Job(1,4,20),
                        new Job(2,1,10),
                        new Job(3,1,40),
                        new Job(4,1,30)
        };

        System.out.println(Arrays.toString(jobScheduling(jobs, jobs.length)));
    }

    public static int[] jobScheduling(Job[] arr, int n) {
        Arrays.sort(arr, new myc());
        int m = 0;
        for(int i= 0; i<n; i++) {
            m = Math.max(m, arr[i].deadline);
        }
        int[] a = new int[m+1];
        for(int i = 0;i<n; i++) {
            int x = arr[i].deadline;
            for(int j=x;j>=0;j--) {
                if(a[j]==0)
                {
                    a[j] = arr[i].profit;
                    break;
                }
            }

        }
        int count = 0, profit = 0;
        for(int i=1;i<m + 1;i++) {
            if(a[i]!=0) {
                count++;
                profit += a[i];
            }
        }
        int[] ans = new int[2];
        ans[0] = count;
        ans[1] = profit;
        return ans;
    }
}

class myc implements Comparator<Job> {
    public int compare(Job a, Job b) {
        return b.profit - a.profit;
    }
}

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

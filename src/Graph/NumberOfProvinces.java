package Graph;
import java.util.ArrayList;

public class NumberOfProvinces {
    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = 8, count = 0;
        for(int i=0; i<n+1; i++)    adj.add(new ArrayList<Integer>());
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(4).add(5);
        adj.get(5).add(4);
        adj.get(5).add(6);
        adj.get(6).add(5);
        adj.get(7).add(8);
        adj.get(8).add(7);

        boolean[] vis = new boolean[n+1];

        for(int i=1; i<n+1; i++){
            if(!vis[i]){
                vis[i] = true;
                count++;
                Traversals.dfs(i, adj, vis, ls);
            }
        }
        System.out.println(count);
        System.out.println(ls);
    }
}

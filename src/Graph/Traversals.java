package Graph;

import java.util.*;

public class Traversals {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = 5;
        for(int i=0; i<n+1; i++)    adj.add(new ArrayList<Integer>());
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(4);
        adj.get(4).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(3).add(5);
        adj.get(5).add(3);

        // bfs traversal
        ArrayList<Integer> bfsTraversal = bfs(adj);

        boolean[] vis = new boolean[n+1];
        vis[1] = true;
        ArrayList<Integer> dfsTraversal = new ArrayList<>();
        // dfs traversal
        dfs(1, adj, vis, dfsTraversal);

        System.out.println(bfsTraversal);
        System.out.println(dfsTraversal);
    }

    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj){
        int n = adj.size();
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        vis[1] = true;
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);
            ArrayList<Integer> list = adj.get(curr);
            for(int val: list){
                if(!vis[val]){
                    vis[val] = true;
                    q.add(val);
                }
            }
        }
        return ans;
    }

    public static void dfs(int val, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ls){
        ls.add(val);
        for(int v: adj.get(val)){
            if(!vis[v]){
                vis[v] = true;
                dfs(v, adj, vis, ls);
            }
        }
    }
}

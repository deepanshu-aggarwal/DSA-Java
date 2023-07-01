package Graph.DirectedGraph.ShortestDistanceInDAG;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestDistanceInDAG {
    public static void main(String[] args) {
        int N = 6;
        int[][] edges = {{0, 1, 2},
                         {0, 4, 1},
                         {4, 5, 4},
                         {4, 2, 2},
                         {1, 2, 3},
                         {2, 3, 6},
                         {5, 3, 1}};
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<N; i++)  adj.add(new ArrayList<>());
        for(int[] edge: edges){
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[N];
        for(int i=0; i<N; i++){
            if(!vis[i]){
                topoSort(i, adj, st, vis);
                st.push(i);
            }
        }
        int[] dist = new int[N];
        Arrays.fill(dist, -1);
        dist[0] = 0;
        while(!st.isEmpty()){
            int u = st.pop();
            if(dist[u] == -1) continue;
            for(Pair v: adj.get(u)){
                if(dist[v.val] == -1)   dist[v.val] = dist[u] + v.dist;
                else    dist[v.val] = Math.min(dist[v.val], dist[u] + v.dist);
            }
        }
        System.out.println(Arrays.toString(dist));
    }

    private static boolean topoSort(int u, List<List<Pair>> adj, Stack<Integer> st, boolean[] vis){
        if(vis[u])  return true;
        vis[u] = true;
        for(Pair v: adj.get(u)){
            if(!topoSort(v.val, adj, st, vis))  return false;
        }
        st.push(u);
        return true;
    }
}

class Pair{
    int val;
    int dist;
    Pair(int v, int d){
        val = v;
        dist = d;
    }
}
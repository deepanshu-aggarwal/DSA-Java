package Graph.DirectedGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 6;
        for(int i=0; i<V; i++)  adj.add(new ArrayList<>());
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(1);
        adj.get(4).add(0);
        adj.get(5).add(0);
        adj.get(5).add(2);

//        dfsTopoSort(V, adj);
        kahnsTopoSort(V, adj);
    }

    private static void dfsTopoSort(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfsHelper(i, adj, vis, st);
                st.push(i);
            }
        }
        while(!st.isEmpty())    System.out.print(st.pop() + " ");
    }

    private static void dfsHelper(int u, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st){
        vis[u] = true;
        for(int v: adj.get(u)){
            if(!vis[v]){
                dfsHelper(v, adj, vis, st);
                st.push(v);
            }
        }
    }

    private static void kahnsTopoSort(int V, ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[V];
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> sort = new ArrayList<>();

        for(ArrayList<Integer> u: adj){
            for(int v: u){
                indegree[v]++;
            }
        }
        for(int i=0; i<V; i++){
            if(indegree[i]==0)  q.add(i);
        }
        while(!q.isEmpty()){
            int u = q.poll();
            sort.add(u);
            for(int v: adj.get(u)){
                indegree[v]--;
                if(indegree[v]==0)  q.add(v);
            }
        }
        System.out.println(sort);
    }
}

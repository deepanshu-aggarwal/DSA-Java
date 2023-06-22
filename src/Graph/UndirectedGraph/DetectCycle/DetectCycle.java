package Graph.UndirectedGraph.DetectCycle;

import java.util.*;

public class DetectCycle {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 6;
        for(int i=0; i<V+1; i++)    adj.add(new ArrayList<>());
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(1);
        adj.get(1).add(4);
        adj.get(3).add(5);
        adj.get(5).add(3);

        boolean[] vis = new boolean[V];

        // BFS
//        for(int i=0; i<V; i++){
//            if(!vis[i]){
//                if(bfsDetectCycle(i, adj, vis)){
//                    System.out.println("true");
//                    return;
//                };
//            }
//        }
//        System.out.println("false");

        // DFS
        for(int i=0; i<V; i++){
            if(!vis[i]){
                if(dfsDetectCycle(i, -1, adj, vis)) {
                    System.out.println("true");
                    return;
                }
            }
        }
        System.out.println("false");
    }

    private static boolean dfsDetectCycle(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        if(vis[node])   return true;
        vis[node] = true;
        ArrayList<Integer> list = adj.get(node);
        for(int i: list){
            if(i==parent)   continue;
            if(dfsDetectCycle(i, node, adj, vis))  return true;
        }
        return false;
    }

    private static boolean bfsDetectCycle(int val, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(val, -1));
        vis[val] = true;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int node = curr.node;
            int par = curr.par;
            for(int v: adj.get(node)){
                if(v==par)  continue;
                if(vis[v])  return true;
                q.add(new Pair(v, node));
                vis[v] = true;
            }
        }
        return false;
    }
}

class Pair{
    int node;
    int par;
    Pair(int node, int par){
        this.node = node;
        this.par = par;
    }
}

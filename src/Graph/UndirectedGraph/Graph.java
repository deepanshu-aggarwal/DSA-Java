package Graph.UndirectedGraph;

import java.util.ArrayList;

public class Graph {
    public static void main(String[] args) {
    }

    public static ArrayList<ArrayList<Integer>> getGraph(){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = 8;
        for(int i=0; i<n+1; i++)    adj.add(new ArrayList<>());
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

        return adj;
    }
}

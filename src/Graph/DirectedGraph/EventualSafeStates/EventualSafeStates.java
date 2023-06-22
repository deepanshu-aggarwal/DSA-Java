package Graph.DirectedGraph.EventualSafeStates;

public class EventualSafeStates {
    public static void main(String[] args) {
//        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        int[][] graph = {{1},{2},{3},{4,5},{6},{6},{7},{},{1,9},{10},{8},{9}};
        boolean[] states = findStates(graph);
        for(int i=0; i<graph.length; i++){
            if(states[i]) System.out.print(i + ", ");
        }
    }

    private static boolean[] findStates(int[][] graph){
        int V = graph.length;
        boolean[] states = new boolean[V];
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(i, graph, vis, pathVis, states);
            }
        }
        return states;
    }

    private static boolean dfs(int u, int[][] graph, boolean[] vis, boolean[] pathVis, boolean[] states){
        if(states[u])   return true;
        if(vis[u] && pathVis[u])  return false;
        vis[u] = true;
        pathVis[u] = true;
        for(int v: graph[u]){
            if(!dfs(v, graph, vis, pathVis, states)) return false;
        }
        states[u] = true;
        pathVis[u] = false;
        return true;
    }
}

package Graph.DirectedGraph.CourseSchedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule2 {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());
        for(int i=0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        List<Integer> topoSort = new ArrayList<>();
        Stack<Integer>  st = new Stack<>();
        for(int i=0; i<numCourses; i++){
            if(!vis[i]){
                if(!findTopo(i, adj, vis, pathVis, st))    break;
            }
        }
        if(st.size()<numCourses) System.out.println("Not possible");
        while(!st.isEmpty())    topoSort.add(st.pop());
        System.out.println(topoSort);
    }

    private static boolean findTopo(int u, List<List<Integer>> adj, boolean[] vis, boolean[] pathVis, Stack<Integer> st){
        if(pathVis[u])  return false;
        if(vis[u])  return true;
        vis[u] = true;
        pathVis[u] = true;
        for(int v: adj.get(u)){
            if(!findTopo(v, adj, vis, pathVis, st))   return false;
        }
        st.push(u);
        pathVis[u] = false;
        return true;
    }
}
